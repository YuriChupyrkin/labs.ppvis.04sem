package paint.v04.model;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public interface Tool {
	public void draw(int X, int Y);
	public MouseMotionListener getMouseMotionListener();
	public MouseListener getMouseListener();
}
