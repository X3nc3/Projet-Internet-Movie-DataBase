package fr.diginamic.Utils;

import java.util.Scanner;

public class RechercheFilmAnneeActeur {

    public void rechercheFilmAnneeActeur(Scanner scanner) {
        System.out.println("Choississez une 1er année :");
        String annee1 = scanner.next();

        System.out.println("Choississez une 2em année :");
        String annee2 = scanner.next();
        int premierAnnee = Integer.parseInt(annee1);
        int deuxiemeAnnee = Integer.parseInt(annee2);
    }
}
