package com.wyd.julyed;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class BuildDocument {
    private int parameter1, parameter2, result;
    private String operator;
    private Document document;
    private Element root;

    public BuildDocument() {
        // TODO Auto-generated constructor stub
        document = new Document();
        root = new Element(Constant.STRING_HISTORIES);
        document.setRootElement(root);
    }

    public void addElement(Calculation calculation) {
        parameter1 = calculation.getParameter1Property().getValue();
        parameter2 = calculation.getParameter2Property().getValue();
        result = calculation.getResultProperty().getValue();
        operator = calculation.getOperatorProperty().getValue();

        Element child = new Element(Constant.STRING_HISTORY);
        root.addContent(child);
        child.setAttribute(Constant.STRING_PARAMETER1, String.valueOf(parameter1));
        child.setAttribute(Constant.STRING_OPERATOR, operator);
        child.setAttribute(Constant.STRING_PARAMETER2, String.valueOf(parameter2));
        child.setAttribute(Constant.STRING_RESULT, String.valueOf(result));
    }

    public void outputXmlFile(File saveFile) throws IOException {
        XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
        outputter.output(document, new FileOutputStream(saveFile));
    }

}
