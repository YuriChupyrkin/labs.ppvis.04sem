package lab2.view;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.TableModel;

import lab2.controller.ScrollDownButtonListener;
import lab2.controller.ScrollUpButtonListener;
import lab2.controller.SliderListener;
import lab2.controller.ArrowIcon;
import lab2.model.PagingModel;

public class MainPanel extends JPanel{

	private enum Buttons{
		
		add("Добавить", "ADD", 250, 10, 100, 30),
		remove("Удалить", "REMOVE", 360, 10, 100, 30),
		search("Найти", "SEARCH", 470, 10, 100, 30);
		
		final int posX;
		final int posY;
		final int WIDTH;
		final int HEIGHT;
		final String NAME;
		final String COMAND;
		
		Buttons(String name, String cmd, int X, int Y, int H, int W){
			this.NAME = name;
			this.COMAND = cmd;
			this.posX = X;
			this.posY = Y;
			this.HEIGHT = H;
			this.WIDTH = W;
		}

	}
		
	private MainFrame mainFrame;
	private JScrollPane scrollPane;
	private JTable table;
	public JSlider slider;
	public JButton upButton;
	public JButton downButton;
	public PagingModel model;
	private ScrollUpButtonListener scrollUpButtonListener;
	private ScrollDownButtonListener scrollDownButtonListener;
	private SliderListener sliderListener;
	private JLabel numLabel;
	public JLabel countLabel;
	public JLabel pageLabel;
	public JLabel numPageLabel;
	
	
	public MainPanel(MainFrame frame) {
		super();
		this.mainFrame = frame;
		this.setBackground(Color.gray);
		this.setLayout(null);
		
		
		for(Buttons but: Buttons.values()){
			JButton button = new JButton(but.NAME);
			button.setBounds(but.posX, but.posY, but.HEIGHT, but.WIDTH);
			button.setActionCommand(but.COMAND);
			button.addActionListener(mainFrame.getActionItemsListener());
			this.add(button);
		}
		
		numLabel = new JLabel("количество строк: ");
		numLabel.setBounds(600, 10, 110, 30);
		this.add(numLabel);
		countLabel = new JLabel("0");
		countLabel.setBounds(710, 10, 50, 30);
		this.add(countLabel);
		pageLabel = new JLabel("1");
		pageLabel.setBounds(70, 10, 60, 30);
		this.add(pageLabel);
		numPageLabel = new JLabel("Страница: ");
		numPageLabel.setBounds(10, 10, 65, 30);
		this.add(numPageLabel);

		table = new JTable(mainFrame.getAdapter().getData().getPagingModel());	
		scrollPane = new JScrollPane(table);
		TableModel tmodel = table.getModel();
	    model = (PagingModel) tmodel;
		upButton = new JButton(new ArrowIcon(ArrowIcon.UP));
		upButton.setEnabled(false); // starts off at 0, so can't go up
		downButton = new JButton(new ArrowIcon(ArrowIcon.DOWN));
		/*if (model.getPageCount() <= 1) {
			downButton.setEnabled(false); // One page...can't scroll down
		} */
		    
		scrollUpButtonListener = new ScrollUpButtonListener(this);
		upButton.addActionListener(scrollUpButtonListener);
		scrollDownButtonListener = new ScrollDownButtonListener(this);
		downButton.addActionListener(scrollDownButtonListener);
		
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setCorner(ScrollPaneConstants.UPPER_RIGHT_CORNER, upButton);
		scrollPane.setCorner(ScrollPaneConstants.LOWER_RIGHT_CORNER, downButton);
		
		
		slider = new JSlider(0, 100, 10);
		slider.setMajorTickSpacing(5);
		slider.setMinorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);	
		slider.setBounds(10, 480, 765, 50);
		
		sliderListener = new SliderListener(this);
		slider.addChangeListener(sliderListener);
	
		scrollPane.setBounds(10, 50, 765, 430);
		this.add(scrollPane);
		this.add(slider);
	}

	
	/////////////////////////  Getters  /////////////////
	public JTable getTable() {
		return table;
	}
	
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	
}
