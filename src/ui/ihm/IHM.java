package ui.ihm;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date; 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

import dao.UserDAO;
import model.User;

public class IHM extends JFrame{
	
	JPanel main;
	
	
		JPanel haut; 
		JPanel infos;
		JPanel userPnl;
		JLabel userLbl; 
		
		JPanel texte;
		
		JPanel add;
		JLabel addConf;
		JLabel add1;

		JPanel boutons;
		JLabel uptConf;


		JPanel delete;
		JPanel delete0;
		JPanel delete2;
		JLabel delConf;
		JLabel delete1;

		JLabel userIdLbl;
		JLabel userNameLbl;
		JLabel userBirthLbl;
		JLabel userMailLbl;
	
		JTextField userIpt; // Les JTextField permettent de saisir un texte au clavier
		
		JTextField addId;
		JTextField addUsername;
		JTextField addBirthdate;
		JTextField addEmail;
	
		JTextField delId;
		
		JButton displayBtn; // Un bouton
		JButton addBtn; // Un bouton
		JButton updateBtn; // Un bouton
		JButton deleteBtn; // Un bouton
		JButton resBtn; // Un bouton
	
		JTextArea zone_texte ;
		Date birthdate ;
		
		JScrollPane scroll;
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		ArrayList<String> reviews = new ArrayList <>();
		public IHM () {
			// Paramétrage de la fenêtre
			this.setSize(1000, 700);
			this.setTitle("Gestion des utilisateurs");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			main = new JPanel();
			
			texte = new JPanel();
			zone_texte = new JTextArea();
			
			
			
			haut = new JPanel();
			infos = new JPanel();
			userPnl = new JPanel();
			
			add = new JPanel();
			addConf = new JLabel(" ");
			
			boutons = new JPanel();
			uptConf = new JLabel(" ");
			
			delete = new JPanel();
			delete0 = new JPanel();
			delete2 = new JPanel();
			delConf = new JLabel(" ");
			
			userLbl = new JLabel("              Affichage des infos d'un utilisateur, rentrez l'identifiant :            ");
			add1 = new JLabel("              Insertion ou modification d'un utilisateur : ");

			delete1 = new JLabel("Suppression d'un utilisateur, rentrez l'ID de l'utilisateur à supprimer ");
			
			userIdLbl = new JLabel("  Identifiant : ");
			userNameLbl = new JLabel("  Nom : ");
			userBirthLbl = new JLabel("  Date de naissance : ");
			userMailLbl = new JLabel("  Adresse mail : ");
			
			
			userIpt = new JTextField(10);
			userIpt.setSize(100, 50);
			
			addId = new JTextField(10);
			addId.setSize(100, 50);
			
			addUsername = new JTextField(10);
			addUsername.setSize(100, 50);
			
			addBirthdate = new JTextField(10);
			addBirthdate.setSize(100, 50);

			addEmail = new JTextField(10);
			addEmail.setSize(100, 50);
			
			
			delId = new JTextField(10);
			delId.setSize(100, 50);

			
			
			// Ajout d'un bouton pour valider la référence
			displayBtn = new JButton("CONSULTER");
			displayBtn.addActionListener(new ActionListener() { // On surveille les évènements avec un listener
			
			public void actionPerformed(ActionEvent e) { // Et lorsqu'on clique sur le bouton...
				infos.removeAll();
				zone_texte.setText(" ");
				if(userIpt.getText().length() > 0) { 
					
					int id = Integer.parseInt(userIpt.getText()); // On convertit la référence saisie en nombre entier
					displayReviews ( id);
					displayUser(id); // on affiche les informations du fournisseur correspondant avec la méthode écrite plus bas
					revalidate(); // on rafraichit la fenêtre
				}
				else {
					JOptionPane.showMessageDialog(new JFrame(), "Vous devez entrer une référence d'utilisareur", "Dialog",
					        JOptionPane.ERROR_MESSAGE);
				}
			}
				
			});
			
			resBtn = new JButton("Afficher tous les utilisateurs ");
			displayBtn.addActionListener(new ActionListener() { // On surveille les évènements avec un listener
				
				public void actionPerformed(ActionEvent e) { // Et lorsqu'on clique sur le bouton...
					displayUsers(); 
					revalidate();
				}
					
				});
			
			addBtn = new JButton("AJOUTER");
			addBtn.addActionListener(new ActionListener() { // On surveille les évènements avec un listener
			
			public void actionPerformed(ActionEvent e) { // Et lorsqu'on clique sur le bouton...
				
				if(addId.getText().length() > 0 & addUsername.getText().length() > 0 & addBirthdate.getText().length() > 0 & addEmail.getText().length() > 0   ) { 
					
					int id = Integer.parseInt(addId.getText()); // On convertit la référence saisie en nombre entier
					String datee = addBirthdate.getText();
					 try {
				            // Analyser la chaîne pour obtenir un objet java.util.Date
				            java.util.Date parsedDate = dateFormat.parse(datee);
				            
				            // Convertir java.util.Date en java.sql.Date
				            birthdate = new Date(parsedDate.getTime());
				        } catch (ParseException e1) {
				            // Gérer l'exception en cas de problème de format
				            e1.printStackTrace();
				        }
					addUser(id,addUsername.getText(),birthdate ,addEmail.getText()); // on affiche les informations du fournisseur correspondant avec la méthode écrite plus bas
					revalidate(); // on rafraichit la fenêtre
				}
				else {
					JOptionPane.showMessageDialog(new JFrame(), "Vous devez entrer tous les paramètres de l'utilisateur", "Dialog",
					        JOptionPane.ERROR_MESSAGE);
				}
			}
				
			});
			
			updateBtn = new JButton("MODIFIER");
			updateBtn.addActionListener(new ActionListener() { // On surveille les évènements avec un listener
			
			public void actionPerformed(ActionEvent e) { // Et lorsqu'on clique sur le bouton...
				
				if(addId.getText().length() > 0 & addUsername.getText().length() > 0 & addBirthdate.getText().length() > 0 & addEmail.getText().length() > 0    ) { 
					
					int id = Integer.parseInt(addId.getText()); // On convertit la référence saisie en nombre entier
					String datee = addBirthdate.getText();
					 try {
				            // Analyser la chaîne pour obtenir un objet java.util.Date
				            java.util.Date parsedDate = dateFormat.parse(datee);
				            
				            // Convertir java.util.Date en java.sql.Date
				            birthdate = new Date(parsedDate.getTime());
				        } catch (ParseException e2) {
				            // Gérer l'exception en cas de problème de format
				            e2.printStackTrace();
				        }
					 updateUser(id,addUsername.getText(),birthdate ,addEmail.getText()); // on affiche les informations du fournisseur correspondant avec la méthode écrite plus bas
					revalidate(); // on rafraichit la fenêtre
				}
				else {
					JOptionPane.showMessageDialog(new JFrame(), "Vous devez entrer tous les paramètres de l'utilisateur", "Dialog",
					        JOptionPane.ERROR_MESSAGE);
				}
			}
				
			});
			
			deleteBtn = new JButton("SUPPRIMER");
			deleteBtn.addActionListener(new ActionListener() { // On surveille les évènements avec un listener
			
			public void actionPerformed(ActionEvent e) { // Et lorsqu'on clique sur le bouton...
				delId.removeAll();
				if(delId.getText().length() > 0) { 
					
					int id = Integer.parseInt(delId.getText()); // On convertit la référence saisie en nombre entier
					deleteUser(id); // on affiche les informations du fournisseur correspondant avec la méthode écrite plus bas
					revalidate(); // on rafraichit la fenêtre
				}
				else {
					JOptionPane.showMessageDialog(new JFrame(), "Vous devez entrer une référence d'utilisareur", "Dialog",
					        JOptionPane.ERROR_MESSAGE);
				}
			}
				
			});
			
			// ajout des composants à la fenêtre
			
			haut.setLayout(new GridLayout(1, 2));
			
			
			
			delete2.add(userLbl);
			delete2.add(userIpt) ;
			delete2.add(displayBtn);
			
			add.setLayout(new GridLayout(12, 1));

			add.add(add1);

			add.add(userIdLbl);
			add.add(addId);
			
			add.add(userNameLbl); 
			add.add(addUsername); 
			
			add.add(userBirthLbl); 
			add.add(addBirthdate); 
			
			add.add(userMailLbl); 
			add.add(addEmail); 
			
			boutons.setLayout(new GridLayout(1, 2));
			
			boutons.add(addBtn);
			boutons.add(updateBtn);
			
			add.add(boutons);
			
			add.add(addConf);
			add.add(uptConf); 
			
			delete0.add(delete1); 
			delete0.add(delId); 
			
			delete0.add(deleteBtn);
			delete0.add(delConf);
			
			delete.setLayout(new GridLayout(4, 1));
			delete.add(delete0);
			delete.add(delete2);
			delete.add(infos);
			delete.add(resBtn);

			
			texte.add(zone_texte);
			
			main.add(add);
			main.add(delete);
			scroll = new JScrollPane(zone_texte);
			
			main.setLayout(new GridLayout(1, 2));
			
			this.getContentPane().setLayout(new GridLayout(2, 1));
			this.getContentPane().add(main);
			this.getContentPane().add(scroll);
			
			this.setVisible(true);
		}
		
