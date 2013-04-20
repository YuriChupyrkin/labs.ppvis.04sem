package paint.v04.controller;

import paint.v04.model.Data;
import paint.v04.model.MousePosition;
import paint.v04.view.MainFrame;

public class Adapter {

	private MainFrame mainFrame;
	private ButtonsAndMenuItemsListener butListener;
	private Data data;
	private ColorPanelListener colorPanelListener;
	private MousePosition mousePosition;
	private KeyListener keyListener;
	private WindowListener windowListener;
	
	public Adapter(MainFrame frame) {
		super();
		this.mainFrame = frame;
		butListener = new ButtonsAndMenuItemsListener(this);
		colorPanelListener = new ColorPanelListener(this);
		data = new Data(this);
		mousePosition = new MousePosition(this);
		keyListener = new KeyListener(this);
		windowListener = new WindowListener(this);
	}
	
	
	
	/////////////////////////////  Getters  ///////////////////////////
	public WindowListener getWindowListener() {
		return windowListener;
	}
	public KeyListener getKeyListener() {
		return keyListener;
	}
	public MainFrame getMainFrame() {
		return mainFrame;
	}
	
	public ButtonsAndMenuItemsListener getButListener() {
		return butListener;
	}
	
	public Data getData() {
		return data;
	}
	
	public ColorPanelListener getColorPanelListener() {
		return colorPanelListener;
	}
	
	public MousePosition getMousePosition() {
		return mousePosition;
	}
	
}
