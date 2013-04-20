package lab2.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class LoaderSaver {

	private Data data;
	private File file;
	private String fileName;
	private JFileChooser fileChooser;
	private TextFileFilter xmlFilter;
	
	public LoaderSaver(Data data) {
		super();
		this.data = data;
		fileChooser = new  JFileChooser();
		xmlFilter = new  TextFileFilter(".xml");

	}
	
	
	public void saveDialog(String action){	
		if(!data.studList.isEmpty()){
			int messageType = JOptionPane.QUESTION_MESSAGE;
		    String[] options = {"yes", "no", "cancel"};
		    int code = JOptionPane.showOptionDialog(data.getAdapter().getMainFrame(), 
		         "Save xml file?", 
		         " ", 0, messageType, 
		         null, options, "yes");
		    
			 if(code == 0){
		    	  saveAs();
		    	  if(action == "load"){
		    		  loadFile();
		    	  }
		    	  else if(action == "close")
		    	  {
		    		  System.exit(1);
		    	  }
		    	  else if(action == "new")
		    	  {
		    		  newFile();
		    	  }
		     }
			 else  if(code == 1){
		    	  if(action == "close"){
			    	  System.exit(1);
		    	  }
		    	  else if(action == "load"){
		    		  loadFile();
		    	  }
		    	  else if(action == "new"){
		    		  newFile();
		    	  }
		     }
		}
		else{
			 if(action == "close"){
		    	  System.exit(1);
	    	  }
	    	  else if(action == "load"){
	    		  loadFile();
	    	  }
	    	  else if(action == "new"){
	    		  newFile();
	    	  }
		}
	}

	
	private void newFile(){
		data.studList.clear();
		data.pagingModel = new PagingModel(data.studList);
		data.getAdapter().getMainFrame().getMainPanel().getTable().revalidate();
	    data.getAdapter().getMainFrame().getMainPanel().getTable().repaint();
	    data.getAdapter().getMainFrame().getMainPanel().countLabel.setText("0");
	    data.getAdapter().getMainFrame().getMainPanel().repaint();

	}
	
	private void loadFile(){

		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.addChoosableFileFilter(xmlFilter); 
	    int  result1 = fileChooser.showOpenDialog(null);		   
	    if(result1==JFileChooser.APPROVE_OPTION)
	    {
	        fileName = fileChooser.getSelectedFile().getAbsolutePath();
	        file = new  File(fileName);
	        
	        try{
	        	data.studList.clear();
	        	data.pagingModel = new PagingModel(data.studList);
				SAXParserFactory factory = SAXParserFactory.newInstance();
				SAXParser parser = factory.newSAXParser();
				SAXPars saxp = new SAXPars(data);
				
				parser.parse(new File(fileName), saxp);
				
			}
			catch (Exception e) {
				// TODO: handle exception
			}

	     }
	    data.getAdapter().getMainFrame().getMainPanel().getTable().revalidate();
	    data.getAdapter().getMainFrame().getMainPanel().getTable().repaint();
	    
	    data.getAdapter().getMainFrame().getMainPanel().countLabel.setText(String.valueOf(data.studList.size()));
	    data.getAdapter().getMainFrame().getMainPanel().repaint();
	}
	
	public void saveAs(){
			fileChooser.setAcceptAllFileFilterUsed(false);
			fileChooser.addChoosableFileFilter(xmlFilter);
			int  result = fileChooser.showSaveDialog(null);
	        if(result==JFileChooser.APPROVE_OPTION)
	        {
	        	fileName = fileChooser.getSelectedFile().getAbsolutePath() + ".xml";
	        	data.getDomPars().writeFile(fileName);
	        }
	}

}
