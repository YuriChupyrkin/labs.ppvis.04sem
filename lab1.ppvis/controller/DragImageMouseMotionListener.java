package paint.v04.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import paint.v04.model.DragImage;
import paint.v04.view.DrawPanel;

public class DragImageMouseMotionListener implements MouseMotionListener{

	private DragImage dragImage;
	public DragImageMouseMotionListener(DragImage dragImage) {
		super();
		this.dragImage = dragImage;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		dragImage.draw(arg0.getX(), arg0.getY());
		getDrawPanel().repaint();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	///////////////////////Getters //////////////////////
	public DrawPanel getDrawPanel(){
		return dragImage.getToolList().getData().getAdapter().getMainFrame().getDrawPanel();
	}

}
