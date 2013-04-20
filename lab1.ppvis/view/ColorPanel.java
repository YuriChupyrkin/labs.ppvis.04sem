package paint.v04.view;
import java.awt.Color;

import javax.swing.*;

import paint.v04.controller.Adapter;

public class ColorPanel extends JPanel{

	private enum ColorsButtons
	{
		//butCurrenColor("CHOOSE", Color.black, 20, 5, 50, 50),
		butWhite("WHITE", Color.white, 100, 20, 20, 20),
		butBlack("BLACK", Color.black, 130, 20, 20, 20),
		butRed("RED", Color.red, 160, 20, 20, 20),
		butOrange("ORANGE", Color.orange, 190, 20, 20, 20),
		butYellow("YELLOW", Color.yellow, 220, 20, 20, 20),
		butGreen("GREEN", Color.green, 250, 20, 20, 20),
		butBLUE("BLUE", Color.blue, 280, 20, 20, 20),
		butMagneta("MAGNETA", Color.magenta, 310, 20, 20, 20);
		
		final int posX;
		final int posY;
		final int width;
		final int height;
		final String COMAND;
		Color color;
				
		ColorsButtons(String cmd, Color color, int butPosX, int butPosY, int butWidth, int butHeight)
		{
			this.color = color;
			this.posX = butPosX;
			this.posY = butPosY;
			this.width = butWidth;
			this.height = butHeight;
			this.COMAND = cmd;
		}
	}
	
	public JButton butChooseColor;
	
	MainPanel mainPanel;
	public ColorPanel(MainPanel panel) {
		super();
		this.mainPanel = panel;
		this.setBackground(Color.gray);
		this.setLayout(null);
		
		butChooseColor = new JButton();
		butChooseColor.setBackground(Color.black);
		butChooseColor.setBounds(20, 5, 50, 50);
		butChooseColor.addActionListener(getAdapter().getColorPanelListener());
		butChooseColor.setActionCommand("CHOOSE");
		this.add(butChooseColor);
		
		for(ColorsButtons but : ColorsButtons.values())
		{
			JButton button = new JButton();
			button.setBackground(but.color);
			button.setActionCommand(but.COMAND);
			button.setBounds(but.posX, but.posY, but.width, but.height);
			button.addActionListener(getAdapter().getColorPanelListener());
			this.add(button);
		}
	}

	
	//////////////////////////////  Getters  /////////////////////
	public Adapter getAdapter(){
		return mainPanel.getMainFrame().getAdapter();
	}
}
