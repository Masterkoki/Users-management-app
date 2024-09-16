package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ResultatsDAO extends ConnexionDAO{
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public ResultatsDAO() {
		super();
	}
	
	public ArrayList <String> getRes1() {
		
		ArrayList <String> returnValue = new ArrayList<String>() ;

		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("select count (app.id), category.name from app inner join category on category_id = category.id group by category.name order by count (app.id) desc");

			// on execute la requete
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			while (rs.next()) {
				returnValue.add("Catégorie : "+rs.getString("name") +"| Nombre d'applications : "+rs.getInt("count(app.id)")) ;
				
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			// fermeture du rs, du preparedStatement et de la connexion
			try {
				if (rs != null)
					rs.close();
			} catch (Exception ignore) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignore) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ignore) {
			}
		}
		return returnValue;
	}
	
	public ArrayList <String> getRes2() {
		
		ArrayList <String> returnValue = new ArrayList<String>() ;

		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("select category.name  as \"nom\" ,round(avg(polarity),2) from review inner join app on app.id = app_id inner join category on category_id = category.id group by category.name");

			// on execute la requete
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			while (rs.next()) {
				returnValue.add("Catégorie : "+rs.getString("nom") +"| Polarité moyenne : "+rs.getDouble("round(avg(polarity),2)")) ;
				
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			// fermeture du rs, du preparedStatement et de la connexion
			try {
				if (rs != null)
					rs.close();
			} catch (Exception ignore) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignore) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ignore) {
			}
		}
		return returnValue;
	}
	public ArrayList <String> getRes3(int limite) {
		
		ArrayList <String> returnValue = new ArrayList<String>() ;

		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement(" select count(id) from app where price >"+ limite);

			// on execute la requete
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			while (rs.next()) {
				returnValue.add("Nombre d'appli coutant plus de "+limite+" € : " +rs.getInt("count(id)")) ;
				
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			// fermeture du rs, du preparedStatement et de la connexion
			try {
				if (rs != null)
					rs.close();
			} catch (Exception ignore) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignore) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ignore) {
			}
		}
		return returnValue;
	}
	
	public ArrayList <String> getRes4() {
		
		ArrayList <String> returnValue = new ArrayList<String>() ;

		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement(" select  name as \"n\" , count (review.id) as \"c\" from review inner join app on app_id = app.id group by app.name having count (review.id) > 100");
				

			// on execute la requete
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			while (rs.next()) {
				returnValue.add("Nom de l'application :"+ rs.getString ("n")+" | Nombre de reviews : "+ rs.getInt("c")  ) ;
				
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			// fermeture du rs, du preparedStatement et de la connexion
			try {
				if (rs != null)
					rs.close();
			} catch (Exception ignore) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignore) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ignore) {
			}
		}
		return returnValue;
	}
}
