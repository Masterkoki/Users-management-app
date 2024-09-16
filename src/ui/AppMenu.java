package ui;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import dao.AppDAO;
import model.App;
;

public class AppMenu  {
	
	LocalDateTime datee = LocalDateTime.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    String date = datee.format(formatter);
    

	
	/**
	 * Le scanner utilis� pour lire sur la console
	 */
	private Scanner input = new Scanner(System.in);
	
	/**
	 * La classe DAO utilis�e pour interagir avec la BDD
	 */
	private AppDAO dao = new AppDAO();
	
	/**
	 * Lance le menu supplier.
	 */
	
	public void launch(File log, FileWriter fileWriter,BufferedWriter writer ) {
		int choix;
		try {
		do {
			System.out.println("Vous êtes bien dans le menu des applications. Que souhaitez-vous faire ?\n"
					+ "1 - Ajouter une application\n"
					+ "2 - Modifier une application\n"
					+ "3 - Supprimer une application\n"
					+ "4 - Lister toutes les application\n"
					+ "0 - Quitter\n");
			choix = input.nextInt();
			input.nextLine();
			
			switch (choix) {
				case 1 :
					
					System.out.println("Entrez les informations d'application à ajouter\n");
					App appToAdd = readAppFromConsole();
					dao.add(appToAdd);
					writer.write (date + " -  Application ajoutée - ID : "+appToAdd.getId()+" ; Nom : "+appToAdd.getName()+"\n");

					
					break;
				case 2:
					System.out.println("Entrez les nouvelles informations de l'application à modifier\n");
					App appToUpdate = readAppFromConsole();
					dao.update(appToUpdate);
					writer.write (date + " -  Application modifiée - ID : "+appToUpdate.getId()+" ; Nom : "+appToUpdate.getName()+"\n");

					
					break;
				case 3:
					System.out.println("Entrez l'id de l'application à supprimer\n");
					int idToDelete = input.nextInt();
					input.nextLine();
					dao.delete(idToDelete);
					writer.write (date + " -  Application supprimée - ID : "+idToDelete+"\n");
					
					break;
				case 4:
					ArrayList<App> allApps = dao.getList();
					for (App s : allApps) {
						// Appel implicite de la m�thode .toString()
						s.display();
						System.out.println("\n");
					}
					writer.write (date + " - Liste des applications consultée \n");

					break;
				case 0:
					break;
				default: 
					System.out.println("Choix non valide\n");
					break;
			}
		} while (choix != 0);}
		
		
			catch (FileNotFoundException e) {
			System.out.println("Fichier non trouvé");
			}
			catch (IOException e) {
			System.out.println("Fichier non accessible");
			}
	}

	/**
	 * Permet de lire les diff�rentes informations d'un objet supplier via la console.
	 * 
	 * @return un objet supplier rempli
	 */
	private App readAppFromConsole() {
		System.out.println("Identifiant de l'application :");
		int id = input.nextInt();
		 input.nextLine(); 
		 System.out.println("Identifiant de la catégorie :");
			int category_id = input.nextInt();
			 input.nextLine(); 
		System.out.println("Nom de l'application : ");
		String name = input.nextLine();
		System.out.println("Note de l'application : ");
		double rating = input.nextDouble();
		 input.nextLine(); 
		System.out.println("Nb de téléchargements de l'application : ");
		String installs = input.nextLine();
		System.out.println("Taille de l'application : ");
		String size = input.nextLine();
		System.out.println("Prix de l'application : ");
		double price = input.nextDouble();
		 input.nextLine(); 
		System.out.println("Commentaire sur le contenu de l'application : ");
		String content_rating = input.nextLine();
		App appToAdd = new App(id, name,category_id , rating, installs,size, price,content_rating );
		return appToAdd;
	}		
	
}
