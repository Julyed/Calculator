package com.wyd.julyed.tool;

import com.wyd.julyed.Calculation;
import com.wyd.julyed.Constant;
import com.wyd.julyed.controller.HistoryController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

public class GlobalManager {
    private static Stage mainStage;
    private static HistoryController historyController;
    private static ObservableList<Calculation> list = FXCollections.observableArrayList();

    public static Stage getMainStage() {
        return mainStage;
    }

    public static void setMainStage(Stage mainStage) {
        GlobalManager.mainStage = mainStage;
    }

    public static HistoryController getHistoryController() {
        return historyController;
    }

    public static void setHistoryController(HistoryController historyController) {
        GlobalManager.historyController = historyController;
    }

    public static ObservableList<Calculation> getList() {
        return list;
    }

    public static String getMethodName() {
        StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
        StackTraceElement e = stacktrace[2];
        String methodName = e.getMethodName();
        return methodName;
    }

    public static String formatDoubleNumber(double number) {
        String ret = String.valueOf(number);
        if (ret.contains(".")) {
            while (ret.endsWith(String.valueOf(Constant.ZERO)) || ret.endsWith(Constant.SYMBOL_DECIMAL_POINT)) {
                ret = ret.substring(0, ret.length() - 1);
                if (!ret.contains(Constant.SYMBOL_DECIMAL_POINT)) {
                    break;
                }
            }
        }
        if (ret.contains(Constant.SYMBOL_DECIMAL_POINT)) {
            while (ret.substring(ret.indexOf(Constant.SYMBOL_DECIMAL_POINT)).length() > 15) {
                ret = ret.substring(0, ret.length() - 1);
            }
        }
        return ret;
    }
}
