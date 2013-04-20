package lab2.model;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import lab2.controller.RemoveDialogListener;
import lab2.view.RemoveDialog;
import lab2.view.RemoveDialog.ComboBoxItems;

public class RemoveElements {

	private RemoveDialogListener removeDialogListener;
	private Data data;
	private RemoveDialog removeDialog;
	private List<Student>studList;
	private int count;
	
	public RemoveElements(RemoveDialogListener removeDialogListener) {
		super();
		this.removeDialogListener = removeDialogListener;
		studList = removeDialogListener.getMainFrame().getAdapter().getData().studList;
		removeDialog = removeDialogListener.getRemoveDialog();
	}
	
	
	public void revomeEl(){
		
		if(removeDialog.item1Text.getText().length() > 0 && removeDialog.item2Text.getText().length() > 0){
			for(int index = 0; index < studList.size(); index++){
				
				Student stud = studList.get(index);
				
				if(ComboBoxItems.firstIt.ITEM  == (String)removeDialog.comboBox.getSelectedItem()){
					if(stud.getFio().indexOf(removeDialog.item2Text.getText()) != -1 && stud.getHouse().equals(removeDialog.item1Text.getText())){
						if(stud.getFio().length() > removeDialog.item2Text.getText().length()){
							if(stud.getFio().toCharArray()[removeDialog.item2Text.getText().length()] == ' '){
								studList.remove(index);
								index--;
								count++;
							}
						}
						else {
							if(stud.getFio().equals(removeDialog.item2Text.getText())){
								studList.remove(index);
								index--;
								count++;
							}
						}
					}
				}
				else if(ComboBoxItems.secondIt.ITEM  == (String)removeDialog.comboBox.getSelectedItem()){
					if(stud.getFlat().equals(removeDialog.item2Text.getText()) && stud.getStreet().equals(removeDialog.item1Text.getText())){
						studList.remove(index);
						index--;
						count++;
					}
				}
				else if(ComboBoxItems.thirdIt.ITEM  == (String)removeDialog.comboBox.getSelectedItem()){
						if(stud.getHouse().indexOf(removeDialog.item2Text.getText()) != -1
								&& stud.getFio().indexOf(removeDialog.item1Text.getText()) != -1){
							if(stud.getFio().length() > removeDialog.item1Text.getText().length()){
								if(stud.getFio().toCharArray()[removeDialog.item1Text.getText().length()] == ' '){					
									studList.remove(index);
									index--;
									count++;
									}
								}
												
							else{
								if(stud.getFio().equals(removeDialog.item1Text.getText())){
									studList.remove(index);
									index--;
									count++;
								}
							}
						}
				} 
				
			}
		}
		else if(removeDialog.item1Text.getText().length() > 0 && removeDialog.item2Text.getText().length() == 0){
			for(int index = 0; index < studList.size(); index++){
				
				Student stud = studList.get(index);
				
				if(ComboBoxItems.firstIt.ITEM  == (String)removeDialog.comboBox.getSelectedItem()){
					if(stud.getHouse().equals(removeDialog.item1Text.getText())){
						studList.remove(index);
						index--;
						count++;
					}
				}
				else if(ComboBoxItems.secondIt.ITEM  == (String)removeDialog.comboBox.getSelectedItem()){
					if(stud.getStreet().equals(removeDialog.item1Text.getText())){
						studList.remove(index);
						index--;
						count++;
					}
				}
				else if(ComboBoxItems.thirdIt.ITEM  == (String)removeDialog.comboBox.getSelectedItem()){
					if(stud.getFio().indexOf(removeDialog.item1Text.getText()) != -1){
						if(stud.getFio().length() > removeDialog.item1Text.getText().length()){
							if(stud.getFio().toCharArray()[removeDialog.item1Text.getText().length()] == ' '){			
							studList.remove(index);
							index--;
							count++;
							}
						}
						else{
							if(stud.getFio().equals(removeDialog.item1Text.getText())){
								studList.remove(index);
								index--;
								count++;
							}
						}
					}
				} 
			}				
		}
		else if(removeDialog.item1Text.getText().length() == 0 && removeDialog.item2Text.getText().length() > 0){
			for(int index = 0; index < studList.size(); index++){
				
				Student stud = studList.get(index);
				
				if(ComboBoxItems.firstIt.ITEM  == (String)removeDialog.comboBox.getSelectedItem()){
					if(stud.getFio().indexOf(removeDialog.item2Text.getText()) != -1){
						if(stud.getFio().length() > removeDialog.item2Text.getText().length()){
							if(stud.getFio().toCharArray()[removeDialog.item2Text.getText().length()] == ' '){
								studList.remove(index);
								index--;
								count++;
							}
						}
						else {
							if(stud.getFio().equals(removeDialog.item2Text.getText())){
								studList.remove(index);
								index--;
								count++;
							}
						}
					}
				}
				else if(ComboBoxItems.secondIt.ITEM  == (String)removeDialog.comboBox.getSelectedItem()){
					if(stud.getFlat().equals(removeDialog.item2Text.getText())){
						studList.remove(index);
						index--;
						count++;
					}
				}
				else if(ComboBoxItems.thirdIt.ITEM  == (String)removeDialog.comboBox.getSelectedItem()){
					if(stud.getHouse().indexOf(removeDialog.item2Text.getText()) != -1){
						studList.remove(index);
						index--;
						count++;
					}
				} 
				
			}
		}
		
	
		JTable table = removeDialog.getMainFrame().getMainPanel().getTable();
		table.revalidate();
		table.repaint();
		removeDialog.setVisible(false);
		
		JOptionPane.showMessageDialog(removeDialog.getMainFrame(), "Удалено " + count + " элемет(ов)" );
	}
	
	
	

}
