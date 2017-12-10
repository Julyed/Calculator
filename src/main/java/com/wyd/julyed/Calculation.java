package com.wyd.julyed;

import com.wyd.julyed.tool.Operator;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Calculation {
	private IntegerProperty parameter1 = new SimpleIntegerProperty();
	private IntegerProperty parameter2 = new SimpleIntegerProperty();
	private IntegerProperty result = new SimpleIntegerProperty();
	private Operator operator = Operator.NONE;
	private StringProperty calc = new SimpleStringProperty("=");

	public void calculateAndSetResult() {
		this.setResult(this.calculate());
	}

	public int calculate() {
		return operator.calculate(parameter1.getValue(), parameter2.getValue());
	}

	public void setParameter1(int parameter1) {
		this.parameter1.set(parameter1);
	}

	public void setParameter2(int parameter2) {
		this.parameter2.set(parameter2);
	}

	public void setResult(int result) {
		this.result.set(result);
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public IntegerProperty parameter1Property() {
		return parameter1;
	}

	public IntegerProperty parameter2Property() {
		return parameter2;
	}

	public IntegerProperty resultProperty() {
		return result;
	}

	public StringProperty operatorProperty() {
		return new SimpleStringProperty(operator.getOperatorString());
	}

	public StringProperty calcProperty() {
		return calc;
	}

	public Operator getOperator() {
		return this.operator;
	}

}
