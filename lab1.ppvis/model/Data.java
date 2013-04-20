package paint.v04.model;

import java.awt.Color;

import javax.swing.text.DefaultEditorKit.CutAction;

import paint.v04.controller.Adapter;

public class Data {

	private Adapter adapter;
	private ImageData imageData;
	private int zoom;
	private Color currentColor;
	private ToolList toolList;
	private ToolActivator toolActivator;
	
	public Data(Adapter adapter) {
		super();
		this.adapter = adapter;
		zoom = 1;
		currentColor = Color.black;
		
		imageData = new ImageData(this);
		toolList = new ToolList(this);
		toolActivator = new ToolActivator(this);

	}

	
	/////////////////////////  Getters and Setters ///////////////////////////
	public ImageData getImageData() {
		return imageData;
	}
	
	public Adapter getAdapter() {
		return adapter;
	}
	
	public int getZoom() {
		return zoom;
	}

	
	public void setZoom(int x){
		this.zoom = x;
		getMainImage().setWidthAndHeight(getMainImage().image.getWidth() * zoom, getMainImage().image.getHeight() * zoom);
	}
	
	public Color getCurrentColor() {
		return currentColor;
	}
	
	public void setCurrentColor(Color currentColor) {
		this.currentColor = currentColor;
	}
	
	public ToolList getToolList() {
		return toolList;
	}
	
	public ToolActivator getToolActivator() {
		return toolActivator;
	}
	
	public MainImage getMainImage(){
		return imageData.getMainImage();
	}
}
