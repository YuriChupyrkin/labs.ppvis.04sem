package paint.v04.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import paint.v04.controller.EraserMouseListener;
import paint.v04.controller.EraserMouseMotionListener;

public class Eraser implements Tool{

	private ToolList toolList;
	private EraserMouseListener eraserML;
	private EraserMouseMotionListener eraserMML;
	
	public Eraser(ToolList toolList) {
		super();
		this.toolList = toolList;
		eraserML = new EraserMouseListener(this);
		eraserMML = new EraserMouseMotionListener(this);
	}

	@Override
	public void draw(int X, int Y) {
		Graphics graphics = toolList.getMainImage().getGraphics();
		Graphics2D graphics2D = toolList.getMainImage().getGraphics2D();
		graphics2D.setColor(Color.white);
		graphics2D.setStroke(new BasicStroke(2.0f));
		graphics2D.drawLine(toolList.getMousePosition().getMousePosX(), toolList.getMousePosition().getMousePosY(), X / toolList.getZoom(), Y / toolList.getZoom());
	}

	@Override
	public MouseMotionListener getMouseMotionListener() {
		// TODO Auto-generated method stub
		return eraserMML;
	}

	@Override
	public MouseListener getMouseListener() {
		// TODO Auto-generated method stub
		return eraserML;
	}
	
	//////////////////////////////////  Getters  //////////////////////////////
	public ToolList getToolList() {
		return toolList;
	}

}
