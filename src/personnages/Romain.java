package personnages;

public class Romain {
	private static final String ROMAIN_APPEL = "Le Romain ";
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
		return (force >= 0);
	}

	public String getNom() {
		return nom;
	}
	
	public int getForce() {
		return force;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return ROMAIN_APPEL + nom + " : ";
	}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		
		forceCoup = calculResistanceEquipement(forceCoup);
		
		force -= forceCoup;
	
		if (force > 0) {
		
			parler("Aïe");
			
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		// post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;
	}

//	public void recevoirCoup(int forceCoup) {
//		assert isForceVerified();
//		int forceInit = force;
//		force -= forceCoup;
//		if (force > 0) {
//			parler("Aïe");
//		} else {
//			parler("J'abandonne...");
//		}
//		assert ((forceInit)>force);
//	}

	private int calculResistanceEquipement(int forceCoup) {
		
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup
				+ " Mais heureusement, grace à mon équipement sa force est diminué de ";
		int resistanceEquipement = 0;
		if (nbEquipements != 0) {
			for (int i = 0; i < nbEquipements;i++) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
		} 
		texte += "\n"+resistanceEquipement + "!";
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		System.out.println("L'équipement de " + nom
		+ "s'envole sous la force du coup.");
		Equipement[] equipementEjecte = new Equipement[nbEquipements];
		int nbEquipementEjecte = 0;
		
		for (int i = 0; i < nbEquipements; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}

	public void sEquiper(Equipement equip) {
		switch (nbEquipements) {
		case 0:
			ajouterEquipement(equip);
			break;
		case 1:
			if (equipements[nbEquipements - 1] == equip) {
				System.out.println(ROMAIN_APPEL + nom + " possède déjà un " + equip);
			} else {
				ajouterEquipement(equip);
			}
			break;
		default:
			System.out.println("Le soldat " + nom + " est déjà bien protégé !");
			break;
		}
	}

	private void ajouterEquipement(Equipement equip) {
		equipements[nbEquipements] = equip;
		nbEquipements++;
		System.out.println(ROMAIN_APPEL + nom + " s'equipe avec un " + equip);
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
