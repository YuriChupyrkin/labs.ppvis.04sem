package paint.v04.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import paint.v04.model.DragImage;
import paint.v04.view.DrawPanel;

public class DragImageMouseListener implements MouseListener{

	private DragImage dragImage;
	
	public DragImageMouseListener(DragImage dragImage) {
		super();
		this.dragImage = dragImage;
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
		dragImage.copy();
		getDrawPanel().repaint();	
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		dragImage.paste();
		getDrawPanel().repaint();	
	}
	
	///////////////////////Getters //////////////////////
	public DrawPanel getDrawPanel(){
		return dragImage.getToolList().getData().getAdapter().getMainFrame().getDrawPanel();
	}
}
