package com.wyd.julyed;

import java.net.URL;
import java.util.ResourceBundle;

import com.wyd.julyed.tool.GlobalManager;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class HistoryController implements Initializable {
	public static ObservableList<Calculation> list = GlobalManager.getList();

	@FXML
	private TableView<Calculation> tableViewHistory;
	@FXML
	private TableColumn<Calculation, Integer> tableColumnParameter1;
	@FXML
	private TableColumn<Calculation, Integer> tableColumnParameter2;
	@FXML
	private TableColumn<Calculation, Integer> tableColumnResult;
	@FXML
	private TableColumn<Calculation, String> tableColumnOperator;
	@FXML
	private TableColumn<Calculation, String> tableColumnCalc;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		GlobalManager.setHistoryController(this);

		tableColumnParameter1.setCellValueFactory(cellData -> cellData.getValue().getParameter1Property().asObject());
		tableColumnParameter2.setCellValueFactory(cellData -> cellData.getValue().getParameter2Property().asObject());
		tableColumnResult.setCellValueFactory(cellData -> cellData.getValue().getResultProperty().asObject());
		tableColumnOperator.setCellValueFactory(cellData -> cellData.getValue().getOperatorProperty());
		tableColumnCalc.setCellValueFactory(cellData -> cellData.getValue().getCalcProperty());

		tableViewHistory.setItems(list);

	}

	public void addToList(Calculation calculation) {
		list.add(calculation);
		tableViewHistory.refresh();
	}
}
