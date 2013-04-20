package lab2.model;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;


public class SAXPars extends DefaultHandler{

	private Data data;
	private List<Student>studList;
	private String thisElement = "";
	private Student student;
	
	public SAXPars(Data data) {
		super();
		this.data = data;
		studList = data.studList;
	}
	
	
	@Override
	public void startDocument() throws SAXException {
	}
	
	@Override
	public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
		thisElement = qName; 
		  if (thisElement.equals("student")) {
			  student = new Student();   
		  }		  
	}
	
	@Override
	public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
		 if (thisElement.equals("")) {
			 if(student != null){
			  		studList.add(student);
			  		student = null;
				}
		 }
		 thisElement = "";
	}
	
	@Override
	public void endDocument() {
	}

	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		  
		  if (thisElement.equals("fio")) {
		     student.setFio(new String(ch, start, length));
		  }
		  if(thisElement.equals("country")){
			  student.setCountry(new String(ch, start, length));
		  }
		  if(thisElement.equals("province")){
			  student.setProvince(new String(ch, start, length));
		  }
		  if(thisElement.equals("city")){
			  student.setCity(new String(ch, start, length));
		  }
		  if(thisElement.equals("street")){
			  student.setStreet(new String(ch, start, length));
		  }		  
		  if(thisElement.equals("house")){
			  student.setHouse(new String(ch, start, length));
		  }	  
		  if(thisElement.equals("housing")){
			  student.setHousing(new String(ch, start, length));
		  }	 
		  if(thisElement.equals("flat")){
			  student.setFlat(new String(ch, start, length));
		  }	 
	}

	
	////////////////////////////  Getters  ///////////////
	public Data getData() {
		return data;
	}
}
