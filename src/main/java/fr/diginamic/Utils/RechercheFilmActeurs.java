package fr.diginamic.Utils;

import java.util.Scanner;

public class RechercheFilmActeurs {

    public void rechercheFilmActeurs(Scanner scanner) {
        System.out.println("Choississez un 1er acteur/actrice :");
        String acteur1 = scanner.next();

        System.out.println("Choississez un 2em acteur/actrice :");
        String acteur2 = scanner.next();
        int premierActeur = Integer.parseInt(acteur1);
        int deuxiemeActeur = Integer.parseInt(acteur2);
    }
}
