package com.wyd.julyed.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jdom2.JDOMException;

import com.wyd.julyed.Calculation;
import com.wyd.julyed.Constant;
import com.wyd.julyed.tool.DialogHelper;
import com.wyd.julyed.tool.ExportDocument;
import com.wyd.julyed.tool.GlobalManager;
import com.wyd.julyed.tool.ImportDocument;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class HistoryController implements Initializable {
    private static ObservableList<Calculation> list = GlobalManager.getList();
    private static Logger logger = LogManager.getLogger(HistoryController.class);

    @FXML
    private TableView<Calculation> tableViewHistory;
    @FXML
    private TableColumn<Calculation, Integer> tableColumnParameter1;
    @FXML
    private TableColumn<Calculation, Integer> tableColumnParameter2;
    @FXML
    private TableColumn<Calculation, String> tableColumnResult;
    @FXML
    private TableColumn<Calculation, String> tableColumnOperator;
    @FXML
    private TableColumn<Calculation, String> tableColumnCalc;
    @FXML
    private Button importHistoryButton;
    @FXML
    private Button saveHistoryButton;

    public void clickButtonSaveHistory() {
        try {
            // save as:
            saveHistoryButton.setDisable(true);
            FileChooser saveHistoryFileChooser = new FileChooser();
            ExtensionFilter filter = new ExtensionFilter(Constant.STRING_XML_FILE, Constant.EXTENSION_XML);
            saveHistoryFileChooser.getExtensionFilters().add(filter);
            File saveFile = saveHistoryFileChooser.showSaveDialog(GlobalManager.getMainStage());
            if (saveFile == null) {
                return;
            }
            ExportDocument.exportXmlFile(saveFile);
            // 保存成功弹出框
            DialogHelper.popupInformation(null, Constant.STRING_SUCCESS);
        } catch (IOException e) {
            logger.error(String.format(Constant.PATTERN_EXCEPTION_AT_METHOD, GlobalManager.getMethodName()), e);
            // 保存失败弹出框
            DialogHelper.popupError(null, Constant.STRING_ERROR);
        } finally {
            saveHistoryButton.setDisable(false);
        }
    }

    public void clickButtonShowLocalHistory() {
        try {
            importHistoryButton.setDisable(true);
            FileChooser localHistoryFileChooser = new FileChooser();
            ExtensionFilter filter = new ExtensionFilter(Constant.STRING_XML_FILE, Constant.EXTENSION_XML);
            localHistoryFileChooser.getExtensionFilters().add(filter);
            File localFile = localHistoryFileChooser.showOpenDialog(GlobalManager.getMainStage());
            if (localFile == null) {
                return;
            }
            ImportDocument.importXmlFile(localFile);
        } catch (JDOMException | IOException e) {
            logger.error(String.format(Constant.PATTERN_EXCEPTION_AT_METHOD, GlobalManager.getMethodName()), e);
        } finally {
            importHistoryButton.setDisable(false);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        GlobalManager.setHistoryController(this);

        tableColumnParameter1.setCellValueFactory(cellData -> cellData.getValue().getParameter1Property().asObject());
        tableColumnParameter2.setCellValueFactory(cellData -> cellData.getValue().getParameter2Property().asObject());
        tableColumnResult.setCellValueFactory(cellData -> cellData.getValue().getResultProperty());
        tableColumnOperator.setCellValueFactory(cellData -> cellData.getValue().getOperatorProperty());
        tableColumnCalc.setCellValueFactory(cellData -> cellData.getValue().getCalcProperty());

        tableViewHistory.setItems(list);

    }
}
