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

import dao.ResultatsDAO;

public class Resultats  {
	private ResultatsDAO dao = new ResultatsDAO();
	Scanner input = new Scanner(System.in);
	int choix;
	LocalDateTime datee = LocalDateTime.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    String date = datee.format(formatter);

	public void launch(File log, FileWriter fileWriter,BufferedWriter writer,FileWriter fileWriter2,BufferedWriter writer2 ){
		
		try {
			
			System.out.println("Prix limite : ");
			choix = input.nextInt();
			input.nextLine();
			ArrayList<String> res1 = dao.getRes1();
			ArrayList<String> res2 = dao.getRes2();
			ArrayList<String> res3 = dao.getRes3(choix);
			ArrayList<String> res4 = dao.getRes4();
			writer.write (date +" - Fiche de résultats consultée \n");
			
			
		 //File log = new File("C:\\Users\\USER\\Downloads\\projet_"+ formattedDateTime +"_log.txt");
	     File log1 = new File("C:\\Users\\USER\\Downloads\\projet_resultats.txt");
	     
			
			 fileWriter2 = new FileWriter(log1); 
			 writer2 =  new BufferedWriter(fileWriter2);
			
			writer2.write("Nombres d'applications par catégories : ");
			writer2.newLine();
			writer2.newLine();

			for (int i = 0; i < res1.size(); i++) {
				writer2.write(res1.get(i));
				writer2.newLine();
			    }
			
			writer2.newLine();
			writer2.newLine();
			
			writer2.write("Polarité moyenne des avis par catégorie : ");
			
			writer2.newLine();
			writer2.newLine();
			
			for (int i = 0; i < res2.size(); i++) {
				writer2.write(res2.get(i));
				writer2.newLine();
			    }
			writer2.newLine();
			writer2.newLine();
			
			writer2.write(res3.get(0));
			writer2.newLine();
			writer2.newLine();
			
			writer2.write("Applications ayant plus de 100 reviews : ");
			writer2.newLine();
			writer2.newLine();
			for (int i = 0; i < res4.size(); i++) {
				writer2.write(res4.get(i));
				writer2.newLine();
			    }
			
			
			
			writer2.close(); 
		}
		catch (FileNotFoundException e) {
		System.out.println("Fichier non trouvé");
		}
		catch (IOException e) {
		System.out.println("Fichier non accessible");
		}
		
		
		
	}
}
