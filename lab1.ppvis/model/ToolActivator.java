package paint.v04.model;

import paint.v04.view.DrawPanel;

public class ToolActivator {

	private Data data;
	private Tool currentTool;
	private Tool prevTool;
	
	public ToolActivator(Data data) {
		super();
		this.data = data;
		currentTool = data.getToolList().getPen();	
		prevTool = data.getToolList().getPen();
	}
	
	public void activate(Tool tool)
	{
		getDrawPanel().removeMouseMotionListener(prevTool.getMouseMotionListener());
		getDrawPanel().removeMouseListener(prevTool.getMouseListener());
		currentTool = tool;
		getDrawPanel().addMouseMotionListener(currentTool.getMouseMotionListener());
		getDrawPanel().addMouseListener(currentTool.getMouseListener());
		prevTool = currentTool;
	}

	
	////////////////////////  Getters  ///////////////////
	public Data getData() {
		return data;
	}
	
	public DrawPanel getDrawPanel(){
		return data.getAdapter().getMainFrame().getDrawPanel();
	}
}
