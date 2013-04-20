package paint.v04.model;

public class ImageData {

	private Data data;
	private MainImage mainImage;
	private LoadAndSaveImage loaderAndSaver;
	private MainRectangle mainRect;
	private SubImage subImage;
	
	public ImageData(Data data) {
		super();
		this.data = data;
		
		mainImage = new MainImage(this);
		loaderAndSaver = new LoadAndSaveImage(this);
		mainRect = new MainRectangle(this);
		subImage = new SubImage(this);
	}

	
	
	///////////////////////  Getters  /////////////////////////
	public Data getData() {
		return data;
	}
	
	public MainImage getMainImage() {
		return mainImage;
	}
	
	public LoadAndSaveImage getLoaderAndSaver() {
		return loaderAndSaver;
	}
	
	public MainRectangle getMainRect() {
		return mainRect;
	}
	
	public SubImage getSubImage() {
		return subImage;
	}
	
}
