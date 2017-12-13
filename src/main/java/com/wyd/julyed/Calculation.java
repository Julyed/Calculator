package com.wyd.julyed;

import com.wyd.julyed.tool.GlobalManager;
import com.wyd.julyed.tool.enums.Operator;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
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
    private DoubleProperty result = new SimpleDoubleProperty();
    private Operator operator = Operator.NONE;
    private StringProperty calc = new SimpleStringProperty(Constant.OPERATOR_EQU);
    private boolean calculated = false;

    public Calculation() {
        setParameter1(0);
        setParameter2(0);
        setCalculated(false);
        setOperator(Operator.NONE);
    }

    public void setParameter1(int parameter) {
        this.parameter1.set(parameter);
    }

    public void setParameter2(int parameter) {
        this.parameter2.set(parameter);
    }

    public void setResult(double result) {
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

    public StringProperty getResultProperty() {
        return new SimpleStringProperty(GlobalManager.formatDoubleNumber(result.get()));
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

    public boolean isCalculated() {
        return calculated;
    }

    public void setCalculated(boolean calculated) {
        this.calculated = calculated;
    }

}
