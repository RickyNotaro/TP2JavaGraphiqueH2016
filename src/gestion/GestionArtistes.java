/**
 * @author Alexandre Chamberland-Cardinal
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

import classesMetiers.Artiste;

public class GestionArtistes {
	
	private Statement statement = null;
	private PreparedStatement declarationParametree;
	private ResultSet jeuResultats;
	private ArrayList<Artiste> artistes;
	
	public GestionArtistes(){
	}
	
	public void updateArrayList(Connection connexion){
		String requete = "Select * from artistes";
		artistes = new ArrayList<>();
		try {
			statement = connexion.createStatement();
			jeuResultats=statement.executeQuery(requete);
			while (jeuResultats.next()){
				String nom = jeuResultats.getString("nom");
				String photo = jeuResultats.getString("photo");
				boolean membre = jeuResultats.getBoolean("membre");
				int numero = jeuResultats.getInt("numero");
				artistes.add(new Artiste(numero,nom,photo,membre));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void modifierArtiste(Connection connexion,int numero, String nouvNom, String nouvPhoto, boolean nouvMembre){
		String requete = "UPDATE artistes SET nom=?,membre=?,photo=? where numero=?";
		
		try {
			int index = 0;
			while(index < artistes.size() - 1 && artistes.get(index).getNumero() != numero){
				index++;
			}
			artistes.get(index).setNom(nouvNom);
			artistes.get(index).setPhoto(nouvPhoto);
			artistes.get(index).setMembre(nouvMembre);
			statement = connexion.createStatement();
			declarationParametree= connexion.prepareStatement(requete);
			declarationParametree.setString(1, artistes.get(index).getNom());
			declarationParametree.setBoolean(2, artistes.get(index).isMember());
			declarationParametree.setString(3, artistes.get(index).getPhoto());
			declarationParametree.setInt(4, numero);
			declarationParametree.executeUpdate();
			declarationParametree.clearParameters();
		}
		catch (SQLException se) {
			System.out.println("ERREUR SQL :" + se);
		}
	}
	
	public void supprimerArtiste(Connection connexion,int numero){
		String requete = "Delete from artistes where numero=?";
		
		try {
			int index = 0;
			while(index < artistes.size() - 1 && artistes.get(index).getNumero() != numero){
				index++;
			}
			statement = connexion.createStatement();
			declarationParametree= connexion.prepareStatement(requete);
			declarationParametree.setInt(1, numero);
			declarationParametree.executeUpdate();
			declarationParametree.clearParameters();
			updateArrayList(connexion);
		}
		catch (SQLException se) {
			System.out.println("ERREUR SQL :" + se);
		}
	}
	
	public void ajouterArtiste(Connection connexion, Artiste artiste){
		String requete = "Insert into artistes (nom,membre,photo) values(?,?,?)";
		
		try {
			statement = connexion.createStatement();
			declarationParametree= connexion.prepareStatement(requete);
			declarationParametree.setString(1, artiste.getNom());
			declarationParametree.setBoolean(2, artiste.isMember());
			declarationParametree.setString(3, artiste.getPhoto());
			declarationParametree.executeUpdate();
			declarationParametree.clearParameters();
			String requete1 = "SELECT numero FROM artistes WHERE numero=(SELECT max(numero) FROM artistes)";
			try {
				statement.execute(requete1);
				jeuResultats=statement.getResultSet();
				if(jeuResultats.next())
					artiste.setNumero(jeuResultats.getInt(1));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		catch (SQLException se) {
			System.out.println("ERREUR SQL :" + se);
		}
		
		updateArrayList(connexion);
	}
	

	
	public void afficherTousArtistes(){
		artistes.get(0).toString();
		for(Artiste art : artistes){
			System.out.println(art.toString());
		}
	}
}
