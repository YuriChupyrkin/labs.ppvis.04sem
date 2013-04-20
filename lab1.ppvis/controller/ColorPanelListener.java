package paint.v04.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JColorChooser;

import paint.v04.model.Data;
import paint.v04.view.ColorPanel;

public class ColorPanelListener extends AbstractAction{

	private Adapter adapter;
	private String comand;
	
	public ColorPanelListener(Adapter adapter) {
		super();
		this.adapter = adapter;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		comand = arg0.getActionCommand();
		
		if(comand.equals("CHOOSE")){
			JColorChooser colorChooser = null;
			getData().setCurrentColor(colorChooser.showDialog(getColorPanel().butChooseColor, "Choose color", Color.white));
		}
		else if(comand.equals("WHITE")){
			getData().setCurrentColor(Color.white);
		}
		else if(comand.equals("BLACK")){
			getData().setCurrentColor(Color.black);
		}
		else if(comand.equals("RED")){
			getData().setCurrentColor(Color.red);
		}
		else if(comand.equals("ORANGE")){
			getData().setCurrentColor(Color.orange);
		}
		else if(comand.equals("YELLOW")){
			getData().setCurrentColor(Color.yellow);
		}
		else if(comand.equals("GREEN")){
			getData().setCurrentColor(Color.green);
		}
		else if(comand.equals("BLUE")){
			getData().setCurrentColor(Color.blue);
		}
		else if(comand.equals("MAGNETA")){
			getData().setCurrentColor(Color.magenta);
		}
			
		
		getColorPanel().butChooseColor.setBackground(getData().getCurrentColor());
		getColorPanel().repaint();
		adapter.getMainFrame().getMainPanel().requestFocusInWindow();
	}
	
	////////////////////  Getters  /////////////////////////
	public Data getData()
	{
		return adapter.getData();
	}
	
	public ColorPanel getColorPanel()
	{
		return adapter.getMainFrame().getMainPanel().getColorPanel();
	}
	
}
