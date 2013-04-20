package lab2.view;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import lab2.controller.ActionItemsListener;
import lab2.controller.Adapter;
import lab2.controller.FileItemsListener;

public class MainFrame extends JFrame{

	private enum FileItems{
		newFile("создать новую таблицу", "NEW"),
		load("открыть", "LOAD"),
		save("сохранить как", "SAVE"),
		close("выход", "CLOSE");
		
		final String NAME;
		final String COMAND;
		FileItems(String name, String comand){
			this.NAME = name;
			this.COMAND = comand;
		}
	}
	
	private enum ActionItems{
		add("добавить", "ADD"),
		remove("удалить", "REMOVE"),
		search("найти", "SEARCH");
		
		final String NAME;
		final String COMAND;
		ActionItems(String name, String comand){
			this.NAME = name;
			this.COMAND = comand;
		}
	}
	
	private JMenuBar menuBar;
	private JMenu actions;
	private JMenu file;
	private JMenu help;
	private JMenuItem about;
	
	private Adapter adapter;
	private MainPanel mainPanel;
	private FileItemsListener fileItemListener;
	private ActionItemsListener actionItemsListener;
	
	public MainFrame(){
		super();
		this.setSize(800, 600);
		this.setLocation(100, 100);
		this.setResizable(false);
		this.setTitle("Lab2 by Yu4");
			
		
		adapter = new Adapter(this);
		fileItemListener = new FileItemsListener(this);
		actionItemsListener = new ActionItemsListener(this);
		mainPanel = new MainPanel(this);
		
		
		///// menu add ////////
		menuBar = new JMenuBar();
		file = new JMenu("файл");
		actions = new JMenu("действия");
		menuBar.add(file);
		menuBar.add(actions);
		
		for(FileItems fItem: FileItems.values()){
			JMenuItem menuItem = new JMenuItem(fItem.NAME);
			menuItem.setActionCommand(fItem.COMAND);
			menuItem.addActionListener(fileItemListener);
			file.add(menuItem);
		}
		
		for(ActionItems aItem: ActionItems.values()){
			JMenuItem menuItem = new JMenuItem(aItem.NAME);
			menuItem.setActionCommand(aItem.COMAND);
			menuItem.addActionListener(actionItemsListener);
			actions.add(menuItem);
		}
		
		help = new JMenu("help");
		about = new JMenuItem("about");
		about.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				DialogAbout();
			}
		});
		
		help.add(about);
		menuBar.add(help);
		this.setJMenuBar(menuBar);	
		this.addWindowListener(adapter.getWindowListener());
	}

	
	void DialogAbout()
	{
		JOptionPane.showMessageDialog(this, "Лаб №2 по ППвИС\n" +
				"выполнил: Чупыркин Ю.А." );
	}
	public void run(){
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setVisible(true);
		this.add(mainPanel);
	}
	
	
	
	////////////////////////////  Getters  //////////////////////////
	public MainPanel getMainPanel() {
		return mainPanel;
	}
	
	public Adapter getAdapter() {
		return adapter;
	}
	
	public FileItemsListener getFileItemListener() {
		return fileItemListener;
	}
	
	public ActionItemsListener getActionItemsListener() {
		return actionItemsListener;
	}

	
}
