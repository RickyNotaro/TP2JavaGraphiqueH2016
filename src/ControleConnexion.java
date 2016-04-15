/**
 * @author Ricky Notaro-Garcia & Alexandre Chamberland-Cardinal
 */
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;

public class ControleConnexion {
	private static Connection laConnexion;
	private static String url = "jdbc:mysql://localhost/ChamberlandCardinalNotaroGarciaAlbums";
	
	public static Connection connecter(){
		try{
			if(laConnexion == null || laConnexion.isClosed()){
				Class.forName("org.gjt.mm.mysql.Driver");
				laConnexion = DriverManager.getConnection(url, "root", "mysql");
				//System.out.println("I SURVIVED");
			}
		} catch (ClassNotFoundException e){
			System.out.println("Erreur: " + e);
		} catch (SQLException sqle){
			System.out.println("Erreur sql: " + sqle);
		}
		return laConnexion;
	}
	
	public static void fermerSession(){
		try{
			if(laConnexion!=null && !laConnexion.isClosed()){
				laConnexion.close();
			}
		} catch (SQLException sqle){
			System.out.println("Erreur sql: " + sqle);
		}
	}
	
	public static Connection getLaConnexion(){
		return laConnexion;
	}
}