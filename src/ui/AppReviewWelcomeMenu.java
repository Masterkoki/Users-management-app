package ui;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AppReviewWelcomeMenu  {
	
	 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choix;
		Scanner sc = new Scanner(System.in);
		String fileName = "projet_log.txt";
	    File log = new File(fileName);
	    try {
			FileWriter fileWriter= new FileWriter("projet_log.txt"); 
			BufferedWriter writer =  new BufferedWriter(fileWriter);
			FileWriter fileWriter2 = new FileWriter("projet_resultats.txt"); 
			BufferedWriter writer2 =  new BufferedWriter(fileWriter2);
		do {
			
				
			System.out.println("Bonjour et bienvenue dans l'application des applications et des reviews\n"
					+ "Que souhaitez-vous faire ?\n"
					+ "1 - Gérer les applications\n"
					+ "2 - Gérer les reviews\n"
					+ "3 - Gérer les utilisateurs\n"
					+ "4 - Gérer les catégories\n"
					+ "5 - Générer un fichier de résultats\n"
					+ "0 - Quitter\n");
			choix = sc.nextInt();
			// NB : Cette ligne permet de supprimer le "\n" qui reste dans le buffer apr�s la lecture du int
			sc.nextLine();
			switch (choix) {
				case 1 :
					// On lance le sous-menu supplier
					AppMenu appMenu = new AppMenu();
					appMenu.launch(log,fileWriter,writer);

					
					
						
					break;
				case 2:
					ReviewMenu reviewMenu = new ReviewMenu();
					reviewMenu.launch(log,fileWriter,writer);

					
					break;
				case 3:
					UserMenu userMenu = new UserMenu();
					userMenu.launch(log,fileWriter,writer);

					break;
				case 4:
					CategoryMenu categoryMenu = new CategoryMenu();
					categoryMenu.launch(log,fileWriter,writer);

					
					break;
				case 5:
					Resultats res = new Resultats();
					res.launch(log,fileWriter,writer,fileWriter2,writer2 );

					
					break;
				case 0:
					System.out.println("Au revoir !\n");
					break;
			}
		
		} while (choix != 0);
		sc.close();
		writer.close();
	    }
		catch (FileNotFoundException e) {
			System.out.println("Fichier non trouvé");
			}
			catch (IOException e) {
			System.out.println("Fichier non accessible");
			}
	}

}
