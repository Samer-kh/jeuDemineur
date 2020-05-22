package Package2;

public class matrices {
	public static int[] casesvoisines(int i , int j ,int x,int y, int[][]matrice)
	{
		if ((i==x-1)&&(j>0)&&(j<y-1))
		{
			int[] res = new int[8];
			res[0]=matrice[i-1][j-1];
			res[1]=matrice[i-1][j];
			res[2]=matrice[i-1][j+1];
			res[3]=matrice[i][j-1];
			res[4]=matrice[i][j+1];
			res[4]=matrice[i][j+1];
			res[5]=99;
			res[6]=99;
			res[7]=99;
			return res;
		}
		else if ((i==0)&&(j>0)&&(j<y-1))
		{
			int[] res = new int[8];
			res[0]=99;
			res[1]=99;
			res[2]=99;
			res[3]=matrice[i][j-1];
			res[4]=matrice[i][j+1];
			res[5]=matrice[i+1][j-1];
			res[6]=matrice[i+1][j];
			res[7]=matrice[i+1][j+1];
			return res;
		}
		else if ((j==0)&&(i>0)&&(i<x-1))
		{
			int[] res = new int[8];
			res[0]=99;
			res[1]=matrice[i-1][j];
			res[2]=matrice[i-1][j+1];
			res[3]=99;
			res[4]=matrice[i][j+1];
			res[5]=99;
			res[6]=matrice[i+1][j];
			res[7]=matrice[i+1][j+1];
			return res;
			
		}
		else if ((j==y-1)&&(i>0)&&(i<x-1))
		{
			int[] res = new int[8];
			res[0]=matrice[i-1][j-1];
			res[1]=matrice[i-1][j];
			res[2]=99;
			res[3]=matrice[i][j-1];
			res[4]=99;
			res[5]=matrice[i+1][j-1];
			res[6]=matrice[i+1][j];
			res[7]=99;
			return res;
			
		}
		else if ((j==0)&&(i==0))
		{
			int[] res = new int[8];
			res[0]=99;
			res[1]=99;
			res[2]=99;
			res[3]=99;
			res[4]=matrice[i][j+1];
			res[5]=99;
			res[6]=matrice[i+1][j];
			res[7]=matrice[i+1][j+1];
			return res;
			
		}
		
		else if ((j==0)&&(i==x-1))
		{
			int[] res = new int[8];
			res[0]=99;
			res[1]=matrice[i-1][j];
			res[2]=matrice[i-1][j+1];
			res[3]=99;
			res[4]=matrice[i][j+1];
			res[5]=99;
			res[6]=99;
			res[7]=99;
			return res;
			
		}
		else if ((j==y-1)&&(i==0))
		{
			int[] res = new int[8];
			res[0]=99;
			res[1]=99;
			res[2]=99;
			res[3]=matrice[i][j-1];
			res[4]=99;
			res[5]=matrice[i+1][j-1];
			res[6]=matrice[i+1][j];
			res[7]=99;
			return res;
			
		}
		else if ((j==y-1)&&(i==x-1))
		{
			int[] res = new int[8];
			res[0]=matrice[i-1][j-1];
			res[1]=matrice[i-1][j];
			res[2]=99;
			res[3]=matrice[i][j-1];
			res[4]=99;
			res[5]=99;
			res[6]=99;
			res[7]=99;
			return res;
			
		}
		else
		{
			int[] res = new int[8];
			res[0]=matrice[i-1][j-1];
			res[1]=matrice[i-1][j];
			res[2]=matrice[i-1][j+1];
			res[3]=matrice[i][j-1];
			res[4]=matrice[i][j+1];
			res[5]=matrice[i+1][j-1];
			res[6]=matrice[i+1][j];
			res[7]=matrice[i+1][j+1];
			return res;
		}
		
	}
	public static int nombreadj(int i , int j ,int x,int y, int[][]matrice)
	{
		int[] tab = matrices.casesvoisines(i,j,x,y,matrice);
		int s=0;
		for (i=0;i<tab.length;i++)
		{
			if (tab[i]==-1)
				{
					s++;
				}
		}
		return s;
	}
}
