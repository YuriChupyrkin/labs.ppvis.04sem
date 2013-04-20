package paint.v04.view;
import java.awt.Color;

import javax.swing.*;

public class MainPanel extends JPanel{

	private MainFrame frame;
	private ButtonPanel buttonPanel;
	private ColorPanel colorPanel;
	private DrawPanel drawPanel;
	JScrollPane scrollPane;
	
	public MainPanel(MainFrame frame) {
		super();
		this.frame = frame;
		this.setBackground(Color.DARK_GRAY);
		this.setLayout(null);
		
		buttonPanel = new ButtonPanel(frame);
		buttonPanel.setBounds(5, 10, 100, 610);	
		colorPanel = new ColorPanel(this);
		colorPanel.setBounds(120, 560, 400, 60);	
		drawPanel = new DrawPanel(frame);
		scrollPane = new JScrollPane(drawPanel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);		
		scrollPane.setBounds(120, 10, 850, 500);
				
		this.add(buttonPanel);
		this.add(colorPanel);
		this.add(scrollPane);
		
		this.setFocusable(true);
		this.addKeyListener(frame.getAdapter().getKeyListener());
	}
	
	
	///////////////////////////////////  Getters  //////////////
	public DrawPanel getDrawPanel() {
		return drawPanel;
	}
	
	public MainFrame getMainFrame(){
		return frame;
	}
	
	public ColorPanel getColorPanel() {
		return colorPanel;
	}

	
}
