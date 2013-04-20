package paint.v04.model;

import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import paint.v04.controller.DragImageMouseListener;
import paint.v04.controller.DragImageMouseMotionListener;

public class DragImage implements Tool{

	private ToolList toolList;
	private DragImageMouseListener dragImageML;
	private DragImageMouseMotionListener dragImageMML;
	
	public DragImage(ToolList toolList) {
		super();
		this.toolList = toolList;
		dragImageML = new DragImageMouseListener(this);
		dragImageMML = new DragImageMouseMotionListener(this);
	}

	@Override
	public void draw(int X, int Y) {
		if(toolList.getMainRectangle().rectangle2D != null){		
			toolList.getSubImage().setSubImPos(X, Y);
		}
	}
	
	public void copy(){
		if(toolList.getMainRectangle().rectangle2D != null){
			BufferedImage tmpImage = toolList.getMainImage().image.getSubimage(toolList.getMainRectangle().getRectPosX(), toolList.getMainRectangle().getRectPosY(), (int)toolList.getMainRectangle().getRectangle2D().getWidth() / toolList.getZoom(), (int)toolList.getMainRectangle().getRectangle2D().getHeight() / toolList.getZoom());
			toolList.getSubImage().subIm = new BufferedImage((int)(toolList.getMainRectangle().rectangle2D.getWidth() / toolList.getZoom()), (int)(toolList.getMainRectangle().rectangle2D.getHeight() / toolList.getZoom()), BufferedImage.TYPE_INT_RGB);
			for(int rectW = 0; rectW < (int)(toolList.getMainRectangle().getRectangle2D().getWidth() / toolList.getZoom()); rectW++)
				for(int rectH = 0; rectH < (int)(toolList.getMainRectangle().getRectangle2D().getHeight() / toolList.getZoom()); rectH++)
					toolList.getSubImage().subIm.setRGB(0 + rectW , 0 + rectH, tmpImage.getRGB(rectW, rectH));
			toolList.getSubImage().setSubImPos(0, 0); 
		}
	}
	
	public void paste(){
		if(toolList.getMainRectangle().rectangle2D != null){
			for(int rectW = 0; rectW < (int)(toolList.getMainRectangle().getRectangle2D().getWidth() / toolList.getZoom()); rectW++)
				for(int rectH = 0; rectH < (int)(toolList.getMainRectangle().getRectangle2D().getHeight() / toolList.getZoom()); rectH++)
					toolList.getMainImage().image.setRGB(toolList.getMainRectangle().getRectPosX() + rectW, toolList.getMainRectangle().getRectPosY() + rectH,  Color.white.getRGB());
	
			for(int rectW = 0; rectW < (int)(toolList.getMainRectangle().getRectangle2D().getWidth() / toolList.getZoom()); rectW++)
				for(int rectH = 0; rectH < (int)(toolList.getMainRectangle().getRectangle2D().getHeight() / toolList.getZoom()); rectH++)
					toolList.getMainImage().image.setRGB(toolList.getSubImage().getSubImPosX() / toolList.getZoom() + rectW, toolList.getSubImage().getSubImPosY() / toolList.getZoom() + rectH, toolList.getSubImage().subIm.getRGB(rectW, rectH));
			
			toolList.getSubImage().delSubImage();
			toolList.getMainRectangle().setToZero();
		}
	}

	@Override
	public MouseMotionListener getMouseMotionListener() {
		// TODO Auto-generated method stub
		return dragImageMML;
	}

	@Override
	public MouseListener getMouseListener() {
		// TODO Auto-generated method stub
		return dragImageML;
	}
	
	////////////////////////  Getters  ////////////////////////////
	public ToolList getToolList() {
		return toolList;
	}

}
