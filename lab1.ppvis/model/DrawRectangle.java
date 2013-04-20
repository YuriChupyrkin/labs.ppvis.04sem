package paint.v04.model;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;

import paint.v04.controller.DrawRectangleMousMotionListener;
import paint.v04.controller.DrawRectangleMouseListener;

public class DrawRectangle implements Tool{

	private ToolList toolList;
	private DrawRectangleMouseListener drawRectML;
	private DrawRectangleMousMotionListener drawRectMML;
	
	public DrawRectangle(ToolList toolList) {
		super();
		this.toolList = toolList;
		drawRectML = new DrawRectangleMouseListener(this);
		drawRectMML = new DrawRectangleMousMotionListener(this);
	}

	@Override
	public void draw(int X, int Y) {
		toolList.getRect().draw(X, Y);
	}
	
	public void drawRect(){
		Graphics graphics = toolList.getMainImage().getGraphics();
		Graphics2D graphics2D = toolList.getMainImage().getGraphics2D();
		graphics2D.setColor(toolList.getData().getCurrentColor());
		graphics2D.setStroke(new BasicStroke(2.0f));
		graphics2D.drawRect(toolList.getMainRectangle().getRectPosX(),toolList.getMainRectangle().getRectPosY(), (int)(toolList.getMainRectangle().getRectangle2D().getWidth() / toolList.getZoom()), (int)(toolList.getMainRectangle().getRectangle2D().getHeight() / toolList.getZoom()));
		toolList.getMainRectangle().setToZero();
	}
	
	@Override
	public MouseMotionListener getMouseMotionListener() {
		// TODO Auto-generated method stub
		return drawRectMML;
	}

	@Override
	public MouseListener getMouseListener() {
		// TODO Auto-generated method stub
		return drawRectML;
	}
	
	////////////////////////Getters  ////////////////////////////
	public ToolList getToolList() {
		return toolList;
	}

}
