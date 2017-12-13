package com.wyd.julyed;

import java.io.File;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class ImportDocument {
    public ImportDocument(String fileName) throws JDOMException, IOException {
        File importXmlFile = new File(fileName);
        SAXBuilder saxReader = new SAXBuilder();
        Document document = saxReader.build(importXmlFile);
        Element root = document.getRootElement();
    }
}
