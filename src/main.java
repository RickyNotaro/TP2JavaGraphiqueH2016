/**
 * @author Ricky Notaro-Garcia & Alexandre Chamberland-Cardinal
 */
import java.sql.Connection;

import classesMetiers.Album;
import classesMetiers.Artiste;
import gestion.GestionAlbums;
import gestion.GestionArtistes;

public class main {

	public static void main(String[] args) {
		
		ControleConnexion cc = new ControleConnexion();
		Connection connexion = cc.connecter();
		// ART
		Artiste jean = new Artiste("Jean","Photo absente", true);
		Artiste jim = new Artiste("Jim","Photo absented", true);
		GestionArtistes gestion = new GestionArtistes();
		gestion.updateArrayList(connexion);
		gestion.ajouterArtiste(connexion, jean);
		gestion.ajouterArtiste(connexion, jim);
		gestion.modifierArtiste(connexion,2,"Julien", "Photo mod 2", false);
		gestion.supprimerArtiste(connexion, 4);
		gestion.supprimerArtiste(connexion, 6);
		gestion.afficherTousArtistes();
		
		//ALB
		Album album1 = new Album((Integer) null, "Un bel album", 13.42, "Électronique", 2016, "Montmorency Records", "www.google.com/logo.jpg", 1);
		Album album2 = new Album((Integer) null, "Automne, l'album", 24.42, "Classique", 1728, "Classical Music Label", "www.google.com/logo.jpg", 1);
		GestionAlbums gestionnaireAlbums = new GestionAlbums(connexion);
		gestionnaireAlbums.ajouterAlbum(album1);
		gestionnaireAlbums.ajouterAlbum(album2);
		gestionnaireAlbums.supprimerAlbum(24);
		gestionnaireAlbums.AfficherToutAlbums();
		cc.fermerSession(); // Ferme la connexion
	}

}
