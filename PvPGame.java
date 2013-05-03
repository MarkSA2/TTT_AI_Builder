import java.awt.Canvas;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 * A simple two player Tic-Tac-Toe Game.
 * 
 * @author Mark Adams
 * @version 2013/05/02
 */
public class PvPGame extends Canvas
{
  private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 630;
	public static final int HEIGHT = 630;
	public static final String TITLE = "TTT_AI_Builder - Last Update: 2013/05/02";
	public Image offScreenBuffer;
	public Rule rule;
	public Judge judge;
	public int[] rowOrColPos = {0, 3 + (WIDTH / 3), 5 + (2 *(WIDTH / 3))};

	/**
	 * Build the game window.
	 */
	public PvPGame()
	{
		this.rule = new Rule();
		this.judge = new Judge();
		
		JFrame frame = new JFrame();
		frame.add(this);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.pack();
		frame.setTitle(TITLE);
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Paints the Board to the game window using icons to represent the Board contents.
	 */
	public void paint(Graphics g)
	{
		BufferedImage img = null;
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
			{
				try {img = chooseImage(this.rule.getPos(i, j));} 
				catch (IOException e) {e.printStackTrace();}
				
				g.drawImage(img, this.rowOrColPos[j], this.rowOrColPos[i], null);
			}
	}
	/**
	 * Double buffers the screen for a more smooth appearance (reduces flickering).
	 */
	public void update(Graphics g)
    {
    	Graphics gr; 
    	if (this.offScreenBuffer==null || (! (this.offScreenBuffer.getWidth(this) == PvPGame.WIDTH 
    			&& this.offScreenBuffer.getHeight(this) == PvPGame.HEIGHT)))
    	{
    		offScreenBuffer = this.createImage(PvPGame.WIDTH, PvPGame.HEIGHT);
    	}
     
    	gr = offScreenBuffer.getGraphics();
    	paint(gr); 
    	g.drawImage(offScreenBuffer, 0, 0, this);     
    }
	
	/**
	 * Loads a specified token as an BufferedImage from the packages icon directory.
	 * 
	 * @param token -> The icon that needs to be loaded.
	 * @return -> The icon loaded as a BufferedImage.
	 * @throws IOException
	 */
	public BufferedImage chooseImage(char token) throws IOException
	{
		BufferedImage img;
		
		if(token == 'X')
			img = ImageIO.read(new File("icons/X.jpg"));
		else if(token == 'O')
			img = ImageIO.read(new File("icons/O.jpg"));
		else if(token == 'W')
			img = ImageIO.read(new File("icons/W.jpg"));
		else if(token == 'N')
			img = ImageIO.read(new File("icons/N.jpg"));
		else if(token == ' ')
			img = ImageIO.read(new File("icons/space.jpg"));
		else
			img = ImageIO.read(new File("icons/dontCare.jpg"));
		
		return img;
	}
	
	/**
	 * Performs an action when the mouse is clicked within the game window.
	 */
	public boolean mouseDown(Event e, int x, int y)
	{
		int clickedRow, clickedColumn; 
		boolean xHasWon = this.judge.hasWon(this.rule, 'X');
		boolean oHasWon = this.judge.hasWon(this.rule, 'O');
		
		if (!(xHasWon || oHasWon))
		{
			clickedRow = clickedPosition(y);
			clickedColumn = clickedPosition(x);
			
			if (this.judge.isValidMove(this.rule, clickedRow, clickedColumn))
				this.rule.setPos(clickedRow, clickedColumn, this.judge.getPlayerTurn(this.rule));
		}
		
		//Check to see if a player has won again.
		xHasWon = this.judge.hasWon(this.rule, 'X');
		oHasWon = this.judge.hasWon(this.rule, 'O');
		if (xHasWon)
			setHasWonScreen('X');
		else if (oHasWon)
			setHasWonScreen('O');

		this.repaint();
		
		return true;
	}
	
	/**
	 * Sets the board to display a message that states the winner.
	 * 
	 * @param player -> The player that won the game.
	 */
	public void setHasWonScreen(char player)
	{
		this.rule.setPos(0, 0, ' ');
		this.rule.setPos(0, 1, player);
		this.rule.setPos(0, 2, ' ');
		this.rule.setPos(1, 0, '?');
		this.rule.setPos(1, 1, '?');
		this.rule.setPos(1, 2, '?');
		this.rule.setPos(2, 0, 'W');
		this.rule.setPos(2, 1, 'O');
		this.rule.setPos(2, 2, 'N');
	}
	
	/**
	 * 
	 * @param axisPosition -> Determine the row or column that was clicked.
	 * @return The row or column in the game window that was clicked.
	 */
	public int clickedPosition(int axisPosition)
	{
		int result = 0;
		
		for (int i = 0; i < 3; i++)
			if (axisPosition >= this.rowOrColPos[i])
			{
				if (i == 2)
				{
					result = i;
					break;
				}
				
				else if (axisPosition <= this.rowOrColPos[i+1])
				{
					result = i;
					break;
				}
				
				else
					continue;
			}
		
		return result;
	}
	
	public static void main(String[] args)
	{
		PvPGame game = new PvPGame();
		game.repaint();
	}
}
