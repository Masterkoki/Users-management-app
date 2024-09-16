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

import dao.ReviewDAO;
import model.Review;

public class ReviewMenu  {
	
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
	private ReviewDAO dao = new ReviewDAO();
	
	/**
	 * Lance le menu supplier.
	 */
	
	public void launch(File log, FileWriter fileWriter,BufferedWriter writer) {
		int choix;
		try {
		do {
			System.out.println("Vous êtes bien dans le menu des reviews. Que souhaitez-vous faire ?\n"
					+ "1 - Ajouter une review\n"
					+ "2 - Modifier une review\n"
					+ "3 - Supprimer une review\n"
					+ "4 - Lister toutes les reviews\n"
					+ "0 - Quitter\n");
			choix = input.nextInt();
			input.nextLine();
			switch (choix) {
				case 1 :
					System.out.println("Entrez les informations de la review à ajouter\n");
					Review reviewToAdd = readReviewFromConsole();
					dao.add(reviewToAdd);
					writer.write (date + " -  Review ajoutée - ID : "+reviewToAdd.getId()+"\n");

					

					break;
				case 2:
					System.out.println("Entrez les nouvelles informations de la review à modifier\n");
					Review reviewToUpdate = readReviewFromConsole();
					dao.update(reviewToUpdate);
					writer.write (date + " -  Review modifiée - ID : "+reviewToUpdate.getId()+"\n");

					
					break;
				case 3:
					System.out.println("Entrez l'id de la review à supprimer\n");
					int idToDelete = input.nextInt();
					input.nextLine();
					dao.delete(idToDelete);
					writer.write (date + " -  Review supprimée - ID : "+idToDelete+"\n");

					
					break;
				case 4:
					ArrayList<Review> allReviews = dao.getList();
					for (Review s : allReviews ){
						// Appel implicite de la m�thode .toString()
						s.display();
						System.out.println("\n");
					}
					writer.write (date + " - Liste des reviews consultée \n");

				
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
	private Review readReviewFromConsole() {
		System.out.println("Identifiant de la review : ");
		int id = input.nextInt();
		input.nextLine(); 
		System.out.println("Identifiant de l'application : ");
		int app_id = input.nextInt();
		input.nextLine(); 
		System.out.println("Identifiant de l'utilisateur : ");
		int user_id = input.nextInt();
		input.nextLine(); 
		System.out.println("Avis traduit : ");
		String translated_review = input.nextLine();
		System.out.println("Sentiment :");
		String sentiment = input.nextLine();
		System.out.println("Polarité : ");
		double polarity = input.nextDouble();
		 input.nextLine(); 
		System.out.println("Subjectivité : ");
		double subjectivity = input.nextDouble();
		 input.nextLine(); 
		 Review reviewToAdd = new Review(id,app_id , user_id, translated_review, sentiment, polarity,subjectivity );
			
		return reviewToAdd;
	}
}
