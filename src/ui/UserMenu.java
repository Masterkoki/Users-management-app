package ui;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import dao.UserDAO;

import model.User;
;

public class UserMenu  {

	
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
	private UserDAO dao = new UserDAO();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Date birthdate ;
	
	/**
	 * Lance le menu supplier.
	 */
	
	public void launch(File log, FileWriter fileWriter,BufferedWriter writer) {
		int choix;
		try {
		do {
			System.out.println("Vous êtes bien dans le menu des utilisateurs. Que souhaitez-vous faire ?\n"
					+ "1 - Ajouter un utilisateur\n"
					+ "2 - Modifier un utilisateur\n"
					+ "3 - Supprimer un utilisateur\n"
					+ "4 - Lister tous les utilisateurs\n"
					+ "0 - Quitter\n");
			choix = input.nextInt();
			input.nextLine();
			switch (choix) {
				case 1 :
					System.out.println("Entrez les informations de l'utilisateur à ajouter\n");
					User userToAdd = readUserFromConsole();
					dao.add(userToAdd);
					writer.write (date + " -  Utilisateur ajouté - ID : "+userToAdd.getId()+" ; Nom : "+userToAdd.getUsername()+"\n");

					

					break;
				case 2:
					System.out.println("Entrez les nouvelles informations de l'utilisateur à modifier\n");
					User userToUpdate = readUserFromConsole();
					dao.update(userToUpdate);
					writer.write (date + " -  Utilisateur modifié - ID : "+userToUpdate.getId()+" ; Nom : "+userToUpdate.getUsername()+"\n");

				
					break;
				case 3:
					System.out.println("Entrez l'id de l'utilisateur à supprimer\n");
					int idToDelete = input.nextInt();
					input.nextLine();
					dao.delete(idToDelete);
					writer.write (date + " -  Utilisateur supprimée - ID : "+idToDelete+"\n");

					
					break;
				case 4:
					ArrayList<User> allUsers = dao.getList();
					for (User s : allUsers) {
						// Appel implicite de la m�thode .toString()
						s.display();
						System.out.println("\n");
					}
					writer.write (date + " - Liste des utilisateurs consultée \n");

					
					break;
				case 0:
					break;
				default: 
					System.out.println("Choix non valide\n");
					break;
			}
		} while (choix != 0);
		
		}
		
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
	private User readUserFromConsole() {
		System.out.println("Identifiant de l'utilisateur :");
		int id = input.nextInt();
		 input.nextLine(); 
		 
		System.out.println("Nom de l'utilisateur : ");
		String username = input.nextLine();
		
		System.out.println("Date de naissance de l'utilisateur : ");
		String datee = input.nextLine();
		 try {
	            // Analyser la chaîne pour obtenir un objet java.util.Date
	            java.util.Date parsedDate = dateFormat.parse(datee);
	            
	            // Convertir java.util.Date en java.sql.Date
	            birthdate = new Date(parsedDate.getTime());
	        } catch (ParseException e) {
	            // Gérer l'exception en cas de problème de format
	            e.printStackTrace();
	        }
		 System.out.println("Email : ");
			String email = input.nextLine();

		
	
		User userToAdd =new User (id, username, birthdate, email);
		return userToAdd;
	}		
	
}
