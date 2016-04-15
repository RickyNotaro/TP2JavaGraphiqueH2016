/**
 * @author Ricky Notaro-Garcia
 */
package gestion;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import classesMetiers.Album;

public class GestionAlbums {
	
	private Statement statement = null;
	private PreparedStatement declarationParametree;
	private ResultSet jeuResultats;
	private ArrayList<Album> listeAlbums = new ArrayList<>();
	private static Connection connexion;
	
	public GestionAlbums(Connection c){
		this.connexion = c;
	}
	
	public void UpdaterArrayList(){
		listeAlbums.clear();
		String requete = "SELECT numero,titre,prix,genre,anneeSortie,maisonDistribution,image,numeroArtiste FROM Albums";
		try {
			statement = connexion.createStatement();
			jeuResultats = statement.executeQuery(requete);
			while (jeuResultats.next()) {
				Album a = new Album();
				a.setNumeroAlbum(jeuResultats.getInt(1));
				a.setTitre(jeuResultats.getString(2));
				a.setPrix(jeuResultats.getDouble(3));
				a.setGenre(jeuResultats.getString(4));
				a.setAnnee(jeuResultats.getInt(5));
				a.setMaisonDistribution(jeuResultats.getString(6));
				a.setImage(jeuResultats.getString(7));
				a.setNumeroArtiste(jeuResultats.getInt(8));
				listeAlbums.add(a);
				}
		}
		catch (SQLException se) {
			System.out.println("ERREUR SQL UpdateArraylist :" + se);
		}


	}
	
	public void AfficherToutAlbums(){
		UpdaterArrayList();
		for (Album a : listeAlbums) {
			System.out.println(a.toString());
		}
	}
	
	public void modifierAlbum(Album album){
		String requete = "UPDATE albums SET numero=?,titre=?,prix=?,genre=?,anneeSortie=?,maisonDistribution=?,image=?,numeroArtiste where numero=?";
		
		try {
			statement = connexion.createStatement();
			declarationParametree= connexion.prepareStatement(requete);
			declarationParametree.setInt(1, album.getNumeroAlbum());
			declarationParametree.setString(2, album.getTitre());
			declarationParametree.setDouble(3, album.getPrix());
			declarationParametree.setString(4, album.getGenre());
			declarationParametree.setInt(5, album.getAnnee());
			declarationParametree.setString(6, album.getMaisonDistribution());
			declarationParametree.setString(7, album.getImage());
			declarationParametree.setInt(8, album.getNumeroArtiste());
			declarationParametree.executeUpdate();
			declarationParametree.clearParameters();
		}
		catch (SQLException se) {
			System.out.println("ERREUR SQL :" + se);
		}
	}
	
	public void dropTable(){
	      try {
			statement = connexion.createStatement();
			String sql = "DELETE FROM Albums";
			 statement.executeUpdate(sql);
	      }catch (SQLException se) {
				System.out.println("ERREUR SQL drop table :" + se);
			}	          
	}
	
	public void supprimerAlbum(int idAlbum){

	      try {
	    	  String requete = "DELETE FROM Albums WHERE numero=?";
				statement = connexion.createStatement();
				declarationParametree= connexion.prepareStatement(requete);
				declarationParametree.setInt(1, idAlbum);
				declarationParametree.executeUpdate();
				declarationParametree.clearParameters();
			}
			catch (SQLException se) {
				System.out.println("ERREUR SQL :" + se);
			}
	}
	
	public void ajouterAlbum(Album album){
		
		String requete = "Insert into albums (titre,prix,genre,anneeSortie,maisonDistribution,image,numeroArtiste) VALUES(?,?,?,?,?,?,?)";
		
		try {
			statement = connexion.createStatement();
			
			declarationParametree= connexion.prepareStatement(requete);
			declarationParametree.setString(1, album.getTitre());
			declarationParametree.setDouble(2, album.getPrix());
			declarationParametree.setString(3, album.getGenre());
			declarationParametree.setInt(4, album.getAnnee());
			declarationParametree.setString(5, album.getMaisonDistribution());
			declarationParametree.setString(6, album.getImage());
			declarationParametree.setInt(7, album.getNumeroArtiste());
			declarationParametree.executeUpdate();
			declarationParametree.clearParameters();
			listeAlbums.add(album);
		}
		catch (SQLException se) {
			System.out.println("ERREUR SQL AJOUT ALBUM :" + se);
		}
	}
}