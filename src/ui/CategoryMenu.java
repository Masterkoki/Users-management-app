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
import dao.CategoryDAO;
import model.Category;


public class CategoryMenu   {

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
	private CategoryDAO dao = new CategoryDAO();
	
	/**
	 * Lance le menu supplier.
	 */
	
	public void launch(File log, FileWriter fileWriter,BufferedWriter writer) {
		int choix;
		try {
		do {
			System.out.println("Vous êtes bien dans le menu des catégories. Que souhaitez-vous faire ?\n"
					+ "1 - Ajouter une catégorie\n"
					+ "2 - Modifier une catégorie\n"
					+ "3 - Supprimer une catégorie\n"
					+ "4 - Lister toutes les catégories\n"
					+ "0 - Quitter\n");
			choix = input.nextInt();
			input.nextLine();
			switch (choix) {
				case 1 :
					System.out.println("Entrez les informations de la catégorie à ajouter\n");
					Category categoryToAdd = readCategoryFromConsole();
					dao.add(categoryToAdd);
					writer.write (date + " -  Catégorie ajoutée - ID : "+categoryToAdd.getId()+" ; Nom : "+categoryToAdd.getName()+"\n");

					
					break;
				case 2:
					System.out.println("Entrez les nouvelles informations de la catégorie à modifier\n");
					Category categoryToUpdate = readCategoryFromConsole();
					dao.update(categoryToUpdate);
					writer.write (date + " -  Catégorie ajoutée - ID : "+categoryToUpdate.getId()+" ; Nom : "+categoryToUpdate.getName()+"\n");

					break;
				case 3:
					System.out.println("Entrez l'id de la catégorie à supprimer\n");
					int idToDelete = input.nextInt();
					input.nextLine();
					dao.delete(idToDelete);
					writer.write (date + " -  Catégorie supprimée - ID : "+idToDelete+"\n");

					break;
				case 4:
					ArrayList<Category> allCategories = dao.getList();
					for (Category s : allCategories) {
						// Appel implicite de la m�thode .toString()
						s.display();
						System.out.println("\n");
					}
					writer.write (date + " - Liste des catégories consultée \n");

					
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
	private Category readCategoryFromConsole() {
		System.out.println("Identifiant de la categorie :");
		int id = input.nextInt();
		 input.nextLine(); 
		System.out.println("Nom de la catégorie :");
		String name = input.nextLine();

		Category categoryToAdd = new Category(id, name );
		return categoryToAdd;
	}		
	
}
