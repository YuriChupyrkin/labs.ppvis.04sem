package paint.v04.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import paint.v04.model.DrawLine;
import paint.v04.model.MainRectangle;
import paint.v04.view.DrawPanel;

public class DrawLineMouseListener implements MouseListener{

	private DrawLine drawLine;
	public DrawLineMouseListener(DrawLine line) {
		super();
		this.drawLine = line;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		getMainRect().setToZero();
		getDrawPanel().repaint();
		getMainRect().setRectPos(arg0.getX(), arg0.getY());		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		drawLine.draw(arg0.getX(), arg0.getY());
		getDrawPanel().repaint();
	}
	
	///////////////////////Getters //////////////////////
	public DrawPanel getDrawPanel(){
		return drawLine.getToolList().getData().getAdapter().getMainFrame().getDrawPanel();
	}
	
	public MainRectangle getMainRect(){
		return drawLine.getToolList().getImageData().getMainRect();
	}

}
