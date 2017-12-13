package com.wyd.julyed;

import java.io.File;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.wyd.julyed.tool.GlobalManager;
import com.wyd.julyed.tool.Operator;

public class ImportDocument {
	public static void importDocument(File importXmlFile) throws JDOMException, IOException {
		SAXBuilder saxReader = new SAXBuilder();
		Document document = saxReader.build(importXmlFile);
		Element root = document.getRootElement();
		root.getChildren().forEach(item -> addToList(item));
	}

	public static void addToList(Element item) {
		Calculation calcuation = new Calculation();
		calcuation.setParameter1(Integer.valueOf(item.getAttributeValue(Constant.STRING_PARAMETER1)));
		calcuation.setOperator(Operator.getOperator(item.getAttributeValue(Constant.STRING_OPERATOR)));
		calcuation.setParameter2(Integer.valueOf(item.getAttributeValue(Constant.STRING_PARAMETER2)));
		calcuation.setResult(Integer.valueOf(item.getAttributeValue(Constant.STRING_RESULT)));
		GlobalManager.getList().add(calcuation);
	}
}
