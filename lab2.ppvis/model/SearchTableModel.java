package lab2.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class SearchTableModel extends AbstractTableModel{

	private List<Student>studList;
	
	public SearchTableModel(List studList) {
		super();
		this.studList = studList;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 8;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return studList.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		Student student = studList.get(arg0);
		
		switch(arg1){
		case 0:
			return student.getFio();
		case 1:
			return student.getCountry();
		case 2:
			return student.getProvince();
		case 3:
			return student.getCity();
		case 4:
			return student.getStreet();
		case 5:
			return student.getHouse();
		case 6:
			return student.getHousing();
		case 7:
			return student.getFlat();
		}
		return "";
	}
	
	@Override
	public String getColumnName(int column){
		switch(column){
		case 0:
			return "���";
		case 1:
			return "������";
		case 2:
			return "�������";
		case 3:
			return "�����";
		case 4: 
			return "�����";
		case 5:
			return "���";	
		case 6:
			return "������";	
		case 7:
			return "��������";	
		}
		return "";
	}

	
	///////////////////////  Getters  ///////////////////
	public List<Student> getStudList() {
		return studList;
	}
}
