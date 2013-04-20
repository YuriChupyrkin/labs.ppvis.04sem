package lab2.view;
import javax.swing.*;

import lab2.controller.RemoveDialogListener;

public class RemoveDialog extends JDialog{
	
	private MainFrame mainFrame;
	public JComboBox comboBox;
	private JLabel mainLabel;
	public JLabel item1Label;
	public JTextField item1Text;
	public JLabel item2Label;
	public JTextField item2Text;
	public JButton butRemove;
	private RemoveDialogListener removeDialogListener;
	
	public enum ComboBoxItems{
		firstIt("������ ���� � �������"),
		secondIt("����� � ��������"),
		thirdIt("������� � ������ ������������� � ������ ����");
		
		public final String ITEM;
		ComboBoxItems(String item){
			this.ITEM = item;
		}
	}
	
	public RemoveDialog(MainFrame frame){
		this.mainFrame = frame;
		
		this.setLocation(200, 200);
		this.setSize(450, 150);
		this.setTitle("Remove");
		this.setResizable(false);
		
		removeDialogListener = new RemoveDialogListener(this);
		
		comboBox = new JComboBox();
		comboBox.setActionCommand("COMBOBOX");
		comboBox.setEditable(false);
		
		for(ComboBoxItems str: ComboBoxItems.values()){
			comboBox.addItem(str.ITEM);
		}
		
		mainLabel = new JLabel("������� �� ");
		
		item1Label = new JLabel("               ����� ����");
		item2Label = new JLabel("                    �������");
		item1Text = new JTextField();
		item2Text = new JTextField();
		butRemove = new JButton("Remove");
		butRemove.setActionCommand("REMOVE");
		
		Box boxCondition = Box.createHorizontalBox();
		boxCondition.add(mainLabel);
		boxCondition.add(comboBox);
		
		Box boxItem1 = Box.createHorizontalBox();
		boxItem1.add(item1Label);
		boxItem1.add(item1Text);
		
		Box boxItem2 = Box.createHorizontalBox();
		boxItem2.add(item2Label);
		boxItem2.add(item2Text);
		
		Box boxButton = Box.createHorizontalBox();
		boxButton.add(butRemove);
		
		Box mainBox = Box.createVerticalBox();
		mainBox.add(boxCondition);
		mainBox.add(boxItem1);
		mainBox.add(boxItem2);
		mainBox.add(boxButton);
	
		this.add(mainBox);
		
		comboBox.addActionListener(removeDialogListener);
		butRemove.addActionListener(removeDialogListener);
	}

	
	
	public void runRemoveDialog(){
		this.setVisible(true);
	}
	
	////////////////  Getters  //////////////////
	public MainFrame getMainFrame() {
		return mainFrame;
	}
}
