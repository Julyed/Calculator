package com.wyd.julyed.tool;

import java.io.File;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.wyd.julyed.Calculation;
import com.wyd.julyed.Constant;
import com.wyd.julyed.tool.enums.Operator;

public class ImportDocument {

    public static void importXmlFile(File importXmlFile) throws JDOMException, IOException {
        SAXBuilder saxReader = new SAXBuilder();
        Document document = saxReader.build(importXmlFile);
        Element root = document.getRootElement();
        root.getChildren().forEach(item -> addToList(item));
    }

    private static void addToList(Element item) {
        Calculation calcuation = new Calculation();
        calcuation.setParameter1(Integer.valueOf(item.getAttributeValue(Constant.STRING_PARAMETER1)));
        calcuation.setOperator(Operator.getOperator(item.getAttributeValue(Constant.STRING_OPERATOR)));
        calcuation.setParameter2(Integer.valueOf(item.getAttributeValue(Constant.STRING_PARAMETER2)));
        calcuation.setResult(Integer.valueOf(item.getAttributeValue(Constant.STRING_RESULT)));
        GlobalManager.getList().add(calcuation);
    }
}
