package Package1;
import java.awt.FlowLayout;
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
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
public class interface1  {
	public static void main(String[] args)
	{
		fenétre F=new fenétre();
		
	}}
class fenétre extends JFrame
	{
		JRadioButton b;
		JRadioButton b1;
		ButtonGroup bg;
		JLabel l;
		JButton button;
		public fenétre () {
			button = new JButton("submit");
			bg = new ButtonGroup();
			l=new JLabel("Bienvenue à notre jeu démineur");
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
	l2=new JLabel("choississez la difficulté qui convient :");
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
		jeu jeu =new jeu(10,10,10,10,new JButton[10][10], new JLabel[10][10]);
		jeu.placer_mines();
		jeu.initial_buttons(jeu);
		jeu.placer_label();
		jeu.insert_buttons(jeu);
		jeu.setExtendedState(jeu.MAXIMIZED_BOTH);}					
	else if (b12.isSelected())
		{this.dispose();
		jeu jeu =new jeu(15,15,32,32,new JButton[15][15], new JLabel[15][15]);
		jeu.placer_mines();
		jeu.placer_label();
		jeu.initial_buttons(jeu);
		jeu.insert_buttons(jeu);
		jeu.setExtendedState(jeu.MAXIMIZED_BOTH);}
	else if (b13.isSelected())
		{this.dispose();
		jeu jeu =new jeu(20,20,64,64,new JButton[20][20], new JLabel[20][20]);
		jeu.placer_mines();
		jeu.placer_label();
		jeu.initial_buttons(jeu);
		jeu.insert_buttons(jeu);
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
	public jeu (int x,int y ,int z,int f,JButton[][] Tableau,JLabel[][] LabTab )
	{
		this.x=x;
		this.y=y;
		this.nb_mines= z;
		this.nb_drapeau=f;
		
		nb_coups=0;
		
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
				Bl=new JButton("click");
				
				Gp.add(Bl);
				Tab[i][j]=Bl;
				Bl.addActionListener(ae->
				{
				Tab[o][p]=null;	
				this.dispose();
				 if (x==10)
					{Frame.dispose();
					jeu jeu =new jeu(10,10,10,10,Tab,TabLabel);
					
					jeu.insert_buttons(jeu);
					jeu.setExtendedState(jeu.MAXIMIZED_BOTH);}					
				else if (x==15)
					{Frame.dispose();
					jeu jeu =new jeu(15,15,32,32,Tab,TabLabel);
					
					jeu.insert_buttons(jeu);
					jeu.setExtendedState(jeu.MAXIMIZED_BOTH);}
				else if (x==20)
					{Frame.dispose();
					jeu jeu =new jeu(20,20,64,64,Tab,TabLabel);
				
					jeu.insert_buttons(jeu);
					jeu.setExtendedState(jeu.MAXIMIZED_BOTH);}
					
				}
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
	
	
	
	
	public void initial_Label()
	{for (int i=0;i<x;i++)
	{
		for (int j=0;j<x;j++)
		{
			JLabel LB=new JLabel("Rien");
			TabLabel[i][j]=LB;
	}}}
	
}
	
	
	

	

