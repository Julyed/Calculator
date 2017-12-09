package com.wyd.julyed.tool;

public enum Operator {
	ADD, SUB, MUL, DIV;
	public int calculate(int parameter1, int parameter2) {
		switch(this) {
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
