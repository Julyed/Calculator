package com.wyd.julyed;

import com.wyd.julyed.tool.Operator;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Calculation {
	/*
	 * 这是一个算式类，包含算式的两个参数，运算符号，等号与运算结果 通过操作成员函数，可以设置参数与运算符号 可以进行结果计算
	 * 为方便与showHistory.fxml进行绑定，可以获得各项参数，运算符号，等号和结果
	 */
	private IntegerProperty parameter1 = new SimpleIntegerProperty();
	private IntegerProperty parameter2 = new SimpleIntegerProperty();
	private IntegerProperty result = new SimpleIntegerProperty();
	private Operator operator = Operator.NONE;
	private StringProperty calc = new SimpleStringProperty(Constant.OPERATOR_EQU);

	public Calculation() {
		setParameter1(0);
		setParameter2(0);
	}

	public void setParameter1(int parameter) {
		this.parameter1.set(parameter);
	}

	public void setParameter2(int parameter) {
		this.parameter2.set(parameter);
	}

	public void setResult(Integer result) {
		this.result.set(result);
	}

	public void calculate() {
		this.result.set(this.operator.calculate(parameter1.getValue(), parameter2.getValue()));
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public IntegerProperty getParameter1Property() {
		return parameter1;
	}

	public IntegerProperty getParameter2Property() {
		return parameter2;
	}

	public IntegerProperty getResultProperty() {
		return result;
	}

	public StringProperty getOperatorProperty() {
		return new SimpleStringProperty(this.operator.getOperatorString());
	}

	public StringProperty getCalcProperty() {
		return calc;
	}

	public Operator getOperator() {
		return operator;
	}

}
