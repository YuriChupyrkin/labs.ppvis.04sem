package paint.v04.model;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import paint.v04.controller.DrawLineMouseListener;

public class DrawLine implements Tool{
	
	private ToolList toolList;
	private DrawLineMouseListener drawLineML;
	
	public DrawLine(ToolList toolList) {
		super();
		this.toolList = toolList;
		drawLineML = new DrawLineMouseListener(this);
	}

	@Override
	public void draw(int X, int Y) {
		Graphics graphics = toolList.getMainImage().getGraphics();
		Graphics2D graphics2D = toolList.getMainImage().getGraphics2D();
		graphics2D.setColor(toolList.getData().getCurrentColor());
		graphics2D.setStroke(new BasicStroke(2.0f));
		graphics2D.drawLine(toolList.getMainRectangle().getRectPosX(),toolList.getMainRectangle().getRectPosY(), X / toolList.getZoom(), Y / toolList.getZoom()); 
		toolList.getMainRectangle().setToZero();
		/*
		 * graphics2D.setColor(getCurrentColor());
		graphics2D.setStroke(new BasicStroke(1.0f));
		graphics2D.drawLine(getStartRectPosX(), getStartRectPosY(), currentPosX / getZoom(),  currentPosY / getZoom());
	
		 */
		
	}

	@Override
	public MouseMotionListener getMouseMotionListener() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MouseListener getMouseListener() {
		// TODO Auto-generated method stub
		return drawLineML;
	}
	
	///////////////////////////////////  Getters  ////////////////////////
	public ToolList getToolList() {
		return toolList;
	}

}
