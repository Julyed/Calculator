package com.wyd.julyed.tool;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class DialogHelper {
    private static void popupsetter(AlertType alertType, String headText, String contentText) {
        Alert popup = new Alert(alertType);
        popup.setHeaderText(headText);
        popup.setContentText(contentText);
        popup.showAndWait();
    }

    public static void popupInformation(String headText, String contentText) {
        popupsetter(AlertType.INFORMATION, headText, contentText);
    }

    public static void popupError(String headText, String contentText) {
        popupsetter(AlertType.ERROR, headText, contentText);
    }

    public static void popupWarning(String headText, String contentText) {
        popupsetter(AlertType.WARNING, headText, contentText);
    }
}
