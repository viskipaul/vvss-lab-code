package inventory;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;

import java.io.IOException;

public class Utils {
    /**
     * Afiseaza popup cu erori
     * @param title
     * @param msg
     */

    public static void showErrorPopup(String title, String msg){
        System.out.println(msg);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText("Error!");
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
