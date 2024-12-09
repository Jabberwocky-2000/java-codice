package it.uniurb.pmo.pmo13.enums.en1;

import java.util.Arrays;

public class UseRegion {
	
	public static void main(String[] args) {
		// nella variabile regione, si possono usare solo 3 casi
		Region regione = Region.MARCHE;
		
		System.out.println(regione);
		// si ottengono gli array dei valori possibile
		System.out.println(Arrays.toString(Region.VALUES));
		// è possibile accedere alla "prossima regione"
		System.out.println(Region.VALUES[regione.getId()+1]);
	}

}
