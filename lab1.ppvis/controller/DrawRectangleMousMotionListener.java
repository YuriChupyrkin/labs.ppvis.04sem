package paint.v04.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import paint.v04.model.DrawRectangle;
import paint.v04.view.DrawPanel;

public class DrawRectangleMousMotionListener implements MouseMotionListener{

	private DrawRectangle drawRectangle;
	public DrawRectangleMousMotionListener(DrawRectangle rect) {
		super();
		this.drawRectangle = rect;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		drawRectangle.draw(arg0.getX(), arg0.getY());
		getDrawPanel().repaint();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	///////////////////////Getters //////////////////////
	public DrawPanel getDrawPanel(){
		return drawRectangle.getToolList().getData().getAdapter().getMainFrame().getDrawPanel();
	}


}
