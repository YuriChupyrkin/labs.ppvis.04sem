package paint.v04.model;

import java.awt.geom.Rectangle2D;


public class MainRectangle {

	private ImageData imageData;
	Rectangle2D rectangle2D;
	private int rectPosX;
	private int rectPosY;
	private int lastX;
	private int lastY;
	private int finalRectPosX;
	private int finalRectPosY;
	
	public MainRectangle(ImageData imData) {
		super();
		this.imageData = imData;
	}
	

	public void setToZero(){
		finalRectPosX = 0;
		finalRectPosY = 0;
		rectPosX = 0;
		rectPosY = 0;
		lastX = 0;
		lastY = 0;
		rectangle2D = null;
	}
	
	
	/////////////////////  Getters and Setters  ////////////////
	
	public int getRectPosX() {
		return rectPosX;
	}
	
	public int getFinalRectPosX() {
		return finalRectPosX;
	}


	public void setFinalRectPosX(int finalRectPosX) {
		this.finalRectPosX = finalRectPosX - rectPosX * imageData.getData().getZoom();
	}


	public int getFinalRectPosY() {
		return finalRectPosY;
	}


	public void setFinalRectPosY(int finalRectPosY) {
		this.finalRectPosY = finalRectPosY - rectPosY * imageData.getData().getZoom();
	}


	public int getLastX() {
		return lastX;
	}


	public void setLastX(int lastX) {
		this.lastX = lastX / imageData.getData().getZoom();
	}


	public int getLastY() {
		return lastY;
	}


	public void setLastY(int lastY) {
		this.lastY = lastY / imageData.getData().getZoom();
	}


	public int getRectPosY() {
		return rectPosY;
	}
	
	
	public void setRectPos(int X,int Y){
		rectPosX = X / imageData.getData().getZoom();
		rectPosY = Y / imageData.getData().getZoom();
	}
	
	public Rectangle2D getRectangle2D() {
		return rectangle2D;
	}
}
