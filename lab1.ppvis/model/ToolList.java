package paint.v04.model;

public class ToolList {

	private Data data;
	private Pen pen;
	private Brush brush;
	private Rectangle rect;
	private CopyImage copyImage;
	private DragImage dragImage;
	private DrawRectangle drawRectangle;
	private DrawLine drawLine;
	private DrawOval drawOval;
	private Eraser eraser;
	private DeleteArea deleteArea;
		
	public ToolList(Data data) {
		super();
		this.data = data;
		pen = new Pen(this);
		brush = new Brush(this);
		rect = new Rectangle(this);
		copyImage = new CopyImage(this);
		dragImage = new DragImage(this);
		drawRectangle = new DrawRectangle(this);
		drawLine = new DrawLine(this);
		drawOval = new DrawOval(this);
		eraser = new Eraser(this);
		deleteArea = new DeleteArea(this);
	}

	
	
	////////////////////////  Getters  //////////////////////
	public DeleteArea getDeleteArea() {
		return deleteArea;
	}
	public Eraser getEraser() {
		return eraser;
	}
	public DrawOval getDrawOval() {
		return drawOval;
	}
	public DrawLine getDrawLine() {
		return drawLine;
	}
	public DrawRectangle getDrawRectangle() {
		return drawRectangle;
	}
	
	public DragImage getDragImage() {
		return dragImage;
	}
	
	public Pen getPen() {
		return pen;
	}
	
	public Brush getBrush() {
		return brush;
	}
	
	public Data getData() {
		return data;
	}
	
	public MousePosition getMousePosition(){
		return data.getAdapter().getMousePosition();
	}
	
	public Rectangle getRect() {
		return rect;
	}
	public CopyImage getCopyImage() {
		return copyImage;
	}
	
	public MainImage getMainImage(){
		return data.getMainImage();
	}
	
	public SubImage getSubImage(){
		return data.getImageData().getSubImage();
	}
	
	public MainRectangle getMainRectangle(){
		return data.getImageData().getMainRect();
	}
	
	public ImageData getImageData(){
		return data.getImageData();
	}
	
	public int getZoom(){
		return data.getZoom();
	}
}
