package com.wyd.julyed.tool;

import com.wyd.julyed.Constant;

public enum Operator {
    NONE(Constant.OPERATOR_NONE), ADD(Constant.OPERATOR_ADD), SUB(Constant.OPERATOR_SUB), MUL(
            Constant.OPERATOR_MUL), DIV(Constant.OPERATOR_DIV);

    private String operator;

    private Operator(String operator) {
        this.operator = operator;
    }

    public String getOperatorString() {
        return operator;
    }

    public static Operator getOperator(String operatorString) {
        // switch (operatorString) {
        // case Constant.OPERATOR_ADD:
        // return Operator.ADD;
        // case Constant.OPERATOR_SUB:
        // return Operator.SUB;
        // case Constant.OPERATOR_MUL:
        // return Operator.MUL;
        // case Constant.OPERATOR_DIV:
        // return Operator.DIV;
        // case Constant.OPERATOR_NONE:
        // return Operator.NONE;
        // }
        for (Operator operator : Operator.values())
            if (operator.getOperatorString().equals(operatorString))
                return operator;
        return null;
    }

    public int calculate(int parameter1, int parameter2) {
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
