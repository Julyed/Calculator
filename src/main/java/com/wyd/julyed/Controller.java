package com.wyd.julyed;

import java.net.URL;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import com.wyd.julyed.tool.*;

public class Controller implements Initializable {

	int parameter1, parameter2, result;
	boolean firstNum = true;
	Operator operator;
	Logger logger = LogManager.getLogger(Controller.class);

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
		calcResult.appendText("+");
		firstNum = false;
		operator = Operator.ADD;
	}

	public void clickButtonSub() {
		calcResult.appendText("-");
		firstNum = false;
		operator = Operator.SUB;
	}

	public void clickButtonMul() {
		calcResult.appendText("*");
		firstNum = false;
		operator = Operator.MUL;
	}

	public void clickButtonDiv() {
		calcResult.appendText("/");
		firstNum = false;
		operator = Operator.DIV;
	}

	public void clickButtonCalc() {
		calcResult.appendText("=");
		if (firstNum) {
			calcResult.clear();
			calcResult.appendText(String.valueOf(parameter1));
		} else if (operator.equals(Operator.DIV) && parameter2 == 0) {
			calcResult.clear();
			calcResult.appendText("Invalid divisor");
		} else {
			result = operator.calculate(parameter1, parameter2);
			calcResult.appendText(String.valueOf(result));
		}
	}

	public void clickButtonClearAll() {
		clearAll();
	}

	public void clickOnDigitButton(int number) {
		logger.info("press button " + number);
		calcResult.appendText(String.valueOf(number));
		if (firstNum) {
			parameter1 = parameter1 * 10 + number;
		} else {
			parameter2 = parameter2 * 10 + number;
		}
	}

	public void clearAll() {
		calcResult.clear();
		parameter1 = parameter2 = result = 0;
		firstNum = true;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		clearAll();
	}
}