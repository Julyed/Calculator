package com.wyd.julyed.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wyd.julyed.Calculation;
import com.wyd.julyed.Constant;
import com.wyd.julyed.tool.GlobalManager;
import com.wyd.julyed.tool.enums.Operator;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CalculatorController implements Initializable {

    private Calculation calculation = new Calculation();
    private boolean firstNum = true;
    private static Logger logger = LogManager.getLogger(CalculatorController.class);

    @FXML
    private TextField calcResult;

    @FXML
    private Button showHistoryButton;

    // When user click on myButton
    // this method will be called.
    public void clickButton1() {
        clickOnDigitButton(1);
    }

    public void clickButton2() {
        clickOnDigitButton(2);
    }

    public void clickButton3() {
        clickOnDigitButton(3);
    }

    public void clickButton4() {
        clickOnDigitButton(4);
    }

    public void clickButton5() {
        clickOnDigitButton(5);
    }

    public void clickButton6() {
        clickOnDigitButton(6);

    }

    public void clickButton7() {
        clickOnDigitButton(7);
    }

    public void clickButton8() {
        clickOnDigitButton(8);
    }

    public void clickButton9() {
        clickOnDigitButton(9);
    }

    public void clickButton0() {
        if (firstNum && calculation.getParameter1Property().getValue().equals(0) && calcResult.getText().length() > 0) {
            return;
        }
        if (!firstNum && calculation.getParameter2Property().getValue().equals(0) && calcResult.getText()
                .substring(calcResult.getText().indexOf(calculation.getOperator().getOperatorString())).length() > 1) {
            return;
        }
        clickOnDigitButton(0);
    }

    public void clickButtonAdd() {
        clickOnOperatorButton(Operator.ADD);
    }

    public void clickButtonSub() {
        clickOnOperatorButton(Operator.SUB);
    }

    public void clickButtonMul() {
        clickOnOperatorButton(Operator.MUL);
    }

    public void clickButtonDiv() {
        clickOnOperatorButton(Operator.DIV);
    }

    public void clickButtonCalc() {
        if (calculation.isCalculated()) {
            return;
        }
        logger.info(String.format(Constant.PATTERN_LOG_PRESS_BUTTON, Constant.STRING_CALC));
        if (firstNum) {
            calculation.setParameter2(0);
        }
        if (calculation.getOperator().equals(Operator.DIV) && calculation.getParameter2Property().getValue() == 0) {
            calcResult.clear();
            calcResult.appendText(Constant.STRING_INVALID_DIVISOR);
        } else {
            if (!calculation.getOperator().equals(Operator.NONE)
                    && calculation.getParameter2Property().getValue().equals(0)) {
                clickButton0();
            }
            calcResult.appendText(Constant.OPERATOR_EQU);
            calculation.calculate();
            calcResult.appendText(String.valueOf(calculation.getResultProperty().getValue()));
            GlobalManager.getList().add(calculation);
        }
        calculation.setCalculated(true);
        logger.info(String.format(Constant.PATTERN_LOG_GET_RESULT, calcResult.getText()));
    }

    public void clickButtonClearAll() {
        clearAll();
        logger.info(String.format(Constant.PATTERN_LOG_PRESS_BUTTON, Constant.STRING_CLEAR_ALL));
    }

    @FXML
    private void clickButtonShowHistory() {
        try {
            Stage stageShowHistory = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource(Constant.FXML_HISTORY_SCENE));

            stageShowHistory.setTitle(Constant.TITLE_HISTORY);
            stageShowHistory.setScene(new Scene(root));
            stageShowHistory.initOwner(GlobalManager.getMainStage());
            stageShowHistory.centerOnScreen();
            stageShowHistory.setOnCloseRequest(event -> showHistoryButton.setDisable(false));
            showHistoryButton.setDisable(true);
            stageShowHistory.showAndWait();
        } catch (Exception e) {
            logger.error(String.format(Constant.PATTERN_EXCEPTION_AT_METHOD, GlobalManager.getMethodName()), e);
        }
    }

    private void clickOnDigitButton(int number) {
        if (calculation.isCalculated()) {
            clickButtonClearAll();
        }
        logger.info(String.format(Constant.PATTERN_LOG_PRESS_BUTTON, String.valueOf(number)));
        calcResult.appendText(String.valueOf(number));
        if (firstNum) {
            calculation.setParameter1(calculation.getParameter1Property().getValue() * 10 + number);
        } else {
            calculation.setParameter2(calculation.getParameter2Property().getValue() * 10 + number);
        }
    }

    private void clickOnOperatorButton(Operator operator) {
        if (calculation.isCalculated()) {
            return;
        }
        if (!firstNum) {
            calcResult.setText(calcResult.getText().replace(calculation.getOperator().getOperatorString(),
                    operator.getOperatorString()));
            calculation.setOperator(operator);
            return;
        }
        if (calculation.getParameter1Property().getValue().equals(0)) {
            clickButton0();
        }
        logger.info(String.format(Constant.PATTERN_LOG_PRESS_BUTTON, operator.getOperatorString()));
        calcResult.appendText(operator.getOperatorString());
        calculation.setOperator(operator);
        firstNum = false;

    }

    public void clearAll() {
        calcResult.clear();
        calculation = new Calculation();
        firstNum = true;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        clearAll();
    }
}