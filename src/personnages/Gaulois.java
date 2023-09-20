package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de "
		+ romain.getNom());
//		System.out.println(((force / 3) * boirePotion(effetPotion)));
		romain.recevoirCoup((force / 3)* boirePotion(effetPotion));
	}
	
	public int boirePotion(int forcePotion) {
		if (effetPotion == forcePotion) {
			return effetPotion;
		} else {
			effetPotion = forcePotion;
			System.out.println(prendreParole() + "Merci Druide, je sens que ma force est "
			+ forcePotion + " fois décuplée." );
			return effetPotion;
		}
	}
	
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force
		+ ", effetPotion=" + effetPotion + "]";
	}
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		Romain potus = new Romain("Potus", 6);
		
		asterix.prendreParole();
		asterix.parler("je suis le gaulois le plus fier et le plus fort !");
		asterix.frapper(potus);
	}

}
