package com.wyd.julyed.tool.enums;

import com.wyd.julyed.Constant;

public enum Operator {
    /**
     * "#"：立即数或初始状态
     */
    NONE(Constant.OPERATOR_NONE),
    /**
     * "+"：加号
     */
    ADD(Constant.OPERATOR_ADD),
    /**
     * "-"：减号
     */
    SUB(Constant.OPERATOR_SUB),
    /**
     * "*"：乘号
     */
    MUL(Constant.OPERATOR_MUL),
    /**
     * "/"：除号
     */
    DIV(Constant.OPERATOR_DIV);

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

    public double calculate(int parameter1, int parameter2) {
        switch (this) {
        case NONE:
        case ADD:
            return (double) (parameter1 + parameter2);
        case SUB:
            return (double) (parameter1 - parameter2);
        case MUL:
            return (double) (parameter1 * parameter2);
        case DIV:
            return (parameter1 / (double) parameter2);
        }
        return 0.0;
    }

}
