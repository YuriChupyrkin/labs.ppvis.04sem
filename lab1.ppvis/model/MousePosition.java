package paint.v04.model;

import paint.v04.controller.Adapter;

public class MousePosition {

	private int MousePosX;
	private int MousePosY;
	private Adapter adapter;
	
	public MousePosition(Adapter adapter) {
		super();
		this.adapter = adapter;
	}
	
	/////////////////////////////  Getters and Setters //////////////////////
	public int getMousePosX() {
		return MousePosX;
	}
	
	public int getMousePosY() {
		return MousePosY;
	}
	
	public void setMousePos(int X, int Y){
		MousePosX = X / getData().getZoom();
		MousePosY = Y / getData().getZoom();
	}
	
	public Data getData(){
		return adapter.getData();
	}
}
