package com.wyd.julyed;

import java.net.URL;
import java.util.ResourceBundle;

import com.wyd.julyed.tool.GlobalManager;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class OperationListController implements Initializable {
	public static ObservableList<Calculation> list = GlobalManager.getList();

	@FXML
	private TableView<Calculation> operationList;
	@FXML
	private TableColumn<Calculation, Integer> parameter1;
	@FXML
	private TableColumn<Calculation, String> operator;
	@FXML
	private TableColumn<Calculation, Integer> parameter2;
	@FXML
	private TableColumn<Calculation, String> calc;
	@FXML
	private TableColumn<Calculation, Integer> result;

	/**
	 * Initializes the controller class.
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		GlobalManager.setOperationListController(this);
		parameter1.setCellValueFactory(cellData -> cellData.getValue().parameter1Property().asObject());
		operator.setCellValueFactory(cellData -> cellData.getValue().operatorProperty());
		parameter2.setCellValueFactory(cellData -> cellData.getValue().parameter2Property().asObject());
		calc.setCellValueFactory(cellData -> cellData.getValue().calcProperty());
		result.setCellValueFactory(cellData -> cellData.getValue().resultProperty().asObject());
		operationList.setItems(list);

	}

	public void addToList(Calculation calculation) {
		list.add(calculation);
		operationList.refresh();
	}

}