package tamagotchi;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Tama {
	
	public static Scanner sc = new Scanner(System.in);

	private char sexe = 'F';
	private String nom;
	private int faim = 5, humeur = 5, besoin = 5, hygiene = 5, sante = 10, poids = 5, loisirs = 5;
        boolean mort;
	
	/**
	 * 
	 * Valeurs maximales : humeur = 10, faim = 10,
	 * besoin = 10, hygiene = 10, sante = 10, poids = 10;
	 * 
	 * Valeurs par défaut : humeur = 5, faim = 5;
	 * 	besoin = 0, hygiene = 10, sante = 10, poids = 5
	 *
	 * Valeurs d'alerte : humeur = 0, faim = 0;
	 * besoin = 9, hygiene = 0, sante = 2, poids = 1;
	 * 
	 * Valeurs de décès : santé = 0
	 * 
	 * 
	 */
	
//String pNom, char pSexe
	public Tama() {
		String nom = "";  //=pNom;
		char sexe;  //=pSexe;
                int faim = 5, besoin = 5, hygiene = 5, sante = 10 , poids = 5, humeur = 5;
	}

	@Override
	public String toString() {
		return "[sexe=" + sexe + ", humeur=" + humeur + ", nom=" + nom + ", faim=" + faim + ", besoin=" + besoin
				+ ", hygiene=" + hygiene + ", sante=" + sante + ", poids=" + poids + "]";
	}

	public void alert(){
                if (humeur < 2 || faim < 2 || besoin < 2 || hygiene < 2 || loisirs < 2 || sante < 2 || poids < 2 || poids > 8) {
                   
                    
	 	 if (humeur < 2){
	            System.out.println(nom + "est un peu deprimé :( , vous devriez jouer avec lui");
	 	 }
                 else if (faim < 2){
	 		 System.out.println("Brlllbrrll... Oups! Le ventre de " + nom + " gargouille:( , vous devriez penser à le nourrir.");
	 	 }
                 else if (besoin < 2){
	 		 System.out.println(nom + " ne pourra pas se retenir plus longtemps, pensez à l'amener aux toilettes.");
	 	 }
                 else if (hygiene < 2){
	 		 System.out.println("Ca sent pas très bon par ici! Et si on allait à la douche?");
	 	 }
                 else  if (poids < 2) {
	 		 System.out.println(nom + " est tout maigre, nourris-le stp!");
	 	 }
                 else if(loisirs < 2) {
	 		 System.out.println(nom + " s'ennuie... Ne le laissez pas mourir d'ennui :(");
	 	 }
	 	 else if (poids> 8) {
	 		 System.out.println("Ben alors! On se laisse aller? Un peu de sport ne ferait pas de mal à " + nom);
	 	 }
                 else if (sante <2) {
	 		 System.out.println(nom + "n'a pas l'air en forme, est-il malade ?");
	 	 }
                 else;
                }
	}

	public boolean dead() {
		//boolean mort = true;
        if (sante == 0) {
            System.out.println("Tu viens de tuer " + nom + ":(");
            mort = true;
        }
        return mort;
    }

	public void goSport() {
		System.out.println(nom + " s'est bien depensé!");
		this.addFaim(-2);
		this.addBesoin(1);
		this.addHumeur(2);
		this.addHygiene(-2);
		this.addPoids(-2);
                
                if (poids <= 0){
                    sante--;
                }
	}
	public void goToilettes() {
		System.out.println(nom + " se sent léger maintenant.");
		this.addFaim(1);
		this.addBesoin(-10);
		this.addHumeur(1);
		this.addHygiene(-2);
		this.addSante(-1);
		this.addPoids(-1);
	}
	public void goMiam() {
		System.out.println(nom + " se régale! Miam!");
		this.addFaim(10);
		this.addBesoin(2);
		this.addHumeur(2);
		this.addHygiene(-1);
		this.addSante(1);
		this.addPoids(2);
                
                if (faim >= 10) {
                    hygiene --;
                    besoin--;
                    poids++;
                    if(poids >= 10) {
                        sante--;
                    }
                } else if (faim <= 0) {
                    hygiene--;
                    besoin--;
                    poids--;
                    if(poids <= 0) {
                        sante--;
                    }
                }
	}
	public void goDouche() {
		System.out.println(nom + " adore prendre sa douche.");
		System.out.println(toString());
		this.addFaim(-1);
		this.addBesoin(-1);
		this.addHumeur(2);
		this.addHygiene(10);
		this.addSante(1);
		this.addPoids(1);
	}
	public void goDodo() {
		System.out.println("Il est l'heure d'aller dormir!");
		this.addFaim(-5);
		this.addBesoin(-5);
		this.addHumeur(3);
		this.addHygiene(-3);
		this.addSante(5);
		this.addPoids(1);
	}
	public void goLoisirs() {
		System.out.println(nom + " adore jouer avec toi!");
		this.addFaim(-2);
		this.addBesoin(1);
		this.addHumeur(2);
		this.addHygiene(-2);
		this.addSante(1);
		this.addPoids(-2);
                if (faim <= 0) {
                    poids--;
                    if(poids <= 0) {
                        sante--;
                    }
                }
	}

	public char getSexe() {
		return sexe;
	}
	public void setSexe(char sexe) {
		this.sexe = sexe;
	}
	public int getHumeur() {
		return humeur;
	}
	public void setHumeur(int humeur) {
        if(humeur >= 10) {
            this.humeur = 10;
        }
        else if(humeur <= 0) {
            this.humeur = 0;
        }
        else {
            this.humeur = humeur;
        }
    }
    public void addHumeur(int ajout) {
        int nouvelHumeur = this.humeur + ajout;
        this.setHumeur(nouvelHumeur);
    }

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public int getFaim() {
		return faim;
	}
	public void setFaim(int faim) {
		if(faim >= 10) {
			this.faim = 10;
		}
		else if(faim <= 0) {
			this.faim = 0;
		}
		else {
			this.faim = faim;
		}
	}
	
	public void addFaim(int ajout) {
		int nouvelFaim = this.faim + ajout;
		this.setFaim(nouvelFaim);
	}

	public int getBesoin() {
		return besoin;
	}
	
	public void setBesoin(int besoin) {
		if(besoin >= 10) {
			this.besoin = 10;
		}
		else if(besoin <= 0) {
			this.besoin = 0;
		}
		else {
			this.besoin = besoin;
		}
	}
	
	public void addBesoin(int ajout) {
		int nouvelBesoin = this.besoin + ajout;
		this.setBesoin(nouvelBesoin);
	}

	public int getHygiene() {
		return hygiene;
	}
	
	public void setHygiene(int hygiene) {
		if(hygiene >= 10) {
			this.hygiene = 10;
		}
		else if(hygiene <= 0) {
			this.hygiene = 0;
		}
                else {
			this.hygiene = hygiene;
		}
	}
	
	public void addHygiene(int ajout) {
		int nouvelHygiene = this.hygiene + ajout;
		this.setHygiene(nouvelHygiene);
	}
	
	public int getSante() {
		return sante;
	}
	
	public void setSante(int sante) {
		if(sante >= 10) {
			this.sante = 10;
		}
		else if(sante <= 0) {
			this.sante = 0;
		}
		else {
			this.sante = sante;
		}
	}
	
	public void addSante(int ajout) {
		int nouvelSante = this.sante + ajout;
		this.setSante(nouvelSante);
	}

	public int getPoids() {
		return poids;
	}
	
	public void setPoids(int poids) {
		if(poids >= 10) {
			this.poids = 10;
		}
		else if(poids <= 0) {
			this.poids = 0;
		}
		else {
			this.poids = poids;
		}
	}
	
	public void addPoids(int ajout) {
		int nouvelPoids = this.poids + ajout;
		this.setPoids(nouvelPoids);
	}
	
	public int getLoisirs() {
		return loisirs;
	}
	
	public void setLoisirs(int loisirs) {
		if(loisirs >= 10) {
			this.loisirs = 10;
		}
		else if(loisirs <= 0) {
			this.loisirs = 0;
		}
		else {
			this.loisirs = loisirs;
		}
	}
	
	public void addLoisirs(int ajout) {
		int nouvelLoisirs = this.loisirs + ajout;
		this.setLoisirs(nouvelLoisirs);
	}
}


