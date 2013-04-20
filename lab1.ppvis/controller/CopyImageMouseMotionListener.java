package paint.v04.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import paint.v04.model.CopyImage;
import paint.v04.view.DrawPanel;

public class CopyImageMouseMotionListener implements MouseMotionListener{

	private CopyImage copyImage;
	public CopyImageMouseMotionListener(CopyImage copyImage) {
		super();
		this.copyImage = copyImage;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		copyImage.draw(arg0.getX(), arg0.getY());
		getDrawPanel().repaint();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	////////////////////////  Getters //////////////////////
	public DrawPanel getDrawPanel(){
		return copyImage.getToolList().getData().getAdapter().getMainFrame().getDrawPanel();
	}
}
