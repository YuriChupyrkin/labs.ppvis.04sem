package lab2.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.event.ChangeEvent;

import lab2.view.AddDialog;
import lab2.view.MainFrame;
import lab2.view.RemoveDialog;
import lab2.view.SearchDialog;

public class ActionItemsListener extends AbstractAction{

	private MainFrame mainFrame;
	private String comand;
	private AddDialog addDialog;
	
	public ActionItemsListener(MainFrame frame) {
		super();
		this.mainFrame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		comand = e.getActionCommand();
		
		if(comand.equals("ADD")){
			addDialog = new AddDialog(mainFrame);
			addDialog.runAddDialog();
		}
		else if(comand.equals("REMOVE")){
			RemoveDialog removeDialog = new RemoveDialog(mainFrame);
			removeDialog.runRemoveDialog();
		}
		else if(comand.equals("SEARCH")){
			SearchDialog searchDialog = new SearchDialog(mainFrame);
			searchDialog.getMainFrame().getAdapter().getData().searchList.clear();
			searchDialog.getTable().revalidate();
			searchDialog.getTable().repaint();
			searchDialog.runSearchDialog();
		}
		
	}
	
	
	////////////////////////////  Getters  ///////////////////
	public MainFrame getMainFrame() {
		return mainFrame;
	}

}
