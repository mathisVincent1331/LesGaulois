package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int nbTrophees;
	private int effetPotion = 1;
	private Equipement[] trophees ;

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
		this.trophees = new Equipement[100];
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
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] tropheesBataille = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; tropheesBataille != null && i < trophees.length; i++,
				nbTrophees++) {
			this.trophees[nbTrophees] = tropheesBataille[i];
		}
	}
	
	
//	private String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}

//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
//		romain.recevoirCoup((force / 3) * effetPotion);
//	}

	public int boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		System.out
				.println(prendreParole() + "Merci Druide, je sens que ma force est " 
		+ forcePotion + " fois décuplée.");
		return effetPotion;

	}

//	public String toString() {
//		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
//	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		Romain potus = new Romain("Potus", 6);

		asterix.prendreParole();
		asterix.parler("je suis le gaulois le plus fier et le plus fort !");
		asterix.frapper(potus);
	}

}
