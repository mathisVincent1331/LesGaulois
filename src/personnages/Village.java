package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private	int nbVillageois = 0;
	
	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public String getNom() {
		return nom;
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois;
		nbVillageois ++;
	}
	
	public Gaulois trouverHabitant(int idVillageois) {
		return villageois[idVillageois];
	}
	
	public void afficherVillageois() {
		System.out
		.println("Dans village du chef Abraracourcix vivent les légendaires gaulois :");
		for (int i = 0; i < nbVillageois; i++) {
			System.out.println("- " + trouverHabitant(i).getNom());
		}
	}
	
	public static void main(String[] args) {
		Village village = new Village("“Village des Irréductibles", 30);
		Chef abraracourcix = new Chef("Abraracourcix", 6, village);
		Gaulois asterix = new Gaulois("Astérix", 8);
		Gaulois obelix = new Gaulois("Obélix", 25);
		
		village.setChef(abraracourcix);
		village.ajouterHabitant(asterix);
		village.ajouterHabitant(obelix);
		
		village.afficherVillageois();
		
		
		
		
		
//		Gaulois gaulois = village.trouverHabitant(30);
//      La valeur d'entrée dépasse la capacité maximale du tableau
		
//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);
//		il n'y a qu'un villageois donc on sort du tableau
	}
}
