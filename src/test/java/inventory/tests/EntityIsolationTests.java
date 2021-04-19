package inventory.tests;

import inventory.model.InhousePart;
import org.junit.jupiter.api.*;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;


public class EntityIsolationTests {
    private static final Logger LOGGER = Logger.getLogger(EntityIsolationTests.class.getName());
    InhousePart part;

    @BeforeEach
    void setUp() {
        LOGGER.info("Setting up testcase.");
        part = new InhousePart(1, "testPart", 10, 1, 5, 50, 3);
    }

    @AfterEach
    void tearDown() {
        LOGGER.info("Teardown running.");
    }

    @Test()
    void test1() {
        // Test the constructor
        assertEquals(1, part.getPartId());
        assertEquals("testPart", part.getName());
        assertEquals(10, part.getPrice());
        assertEquals(1, part.getInStock());
        assertEquals(5, part.getMin());
        assertEquals(50, part.getMax());
        assertEquals(3, part.getMachineId());
    }

    @Test
    void test2() {
        // Test the setters
        part.setPartId(2);
        part.setName("new");
        part.setPrice(11);
        part.setInStock(2);
        part.setMin(6);
        part.setMax(51);
        part.setMachineId(4);

        assertEquals(2, part.getPartId());
        assertEquals("new", part.getName());
        assertEquals(11, part.getPrice());
        assertEquals(2, part.getInStock());
        assertEquals(6, part.getMin());
        assertEquals(51, part.getMax());
        assertEquals(4, part.getMachineId());
    }
}
