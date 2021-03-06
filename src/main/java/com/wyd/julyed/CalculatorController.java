package com.wyd.julyed;

import java.net.URL;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wyd.julyed.tool.GlobalManager;
import com.wyd.julyed.tool.Operator;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CalculatorController implements Initializable {
	Calculation calculation = new Calculation();
	boolean firstNum = true;
	Logger logger = LogManager.getLogger(CalculatorController.class);

	@FXML
	private TextField calcResult;

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
		calcResult.appendText("=");
		logger.info(String.format(Constant.PATTERN_LOG_PRESS_BUTTON, "Calc"));
		if (firstNum) {
			/*
			 * 如果只输入了一个数，则认为第二个数为0
			 */
			calculation.setParameter2(0);
		}
		if (calculation.getOperator().equals(Operator.DIV) && calculation.parameter2Property().getValue() == 0) {
			/*
			 * 如果进行的是除法运算而除数又等于0，则报错
			 */
			calcResult.clear();
			calcResult.appendText("Invalid divisor");
		} else {
			/*
			 * 正常运算
			 */
			calculation.calculateAndSetResult();
			calcResult.appendText(String.valueOf(calculation.resultProperty().getValue()));
		}
		GlobalManager.getList().add(calculation);
		logger.info(String.format(Constant.PATTERN_LOG_GET_RESULT, calcResult.getText()));
	}

	public void clickButtonClearAll() {
		clearAll();
		logger.info(String.format(Constant.PATTERN_LOG_PRESS_BUTTON, "Clear All"));
	}

	public void clickButtonShowHistory() {
		try {
			Stage stageShowHistory = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource(Constant.FXML_HISTORY_SCENE));

			stageShowHistory.setTitle("Hitory You See");
			stageShowHistory.setScene(new Scene(root));
			stageShowHistory.initOwner(GlobalManager.getMainStage());
			stageShowHistory.centerOnScreen();
			stageShowHistory.showAndWait();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void clickOnDigitButton(int number) {
		logger.info(String.format(Constant.PATTERN_LOG_PRESS_BUTTON, String.valueOf(number)));
		calcResult.appendText(String.valueOf(number));
		if (firstNum) {
			calculation.setParameter1(calculation.parameter1Property().getValue() * 10 + number);
		} else {
			calculation.setParameter2(calculation.parameter2Property().getValue() * 10 + number);
		}
	}

	private void clickOnOperatorButton(Operator operator) {
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