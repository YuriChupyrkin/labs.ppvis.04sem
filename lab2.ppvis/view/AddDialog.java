package lab2.view;

import javax.swing.*;

import lab2.controller.AddDialogButtonListener;
import lab2.model.Data;

public class AddDialog extends JDialog{
	
	private JLabel fioLabel;
	private JTextField fioText;
	private JLabel counrtyLabel;
	private JTextField countryText;
	private JLabel provinceLabel;
	private JTextField provinceText;
	private JLabel cityLabel;
	private JTextField cityText;
	private JLabel streetLabel;
	private JTextField streetText;
	private JLabel houseLabel;
	private JTextField houseText;
	private JLabel housingLabel;
	private JTextField housingText;
	private JLabel flatLabel;
	private JTextField flatText;
	
	private JButton butAdd;
	private AddDialogButtonListener dialogButtonListener;
	private MainFrame mainFrame;
	
	public AddDialog(MainFrame frame){
		this.mainFrame = frame;
		this.setTitle("Add");
		this.setLocation(200, 200);
		this.setSize(300, 300);
		this.setResizable(false);
		
		butAdd = new JButton("Add");
		butAdd.setActionCommand("ADD");
		
		fioLabel = new JLabel("       ���*:");
		fioText = new JTextField("");
		counrtyLabel = new JLabel("   C�����*:");
		countryText = new JTextField("");
		provinceLabel = new JLabel("�������*:");
		provinceText = new JTextField("");
		cityLabel = new JLabel("     �����*:");
		cityText = new JTextField("");
		streetLabel = new JLabel("     �����*:");
		streetText = new JTextField("");
		houseLabel = new JLabel("         ���*:");
		houseText = new JTextField("");
		housingLabel = new JLabel("    ������:");
		housingText = new JTextField("");
		flatLabel = new JLabel("��������:");
		flatText = new JTextField("");
		
		Box fioBox = Box.createHorizontalBox();
		fioBox.add(fioLabel);
		fioBox.add(fioText);
		
		Box countryBox = Box.createHorizontalBox();
		countryBox.add(counrtyLabel);
		countryBox.add(countryText);
		
		Box provinceBox = Box.createHorizontalBox();
		provinceBox.add(provinceLabel);
		provinceBox.add(provinceText);
		
		Box cityBox = Box.createHorizontalBox();
		cityBox.add(cityLabel);
		cityBox.add(cityText);
		
		Box streetBox = Box.createHorizontalBox();
		streetBox.add(streetLabel);
		streetBox.add(streetText);
		
		Box houseBox = Box.createHorizontalBox();
		houseBox.add(houseLabel);
		houseBox.add(houseText);
		
		Box housingBox = Box.createHorizontalBox();
		housingBox.add(housingLabel);
		housingBox.add(housingText);
		
		Box flatBox = Box.createHorizontalBox();
		flatBox.add(flatLabel);
		flatBox.add(flatText);
		
		Box butBox = Box.createHorizontalBox();
		butBox.add(butAdd);
		
		Box mainBox = Box.createVerticalBox();
		mainBox.add(fioBox);
		mainBox.add(countryBox);
		mainBox.add(provinceBox);
		mainBox.add(cityBox);
		mainBox.add(streetBox);
		mainBox.add(houseBox);
		mainBox.add(housingBox);
		mainBox.add(flatBox);
		
		mainBox.add(butBox);

		this.add(mainBox);
		
		dialogButtonListener = new AddDialogButtonListener(this);
		butAdd.addActionListener(dialogButtonListener);
	}
	
	public void runAddDialog(){
		this.setVisible(true);
	}
	
	
	////////////////////////  Getters  /////////////////////////
	public Data getData(){
		return mainFrame.getAdapter().getData();
	}
	
	public MainFrame getMainFrame() {
		return mainFrame;
	}

	public JTextField getFioText() {
		return fioText;
	}

	public JTextField getCountryText() {
		return countryText;
	}

	public JTextField getProvinceText() {
		return provinceText;
	}

	public JTextField getCityText() {
		return cityText;
	}

	public JTextField getStreetText() {
		return streetText;
	}

	public JTextField getHouseText() {
		return houseText;
	}

	public JTextField getHousingText() {
		return housingText;
	}

	public JTextField getFlatText() {
		return flatText;
	}
	
	

}
