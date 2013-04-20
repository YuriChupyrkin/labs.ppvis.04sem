package paint.v04.view;
import java.awt.HeadlessException;

import javax.swing.*;

import paint.v04.controller.Adapter;


public class MainFrame extends JFrame{

	private enum ToolItems
	{
		pen("pen", "PEN"),
		brush("brush", "BRUSH"),
		eraser("eraser", "ERASER"),
		zoom1("zoom x1", "ZOOM1"),
		zoom2("zoom x2", "ZOOM2"),
		zoom4("zoom x4", "ZOOM4"),
		rect("draw rectangle", "RECT"),
		line("draw line", "LINE"),
		oval("draw oval", "OVAL"),
		cut("cut", "CUT"),
		drag("drag", "DRAG"),
		paste("copy", "PASTE"),
		del("delete area", "DEL");
		
		final String NAME;
		final String COMAND;
		
		private ToolItems(String name, String comand)
		{
			this.NAME = name;
			this.COMAND = comand;
		}
	}
	private enum FileItems
	{
		load("load", "LOAD"),
		save("save", "SAVE"),
		close("close", "CLOSE");
		
		final String NAME;
		final String COMAND;
		
		private FileItems(String name, String comand)
		{
			this.NAME = name;
			this.COMAND = comand;
		}
	}
	
	private JMenuBar menuBar;
	private JMenu tools;
	private JMenu file;
	private JMenu help;
	private JMenuItem aboutItem;	
	private MainPanel mainPanel;
	private Adapter adapter;
	
	public MainFrame() throws HeadlessException {
		super();
		this.setSize(1000, 700);
		this.setLocation(70, 40);
		this.setResizable(false);
		this.setTitle("Easy Paint v0.0.04");
		
		adapter = new Adapter(this);
		mainPanel = new MainPanel(this);
		
		menuBar = new JMenuBar();
		tools = new JMenu("Tools");
		file = new JMenu("File");
		help = new JMenu("Help");
		aboutItem = new JMenuItem("about");
		menuBar.add(file);
		menuBar.add(tools);
		menuBar.add(help);
		help.add(aboutItem);
		
		for(ToolItems item : ToolItems.values())
		{
			JMenuItem menuItem = new JMenuItem(item.NAME);
			menuItem.setActionCommand(item.COMAND);
			menuItem.addActionListener(getAdapter().getButListener());
			tools.add(menuItem);
		}
		
		for(FileItems item : FileItems.values())
		{
			JMenuItem menuItem = new JMenuItem(item.NAME);
			menuItem.setActionCommand(item.COMAND);
			menuItem.addActionListener(getAdapter().getButListener());
			file.add(menuItem);
		}
		
		this.setJMenuBar(menuBar);
		this.addWindowListener(adapter.getWindowListener());
	}

	public void run()
	{
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setVisible(true);
		this.add(mainPanel);
	}
	
	
	/////////////////////////////  Getters  //////////////////////////
	public DrawPanel getDrawPanel()
	{
		return mainPanel.getDrawPanel();
	}
	
	public Adapter getAdapter() {
		return adapter;
	}
	
	public MainPanel getMainPanel() {
		return mainPanel;
	}
}
