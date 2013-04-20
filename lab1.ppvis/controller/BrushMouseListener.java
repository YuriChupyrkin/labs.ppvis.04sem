package paint.v04.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import paint.v04.model.Brush;
import paint.v04.view.DrawPanel;

public class BrushMouseListener implements MouseListener{

	Brush brush;
	
	public BrushMouseListener(Brush brush) {
		super();
		this.brush = brush;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
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
		brush.draw(e.getX(), e.getY());
		getDrawPanel().repaint();		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/////////////////////////////  Getters  //////////////////////
	public DrawPanel getDrawPanel(){
		return brush.getToolList().getData().getAdapter().getMainFrame().getDrawPanel();
	}

}
