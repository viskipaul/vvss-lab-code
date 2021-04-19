package inventory.tests;

import inventory.model.InhousePart;
import inventory.model.Part;
import inventory.repository.IRepository;
import inventory.repository.Inventory;
import inventory.repository.InventoryRepository;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.*;

import java.util.logging.Logger;

public class RepositoryIsolationTests {
    private static final Logger LOGGER = Logger.getLogger(RepositoryIsolationTests.class.getName());
    private IRepository inventory;
    private Part part;

    @BeforeEach
    void setUp() {
        LOGGER.info("Setting up testcase.");
        inventory = new InventoryRepository();
        part = Mockito.mock(Part.class);
        Mockito.when(part.getPartId()).thenReturn(651432000);
        Mockito.when(part.getName()).thenReturn("afkluniq123651");
        Mockito.when(part.getPrice()).thenReturn(50.0);
        Mockito.when(part.getInStock()).thenReturn(4);
        Mockito.when(part.getMin()).thenReturn(1);
        Mockito.when(part.getMax()).thenReturn(100);

        inventory.addPart(part);
    }

    @AfterEach
    void tearDown() {
        LOGGER.info("Teardown running.");
        inventory.deletePart(inventory.lookupPart("afkluniq123651"));
    }

    @Test
    void Test1() {
        assertEquals(part, inventory.lookupPart("afkluniq123651"));
    }

    @Test
    void Test2() {
        assertEquals(part, inventory.lookupPart("651432000"));
    }
}
