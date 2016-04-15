/**
 * @author Alexandre Chamberland-Cardinal
 */
package classesMetiers;

public class Artiste {
	private int numero;
	private String nom;
	private String photo;
	private boolean membre;
	
	public Artiste(String nm, String pho, boolean mem){
		nom = nm;
		photo = pho;
		membre = mem;
	}
	
	public Artiste(int num,String nm, String pho, boolean mem){
		numero = num;
		nom = nm;
		photo = pho;
		membre = mem;
	}
	
	public void setNumero(int num){
		numero = num;
	}
	
	public void setNom(String nm){
		nom = nm;
	}
	
	public void setPhoto(String pho){
		photo = pho;
	}
	
	public void setMembre(boolean mem){
		membre = mem;
	}
	
	public int getNumero(){
		return numero;
	}
	
	public String getNom(){
		return nom;
	}
	
	public String getPhoto(){
		return photo;
	}
	
	public boolean isMember(){
		return membre;
	}
	
	@Override
	public String toString(){
		if(membre){
			return nom + " | " + numero + " | " + photo + " | Membre";
		} else {
			return nom + " | " + numero + " | " + photo + " | Non Membre";
		}
	}
}
