package paint.v04.model;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import paint.v04.controller.DrawOvalMouseListener;
import paint.v04.controller.DrawOvalMouseMotionListener;

public class DrawOval implements Tool{

	private ToolList toolList;
	private DrawOvalMouseListener drawOvalML;
	private DrawOvalMouseMotionListener drawOvalMML;
	
	public DrawOval(ToolList toolList) {
		super();
		this.toolList = toolList;
		drawOvalML = new DrawOvalMouseListener(this);
		drawOvalMML = new DrawOvalMouseMotionListener(this);
	}

	@Override
	public void draw(int X, int Y) {
		toolList.getRect().draw(X, Y);	
	}

	public void drawOval(){
		Graphics graphics = toolList.getMainImage().getGraphics();
		Graphics2D graphics2D = toolList.getMainImage().getGraphics2D();
		graphics2D.setColor(toolList.getData().getCurrentColor());
		graphics2D.setStroke(new BasicStroke(2.0f));
		graphics2D.drawOval(toolList.getMainRectangle().getRectPosX(),toolList.getMainRectangle().getRectPosY(), (int)(toolList.getMainRectangle().getRectangle2D().getWidth() / toolList.getZoom()), (int)(toolList.getMainRectangle().getRectangle2D().getHeight() / toolList.getZoom()));
		toolList.getMainRectangle().setToZero();
	}
	@Override
	public MouseMotionListener getMouseMotionListener() {
		// TODO Auto-generated method stub
		return drawOvalMML;
	}

	@Override
	public MouseListener getMouseListener() {
		// TODO Auto-generated method stub
		return drawOvalML;
	}
	
	////////////////////////Getters  ////////////////////////////
	public ToolList getToolList() {
		return toolList;
	}

}
