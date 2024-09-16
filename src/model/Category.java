package model;

public class Category {

	private int id;
	private String name;
	
	public Category(int id, String name) {
		this.id	= id;
		this.name = name;
		
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
	
	public void display() {
		System.out.println("Identifiant de la catégorie : "+this.id);
		System.out.println("Nom de la catégorie : "+this.name);
		

		
	}
	
}
