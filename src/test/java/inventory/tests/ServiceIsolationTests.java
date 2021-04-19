package inventory.tests;

import inventory.model.InhousePart;
import inventory.model.Part;
import inventory.repository.IRepository;
import inventory.repository.Inventory;
import inventory.service.InventoryService;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;

import java.util.logging.Logger;


public class ServiceIsolationTests {
    private static final Logger LOGGER = Logger.getLogger(EntityIsolationTests.class.getName());
    private InventoryService inventoryService;
    private IRepository repository;
    private InhousePart part;

    @BeforeEach
    void setUp() {
        LOGGER.info("Setting up testcase.");

        part = Mockito.mock(InhousePart.class);
        repository = Mockito.mock(IRepository.class);
        inventoryService = new InventoryService(repository);

        Mockito.doReturn(part).when(repository).lookupPart(any());
    }

    @AfterEach
    void tearDown() {
        LOGGER.info("Teardown running.");
    }

    @Test
    void test1() {
        inventoryService.addInhousePart("afkluniq123651", 10, 2, 1, 100, 5);
        Mockito.verify(repository, Mockito.atLeast(1)).addPart(any());
    }

    @Test
    void test2() {
        inventoryService.addInhousePart("afkluniq123651", 10, 2, 1, 100, 5);
        assertEquals(part, repository.lookupPart("afkluniq123651"));
    }
}
