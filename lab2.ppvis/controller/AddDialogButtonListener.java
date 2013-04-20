package lab2.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import lab2.model.AddElementCommand;
import lab2.view.AddDialog;

public class AddDialogButtonListener extends AbstractAction{

	private AddDialog addDialog;
	private String comand;
	
	public AddDialogButtonListener(AddDialog addDialog) {
		super();
		this.addDialog = addDialog;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		comand = arg0.getActionCommand();
		
			if(addDialog.getFioText().getText().length() > 0 && addDialog.getCountryText().getText().length() > 0 &&
					addDialog.getProvinceText().getText().length() > 0 && addDialog.getCityText().getText().length() > 0
					&& addDialog.getStreetText().getText().length() > 0 
					&& addDialog.getHouseText().getText().length() > 0){
				
				AddElementCommand addElement = new AddElementCommand(this);
				addElement.add(addDialog.getFioText().getText(), addDialog.getCountryText().getText(),
						addDialog.getProvinceText().getText(), addDialog.getCityText().getText(),
						addDialog.getStreetText().getText(), addDialog.getHouseText().getText(),
						addDialog.getHousingText().getText(), addDialog.getFlatText().getText());
				addDialog.setVisible(false);
				addDialog.getMainFrame().getMainPanel().getTable().revalidate();
				addDialog.getMainFrame().getMainPanel().getTable().repaint();
				
				addDialog.getMainFrame().getMainPanel().countLabel.setText(String.valueOf(addDialog.
						getMainFrame().getAdapter().getData().studList.size()));
				addDialog.getMainFrame().getMainPanel().repaint();
			}
			else{
				JOptionPane.showMessageDialog(addDialog.getMainFrame(), "����������� ������������ ����!");
			}
		
	}
	
	///////////////////////  Getters  ///////////////
	public AddDialog getAddDialog() {
		return addDialog;
	}
}
