package Package1;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import Package2.matrices;

public class interface1  {
	public static void main(String[] args)
	{
		fen�tre F=new fen�tre();
		
	}}
class fen�tre extends JFrame
	{
		JRadioButton b;
		JRadioButton b1;
		ButtonGroup bg;
		JLabel l;
		JButton button;
		public fen�tre () {
			button = new JButton("submit");
			bg = new ButtonGroup();
			l=new JLabel("Bienvenue � notre jeu d�mineur");
			b=new JRadioButton("Nouvelle Partie");
			b1=new JRadioButton("Montrer les scores");
			bg.add(b);
			bg.add(b1);
			 button.addActionListener(ae -> 
			 {  if (b.isSelected())
			 {		this.dispose();
				 new jeu_difficulty();
			 }
			 else
			 {	 this.dispose();
				 new highscore();}}
					 );
			
			setSize(200,400);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLayout(new FlowLayout());
			
			add(l);
			add(b);
			add(b1);
			add(button);
		}
	}
class jeu_difficulty extends JFrame 
{JLabel l2;
JRadioButton b11;
JRadioButton b12;
JRadioButton b13;
JButton button1;


	public jeu_difficulty()
	{
	l2=new JLabel("choississez la difficult� qui convient :");
	b11=new JRadioButton("10*10");
	b12=new JRadioButton("15*15");
	b13=new JRadioButton("20*20");
	button1= new JButton("Commencez la Partie");
	setVisible(true);
	setSize(250,400);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLayout(new FlowLayout());
	add(l2);
	add(b11);
	add(b12);
	add(b13);
	add(button1);
	button1.addActionListener(ae ->
	{ if (b11.isSelected())
		{this.dispose();
		JButton[][] Tab;
		jeu jeu =new jeu(10,10,10,10,new JButton[10][10], new JLabel[10][10],0);
		jeu.placer_mines();
		jeu.initial_buttons(this);
		jeu.placer_label();
		jeu.insert_buttons(jeu);
		jeu.remplissage_grid();
		jeu.setExtendedState(jeu.MAXIMIZED_BOTH);}					
	else if (b12.isSelected())
		{this.dispose();
		jeu jeu =new jeu(15,15,32,32,new JButton[15][15], new JLabel[15][15],0);
		jeu.placer_mines();
		jeu.placer_label();
		jeu.initial_buttons(jeu);
		jeu.insert_buttons(jeu);
		jeu.remplissage_grid();
		jeu.setExtendedState(jeu.MAXIMIZED_BOTH);}
	else if (b13.isSelected())
		{this.dispose();
		jeu jeu =new jeu(20,20,64,64,new JButton[20][20], new JLabel[20][20],0);
		jeu.placer_mines();
		jeu.placer_label();
		jeu.initial_buttons(jeu);
		jeu.insert_buttons(jeu);
		jeu.remplissage_grid();
		jeu.setExtendedState(jeu.MAXIMIZED_BOTH);}
		
	});
	
	
	}

}

class highscore extends JFrame 
{JLabel l3;
	public highscore()
	{
	l3=new JLabel("highscore");
	setVisible(true);
	setSize(400,400);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLayout(new FlowLayout());
	add(l3);
	}

}
class jeu extends JFrame{
	public int x;
	public int y;
	public int nb_mines;
	public int nb_drapeau;
	public int nb_coups;
	public int[][] grid;
	public JLabel TabLabel[][];
	public JButton Tab[][];
	
