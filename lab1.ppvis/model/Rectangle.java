package paint.v04.model;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import paint.v04.controller.RectangleMouseListener;
import paint.v04.controller.RectangleMouseMotionListener;

public class Rectangle implements Tool{

	private ToolList toolList;
	private RectangleMouseMotionListener rectMML;
	private RectangleMouseListener rectML;
	
	public Rectangle(ToolList toolList) {
		super();
		this.toolList = toolList;
		rectMML = new RectangleMouseMotionListener(this);
		rectML = new RectangleMouseListener(this);
	}

	@Override
	public void draw(int X, int Y) {
		toolList.getMainRectangle().rectangle2D = new Rectangle2D.Double(toolList.getMainRectangle().getRectPosX() * toolList.getZoom(), toolList.getMainRectangle().getRectPosY() * toolList.getZoom(), toolList.getMainRectangle().getFinalRectPosX() / toolList.getZoom(), toolList.getMainRectangle().getFinalRectPosY() / toolList.getZoom());
		
		if(toolList.getMainRectangle().getLastX()  * toolList.getZoom() < X){
			if(toolList.getMainRectangle().getFinalRectPosX() + 2 < ((toolList.getMainImage().image.getWidth() * toolList.getZoom()) - toolList.getMainRectangle().getRectPosX() * toolList.getZoom()) * toolList.getZoom()){
				toolList.getMainRectangle().setFinalRectPosX(X);
				toolList.getMainRectangle().setLastX(X);
			}			
		}
		if(toolList.getMainRectangle().getLastX()  * toolList.getZoom() > X){
			toolList.getMainRectangle().setFinalRectPosX(X);
		}
		
		if(toolList.getMainRectangle().getLastY()  * toolList.getZoom() < Y){
			if(toolList.getMainRectangle().getFinalRectPosY() + 2 < ((toolList.getMainImage().image.getHeight() * toolList.getZoom()) - toolList.getMainRectangle().getRectPosY() * toolList.getZoom()) * toolList.getZoom()){
				toolList.getMainRectangle().setFinalRectPosY(Y);
				toolList.getMainRectangle().setLastY(Y);
			}			
		}
		if(toolList.getMainRectangle().getLastY()  * toolList.getZoom() > Y){
			toolList.getMainRectangle().setFinalRectPosY(Y);
		}
	}

	@Override
	public MouseMotionListener getMouseMotionListener() {
		// TODO Auto-generated method stub
		return rectMML;
	}

	@Override
	public MouseListener getMouseListener() {
		// TODO Auto-generated method stub
		return rectML;
	}

	
	/////////////////////////  Getters  /////////////////////////////
	public ToolList getToolList() {
		return toolList;
	}

}
