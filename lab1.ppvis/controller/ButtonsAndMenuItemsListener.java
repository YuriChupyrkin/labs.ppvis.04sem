package paint.v04.controller;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import paint.v04.model.MainImage;
import paint.v04.model.ToolActivator;
import paint.v04.model.ToolList;
import paint.v04.view.DrawPanel;

public class ButtonsAndMenuItemsListener extends AbstractAction {

	private Adapter adapter;	
	private String comand;
	
	public ButtonsAndMenuItemsListener(Adapter adapter) {
		super();
		this.adapter = adapter;
	}

	public void actionPerformed(ActionEvent arg0) {
		comand = arg0.getActionCommand();
		ToolActivator toolActivator = getToolActivator();
		
		if(comand.equals("CLOSE")){
			adapter.getData().getImageData().getLoaderAndSaver().saveDialog("close");
		}
		else if(comand.equals("LOAD")){
			adapter.getData().getImageData().getLoaderAndSaver().saveDialog("load");
		}
		else if(comand.equals("SAVE")){
			adapter.getData().getImageData().getLoaderAndSaver().saveAs();
		}
		else if(comand.equals("PEN")){
			toolActivator.activate(getToolList().getPen());
		}
		else if(comand.equals("CUT")){
			toolActivator.activate(getToolList().getRect());
		}
		else if(comand.equals("DRAG")){
			toolActivator.activate(getToolList().getDragImage());
		}
		else if(comand.equals("PASTE")){
			toolActivator.activate(getToolList().getCopyImage());
		}
		else if(comand.equals("BRUSH")){
			toolActivator.activate(getToolList().getBrush());
		}
		else if(comand.equals("RECT")){
			toolActivator.activate(getToolList().getDrawRectangle());
		}
		else if(comand.equals("LINE")){
			toolActivator.activate(getToolList().getDrawLine());
		}
		else if(comand.equals("ERASER")){
			toolActivator.activate(getToolList().getEraser());
		}
		else if(comand.equals("DEL")){
			adapter.getData().getToolList().getDeleteArea().delete();
			getDrawPanel().repaint();
		}
		else if(comand.equals("OVAL")){
			toolActivator.activate(getToolList().getDrawOval());
		}
		else if(comand.equals("ZOOM2")){
			adapter.getData().setZoom(2);
			getDrawPanel().setPreferredSize(new Dimension(getMainImage().getWidth(), getMainImage().getHeight()));
			getDrawPanel().revalidate();
			getDrawPanel().repaint();
		}
		else if(comand.equals("ZOOM4")){
			adapter.getData().setZoom(4);
			getDrawPanel().setPreferredSize(new Dimension(getMainImage().getWidth(), getMainImage().getHeight()));
			getDrawPanel().revalidate();
			getDrawPanel().repaint();
		}
		else if(comand.equals("ZOOM1")){
			adapter.getData().setZoom(1);
			getDrawPanel().setPreferredSize(new Dimension(getMainImage().getWidth(), getMainImage().getHeight()));
			getDrawPanel().revalidate();
			getDrawPanel().repaint();
		}
		
		if(comand != "CUT" && comand != "PASTE" && comand != "DRAG"){
			adapter.getData().getImageData().getMainRect().setToZero();
		}
		
		adapter.getMainFrame().getMainPanel().requestFocusInWindow();
	}

	//////////////////////  Getters  ////////////////////
	public ToolActivator getToolActivator(){
		return adapter.getData().getToolActivator();
	}
	
	public ToolList getToolList(){
		return adapter.getData().getToolList();
	}
	public MainImage getMainImage(){
		return adapter.getData().getImageData().getMainImage();
	}
	
	public DrawPanel getDrawPanel(){
		return adapter.getMainFrame().getDrawPanel();
	}
}
