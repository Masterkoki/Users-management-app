package model;
import java.util.ArrayList;

public class App {
	
	private int id;
	private String name;
	private double rating;
	private String installs;
	private String size;
	private double price;
	private String content_rating;

	private int category;
	ArrayList<Review> liste_reviews;
	
	public App (int id,String name,int category,double rating,String installs,String size,double price, String content_rating) {
		this.id = id;
		this.name = name;
		this.installs = installs;
		this.size = size;
		this.price = price;
		this.content_rating = content_rating;
		this.category = category;
	
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
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the installs
	 */
	public String getInstalls() {
		return this.installs;
	}
	/**
	 * @param installs the installs to set
	 */
	public void setInstalls(String installs) {
		this.installs = installs;
	}
	/**
	 * @return the rating
	 */
	public double getRating() {
		return this.rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}
	/**
	 * @return the size
	 */
	public String getSize() {
		return this.size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return this.price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the content_rating
	 */
	public String getContent_rating() {
		return this.content_rating;
	}
	/**
	 * @param content_rating the content_rating to set
	 */
	public void setContent_rating(String content_rating) {
		this.content_rating = content_rating;
	}
	/**
	 * @return the category
	 */
	public int getCategory() {
		return this.category ;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category.getId();
	}
	
	
	
	public void display () {
		
		System.out.println("Identifiant de l'application : "+this.id);
		System.out.println("Nom de l'application : "+this.name);
		System.out.println("Note de l'application : "+this.rating);
		System.out.println("Nombre de téléchargements de l'application : "+this.installs);
		System.out.println("Taille de l'application : "+this.size);
		System.out.println("Prix de l'application : "+this.price); 
		System.out.println("Note du contenu de l'application : "+this.content_rating);
		System.out.println("Identifiant de la categorie : "+this.category);
		
	}
	
	
}
