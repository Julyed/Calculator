package com.wyd.julyed;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wyd.julyed.tool.DialogHelper;
import com.wyd.julyed.tool.GlobalManager;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class HistoryController implements Initializable {
	private static ObservableList<Calculation> list = GlobalManager.getList();
	private static BuildDocument buildDocument = new BuildDocument();
	private static Logger logger = LogManager.getLogger(HistoryController.class);

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

	public void clickButtonSaveHistory() {
		// 普通的循环
		// for (Calculation calculation : list) {
		// buildDocument.addElement(calculation);
		// }
		// 文艺的循环
		list.forEach(item -> buildDocument.addElement(item));
		try {
			// save as:
			FileChooser saveHistoryFileChooser = new FileChooser();
			ExtensionFilter filter = new ExtensionFilter("xml文件", "*.xml");
			saveHistoryFileChooser.getExtensionFilters().add(filter);
			File saveFile = saveHistoryFileChooser.showSaveDialog(GlobalManager.getMainStage());
			buildDocument.outputXmlFile(saveFile);
			// 保存成功弹出框
			DialogHelper.popupInformation(null, Constant.SUCCESS);
		} catch (IOException e) {
			logger.error("Showing Error", e);
			// 保存失败弹出框
			DialogHelper.popupError(null, Constant.ERROR);
		}
	}

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
