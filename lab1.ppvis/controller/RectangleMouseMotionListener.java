package paint.v04.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import paint.v04.model.MousePosition;
import paint.v04.model.Rectangle;
import paint.v04.view.DrawPanel;

public class RectangleMouseMotionListener implements MouseMotionListener {
	
	Rectangle rect;
	public RectangleMouseMotionListener(Rectangle rect) {
		super();
		this.rect = rect;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		rect.draw(arg0.getX(), arg0.getY());
		getDrawPanel().repaint();
		getMousePos().setMousePos(arg0.getX(), arg0.getY());
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		getMousePos().setMousePos(arg0.getX(), arg0.getY());
	}
	
//////////////////////Getters  ///////////////////////////////
	public MousePosition getMousePos() {
		return rect.getToolList().getData().getAdapter().getMousePosition();
	}
	
	public DrawPanel getDrawPanel(){
		return rect.getToolList().getData().getAdapter().getMainFrame().getDrawPanel();
	}

}
