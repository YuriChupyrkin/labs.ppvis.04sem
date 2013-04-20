package paint.v04.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class MainImage {

	private ImageData imageData;
	BufferedImage image;
	private int heightImage;
	private int widthImage;
	private Graphics graphics;
	private Graphics2D graphics2D;
	
	public MainImage(ImageData imData) {
		super();
		this.imageData = imData;
		
		widthImage = 850;
		heightImage = 500;
	}

	public void createNewImage()
	{
		image = new BufferedImage(widthImage, heightImage, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics2D = (Graphics2D)image.createGraphics();
		graphics2D.setColor(Color.white);
		graphics2D.fillRect(0, 0, widthImage, heightImage);
		graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		this.graphics2D = graphics2D;
	}
	
	///////////////////////  Getters and Setters ////////////////////////
	public void setGraphics(Graphics g)	{
		graphics = g;
		graphics2D = (Graphics2D)g;
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	public ImageData getImageData() {
		return imageData;
	}
	
	public int getHeight() {
		return heightImage;
	}
	
	public int getWidth() {
		return widthImage;
	}
	
	public void setWidthAndHeight(int W, int H){
		this.widthImage = W;
		this.heightImage = H;
	}
	public Graphics getGraphics() {
		return graphics;
	}
	
	public Graphics2D getGraphics2D() {
		return graphics2D;
	}
	
}
