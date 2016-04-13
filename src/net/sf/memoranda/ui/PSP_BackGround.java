package net.sf.memoranda.ui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

class PSP_BackGround extends JPanel{

	private static final long serialVersionUID = -2755213468898545438L;
	private BufferedImage img;
	
	public PSP_BackGround (String img, JPanel parent) throws IOException {
		this.img = ImageIO.read(new File(img));
		
		setBounds (0, 0, (int) (parent.getWidth() * 0.95), (int) (parent.getHeight() * 0.95));
		setBorder(null);
		setOpaque (false);
		setLayout(null);				
	}	
	
	public PSP_BackGround (String img, int width, int height) throws IOException {
		this.img = ImageIO.read(new File(img));
		
		setBounds (0, 0, width, height);
		setBorder(null);
		setOpaque (false);
		setLayout(null);				
	}	
 
	//Handles the drawing and scaling
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		double xScale = 1.0;
		double yScale = 1.0;
		
		if (img.getWidth() > this.getWidth()) {
			xScale = xScale * this.getWidth() / img.getWidth();
		}
		
		if (img.getHeight() > this.getHeight()) {
			yScale = yScale * this.getHeight() / img.getHeight();
		}	
		
		Graphics2D g2d = (Graphics2D) g;
		AffineTransform at = AffineTransform.getScaleInstance(xScale, yScale);
		g2d.drawRenderedImage(img,  at);
	} 
}