package paint.v04.model;

import java.awt.Color;

public class DeleteArea {

	private ToolList toolList;
	
	public DeleteArea(ToolList toolList) {
		super();
		this.toolList = toolList;
	}
	
	public void delete(){
		if(toolList.getMainRectangle().rectangle2D != null){
			for(int rectW = 0; rectW < (int)(toolList.getMainRectangle().getRectangle2D().getWidth() / toolList.getZoom()); rectW++)
				for(int rectH = 0; rectH < (int)(toolList.getMainRectangle().getRectangle2D().getHeight() / toolList.getZoom()); rectH++)
					toolList.getMainImage().image.setRGB(toolList.getMainRectangle().getRectPosX() + rectW, toolList.getMainRectangle().getRectPosY() + rectH,  Color.white.getRGB());
		}
	}
	/////////////////  Getters //////////////////////
	public ToolList getToolList() {
		return toolList;
	}
}
