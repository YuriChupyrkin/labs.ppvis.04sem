package paint.v04.controller;

import java.awt.event.KeyEvent;

public class KeyListener implements java.awt.event.KeyListener{

	private Adapter adapter;
	public KeyListener(Adapter adapter) {
		super();
		this.adapter = adapter;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == e.VK_DELETE)
		{
			adapter.getData().getToolList().getDeleteArea().delete();
			adapter.getMainFrame().getDrawPanel().repaint();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
