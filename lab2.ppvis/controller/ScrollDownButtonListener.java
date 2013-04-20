package lab2.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import lab2.view.MainPanel;

public class ScrollDownButtonListener extends AbstractAction{

	private MainPanel mainPanel;
	
	public ScrollDownButtonListener(MainPanel mainPanel) {
		super();
		this.mainPanel = mainPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		mainPanel.model.pageDown();
	    if (mainPanel.model.getPageOffset() == (mainPanel.model.getPageCount() - 1)) {
	        mainPanel.downButton.setEnabled(false);
	     }
	    mainPanel.upButton.setEnabled(true);
	    mainPanel.pageLabel.setText(String.valueOf(mainPanel.model.getPageNum() + 1));
    	mainPanel.repaint();
	}

}
