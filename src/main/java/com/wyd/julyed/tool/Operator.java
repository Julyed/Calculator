package com.wyd.julyed.tool;

public enum Operator {
	NONE("#"), ADD("+"), SUB("-"), MUL("*"), DIV("/");

	private String operator;

	private Operator(String operator) {
		this.operator = operator;
	}

	public String getOperatorString() {
		return operator;
	}

	public Integer calculate(int parameter1, int parameter2) {
		switch (this) {
		case NONE:
		case ADD:
			return parameter1 + parameter2;
		case SUB:
			return parameter1 - parameter2;
		case MUL:
			return parameter1 * parameter2;
		case DIV:
			return parameter1 / parameter2;
		}
		return 0;
	}

}
