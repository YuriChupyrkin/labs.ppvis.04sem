package paint.v04.view;
import java.awt.Color;

import javax.swing.*;

public class ButtonPanel extends JPanel{

	private enum Buttons
	{
		Pen("pencil.gif", "PEN", 5, 10, 40, 40),
		Brush("brush.gif", "BRUSH", 52, 10, 40, 40),
		Line("line.gif", "LINE", 5, 55, 40, 40),
		Eraser("eraser.gif", "ERASER", 52, 55, 40, 40),
		Oval("ellipse.gif", "OVAL", 5, 100, 40, 40),
		Rect("rect.gif", "RECT", 52, 100, 40, 40),
		Zoom1("zoom1.gif", "ZOOM1", 5, 145, 40, 40),
		Zoom2("zoom2.gif", "ZOOM2", 52, 145, 40, 40),
		Cut("cut.gif", "CUT", 52, 190, 40, 40),
		Del("del.gif", "DEL", 5, 190, 40, 40),
		Paste("paste.gif", "PASTE", 52, 235, 40, 40),
		Drag("drag.gif", "DRAG", 5, 235, 40, 40);
		
		final int posX;
		final int posY;
		final int width;
		final int height;
		final String ICON;
		final String COMAND;
		
		Buttons(String butIcon, String cmd, int butPosX, int butPosY, int butWidth, int butHeight)
		{
			this.ICON = butIcon;
			this.posX = butPosX;
			this.posY = butPosY;
			this.width = butWidth;
			this.height = butHeight;
			this.COMAND = cmd;
		}
	}
	
	private MainFrame mainFrame;
	
	public ButtonPanel(MainFrame frame) {
		super();
		this.mainFrame = frame;
		this.setBackground(Color.gray);
		this.setLayout(null);
		
		for(Buttons but : Buttons.values())
		{
			JButton button = new JButton(new ImageIcon(but.ICON));
			button.setBounds(but.posX, but.posY, but.width, but.height);
			button.setActionCommand(but.COMAND);
			button.addActionListener(mainFrame.getAdapter().getButListener());
			this.add(button);
		}
	}

	
}
