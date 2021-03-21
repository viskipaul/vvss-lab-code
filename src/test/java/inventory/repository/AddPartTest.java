package inventory.repository;

import inventory.model.InhousePart;
import inventory.model.Part;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddPartTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @Tag("bva")
    @DisplayName("Valid-BVA-1")
    void addValidPart() {
        // inStock = 1
        InhousePart part = new InhousePart(1, "Surub1", 10.0, 1,
                1, 120, 1);
        Inventory repo = new Inventory();
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
        Inventory repo = new Inventory();
        repo.addPart(part);
        assertEquals(0, repo.getAllParts().size());
    }

    @Test
    @Disabled
    void math(){
        assertEquals(3, 1+1);
    }
}