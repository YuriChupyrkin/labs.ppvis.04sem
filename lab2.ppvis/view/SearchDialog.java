package lab2.view;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.TableModel;

import lab2.controller.ArrowIcon;
import lab2.controller.SearchDialogListener;
import lab2.model.PagingModel;
import lab2.view.RemoveDialog.ComboBoxItems;

public class SearchDialog extends JDialog{

	
	private MainFrame mainFrame;
	public JComboBox comboBox;
	private JLabel mainLabel;
	public JLabel item1Label;
	public JTextField item1Text;
	public JLabel item2Label;
	public JTextField item2Text;
	public JButton butSearch;
	private JTable table;
	private JScrollPane scrollPane;
	private SearchDialogListener searchDialogListener;
	private JLabel numLabel;
	public JLabel countLabel;
	private PagingModel model;
	JButton upButton;
	JButton downButton;
	
	public enum SearchComboBoxItems{
		firstIt("������ ���� � �������"),
		secondIt("����� � ��������"),
		thirdIt("������� � ������ ������������� � ������ ����");
		
		public final String ITEM;
		SearchComboBoxItems(String item){
			this.ITEM = item;
		}
	}
	
	public SearchDialog(MainFrame frame){
		this.mainFrame = frame;
		this.setSize(800, 600);
		this.setLocation(150, 150);
		this.setTitle("Search");
		this.setResizable(false);		
		this.setLayout(null);

		
		comboBox = new JComboBox();
		comboBox.setActionCommand("COMBOBOX");
		comboBox.setEditable(false);
		
		for(SearchComboBoxItems str: SearchComboBoxItems.values()){
			comboBox.addItem(str.ITEM);
		}
		mainLabel = new JLabel("����� �� :");		
		item1Label = new JLabel("               ����� ����");
		item2Label = new JLabel("                    �������");
		item1Text = new JTextField();
		item2Text = new JTextField();
		butSearch = new JButton("Search");
		butSearch.setActionCommand("SEARCH");
		numLabel = new JLabel("�������: ");
		countLabel = new JLabel("0");
		
		countLabel.setBounds(570, 10, 60, 30);
		numLabel.setBounds(500, 10, 60, 30);		
		butSearch.setBounds(330, 50, 150, 70);		
		mainLabel.setBounds(10, 10, 60, 30);
		comboBox.setBounds(70, 10, 410, 30);
		item1Label.setBounds(10, 50, 150, 30);
		item2Label.setBounds(10, 90, 150, 30);
		item1Text.setBounds(160, 50, 150, 30);
		item2Text.setBounds(160, 90, 150, 30);
		
		this.add(mainLabel);
		this.add(comboBox);
		this.add(item1Label);
		this.add(item2Label);
		this.add(item1Text);
		this.add(item2Text);
		this.add(butSearch);
		this.add(numLabel);
		this.add(countLabel);
				
		searchDialogListener = new SearchDialogListener(this);
		comboBox.addActionListener(searchDialogListener);
		butSearch.addActionListener(searchDialogListener);
		
		//table = new JTable(mainFrame.getAdapter().getData().getSearchTableModel());
		table = new JTable(mainFrame.getAdapter().getData().getSearchPagingModel());
		scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 150, 770, 420);
		
		upButton = new JButton(new ArrowIcon(ArrowIcon.UP));
		upButton.setEnabled(false); // starts off at 0, so can't go up
		downButton = new JButton(new ArrowIcon(ArrowIcon.DOWN));
		scrollPane.setCorner(ScrollPaneConstants.UPPER_RIGHT_CORNER, upButton);
		scrollPane.setCorner(ScrollPaneConstants.LOWER_RIGHT_CORNER, downButton);
		
		TableModel tmodel = table.getModel();
		model = (PagingModel) tmodel;
		
		upButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				model.pageUp();
		        if (model.getPageOffset() == 0) {
		        	upButton.setEnabled(false);
		        }
		        downButton.setEnabled(true);     
			}
		});
		
		downButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				model.pageDown();
			    if (model.getPageOffset() == (model.getPageCount() - 1)) {
			        downButton.setEnabled(false);
			     }
			    upButton.setEnabled(true);
			}
		});
		
		this.add(scrollPane);
	}
	
	public void runSearchDialog(){
		this.setVisible(true);
	}
	
	//////////////////////////  Getters  //////////////////////
	public SearchDialogListener getSearchDialogListener() {
		return searchDialogListener;
	}
	
	public MainFrame getMainFrame() {
		return mainFrame;
	}
	
	public JTable getTable() {
		return table;
	}
}
