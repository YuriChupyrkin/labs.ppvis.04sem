package paint.v04.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import paint.v04.model.Brush;
import paint.v04.model.MousePosition;
import paint.v04.view.DrawPanel;

public class BrushMouseMotionListener implements MouseMotionListener{

	private Brush brush;
	public BrushMouseMotionListener(Brush brush) {
		super();
		this.brush = brush;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		brush.draw(arg0.getX(), arg0.getY());
		getDrawPanel().repaint();
		getMousePos().setMousePos(arg0.getX(), arg0.getY());
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		getMousePos().setMousePos(arg0.getX(), arg0.getY());		
	}

	
	//////////////////////Getters  ///////////////////////////////
	public MousePosition getMousePos() {
		return brush.getToolList().getData().getAdapter().getMousePosition();
	}
	
	public DrawPanel getDrawPanel(){
		return brush.getToolList().getData().getAdapter().getMainFrame().getDrawPanel();
	}
}
