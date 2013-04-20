package paint.v04.view;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;
import paint.v04.model.MainImage;
import paint.v04.model.MainRectangle;
import paint.v04.model.Pen;
import paint.v04.model.SubImage;

public class DrawPanel extends JPanel{

	MainFrame mainFrame;
	
	public DrawPanel(MainFrame frame) {
		super();
		this.mainFrame = frame;
		this.setBackground(Color.black);
		this.setPreferredSize(new Dimension(800, 500));
		
		this.addMouseMotionListener(getPen().getMouseMotionListener());
		this.addMouseListener(getPen().getMouseListener());
	}

	public void paintComponent (Graphics g)
	{
		if(getMainImage().getImage() == null)
		{
			getMainImage().createNewImage();
		}
		super.paintComponent(g);
		Graphics2D graphics2D = (Graphics2D)g;
		g.drawImage(getMainImage().getImage(), 0, 0, getMainImage().getWidth(), getMainImage().getHeight(), null);
		getMainPanel().scrollPane.revalidate();
		
		if(getMainRect().getRectangle2D() != null){
			  float []dash1 = {5.0f};
			  BasicStroke dashed =
			        new BasicStroke(1.0f,
			                        BasicStroke.CAP_BUTT,
			                        BasicStroke.JOIN_MITER,
			                        10.0f, dash1, 0.0f);
			  graphics2D.setStroke(dashed);
			  graphics2D.setColor(Color.darkGray);
			  graphics2D.draw(getMainRect().getRectangle2D());
		}
		if(getSubImage().getSubIm() != null){
			g.drawImage(getSubImage().getSubIm(), getSubImage().getSubImPosX(), getSubImage().getSubImPosY(), getSubImage().getSubIm().getWidth() * mainFrame.getAdapter().getData().getZoom(), getSubImage().getSubIm().getHeight() * mainFrame.getAdapter().getData().getZoom(), null);
		}
	}

	
	//////////////////////////////// Getters  ///////////////////
	public MainImage getMainImage(){
		return mainFrame.getAdapter().getData().getImageData().getMainImage();
	}
	
	public MainPanel getMainPanel(){
		return mainFrame.getMainPanel();
	}
	
	public Pen getPen(){
		return mainFrame.getAdapter().getData().getToolList().getPen();
	}
	
	public MainRectangle getMainRect(){
		return mainFrame.getAdapter().getData().getImageData().getMainRect();
	}
	
	public SubImage getSubImage(){
		return mainFrame.getAdapter().getData().getImageData().getSubImage();
		
	}
}
