package Package2;

public class matrices {
	public static int[] casesvoisines(int i , int j , int[][]matrice)
	{
		if (((i-1)<0)&&((j-1)<0))
		{
			int[] res = new int[3];
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
		else if (i-1<0)
		{
			int[] res = new int[5];
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
		else if (j-1<0)
		{
			int[] res = new int[5];
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
	public static int nombreadj(int i , int j , int[][]matrice)
	{
		int[] tab = matrices.casesvoisines(i,j,matrice);
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
