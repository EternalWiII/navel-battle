package com.navel.navalbattle.interfaces;

import com.navel.navalbattle.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.io.IOException;

public interface WindowsManipulations {
    /**
     * processExit створює повідомлення. Якщо користувач обирає OK, вікно закривається.
     * @param stage Поточна сцена яка буде закрита.
     */
    default void processExit (Stage stage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        if (alert.showAndWait().get() == ButtonType.OK) {
            stage.close();
        }
    }

    /**
     * processReturnToMain створює повідомлення. Якщо користувач обирає OK, він повертається до головного меню.
     * @param stage Поточна сцена, для якої відбудеться зміна.
     */
    default void processReturnToMain (Stage stage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        if (alert.showAndWait().get() == ButtonType.OK) {
            FXMLLoader mainLoader = new FXMLLoader(Main.class.getResource("main_menu.fxml"));
            try {
                Scene scene = new Scene(mainLoader.load());
                stage.setScene(scene);

                scene.setOnKeyPressed(event -> {
                    if (event.getCode() == KeyCode.ESCAPE) {
                        processExit(stage);
                    }
                });
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
