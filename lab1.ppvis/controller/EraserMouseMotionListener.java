package paint.v04.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import paint.v04.model.Eraser;
import paint.v04.model.MousePosition;
import paint.v04.view.DrawPanel;

public class EraserMouseMotionListener implements MouseMotionListener{

	private Eraser eraser;
	public EraserMouseMotionListener(Eraser eraser) {
		super();
		this.eraser = eraser;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		eraser.draw(e.getX(), e.getY());
		getDrawPanel().repaint();
		getMousePos().setMousePos(e.getX(), e.getY());
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		getMousePos().setMousePos(e.getX(), e.getY());		
		
	}
	
	//////////////////////Getters  ///////////////////////////////
	public MousePosition getMousePos() {
		return eraser.getToolList().getData().getAdapter().getMousePosition();
	}
	
	public DrawPanel getDrawPanel(){
		return eraser.getToolList().getData().getAdapter().getMainFrame().getDrawPanel();
	}

}
