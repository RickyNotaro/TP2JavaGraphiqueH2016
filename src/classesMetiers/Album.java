/**
 * @author Ricky Notaro-Garcia
 */
package classesMetiers;

import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil.ToStringAdapter;

public class Album {
	// Params 
	private Integer numeroAlbum = null;
	private String titre = null;
	private double prix = 0;
	private String genre = null;
	private int annee = 0;
	private String maisonDistribution = null;
	private String image = null;
	private int numeroArtiste = -1;
	
	// Getters and Setters
	public Album(Integer numeroAlbum, String titre, double prix, String genre, int annee, String maisonDistribution, String image, int numeroArtiste) {
		setNumeroAlbum(numeroAlbum);
		setTitre(titre);
		setPrix(prix);
		setGenre(genre);
		setAnnee(annee);
		setMaisonDistribution(maisonDistribution);
		setImage(image);
		setNumeroArtiste(numeroArtiste);
	}
	
	public Album() {
		
	}

	public int getNumeroAlbum() {
		return numeroAlbum;
	}

	public void setNumeroAlbum(Integer numeroAlbum) {
		this.numeroAlbum = numeroAlbum;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public String getMaisonDistribution() {
		return maisonDistribution;
	}

	public void setMaisonDistribution(String maisonDistribution) {
		this.maisonDistribution = maisonDistribution;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getNumeroArtiste() {
		return numeroArtiste;
	}

	public void setNumeroArtiste(int numeroArtiste) {
		this.numeroArtiste = numeroArtiste;
	}
	
	// Méthodes 
	@Override
	public String toString(){
		String s = new String();
		if (numeroAlbum != null) {
			s += "Numéro Album: " + getNumeroAlbum();
		}		
		s += "\tTitre: " + getTitre();
		s += "\tPrix: " + getPrix();
		s += "\tGenre: " + getGenre();
		s += "\tAnnee: " + getAnnee();
		s += "\tMaison de distribution: " + getMaisonDistribution();
		s += "\tImage: " + getImage();
		s += "\tNuméro de l'artiste: " + getNumeroArtiste();
		return s;		
	}
}