	public jeu ()
	{
		setSize(400,400);
		setLayout(new GridLayout());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public jeu (int x,int y ,int z,int f,JButton[][] Tableau,JLabel[][] LabTab,int nbCoups )
	{
		this.x=x;
		this.y=y;
		this.nb_mines= z;
		this.nb_drapeau=f;
		
		nb_coups=nbCoups;
		
		int i,j;
		grid=new int[x][y];
		Tab=Tableau;
		TabLabel=LabTab;
		for (i=0;i<x;i++)
		{for(j=0;j<y;j++)
			{
				grid[i][j]=0;
			}
		}
		
		
		setLayout(new GridLayout(x,y));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void initial_buttons(JFrame Frame)
	{	int i,j;
		
		for (i=0;i<x;i++)
		{
			for (j=0;j<x;j++)
			{	final int o=i,p=j; 
				ButtonGroup  Gp=new ButtonGroup();
				JButton Bl;
				Bl=new JButton("     ");
				
				Gp.add(Bl);
				Tab[i][j]=Bl;
				Bl.addActionListener(ae ->
				{if(grid[o][p]==-1)
				{
				Tab[o][p]=null;
				//eleminer_button(o,p);
				win_lost();
				this.dispose();
				jeu jeu=new jeu(x,y,0,0,Tab,TabLabel,nb_coups);
				jeu.setExtendedState(jeu.MAXIMIZED_BOTH);
				jeu.insert_buttons(jeu);
				String F="your score is "+nb_coups;
				JOptionPane.showMessageDialog(this, "you just lost the game "+"\n"+ F);
				
				
				BufferedImage myPicture=null;
				
				try {
				    myPicture = ImageIO.read(new File("img\\o.png"));
				} catch (IOException e) {
				    e.printStackTrace();
				}
				
				ImageIcon image = new ImageIcon(myPicture);
				
				
				
				String s = (String)JOptionPane.showInputDialog(
						   this,"Donnez votre nom afin d'enregister votre score",
						   "le titre",
						   JOptionPane.QUESTION_MESSAGE,
						   image,
						   null, // c'est ouvert !!!
						   "nom"); // valeur initiale
			
				/*JOptionPane d = new JOptionPane();
				int retour = d.showConfirmDialog(this, "commencez unz autre partie ?", 
				      "le titre", JOptionPane.YES_NO_OPTION);*/
				      
				      if (JOptionPane.showConfirmDialog(null, "do you want to start an other game ?", "WARNING",
				    	        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				    	  Frame[] frames = Frame.getFrames();
				    	  for (int k=0;k<frames.length;k++)
				    	  {
				    		 frames[k].dispose(); 
				    		  
				    	  }
				    	    fen�tre f=new fen�tre();
				    	} else {
				    	    System.exit(0);
				    	}
				}
				else
				{
				nb_coups++
				;
				Tab[o][p]=null;
				 if (x==10)
					{Frame[] frames = Frame.getFrames();
			    	  for (int k=0;k<frames.length;k++)
			    	  {
			    		 frames[k].dispose(); 
			    		  
			    	  }
					
					jeu jeu =new jeu(10,10,10,10,Tab,TabLabel,nb_coups+1);
					
					jeu.insert_buttons(jeu);
					jeu.win_lost();
					jeu.setExtendedState(jeu.MAXIMIZED_BOTH);}					
				else if (x==15)
					{Frame[] frames = Frame.getFrames();
			    	  for (int k=0;k<frames.length;k++)
			    	  {
			    		 frames[k].dispose(); 
			    		  
			    	  }
					 
					jeu jeu =new jeu(15,15,32,32,Tab,TabLabel,nb_coups+1);
					
					jeu.insert_buttons(jeu);
					jeu.win_lost();
					jeu.setExtendedState(jeu.MAXIMIZED_BOTH);}
				else if (x==20)
					{Frame[] frames = Frame.getFrames();
			    	  for (int k=0;k<frames.length;k++)
			    	  {
			    		 frames[k].dispose(); 
			    		  
			    	  }
					jeu jeu =new jeu(20,20,64,64,Tab,TabLabel,nb_coups+1);
					
					jeu.insert_buttons(jeu);
					jeu.win_lost();
					jeu.setExtendedState(jeu.MAXIMIZED_BOTH);}
					
				}}
						);	
			
			}}
		
	}
	
	
				
	public void insert_buttons(JFrame Frame)					
	{
		for (int i=0;i<x;i++)
		{
			for (int j=0;j<x;j++)
			{	if(Tab[i][j]!=null)
				{Frame.add(Tab[i][j]);}
			else
			{TabLabel[i][j].setHorizontalTextPosition(JLabel.CENTER);
			Frame.add(TabLabel[i][j]);}
			}}
	}
	

	
	
	public void placer_mines()
	
	{
		int index=0;
		while (index<nb_mines)
		{
			int pos1;
			int pos2;
			pos1= (int)Math.round(Math.random()*(x-1));
			pos2= (int)Math.round(Math.random()*(y-1));
			if (grid[pos1][pos2]==0)
			{
				grid[pos1][pos2]=-1;
				index++;
			}
		}
	}
	
	public JLabel Placer_image_mines(String MyImage)
	{	
				BufferedImage myPicture=null;
				
				try {
				    myPicture = ImageIO.read(new File(MyImage));
				}
				catch (IOException e) {
				    // TODO Auto-generated catch block
				    e.printStackTrace();
				}
				
				ImageIcon image = new ImageIcon(myPicture);
				JLabel imageLabel= new JLabel(image);
				return imageLabel;
			}

	public void placer_label()
	{
		int i,j;
		for (i=0;i<x;i++)
		{for (j=0;j<y;j++)
		{ if (grid[i][j]==-1)
		{
			JLabel image = Placer_image_mines("img\\mine.png");
			TabLabel[i][j]=image;
		}
		else
			{JLabel Label=new JLabel("Rien");
			TabLabel[i][j]=Label;}
		}
		}
			
	}
	
	
	
	
	public void remplissage_grid()
	{
		{for (int i=0;i<x;i++)
		{
			for (int j=0;j<x;j++)
			{
				if (grid[i][j]!=-1)
				{
					int nbVoisin=matrices.nombreadj(i,j ,x,y, grid);
					grid[i][j]=nbVoisin;
					String x=Integer.toString(nbVoisin);
					JLabel Label=new JLabel(x);
					TabLabel[i][j]=Label;
				}
			}
	}
	}
	}
	
	
	public void initial_Label()
	{for (int i=0;i<x;i++)
	{
		for (int j=0;j<x;j++)
		{
			JLabel LB=new JLabel("Rien");
			TabLabel[i][j]=LB;
	}}}
	
	/*public void eleminer_button(int i,int j)
	{	
	if (grid[i][j]==0)
	{
		Tab[i][j]=null;
		if (grid[i-1][j-1]==0)
		{
			Tab[i-1][j-1]=null;
			eleminer_button(i-1,j-1);
		}
	
		if (grid[i-1][j]==0)
		{

			Tab[i-1][j]=null;
			eleminer_button(i-1,j);
		}
		if (grid[i-1][j+1]==0)
		{

			Tab[i-1][j+1]=null;
			eleminer_button(i-1,j+1);
		}
		if (grid[i][j-1]==0)
		{

			Tab[i][j-1]=null;
			eleminer_button(i,j-1);
		}
		if (grid[i][j+1]==0)
		{

			Tab[i][j-+1]=null;
			eleminer_button(i,j+1);
		}
		if (grid[i+1][j-1]==0)
		{

			Tab[i+1][j-1]=null;
			eleminer_button(i+1,j-1);
		}
		if (grid[i+1][j]==0)
		{

			Tab[i+1][j]=null;
			eleminer_button(i+1,j);
		}
		if (grid[i+1][j+1]==0)
		{

			Tab[i+1][j+1]=null;
			eleminer_button(i+1,j+1);			
		}
	}	
	}*/
	
	public static void close(JFrame Frame)
	{
		Frame.dispose();
	}
	
	
	public void win_lost()
	{
		for (int i=0;i<x;i++)
		{
			for(int j=0;j<y;j++)
			{
				if ((grid[i][j]==-1))
				{
					
					Tab[i][j]=null;
				}
				
			}
			}
		}
	}
	
	
	
	

	
	
	

	

