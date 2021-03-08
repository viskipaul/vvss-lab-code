package inventory.controller;

import inventory.service.InventoryService;
/*
    Interfata Controlelrs este implementata de catre clasele AddPartController, AddProductController, MainScreenController, ModifyPartController, ModifyProductController
 */
public interface Controller {
    void setService(InventoryService service);
}
