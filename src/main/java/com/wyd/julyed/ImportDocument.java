package com.wyd.julyed;

import java.io.File;
import java.io.Reader;
import java.sql.SQLException;

import javax.sql.RowSetInternal;
import javax.sql.rowset.WebRowSet;
import javax.sql.rowset.spi.XmlReader;
import javax.swing.text.Document;

import org.dom4j.io.SAXReader;
import org.jdom2.Element;

public class ImportDocument {
	public ImportDocument (String fileName) {
		File importXmlFile = new File(fileName);
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(importXmlFile);
		Element root = document.getRootElements();
		Element 
		 
	}
}
