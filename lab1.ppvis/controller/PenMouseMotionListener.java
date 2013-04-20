package paint.v04.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import paint.v04.model.MousePosition;
import paint.v04.model.Pen;
import paint.v04.view.DrawPanel;

public class PenMouseMotionListener implements MouseMotionListener{

	Pen pen;
	public PenMouseMotionListener(Pen pen) {
		super();
		this.pen = pen;
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		pen.draw(e.getX(), e.getY());
		getDrawPanel().repaint();
		getMousePos().setMousePos(e.getX(), e.getY());
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		getMousePos().setMousePos(e.getX(), e.getY());		
	}
	
	//////////////////////  Getters  ///////////////////////////////
	public MousePosition getMousePos() {
		return pen.getToolList().getData().getAdapter().getMousePosition();
	}
	
	public DrawPanel getDrawPanel(){
		return pen.getToolList().getData().getAdapter().getMainFrame().getDrawPanel();
	}

	
}