		/**
		 * Permet d'afficher dans des JLabel les informations
		 * d'un fournisseur récupérées grâce à sa classe DAO et l'id
		 * fourni en entrée
		 * 
		 * @param id la référence d'un fournisseur
		 */
		public void displayUser(int id) {
			
			UserDAO userDao = new UserDAO(); // On crée un objet SupplierDAO pour communiquer avec la base
			User user = userDao.get(id); // On récupère le fournisseur à partir de son id
			userNameLbl = new JLabel("                      Pseudo : "+user.getUsername()); // On crée des JLabel avec les infos du fournisseur
			userBirthLbl = new JLabel("                      Date de naissance : "+user.getBirthdate());
			userMailLbl = new JLabel("                      Email : "+user.getEmail());
			
			infos.setLayout(new GridLayout(3, 1));
						
			infos.add(userNameLbl); // On ajoute les JLabel à la fenêtre
			infos.add(userBirthLbl); // On ajoute les JLabel à la fenêtre
			infos.add(userMailLbl); // On ajoute les JLabel à la fenêtre
			
			
		}
		
		public void addUser(int id, String username, Date birthdate, String email ) {
			
			User user = new User(id, username, birthdate, email);
			UserDAO userDao = new UserDAO(); // On crée un objet SupplierDAO pour communiquer avec la base
			userDao.add(user); // On récupère le fournisseur à partir de son id
			addConf.setText("Ajout effectué !");
			
		
		}
		
