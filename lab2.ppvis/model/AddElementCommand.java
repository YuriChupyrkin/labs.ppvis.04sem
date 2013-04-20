package lab2.model;

import lab2.controller.AddDialogButtonListener;

public class AddElementCommand {

	private Data data;
	
	public AddElementCommand(AddDialogButtonListener dialogButtonListener) {
		super();
		data = dialogButtonListener.getAddDialog().getData();
	}
	
	public void add(String fio, String country, String province, String city,
			String street, String house, String housing, String flat){
		
		data.studList.add(new Student(fio, country, province, city, street, house, housing, flat));
		data.pagingModel = new PagingModel(data.studList);
	}
	
}
