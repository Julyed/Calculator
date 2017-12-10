package com.wyd.julyed;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class BuildDocument {
	int parameter1, parameter2, result;
	String operator;

	public void SetDocElement(Calculation calculation) {
		this.parameter1 = calculation.parameter1Property().getValue();
		this.parameter2 = calculation.parameter2Property().getValue();
		this.result = calculation.resultProperty().getValue();
		this.operator = calculation.getOperator().getOperatorString();
	}

	public static void BuildXMLDoc() throws IOException, JDOMException {
		Document document = new Document();
		Element root = new Element("histories");
		document.setRootElement(root);
		Element child1 = new Element("history");
		root.addContent(child1);
		child1.setAttribute("parameter1", "2");
		child1.setAttribute("operator", "+");
		child1.setAttribute("parameter2", "3");
		child1.setAttribute("result", "5");
		Element child2 = new Element("history");
		root.addContent(child2);
		child2.setAttribute("parameter1", "2");
		child2.setAttribute("operator", "+");
		child2.setAttribute("parameter2", "3");
		child2.setAttribute("result", "5");
		XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
		outputter.output(document, new FileOutputStream(new File("result.xml")));
	}

	public static void main(String[] args) {
		try {
			BuildXMLDoc();
		} catch (IOException | JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}