		public void updateUser(int id, String username, Date birthdate, String email ) {
			
			User user = new User(id, username, birthdate, email);
			UserDAO userDao = new UserDAO(); // On crée un objet SupplierDAO pour communiquer avec la base
			userDao.update(user); // On récupère le fournisseur à partir de son id
			uptConf.setText("Modification effectuée !");
			
		}
		
		public void deleteUser(int id) {
			
			UserDAO userDao = new UserDAO(); // On crée un objet SupplierDAO pour communiquer avec la base
			userDao.delete(id); // On récupère le fournisseur à partir de son id
			delConf.setText("Suppresion effectuée !");
		
		}
		
		public void displayReviews (int id) {
			UserDAO userDao = new UserDAO();
			reviews = userDao.getReviews(id);
			zone_texte.append("Reviews de l'utilisateur :");
			zone_texte.append("\n");
			zone_texte.append("\n");
			for (int i = 0; i < reviews.size(); i++) {
			      zone_texte.append(reviews.get(i));
			      zone_texte.append("\n");
			    }
			
		}
		
		public void displayUsers() {
			
			UserDAO userDao = new UserDAO();
			ArrayList<User> allUsers = userDao.getList();
			zone_texte.append("Affichage de tous les utilisateurs :");

			for (User s : allUsers) {
				// Appel implicite de la m�thode .toString()
				System.out.println("ID" +s.getId()+"\n"+
									"Username" +s.getUsername()+"\n"+
									"Date de naissance" +s.getBirthdate()+"\n"+
									"Email" +s.getEmail()+"\n"+"\n");
				zone_texte.append("\n");
			}
			
		}
		
		public static void main(String[] args) {
			IHM window = new IHM();
		}

}
