package model;

public class Review {
	
	private int id;
	private String translated_review;
	private String sentiment;
	private double polarity;
	private double subjectivity;
	private int app;
	private int user;
	
	public Review(int id, int app,int user, String translated_review, String sentiment, double polarity, double subjectivity) {
		this.id = id;
		this.translated_review = translated_review;
		this.sentiment = sentiment;
		this.polarity = polarity;
		this.subjectivity = subjectivity;
		this.app = app;
		this.user = user;
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
	 * @return the polarity
	 */
	public double getPolarity() {
		return this.polarity;
	}
	/**
	 * @param polarity the polarity to set
	 */
	public void setPolarity(double polarity) {
		this.polarity = polarity;
	}
	/**
	 * @return the translated_review
	 */
	public String getTranslated_review() {
		return this.translated_review;
	}
	/**
	 * @param translated_review the translated_review to set
	 */
	public void setTranslated_review(String translated_review) {
		this.translated_review = translated_review;
	}
	/**
	 * @return the sentiment
	 */
	public String getSentiment() {
		return this.sentiment;
	}
	/**
	 * @param sentiment the sentiment to set
	 */
	public void setSentiment(String sentiment) {
		this.sentiment = sentiment;
	}
	/**
	 * @return the subjectivity
	 */
	public double getSubjectivity() {
		return this.subjectivity;
	}
	/**
	 * @param subjectivity the subjectivity to set
	 */
	public void setSubjectivity(double subjectivity) {
		this.subjectivity = subjectivity;
	}
	
	/**
	 * @return the app
	 */
	public int getApp() {
		return this.app;
	}
	/**
	 * @param app the app to set
	 */
	public void setApp(int app) {
		this.app = app;
	}
	/**
	 * @return the user
	 */
	public int getUser() {
		return this.user;
	}
	/**
	 * @param subjectivity the subjectivity to set
	 */
	public void setSubjectivity(int user) {
		this.user = 
user;
	}
	public void display () {
		System.out.println("Identifiant de la review : "+this.id);
		System.out.println("Review traduite : "+this.translated_review);
		System.out.println("sentiment : "+this.sentiment);
		System.out.println("Polarité : "+this.polarity);
		System.out.println("Subjectivité :"+this.subjectivity);
		System.out.println("Identifiant de l'utilisateur : "+this.user);
		System.out.println("Identifiant de l'application : "+this.app);
		

	}
	
	

}
