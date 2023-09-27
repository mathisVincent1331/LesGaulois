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
	
	private void isEquiper(Equipement equip) {
		switch (nbEquipements) {
			case 0:
				equipements[nbEquipements] = equip;
				nbEquipements ++;
				System.out.println("Le romain "+nom+" s'equipe avec un " + equip);
				break;
			case 1 :
				if (equipements[nbEquipements-1] == equip) {
					System.out.println("Le romain "+nom+" possède déjà un " + equip);
				} else {
					equipements[nbEquipements] = equip;
					nbEquipements ++;
					System.out.println("Le romain "+nom+" s'equipe avec un " + equip);
				}
				break;
			default :
				System.out.println("Le soldat "+ nom + " est déjà bien protégé !");
				break;
		}
	}
	
	public void sEquiper(Equipement equipement) {
		switch (equipement) { 
			case CASQUE:
				isEquiper(equipement);
				break;

			case BOUCLIER:
				isEquiper(equipement);
				break;
		
			default:
				break;
			}
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		minus.recevoirCoup(2);
		
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		
	}
}
