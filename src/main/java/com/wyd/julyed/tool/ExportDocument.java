package com.wyd.julyed.tool;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import com.wyd.julyed.Calculation;
import com.wyd.julyed.Constant;

public class ExportDocument {
    private static Element root = new Element(Constant.STRING_HISTORIES);
    private static Document document = new Document(root);

    private static void addElement(Calculation calculation) {
        int parameter1 = calculation.getParameter1Property().getValue();
        int parameter2 = calculation.getParameter2Property().getValue();
        int result = calculation.getResultProperty().getValue();
        String operator = calculation.getOperatorProperty().getValue();

        Element child = new Element(Constant.STRING_HISTORY);
        root.addContent(child);
        child.setAttribute(Constant.STRING_PARAMETER1, String.valueOf(parameter1));
        child.setAttribute(Constant.STRING_OPERATOR, operator);
        child.setAttribute(Constant.STRING_PARAMETER2, String.valueOf(parameter2));
        child.setAttribute(Constant.STRING_RESULT, String.valueOf(result));
    }

    public static void exportXmlFile(File saveFile) throws IOException {
        // 普通的循环
        // for (Calculation calculation : GlobalManager.getList()) {
        // buildDocument.addElement(calculation);
        // }
        // 文艺的循环
        GlobalManager.getList().forEach(item -> ExportDocument.addElement(item));
        XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
        outputter.output(document, new FileOutputStream(saveFile));
    }

}
