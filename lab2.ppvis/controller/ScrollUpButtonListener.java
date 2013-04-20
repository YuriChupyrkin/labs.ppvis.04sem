package lab2.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import lab2.view.MainPanel;

public class ScrollUpButtonListener extends AbstractAction{

	private MainPanel mainPanel;
	
	public ScrollUpButtonListener(MainPanel mainPanel) {
		super();
		this.mainPanel = mainPanel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		mainPanel.model.pageUp();
        if (mainPanel.model.getPageOffset() == 0) {
        	mainPanel.upButton.setEnabled(false);
        }
        mainPanel.downButton.setEnabled(true);     
        mainPanel.pageLabel.setText(String.valueOf(mainPanel.model.getPageNum() + 1));
    	mainPanel.repaint();
	}
	

}
