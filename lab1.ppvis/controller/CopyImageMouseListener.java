package paint.v04.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import paint.v04.model.CopyImage;
import paint.v04.view.DrawPanel;

public class CopyImageMouseListener implements MouseListener{

	private CopyImage copyImage;
	public CopyImageMouseListener(CopyImage copyImage) {
		super();
		this.copyImage = copyImage;
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
		copyImage.copy();
		getDrawPanel().repaint();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		copyImage.paste();
		getDrawPanel().repaint();
	}
	
	////////////////////////Getters //////////////////////
	public DrawPanel getDrawPanel(){
		return copyImage.getToolList().getData().getAdapter().getMainFrame().getDrawPanel();
	}

}
