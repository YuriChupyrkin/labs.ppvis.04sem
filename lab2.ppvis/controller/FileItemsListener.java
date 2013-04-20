package lab2.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import lab2.view.MainFrame;

public class FileItemsListener extends AbstractAction{

	private MainFrame mainFrame;
	private String comand;

	
	public FileItemsListener(MainFrame frame) {
		super();
		this.mainFrame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		comand = arg0.getActionCommand();
		if(comand.equals("CLOSE")){
			mainFrame.getAdapter().getData().getLoaderSaver().saveDialog("close");
		}
		else if(comand.equals("LOAD")){
			mainFrame.getAdapter().getData().getLoaderSaver().saveDialog("load");
		}
		else if(comand.equals("SAVE")){
			mainFrame.getAdapter().getData().getLoaderSaver().saveAs();
		}
		else if(comand.equals("NEW")){
			mainFrame.getAdapter().getData().getLoaderSaver().saveDialog("new");
		}
	}
	
	//////////////////////////////  Getters  /////////////////////////////////
	public MainFrame getMainFrame() {
		return mainFrame;
	}

}
