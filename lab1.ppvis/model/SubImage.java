package paint.v04.model;

import java.awt.image.BufferedImage;

public class SubImage {

	private ImageData imageData;
	BufferedImage subIm;
	private int subImPosX;
	private int subImPosY;
	
	public SubImage(ImageData imData) {
		super();
		this.imageData = imData;
	}
	
	public void delSubImage()
	{
		subIm = null;
	}
	

	///////////////////////  Getters and Setters  ////////////////////////
	public ImageData getImageData() {
		return imageData;
	}

	public BufferedImage getSubIm() {
		return subIm;
	}

	public int getSubImPosX() {
		return subImPosX;
	}

	public int getSubImPosY() {
		return subImPosY;
	}
	
	public void setSubImPosX(int subImPosX) {
		this.subImPosX = subImPosX;
	}
	
	public void setSubImPosY(int subImPosY) {
		this.subImPosY = subImPosY;
	}
	
	public void setSubImPos(int X,int Y){
		subImPosX = X;
		subImPosY = Y;
	}
	
}
