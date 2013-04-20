package lab2.controller;

import lab2.model.Data;
import lab2.view.MainFrame;

public class Adapter {

	private MainFrame mainFrame;
	private Data data;
	private WindowListener windowListener;
	
	public Adapter(MainFrame frame) {
		super();
		this.mainFrame = frame;
		data = new Data(this);
		windowListener = new WindowListener(this);
	}
	
	
	
	////////////////////////  Getters  //////////////////////////
	public MainFrame getMainFrame() {
		return mainFrame;
	}
	
	public Data getData() {
		return data;
	}
	
	public WindowListener getWindowListener() {
		return windowListener;
	}
	
}
