package net.sf.memoranda.ui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

class BackGround extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2755213468898545438L;
	private BufferedImage img;
	private int deg;
	
	public BackGround (String img, int width, int height) throws IOException 
	{
		this.img = ImageIO.read(new File(img));
		
		setBounds (0, 0, width, height);
		setBorder(null);
		setOpaque (false);
		setLayout(null);				
	}	
 
	//Handles the drawing
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(img, 0, 0, getWidth(), getHeight(), null);				
		g2d.dispose();
	} 
}