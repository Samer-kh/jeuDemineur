package Package2;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class scores {
	public static void remplirfichier(String pseudo,int score) // Cette fonction permet de remplir le fichier des scores.
	{
		String chemin = System.getProperty("user.dir"); // Chemin du projet
		try 
		{
			FileWriter f = new FileWriter(chemin+"/scores.txt", true);
			f.write(pseudo+" "+Integer.toString(score)+"\n"); // Ecriture dans le fichier selon le format utilisé
			f.close();
		
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	public static String[] lecturescores() throws IOException // Lire tous les scores avec les pseudos
	{
		String ligne;
		List<String> list = new ArrayList<String>();
		String chemin = System.getProperty("user.dir"); //chemin du projet
		FileReader F = new FileReader(chemin+"/scores.txt");
		BufferedReader in = new BufferedReader (F); // Lire le fichier
		while((ligne=in.readLine())!=null) // Lecture ligne par ligne
		{
			list.add(ligne); // Mettre toutes les lignes dans une liste
		}
		in.close(); // Fermer le fichier
		String [] resultat=list.toArray(new String[list.size()]);
		return resultat;
	}
	public static String[] scoremax () throws IOException
	{
		String[] tabscores = scores.lecturescores();
		List<String> pseudo = new ArrayList<String>();
		List<Integer> score = new ArrayList<Integer>();
		String [] ch =new String[2];
		String [] resultat = new String[5];
		for (int i=0;i<tabscores.length;i++)
		{
			ch=tabscores[i].split(" ");
			pseudo.add(ch[0]);
			score.add(Integer.parseInt(ch[1]));
			if (i<5)
			{
				resultat[i]=tabscores[i];
			}
		}
		for(int j = 0;j<5;j++)
		{
			int max = Collections.max(score);
			int x=score.indexOf(max);
			resultat[j]=pseudo.get(x)+" "+Integer.toString(score.get(x));
			score.remove(x);
			pseudo.remove(x);
		}
		return resultat;
	}
	 public static void main(String [] args) throws IOException
	 {
		 int i = 12 ;
		 scores.remplirfichier("abc", i);
		 String [] tab = scores.scoremax();
		 for (i=0 ;i<tab.length;i++)
		 {
			 System.out.println(tab[i]);
		 }
	 }
}
