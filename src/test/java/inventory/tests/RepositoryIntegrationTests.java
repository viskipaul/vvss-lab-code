package inventory.tests;

import inventory.model.InhousePart;
import inventory.model.Part;
import inventory.repository.IRepository;
import inventory.repository.Inventory;
import inventory.repository.InventoryRepository;
import inventory.service.InventoryService;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

import org.mockito.*;

import java.util.logging.Logger;

public class RepositoryIntegrationTests {
    private static final Logger LOGGER = Logger.getLogger(EntityIsolationTests.class.getName());
    private InventoryService inventoryService;
    private IRepository repository;
    private InhousePart part;

    @BeforeEach
    void setUp() {
        LOGGER.info("Setting up testcase.");

        part = Mockito.mock(InhousePart.class);
        Mockito.doReturn("afkluniq123651").when(part).getName();
        Mockito.doReturn(1).when(part).getPartId();
        Mockito.when(part.getPrice()).thenReturn(50.0);
        Mockito.when(part.getInStock()).thenReturn(4);
        Mockito.when(part.getMin()).thenReturn(1);
        Mockito.when(part.getMax()).thenReturn(100);

        repository = new InventoryRepository();
        inventoryService = new InventoryService(repository);

        repository.addPart(part);
    }

    @AfterEach
    void tearDown() {
        LOGGER.info("Teardown running.");
    }

    @Test
    void test1() {
        inventoryService.addInhousePart("afkluniq123651", 10, 2, 1, 100, 5);
        inventoryService.lookupPart("afkluniq123651");
        Mockito.verify(part, Mockito.atLeast(1)).getName();

        // file cleanup...
        inventoryService.deletePart(inventoryService.lookupPart("afkluniq123651"));
        inventoryService.deletePart(inventoryService.lookupPart("afkluniq123651"));
    }

    @Test
    void test2() {
        assertEquals(part, inventoryService.lookupPart("afkluniq123651"));
        inventoryService.deletePart(inventoryService.lookupPart("afkluniq123651"));
    }
}
