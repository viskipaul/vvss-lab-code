package inventory.tests;

import inventory.model.InhousePart;
import inventory.model.Part;
import inventory.repository.IRepository;
import inventory.repository.InventoryRepository;
import inventory.service.InventoryService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;

public class CompleteIntegrationTest {
    private static final Logger LOGGER = Logger.getLogger(EntityIsolationTests.class.getName());
    private InventoryService inventoryService;
    private IRepository repository;
    private InhousePart part;

    @BeforeEach
    void setUp() {
        LOGGER.info("Setting up testcase.");

        part = new InhousePart(651432000,
                "afkluniq123651",
                50.0,
                4,
                1,
                100,
                4);
        repository = new InventoryRepository();
        inventoryService = new InventoryService(repository);


        inventoryService.addInhousePart("afkluniq123651", 10, 2, 1, 100, 5);
    }

    @AfterEach
    void tearDown() {
        LOGGER.info("Teardown running.");
    }

    @Test
    void test1() {
        Part part = inventoryService.lookupPart("afkluniq123651");
        assertEquals("afkluniq123651", part.getName());
        inventoryService.deletePart(part);
        assertNull(inventoryService.lookupPart("afkluniq123651"));
    }

    @Test
    void test2() {
        assertEquals("afkluniq123651", inventoryService.lookupPart("afkluniq123651").getName());
        inventoryService.deletePart(inventoryService.lookupPart("afkluniq123651"));
    }
}
