package paint.v04.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import paint.v04.model.MainRectangle;
import paint.v04.model.MousePosition;
import paint.v04.model.Rectangle;
import paint.v04.view.DrawPanel;

public class RectangleMouseListener implements MouseListener{

	Rectangle rect;
	public RectangleMouseListener(Rectangle rect) {
		super();
		this.rect = rect;
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
		// TODO Auto-generated method stub
		getMainRect().setToZero();
		getDrawPanel().repaint();
		getMainRect().setRectPos(arg0.getX(), arg0.getY());
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}
	
	//////////////////////Getters ////////////////
	public MousePosition getMousePos() {
		return rect.getToolList().getData().getAdapter().getMousePosition();
	}
	public DrawPanel getDrawPanel(){
		return rect.getToolList().getData().getAdapter().getMainFrame().getDrawPanel();
	}
	
	public MainRectangle getMainRect(){
		return rect.getToolList().getImageData().getMainRect();
	}

}
