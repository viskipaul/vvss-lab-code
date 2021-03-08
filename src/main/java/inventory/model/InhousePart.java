package inventory.model;

/*
    Clasa part-urilor care sunt de provenienta proprie
    Extinde clasa Part
 */
public class InhousePart extends Part {

    // Declare fields
    private int machineId;

    // Constructor
    public InhousePart(int partId, String name, double price, int inStock, int min, int max, int machineId) {
        super(partId, name, price, inStock, min, max);
        this.machineId = machineId;
    }
    
    // Getter
    public int getMachineId() {
        return machineId;
    }
    
    // Setter
    public void setMachineId(int machineId) {
        this.machineId = machineId;
    }

    @Override
    public String toString() {
        return "I,"+super.toString()+","+getMachineId();
    }
}
