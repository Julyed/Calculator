package com.wyd.julyed.tool;

import com.wyd.julyed.Calculation;
import com.wyd.julyed.OperationListController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

public class GlobalManager {
	private static Stage mainStage;
	private static OperationListController operationListController;
	private static ObservableList<Calculation> list = FXCollections.observableArrayList();

	public static Stage getMainStage() {
		return mainStage;
	}

	public static void setMainStage(Stage mainStage) {
		GlobalManager.mainStage = mainStage;
	}

	public static OperationListController getOperationListController() {
		return operationListController;
	}

	public static void setOperationListController(OperationListController operationListController) {
		GlobalManager.operationListController = operationListController;
	}

	public static ObservableList<Calculation> getList() {
		return list;
	}
}
