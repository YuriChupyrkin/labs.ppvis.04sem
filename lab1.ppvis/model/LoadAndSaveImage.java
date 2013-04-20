package paint.v04.model;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import paint.v04.view.DrawPanel;

public class LoadAndSaveImage {

	private ImageData imageData;
	
	private File file;
	private String fileName;
	private JFileChooser fileChooser;
	private TextFileFilter jpgFilter;
	private TextFileFilter pngFilter;
	private TextFileFilter bmpFilter;
	private TextFileFilter gifFilter;
	private Object source;
	
	public LoadAndSaveImage(ImageData imData) {
		super();
		this.imageData = imData;
		fileChooser = new  JFileChooser();
		jpgFilter = new  TextFileFilter(".jpg");
		pngFilter = new  TextFileFilter(".png");
		bmpFilter = new  TextFileFilter(".bmp");
		gifFilter = new  TextFileFilter(".gif");
	}
	
	
	public void saveDialog(String action)
	{
		int messageType = JOptionPane.QUESTION_MESSAGE;
	    String[] options = {"yes", "no", "cancel"};
	    int code = JOptionPane.showOptionDialog(getImageData().getData().getAdapter().getMainFrame(), 
	         "Save image?", 
	         " ", 0, messageType, 
	         null, options, "yes");

	     if(code == 0)
	     {
	    	  saveAs();
	    	  if(action == "load")
	    		  loadFile();
	    	  if(action == "close")
	    		  System.exit(1);
	     }
	     if(code == 1)
	     {
	    	  if(action == "close")
		    	  System.exit(1);
	    	  if(action == "load")
	    		  loadFile();
	     }
	}
	 
	
	public void loadFile()
	{
		try{
			getImageData().getData().setZoom(1);
			fileChooser.setAcceptAllFileFilterUsed(false);
			fileChooser.addChoosableFileFilter(jpgFilter); 
			fileChooser.addChoosableFileFilter(pngFilter); 
			fileChooser.addChoosableFileFilter(bmpFilter); 
			fileChooser.addChoosableFileFilter(gifFilter); 
		    int  result1 = fileChooser.showOpenDialog(null);
		    if(result1==JFileChooser.APPROVE_OPTION)
	           {
	           	 fileName = fileChooser.getSelectedFile().getAbsolutePath();
	       		 file = new  File(fileName);
	       		 getImageData().getMainImage().image = ImageIO.read(file);
	       		 getMainImage().setWidthAndHeight(getImage().getWidth(), getImage().getHeight());
	       		 getMainImage().setGraphics(getImage().getGraphics());
	       		 getDrawPanel().setPreferredSize(new Dimension(getImage().getWidth(), getImage().getHeight()));
	           }
		    getDrawPanel().revalidate();
		    getDrawPanel().repaint();
		}
		catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(getImageData().getData().getAdapter().getMainFrame(), "File not found" );
		}
		
		catch(IOException ex){
			JOptionPane.showMessageDialog(getImageData().getData().getAdapter().getMainFrame(), "Error" );
		}
	}
	
	public void saveAs()
	{
		try{
			getImageData().getData().setZoom(1);
		    getDrawPanel().repaint();
			fileChooser.setAcceptAllFileFilterUsed(false);
			fileChooser.addChoosableFileFilter(jpgFilter);
			int  result = fileChooser.showSaveDialog(null);
	        if(result==JFileChooser.APPROVE_OPTION)
	        {
	        	fileName = fileChooser.getSelectedFile().getAbsolutePath();
	        	ImageIO.write(getImage(), "jpeg", new File(fileName+".jpg"));
	        }
		}
		
		catch(IOException e){
			JOptionPane.showMessageDialog(getImageData().getData().getAdapter().getMainFrame(), "ERROR!");			 
		}
		
	}

	///////////////////////////  Getters  /////////////////////////////
	public ImageData getImageData() {
		return imageData;
	}
	
	public MainImage getMainImage()
	{
		return getImageData().getMainImage();
	}
	
	public BufferedImage getImage(){
		return getImageData().getMainImage().getImage();
	}
	
	public DrawPanel getDrawPanel()
	{
		return  getImageData().getData().getAdapter().getMainFrame().getDrawPanel();
	}
	
}
