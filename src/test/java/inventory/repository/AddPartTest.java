package inventory.repository;

import inventory.model.InhousePart;
import inventory.model.Part;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class AddPartTest {
    private Inventory repo;
    private final static Logger LOGGER = Logger.getLogger(AddPartTest.class.getName());

    @BeforeEach
    void setUp() {
        LOGGER.info("Setting up testcase.");
        repo = new Inventory();
    }

    @AfterEach
    void tearDown() {
        LOGGER.info("Teardown running.");
    }

    @Test
    @Tag("bva")
    @DisplayName("Valid-BVA-1")
    void addValidPart() {
        // inStock = 1
        InhousePart part = new InhousePart(1, "Surub1", 10.0, 1,
                1, 120, 1);
        repo.addPart(part);
        assertEquals(1, repo.getAllParts().size());
    }

    @Test
    @Tag("bva")
    @DisplayName("Invalid-BVA-1")
    void addInvalidPart() {
        // inStock = 0 (<1)
        InhousePart part = new InhousePart(1, "Surub1", 10.0, 0,
                1, 120, 1);
        repo.addPart(part);
        assertEquals(0, repo.getAllParts().size());
    }

    @Test
    @Tag("ecp")
    @DisplayName("Valid-ECP-1")
    void addValidPartEcp1() {
        // quantity -15
        InhousePart part = new InhousePart(1, "Surub1", 10.0, 15,
                1, 120, 1);
        repo.addPart(part);
        assertEquals(1, repo.getAllParts().size());
    }

    @Test
    @Tag("ecp")
    @DisplayName("Invalid-ECP-1")
    void addInvalidPartEcp1() {
        //- quantity 150
        InhousePart part = new InhousePart(1, "Surub1", 10.0, 150,
                1, 120, 1);
        repo.addPart(part);
        assertEquals(0, repo.getAllParts().size());

    }

    @Tag("ecp")
    @DisplayName("Invalid-ECP-2")
    @ParameterizedTest(name = "Testing for min value {0} and max value 90.")
    @ValueSource(ints = { 100, 200, 300 })
    void addInvalidPartEcp2(int min) {
        //- min > max

        InhousePart part = new InhousePart(1, "Surub1", 10.0, 1,
                min, 90, 1);
        repo.addPart(part);
        assertEquals(0, repo.getAllParts().size());
    }

    @Test
    @Disabled
    void math(){
        assertEquals(3, 1+1);
    }
}