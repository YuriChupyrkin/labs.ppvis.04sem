package lab2.controller;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import lab2.view.MainPanel;

public class SliderListener implements ChangeListener{

	private MainPanel mainPanel;
	
	public SliderListener(MainPanel mainPanel) {
		super();
		this.mainPanel = mainPanel;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
			mainPanel.slider = (JSlider)e.getSource();
			if(mainPanel.slider.getValue() != 0){
				mainPanel.model.setPageSize(mainPanel.slider.getValue());
			}
			else{
				mainPanel.model.setPageSize(1);
			}
			mainPanel.pageLabel.setText(String.valueOf(mainPanel.model.getPageNum() + 1));
		    mainPanel.repaint();
			mainPanel.getTable().revalidate();
			mainPanel.getTable().repaint();
	}

}
