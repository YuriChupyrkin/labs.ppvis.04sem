package paint.v04.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import paint.v04.model.MousePosition;
import paint.v04.model.Pen;
import paint.v04.view.DrawPanel;

public class PenMouseListener implements MouseListener{

	Pen pen;	
	public PenMouseListener(Pen pen) {
		super();
		this.pen = pen;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
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
		pen.draw(arg0.getX(), arg0.getY());
		getDrawPanel().repaint();	
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	////////////////////// Getters ////////////////
	public MousePosition getMousePos() {
		return pen.getToolList().getData().getAdapter().getMousePosition();
	}
	public DrawPanel getDrawPanel(){
		return pen.getToolList().getData().getAdapter().getMainFrame().getDrawPanel();
	}

}
