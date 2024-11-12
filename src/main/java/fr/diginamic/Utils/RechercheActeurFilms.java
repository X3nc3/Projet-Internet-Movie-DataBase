package fr.diginamic.Utils;

import java.util.Scanner;

public class RechercheActeurFilms {

    public void rechercheActeurFilms(Scanner scanner) {
        System.out.println("Choississez un 1er film :");
        String film1 = scanner.next();

        System.out.println("Choississez un 2em film :");
        String film2 = scanner.next();
        int premierFilm = Integer.parseInt(film1);
        int deuxiemeFilm = Integer.parseInt(film2);
    }
}
