package inventory.repository;

import inventory.model.InhousePart;
import inventory.model.Part;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchPartByNameTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void invalidTestCase() {
        Inventory inventory = new Inventory();
        InhousePart part1 = new InhousePart(1, "Part1", 10.0, 2, 1, 10, 15);
        InhousePart part2 = new InhousePart(2, "Part2", 15.0, 2, 1, 10, 15);
        inventory.addPart(part1);
        inventory.addPart(part2);
        assertNull(inventory.lookupPart("Part3"));
    }

    @Test
    void validTestCase() {
        Inventory inventory = new Inventory();
        InhousePart part1 = new InhousePart(1, "Part1", 10.0, 2, 1, 10, 15);
        inventory.addPart(part1);
        assertEquals(inventory.lookupPart(part1.getName()), part1);
    }

    @Test
    void tc1(){
        Inventory inventory = new Inventory();
        assertNull(inventory.lookupPart("part1"));
    }

    @Test
    void tc2() {
        Inventory inventory = new Inventory();
        InhousePart part1 = new InhousePart(1, "Part2", 10.0, 2, 1, 10, 15);
        inventory.addPart(part1);
        assertEquals(inventory.lookupPart("1"), part1);
    }

    @Test
    void tc3() {
        Inventory inventory = new Inventory();
        InhousePart part1 = new InhousePart(1, "Part2", 10.0, 2, 1, 10, 15);
        inventory.addPart(part1);
        assertEquals(inventory.lookupPart("Part2"), part1);
    }

    @Test
    void tc4(){
        Inventory inventory = new Inventory();
        InhousePart part1 = new InhousePart(1, "Part10", 10.0, 2, 1, 10, 15);
        InhousePart part2 = new InhousePart(2, "Part11", 18.0, 2, 1, 15, 15);
        inventory.addPart(part1);
        inventory.addPart(part2);
        assertEquals(inventory.lookupPart("Part11"), part2);
    }

    @Test
    void tc5(){
        Inventory inventory = new Inventory();
        InhousePart part1 = new InhousePart(1, "Part10", 10.0, 2, 1, 10, 15);
        InhousePart part2 = new InhousePart(2, "Part11", 18.0, 2, 1, 15, 15);
        inventory.addPart(part1);
        inventory.addPart(part2);
        assertEquals(inventory.lookupPart("2"), part2);
    }

    @Test
    void tc6(){
        Inventory inventory = new Inventory();
        InhousePart part1 = new InhousePart(1, "Part10", 10.0, 2, 1, 10, 15);
        InhousePart part2 = new InhousePart(2, "Part11", 18.0, 2, 1, 15, 15);
        inventory.addPart(part1);
        inventory.addPart(part2);
        assertNull(inventory.lookupPart("Part20"));
    }

    @AfterEach
    void tearDown() {
    }
}