package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipements = 0;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		equipements = new Equipement[2];
		assert isForceVerified();
	}
	
	private boolean isForceVerified() {
		return (force>=0);
	}
	
	public String getNom(){
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		assert isForceVerified();
		int forceInit = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
		assert ((forceInit)>force);
	}
	
	

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		minus.recevoirCoup(2);
		System.out.println(Equipement.BOUCLIER);
	}
}
