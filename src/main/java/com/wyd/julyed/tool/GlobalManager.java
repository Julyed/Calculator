package com.wyd.julyed.tool;

import com.wyd.julyed.Calculation;
import com.wyd.julyed.HistoryController;

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
}
