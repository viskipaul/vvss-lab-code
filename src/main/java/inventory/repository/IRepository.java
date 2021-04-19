package inventory.repository;

import inventory.model.Part;
import inventory.model.Product;
import javafx.collections.ObservableList;

public interface IRepository {
    void addPart(Part part);

    void addProduct(Product product);

    int getAutoPartId();

    int getAutoProductId();

    ObservableList<Part> getAllParts();

    ObservableList<Product> getAllProducts();

    Part lookupPart(String search);

    Product lookupProduct(String search);

    void updatePart(int partIndex, Part part);

    void updateProduct(int productIndex, Product product);

    void deletePart(Part part);

    void deleteProduct(Product product);

    Inventory getInventory();

    void setInventory(Inventory inventory);
}
