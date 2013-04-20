package paint.v04.model;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import paint.v04.controller.PenMouseListener;
import paint.v04.controller.PenMouseMotionListener;


public class Pen implements Tool{

	private ToolList toolList;
	private PenMouseMotionListener penMML;
	private PenMouseListener penML;
	private Graphics graphics;
	private Graphics2D graphics2D;
	
	public Pen(ToolList toolList) {
		super();
		this.toolList = toolList;
		penMML = new PenMouseMotionListener(this);
		penML = new PenMouseListener(this);
			
	}

	@Override
	public void draw(int X, int Y) {
		graphics = toolList.getMainImage().getGraphics();
		graphics2D = toolList.getMainImage().getGraphics2D();
		graphics2D.setColor(toolList.getData().getCurrentColor());
		graphics2D.setStroke(new BasicStroke(1.0f));
		graphics2D.drawLine(toolList.getMousePosition().getMousePosX(), toolList.getMousePosition().getMousePosY(), X / toolList.getZoom(), Y / toolList.getZoom());
	}

	@Override
	public MouseMotionListener getMouseMotionListener() {
		// TODO Auto-generated method stub
		return penMML;
	}

	@Override
	public MouseListener getMouseListener() {
		// TODO Auto-generated method stub
		return penML;
	}
	
	/////////////////////////  Getters  /////////////////////////////
	public ToolList getToolList() {
		return toolList;
	}
	
}
