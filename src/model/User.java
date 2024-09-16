package model;
import java.sql.Date;

public class User {
	
	private int id;
	private String username;
	private Date birthdate;
	private String email;
	
	public User (int id, String username, Date birthdate, String email) {
		
		this.id = id;
		this.username = username;
		this.birthdate = birthdate;
		this.email= email;
		
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return this.id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return this.username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the birthdate
	 */
	public Date getBirthdate() {
		return this.birthdate;
	}
	/**
	 * @param birthdate the birthdate to set
	 */
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return this.email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void display () {
		System.out.println("Identifiant de l'utilisateur : "+this.id);
		System.out.println("Nom de l'utilisateur : "+this.username);
		System.out.println("Date de naissance : "+this.birthdate);
		System.out.println("Mail de l'utilisateur : "+this.email);
		
	}
	 

}
