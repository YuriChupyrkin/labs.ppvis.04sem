package paint.v04.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import paint.v04.model.Eraser;
import paint.v04.view.DrawPanel;

public class EraserMouseListener implements MouseListener{

	private Eraser eraser;
	public EraserMouseListener(Eraser eraser) {
		super();
		this.eraser = eraser;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		eraser.draw(e.getX(), e.getY());
		getDrawPanel().repaint();		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public DrawPanel getDrawPanel(){
		return eraser.getToolList().getData().getAdapter().getMainFrame().getDrawPanel();
	}

}
