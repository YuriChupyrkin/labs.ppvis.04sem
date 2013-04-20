package paint.v04.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import paint.v04.model.DrawOval;
import paint.v04.model.MainRectangle;
import paint.v04.view.DrawPanel;

public class DrawOvalMouseMotionListener implements MouseMotionListener{

	private DrawOval drawOval;
	
	public DrawOvalMouseMotionListener(DrawOval oval) {
		super();
		this.drawOval = oval;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		drawOval.draw(arg0.getX(), arg0.getY());
		getDrawPanel().repaint();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	///////////////////////Getters //////////////////////
	public DrawPanel getDrawPanel(){
		return drawOval.getToolList().getData().getAdapter().getMainFrame().getDrawPanel();
	}
	public MainRectangle getMainRect(){
		return drawOval.getToolList().getImageData().getMainRect();
	}

}
