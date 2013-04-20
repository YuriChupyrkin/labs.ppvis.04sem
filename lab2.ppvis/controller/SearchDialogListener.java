package lab2.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import lab2.model.SearchElement;
import lab2.view.RemoveDialog.ComboBoxItems;
import lab2.view.SearchDialog;
import lab2.view.SearchDialog.SearchComboBoxItems;

public class SearchDialogListener extends AbstractAction{

	private SearchDialog searchDialog;
	private String comand;
	private SearchElement searchElement;
	
	public SearchDialogListener(SearchDialog searchDialog) {
		super();
		this.searchDialog = searchDialog;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		comand = arg0.getActionCommand();
		
		if(comand.equals("COMBOBOX")){
			if(SearchComboBoxItems.firstIt.ITEM  == (String)searchDialog.comboBox.getSelectedItem()){
				searchDialog.item1Label.setText("               ����� ����");
				searchDialog.item2Label.setText("                  �������");
			}
			else if(ComboBoxItems.secondIt.ITEM  == (String)searchDialog.comboBox.getSelectedItem()){
				searchDialog.item1Label.setText("                    �����");
				searchDialog.item2Label.setText("                 ��������");
			}
			else if(ComboBoxItems.thirdIt.ITEM  == (String)searchDialog.comboBox.getSelectedItem()){
				searchDialog.item1Label.setText("                  �������");
				searchDialog.item2Label.setText("����� ������������� � ������ ����");
			}
		}
		else if(comand.equals("SEARCH")){
			searchElement = new SearchElement(this);
			searchElement.searchEl();
			searchDialog.getTable().revalidate();
			searchDialog.getTable().repaint();
			searchDialog.getMainFrame().getMainPanel().repaint();
		}
		
	}
	
	
	///////////////////////  Getters  //////////////////////////////
	public SearchDialog getSearchDialog() {
		return searchDialog;
	}
	
	public SearchElement getSearchElement() {
		return searchElement;
	}

}
