package paint.v04.model;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import paint.v04.controller.BrushMouseListener;
import paint.v04.controller.BrushMouseMotionListener;

public class Brush implements Tool{

	private ToolList toolList; 
	private BrushMouseMotionListener brushMML;
	private BrushMouseListener brushML;
	private Graphics graphics;
	private Graphics2D graphics2D;
	
	public Brush(ToolList toolList) {
		super();
		this.toolList = toolList;
		brushMML = new BrushMouseMotionListener(this);
		brushML = new BrushMouseListener(this);
		
	}

	@Override
	public void draw(int X, int Y) {
		graphics = toolList.getMainImage().getGraphics();
		graphics2D = toolList.getMainImage().getGraphics2D();
		graphics2D.setColor(toolList.getData().getCurrentColor());
		//graphics2D.setStroke(new BasicStroke(20.0f));
		graphics2D.setStroke(new BasicStroke(3.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 0.0f));
		graphics2D.drawLine(toolList.getMousePosition().getMousePosX(), toolList.getMousePosition().getMousePosY(), X / toolList.getZoom(), Y / toolList.getZoom());
	}

	@Override
	public MouseMotionListener getMouseMotionListener() {
		// TODO Auto-generated method stub
		return brushMML;
	}

	@Override
	public MouseListener getMouseListener() {
		// TODO Auto-generated method stub
		return brushML;
	}

	/////////////////////////  Getters  /////////////////////////////
	public ToolList getToolList() {
		return toolList;
	}
		
}
