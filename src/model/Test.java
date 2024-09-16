package model;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.io.File;


public class Test {

	public static void main(String[] args) {
		
		try {
		
		LocalDateTime date = LocalDateTime.now();
		Scanner input = new Scanner(System.in);
		int id ;
		String name ;
		double rating ;
		String installs ;
		String size ;
		double price ;
		String content_rating ;
		App application = null ;
		int app_id= (Integer) null;
		Category category ;
		String translated_review;
		String sentiment;
		double polarity;
		double subjectivity = (Integer) null;
		String username;
		Date birthdate = null;
		String email;
		ArrayList<App> apps = null; 
		User user = null;
		int user_id = (Integer) null;
		Review review;
		int category_id = (Integer) null;
		
		String datee;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yy-MM-dd_HH:mm");
        String formattedDateTime = date.format(dateTimeFormatter);
        
        File log = new File("C:\\Users\\USER\\Downloads\\projet_"+ formattedDateTime +"_log.txt");
        //File log = new File("C:\\Users\\USER\\Downloads\\projet_log.txt");
        if (log.createNewFile())
            System.out.println("File created");
        else
            System.out.println("File already exists");
		int choix;
		FileWriter fileWriter= new FileWriter(log); 
		BufferedWriter writer =  new BufferedWriter(fileWriter);
		
		
		System.out.println("Bienvenue dans le menu !");
		System.out.println(" ");
		
		do {
		//boucle
		System.out.println("Que voulez-vous faire ?");
		System.out.println(" ");
		System.out.println("Saisissez 0 pour quitter ;");
		System.out.println("Saisissez 1 pour créer une application ;");
		System.out.println("Saisissez 2 pour créer une catégorie ;");
		System.out.println("Saisissez 3 pour créer un avis ;");
		System.out.println("Saisissez 4 pour créer un utilisateur ;");
		System.out.println(" ");
		
		choix = input.nextInt();
		
		switch(choix) {
			
		case 1 : 
			System.out.println("Identifiant de l'application :");
			id = input.nextInt();
			 input.nextLine(); 
			System.out.println("Nom de l'application : ");
			name = input.nextLine();
			System.out.println("Note de l'application : ");
			rating = input.nextDouble();
			 input.nextLine(); 
			System.out.println("Nb de téléchargements de l'application : ");
			installs = input.nextLine();
			System.out.println("Taille de l'application : ");
			size = input.nextLine();
			 input.nextLine(); 
			System.out.println("Prix de l'application : ");
			price = input.nextDouble();
			 input.nextLine(); 
			System.out.println("Commentaire sur le contenu de l'application : ");
			content_rating = input.nextLine();
			
			application = new App(id, name,category_id , rating, installs,size, price,content_rating );
			
			System.out.println("Application créée !");
			
			
				
				writer.write(date + "- APPLICATION ADDED : " + name+ ", "+content_rating );
				writer.newLine(); // Pour passer à la ligne
				
			break;
			
		case 2 :
			
			System.out.println("Identifiant de la categorie :");
			id = input.nextInt();
			 input.nextLine(); 
			System.out.println("Nom de la catégorie :");
			name = input.nextLine();

			category = new Category(id, name );
			System.out.println("Catégorie créée !");
			
			
				writer.write(date + "- CATEGORY ADDED : " + name );
				writer.newLine(); // Pour passer à la ligne
				
				
			break;
			
		case 3 :
			
			System.out.println("Identifiant de la review : ");
			id = input.nextInt();
			 input.nextLine(); 
			System.out.println("Avis traduit : ");
			translated_review = input.nextLine();
			System.out.println("Sentiment :");
			sentiment = input.nextLine();
			System.out.println("Polarité : ");
			polarity = input.nextDouble();
			 input.nextLine(); 
			System.out.println("Subjectivité : ");
			polarity = input.nextDouble();
			 input.nextLine(); 

			review = new Review(id,app_id , user_id, translated_review, sentiment, polarity,subjectivity );
			System.out.println("Review créée !");
			
			
				
				writer.write(date + "- REVIEW ADDED : " + translated_review);
				writer.newLine(); // Pour passer à la ligne
				
				
			
			break;
			
		case 4 :
			
			System.out.println("Identifiant de la l'utilisateur : ");
			id = input.nextInt();
			 input.nextLine(); 
			System.out.println("Pseudo de l'utilisateur : ");
			username = input.nextLine();
			System.out.println("Date de naissance :");
			datee = input.nextLine();
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
			email = input.nextLine();
			
			user = new User (id, username, birthdate, email);
			System.out.println("Utilisateur créé !");
				
		
				
				writer.write(date + "- USER ADDED : " + username+ ", "+email );
				writer.newLine(); // Pour passer à la ligne
				
				
			break;
		}
			}while (choix != 0);
		
		writer.close(); // Fermeture du flux
		}
		catch (FileNotFoundException e) {
			System.out.println("Fichier non trouvé");
			}
			catch (IOException e) {
			System.out.println("Fichier non accessible");
			}
			
		}

	}


