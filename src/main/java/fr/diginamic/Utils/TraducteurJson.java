package fr.diginamic.Utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.diginamic.bo.*;
import fr.diginamic.dto.*;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class TraducteurJson {

    public static List<Pays> ListPaysJson = new ArrayList<>();
    public static List<Genre> ListGenreJson = new ArrayList<>();
    public static List<Lieu> ListLieuxJson = new ArrayList<>();
    public static List<Realisateur> ListeRealisteurJson = new ArrayList<>();
    public static List<Acteur> ListeActeurJson = new ArrayList<>();
    public static List<Film> ListFilmJson = new ArrayList<>();

    public static void TraductionJson() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        File filmsJsonfile = new File("src/main/resources/films.json");
        List<Film_dto> filmsExtreJson = objectMapper.readValue(filmsJsonfile, new TypeReference<List<Film_dto>>() {}); // Récupération des données du json

//        List<Pays> ListPaysJson = new ArrayList<>();                        // création d'une liste pour stocker tous les pays renseignée dans le json
        for (Film_dto filmDto : filmsExtreJson) {                           // boucle pour récupérer tous les paysDTO du json
            Pays_dto paysDTOExtreJson = filmDto.pays();                     // création d'un paysDTO temporaire pour stocker l'info
            if (paysDTOExtreJson != null) {                                 // vérification si présence de paysDTO
                Pays paysExtreJson = new Pays();                            // création d'un pays pour ajouter des valeurs
                paysExtreJson.setNom(paysDTOExtreJson.nom());               // insertion de la valeur dans le pays
                paysExtreJson.setUrl(paysDTOExtreJson.url());

                boolean paysExiste = false;                                 // code pour verification si présence dans la liste des pays total
                for (Pays pays : ListPaysJson) {
                    if (pays.getNom() != null && pays.getNom().equals(paysExtreJson.getNom())) {
                        paysExiste = true;
                        break;
                    }
                }

                if (!paysExiste) {                                          // s'il n'existe PAS dans la liste
                    ListPaysJson.add(paysExtreJson);                        // ajout dans la liste total si le pays n'y est pas
                }
            }
        }

//        List<Genre> ListGenreJson = new ArrayList<>();                      // creation d'une liste pour stocker tous les genres renseignée dans le json
        for (Film_dto filmDto : filmsExtreJson) {                           // boucle pour récupérer tous genres dans les FilmDTO du json // Obtenir la liste des genres pour chaque film

            String[] genresFilm = filmDto.genres();                         // création d'une liste pour stocker les genres du film sélectionné

            for (String nomGenre : genresFilm) {                            // boucle pour récupérer 1 genre par 1 genre
                Genre genreExtreJson = new Genre(nomGenre);                 // Crée un nouvel objet Genre avec le nom du genre

                boolean genreExiste = false;
                int k = 0;
                while (k < ListGenreJson.size()) {                          // code pour vérification si présence dans la liste des genres total
                    Genre genre = ListGenreJson.get(k);

                    if (genre.getNom() != null && genre.getNom().equals(nomGenre)) {
                        genreExiste = true;
                        break;
                    }
                    k++;
                }

                if (!genreExiste) {
                    ListGenreJson.add(genreExtreJson);
                }
            }
        }

    // ** Extraction des lieux **
//        List<Lieu> ListLieuxJson = new ArrayList<>();
        for (Film_dto filmDto : filmsExtreJson) {
            Lieu_dto lieuDto = filmDto.lieuTournage();
            if (lieuDto != null) {
                Lieu lieu = new Lieu();
                lieu.setVille(lieuDto.ville());
                lieu.setEtatDept(lieuDto.etatDept());
                // Associer le pays si défini
                if (lieuDto.pays() != null) {
                    Pays pays = ListPaysJson.stream()
                            .filter(p -> p.getNom().equals(lieuDto.pays()))
                            .findFirst()
                            .orElse(null);
                    // Créer le pays s'il n'existe pas
                    if (pays == null) {
                        pays = new Pays();
                        pays.setNom(lieuDto.pays());
                        ListPaysJson.add(pays);
                    }
                    lieu.setPays(pays);
                }
                // Éviter les doublons pour les lieux
                boolean lieuExiste = ListLieuxJson.stream()
                        .anyMatch(l -> l.getVille().equals(lieu.getVille()) && l.getEtatDept().equals(lieu.getEtatDept()));

                if (!lieuExiste) {
                    ListLieuxJson.add(lieu);
                }
            }
        }

//        List<Realisateur> ListeRealisteurJson = new ArrayList<>();          // creation d'une liste pour stocker tous les réalisateurs renseignée dans le json
        for(Film_dto filmDto : filmsExtreJson){                             // boucle pour récupérer tous les réalisateurs dans FilmDTO du json

            Realisateur_dto[] RealisateurFilm = filmDto.realisateurs();     // création d'une liste pour stocker les réalisateurs du film sélectionné

            for (Realisateur_dto realisateurDto : RealisateurFilm) {        // boucle pour récupérer 1 par 1 les réalisateurs
                Realisateur RealisateurExtreJson = new Realisateur();       // creation d'un objet réalisateur
                RealisateurExtreJson.setUrl(realisateurDto.url());          // ajout des différents paramètres
                RealisateurExtreJson.setIdentite(realisateurDto.identite());
                boolean realisateurExiste = false;
                for (Realisateur realisateur : ListeRealisteurJson) {       // vérification de la présence des réalisateurs dans la liste totaux
                    if (realisateur.getIdentite().equals(realisateurDto.identite())) {
                        realisateurExiste = true;
                        break;
                    }
                }
                if (!realisateurExiste) {
                    ListeRealisteurJson.add(RealisateurExtreJson);          // ajout s'il n'est pas déjà présent dans la liste
                }
            }
        }

//        List<Acteur> ListeActeurJson = new ArrayList<>();                   // creation d'une liste pour stocker tous les acteurs renseignée dans le json
        for (Film_dto filmDto : filmsExtreJson){                            // boucle pour récupérer tous les acteurs dans FilmDTO du json
            Acteur_dto[] CastingFilm = filmDto.castingPrincipal();          // création d'une liste pour stoker tous les acteurs du film sélectionné par le casting

            if (CastingFilm != null) {                                      // vérifie si le casting est vide
                for (Acteur_dto acteurDto : CastingFilm) {                  // on parcourt le casting pour trouver des acteurs
                    Acteur ActeurExtreJson = new Acteur();                  // ajout d'un nouvel acteur
                    ActeurExtreJson.setId(acteurDto.id());
                    ActeurExtreJson.setUrl(acteurDto.url());                // ajout des différents paramètres
                    if(acteurDto.height() == null){                         // vérifie si une taille est rentré
                        ActeurExtreJson.setTaille(0);                       // met à 0 si ce n'est pas le cas
                    }else{
                        ActeurExtreJson.setTaille(Double.parseDouble(acteurDto.height()));
                    }
                    ActeurExtreJson.setIdentite(acteurDto.identite());
                    ActeurExtreJson.setDateNaissance(acteurDto.naissance().dateNaissance());

                    if (acteurDto.naissance().dateNaissance() != null) {    // vérifie si une date de naissance est rentré
                        ActeurExtreJson.setDateNaissance(null);
                    }else{
                        ActeurExtreJson.setDateNaissance(acteurDto.naissance().dateNaissance());
                    }

                    if(acteurDto.naissance() == null){
                        ActeurExtreJson.setLieuNaissance(null);
                        ActeurExtreJson.setDateNaissance(null);
                    }

                    String[] partiesAdresse = acteurDto.naissance().lieuNaissance().split(", "); // on découle le lieu de naissance dans un tableau

                    // défini à un null pour éviter les erreurs
                    String pays = null;
                    String etatDept = null;
                    String ville = null;

                    if(partiesAdresse.length == 2){ // passage dans tous les cas de figure pour éviter les erreurs
                        pays = partiesAdresse[1].toString();
                        etatDept = partiesAdresse[0].toString();

                    }else if(partiesAdresse.length == 3){
                        pays = partiesAdresse[2].toString();
                        etatDept = partiesAdresse[1].toString();
                        ville = partiesAdresse[0].toString();

                    }else if(partiesAdresse.length > 3){
                        pays = partiesAdresse[partiesAdresse.length-1].toString();
                        etatDept = partiesAdresse[partiesAdresse.length-2].toString();
                        ville = String.join(", ", Arrays.copyOfRange(partiesAdresse, 0, partiesAdresse.length - 2));

                    }

                    Lieu lieuNaissanceActeur = new Lieu(ville,etatDept);        // créer le pays de l'acteur
                    int indexLieu = ListLieuxJson.indexOf(lieuNaissanceActeur); // on obtient son index dans la liste total des lieux

                    if(indexLieu == -1){                                        // si -1 alors, il n'existe pas
                        ListLieuxJson.add(lieuNaissanceActeur);                 // on le rajoute dans la liste totale des lieux
                        ActeurExtreJson.setLieuNaissance(lieuNaissanceActeur);  // on le définit à l'acteur
                    }else{                                                      // s'il existe déjà
                        Lieu lieuExistant = ListLieuxJson.get(indexLieu);       // on le récupère dans la liste des totaux
                        ActeurExtreJson.setLieuNaissance(lieuExistant);         // on le définit à l'acteur
                    }

                    Pays paysActuel = new Pays(pays,null);                  // Créons un nouvel objet Pays avec le nom spécifié
                    int indexPays = ListPaysJson.indexOf(paysActuel);           // on obtient son index dans la liste total des pays

                    if (indexPays == -1) {                                      // si -1 alors, il n'existe pas
                        ListPaysJson.add(paysActuel);                           // Si le pays n'existe pas dans la liste, on l'ajoute
                    }else{                                                      // s'il existe déjà
                        Pays paysExistant = ListPaysJson.get(indexPays);        // on le récupère dans la liste des totaux
                        lieuNaissanceActeur.setPays(paysExistant);              // on le définit à l'acteur
                    }


                    boolean acteurExiste = false;
                    for (Acteur acteur : ListeActeurJson) {                     // vérifie si l'acteur n'est pas déjà rentré dans la liste
                        if (acteur.getIdentite().equals(acteurDto.identite())) {
                            acteurExiste = true;
                            break;
                        }
                    }
                    if (!acteurExiste) {
                        ListeActeurJson.add(ActeurExtreJson);                   // l'ajout à la liste et l'ajout aussi a la liste des acteurs qui sont née au même endroit que lui
                        lieuNaissanceActeur.getActeurs().add(ActeurExtreJson);
                    }
                }


            }

            Role_dto[] RolesFilm = filmDto.roles();                         // la même chose que pour acteur dans le casting principal, mais pour role
            if (RolesFilm != null) {
                for (Role_dto roleDto : RolesFilm) {
                    Acteur ActeurExtreJson = new Acteur();
                    ActeurExtreJson.setUrl(roleDto.acteur().url());
                    ActeurExtreJson.setId(roleDto.acteur().id());

                    if(roleDto.acteur().height() == null){
                        ActeurExtreJson.setTaille(0);
                    }else{
                        ActeurExtreJson.setTaille(Double.parseDouble(roleDto.acteur().height()));
                    }
                    ActeurExtreJson.setIdentite(roleDto.acteur().identite());
                    Lieu lieuNaissanceActeur = null;
                    if(roleDto.acteur().naissance() != null){

                        String[] partiesAdresse = roleDto.acteur().naissance().lieuNaissance().split(", "); // on découle le lieu de naissance dans un tableau

                        // défini à un null pour éviter les erreurs
                        String pays = null;
                        String etatDept = null;
                        String ville = null;

                        if(partiesAdresse.length == 2){ // passage dans tous les cas de figure pour éviter les erreurs
                            pays = partiesAdresse[1].toString();
                            etatDept = partiesAdresse[0].toString();

                        }else if(partiesAdresse.length == 3){
                            pays = partiesAdresse[2].toString();
                            etatDept = partiesAdresse[1].toString();
                            ville = partiesAdresse[0].toString();

                        }else if(partiesAdresse.length > 3){
                            pays = partiesAdresse[partiesAdresse.length-1].toString();
                            etatDept = partiesAdresse[partiesAdresse.length-2].toString();
                            ville = String.join(", ", Arrays.copyOfRange(partiesAdresse, 0, partiesAdresse.length - 2));

                        }

                        lieuNaissanceActeur = new Lieu(ville,etatDept);        // créer le pays de l'acteur
                        int indexLieu = ListLieuxJson.indexOf(lieuNaissanceActeur); // on obtient son index dans la liste total des lieux

                        if(indexLieu == -1){                                        // si -1 alors, il n'existe pas
                            ListLieuxJson.add(lieuNaissanceActeur);                 // on le rajoute dans la liste totale des lieux
                            ActeurExtreJson.setLieuNaissance(lieuNaissanceActeur);  // on le définit à l'acteur
                        }else{                                                      // s'il existe déjà
                            Lieu lieuExistant = ListLieuxJson.get(indexLieu);       // on le récupère dans la liste des totaux
                            ActeurExtreJson.setLieuNaissance(lieuExistant);         // on le définit à l'acteur
                        }

                        Pays paysActuel = new Pays(pays,null);                  // Créons un nouvel objet Pays avec le nom spécifié
                        int indexPays = ListPaysJson.indexOf(paysActuel);           // on obtient son index dans la liste total des pays

                        if (indexPays == -1) {                                      // si -1 alors, il n'existe pas
                            ListPaysJson.add(paysActuel);                           // Si le pays n'existe pas dans la liste, on l'ajoute
                        }else{                                                      // s'il existe déjà
                            Pays paysExistant = ListPaysJson.get(indexPays);        // on le récupère dans la liste des totaux
                            lieuNaissanceActeur.setPays(paysExistant);              // on le définit à l'acteur
                        }
                    }
                    else { // si l'acteur n'a pas de date et lieu de naissance
                        ActeurExtreJson.setDateNaissance(null);
                        ActeurExtreJson.setLieuNaissance(null);
                    }


                    boolean acteurExiste = false;
                    for (Acteur acteur : ListeActeurJson){
                        if (acteur.getId().equals(roleDto.acteur().id())){
                            acteurExiste = true;
//                            System.out.println("pas d'ajout de l'acteur : " + ActeurExtreJson.getId() +" Car déjà présent");
                            break;
                        }
                    }

                    if(!acteurExiste){
                        ListeActeurJson.add(ActeurExtreJson);
                        if(ActeurExtreJson.getLieuNaissance() != null){
                            lieuNaissanceActeur.getActeurs().add(ActeurExtreJson);
                        }
                    }


                }
            }
        }

        // Extraction des rôles
        List<Roles> ListRolesJson = new ArrayList<>(); // Liste pour stocker les rôles
        for (Film_dto filmDto : filmsExtreJson) {
            Role_dto[] rolesFilm = filmDto.roles(); // Récupère les rôles associés à un film
            if (rolesFilm != null) {
                for (Role_dto roleDto : rolesFilm) {
                    // Récupération ou création de l'acteur pour ce rôle
                    Acteur acteurAssocie = null;
                    for (Acteur acteur : ListeActeurJson) {
                        if (acteur.getId().equals(roleDto.acteur().id())) {
                            acteurAssocie = acteur;
                            break;
                        }
                    }

                    // Si l'acteur n'existe pas déjà, il est créé
                    if (acteurAssocie == null) {
                        acteurAssocie = new Acteur();
                        acteurAssocie.setId(roleDto.acteur().id());
                        acteurAssocie.setIdentite(roleDto.acteur().identite());
                        acteurAssocie.setUrl(roleDto.acteur().url());
                        if (roleDto.acteur().height() != null) {
                            acteurAssocie.setTaille(Double.parseDouble(roleDto.acteur().height()));
                        }
                        acteurAssocie.setDateNaissance(roleDto.acteur().naissance() != null
                                ? roleDto.acteur().naissance().dateNaissance()
                                : null);

                        // Gestion du lieu de naissance
                        if (roleDto.acteur().naissance() != null && roleDto.acteur().naissance().lieuNaissance() != null) {
                            String adresse = roleDto.acteur().naissance().lieuNaissance();
                            String[] partiesAdresse = adresse.split(", ");

                            String pays = null, etatDept = null, ville = null;

                            if (partiesAdresse.length == 2) {
                                pays = partiesAdresse[1];
                                etatDept = partiesAdresse[0];
                            } else if (partiesAdresse.length == 3) {
                                pays = partiesAdresse[2];
                                etatDept = partiesAdresse[1];
                                ville = partiesAdresse[0];
                            } else if (partiesAdresse.length > 3) {
                                pays = partiesAdresse[partiesAdresse.length - 1];
                                etatDept = partiesAdresse[partiesAdresse.length - 2];
                                ville = String.join(", ", Arrays.copyOfRange(partiesAdresse, 0, partiesAdresse.length - 2));
                            }

                            Lieu lieuNaissance = new Lieu(ville, etatDept);
                            int indexLieu = ListLieuxJson.indexOf(lieuNaissance);
                            if (indexLieu == -1) {
                                ListLieuxJson.add(lieuNaissance);
                                acteurAssocie.setLieuNaissance(lieuNaissance);
                            } else {
                                acteurAssocie.setLieuNaissance(ListLieuxJson.get(indexLieu));
                            }

                            // Gestion du pays
                            Pays paysAssocie = new Pays(pays, null);
                            int indexPays = ListPaysJson.indexOf(paysAssocie);
                            if (indexPays == -1) {
                                ListPaysJson.add(paysAssocie);
                                lieuNaissance.setPays(paysAssocie);
                            } else {
                                lieuNaissance.setPays(ListPaysJson.get(indexPays));
                            }
                        }

                        ListeActeurJson.add(acteurAssocie);
                    }

                    // Création d'un rôle
                    Roles role = new Roles();
                    role.setCharacterName(roleDto.characterName());

                    // Gestion du film
                    Film filmAssocie = new Film();
                    filmAssocie.setId(filmDto.id());
                    filmAssocie.setNom(filmDto.nom());

                    // Vérification des doublons avant ajout
                    boolean roleExiste = ListRolesJson.stream()
                            .anyMatch(r -> r.getCharacterName() != null
                                    && r.getCharacterName().equals(role.getCharacterName())
                                    && r.getActeur() != null
                                    && r.getActeur().getId().equals(role.getActeur().getId())
                                    && r.getFilm() != null
                                    && r.getFilm().getId().equals(role.getFilm().getId()));
                    if (!roleExiste) {
                        ListRolesJson.add(role);
                    }
                }
            }
        }

//        List<Film> ListFilmJson = new ArrayList<>();                        // création de la liste de films totaux
        for(Film_dto filmDto : filmsExtreJson){                             // boucle pour ajouter tous les films

            Film FilmExtrejson = new Film();                                // création d'un film temporaire
            // ajout des paramètres "simple"
            FilmExtrejson.setId(filmDto.id());
            FilmExtrejson.setNom(filmDto.nom());
            FilmExtrejson.setUrl(filmDto.url());
            FilmExtrejson.setPlot(filmDto.plot());
            FilmExtrejson.setLangue(filmDto.langue());
            FilmExtrejson.setAnneeSortie(filmDto.anneeSortie());


            if(filmDto.pays() != null){                               // vérification si il y a un pays d'origine
                Pays paysOrigine = new Pays(filmDto.pays().nom(), filmDto.pays().url());    // création d'un pays

                Pays pays = ListPaysJson.stream()                           // scan dans la liste total des pays s'il existe bien
                        .filter(p -> p.getNom().equals(filmDto.pays().nom()))
                        .findFirst()
                        .orElse(null);

                if (pays == null) {                                         // Créer le pays s'il n'existe pas
                    pays = new Pays();
                    pays.setNom(filmDto.pays().nom());
                    pays.setUrl(filmDto.pays().url());
                    ListPaysJson.add(pays);
                }

                FilmExtrejson.setPays(paysOrigine);                         // ajouter le pays à l'objet film
                int IndexPays = ListPaysJson.indexOf(pays);                 // récupération de l'index du pays
                ListPaysJson.get(IndexPays).getFilms().add(FilmExtrejson);  // ajout du film a la liste des films du pays
            }           // gestion du pays pour le film
            else{
                FilmExtrejson.setPays(null);                                // set à null si le pays n'a pas d'origine
            }


            if(filmDto.lieuTournage() != null){                             // vérifie si le pays a un lieu de tournage
                Lieu LieuTournage = new Lieu();                             // création du lieu
                // ajout des paramètres du lieu
                LieuTournage.setVille(filmDto.lieuTournage().ville());
                LieuTournage.setEtatDept(filmDto.lieuTournage().etatDept());


                Pays paysTournage = new Pays(filmDto.lieuTournage().pays(),null);   // création du pays lié au lieu de tournage

                Pays pays = ListPaysJson.stream()                       // scan de la liste des pays pour vérifié si il existe
                        .filter(p -> p.getNom().equals(paysTournage.getNom()))
                        .findFirst()
                        .orElse(null);

                if(pays == null){                                   // s'il n'existe pas ont l'ajout à la liste
                    pays = new Pays();
                    pays.setNom(filmDto.lieuTournage().pays());
                    pays.setUrl(null);
                    ListPaysJson.add(pays);
                }

                FilmExtrejson.setLieuTournage(LieuTournage);       // ajout du lieu au film
                pays.getFilms().add(FilmExtrejson);                // ajout du film au lieu
            }       // gestion du lieu de tournage pour le film
            else {
                FilmExtrejson.setLieuTournage(null);
            }

            if(filmDto.realisateurs() != null){
                Realisateur_dto[] realisateurDtos = filmDto.realisateurs(); // créer un réalisateur temporaire
                for (Realisateur_dto realisateurDto : realisateurDtos){     // boucle sur la totalité des réalisateurs du film

                    Realisateur realisateur = new Realisateur(realisateurDto.url(),realisateurDto.identite());    // créer un nouveau réalisateur pour la chercher son index

                    Realisateur realisateurExistant = ListeRealisteurJson.stream()
                            .filter(r -> r.getIdentite().equals(realisateurDto.identite()))
                            .findFirst()
                            .orElse(null);

                    // Ajouter le réalisateur au film s'il n'est pas déjà présent
                    FilmExtrejson.getRealisateurs().add(realisateurExistant);

                    // Ajouter le film au set de films du réalisateur existant
                    // on ajoute le film au Set<Film> du réalisateur
                    realisateurExistant.getFilms().add(FilmExtrejson);
                }
            }       // gestion des réalisateurs
            else {
                FilmExtrejson.setRealisateurs(null);
            }




            if(filmDto.castingPrincipal() != null){                                                 // on vérifie si c'est null
                for (Acteur_dto acteurDto : filmDto.castingPrincipal()){                            // on boucle pour tous les acteurs qui ont passé le casting

                    CastingPrincipale castingPrincipale = new CastingPrincipale();                  // on crée un casting a chaque fois
                    Acteur acteurExistant = ListeActeurJson.stream()                                // on cherche l'acteur dans la liste de tous les acteurs
                            .filter(a -> a.getId().equals(acteurDto.id()))
                            .findFirst()
                            .orElse(null);                                                    // L'acteur existe donc on suppose que findFirst() renverra toujours un résultat

                    castingPrincipale.setFilm(FilmExtrejson);                                       // on ajoute le film au casting
                    castingPrincipale.setActeur(acteurExistant);                                    // on ajoute l'acteur au casting

                    FilmExtrejson.getCastingPrincipal().add(castingPrincipale);
                }
            }   // gestion des casting
            else{
                FilmExtrejson.setCastingPrincipal(null);
            }


            if(filmDto.roles() != null){                                                            // on vérifie si c'est null
                for (Role_dto roleDto : filmDto.roles()){                                           // on boucle pour faire tous les roles dans le film
                    Roles roleFilm = new Roles();                                                   // création du roles
                    roleFilm.setCharacterName(roleDto.characterName());                             // ajout du nom du personnage
                    roleFilm.setFilm(FilmExtrejson);                                                // liaison du film au role

                    Acteur acteurExistant = ListeActeurJson.stream()                                // on cherche l'acteur dans la liste de tous les acteurs
                            .filter(a -> a.getId().equals(roleDto.acteur().id()))
                            .findFirst()
                            .orElse(null);                                                    // L'acteur existe donc on suppose que findFirst() renverra toujours un résultat

                    roleFilm.setActeur(acteurExistant);                                             // on ajoute l'acteur au film
                    acteurExistant.getRoles().add(roleFilm);                                        // on ajoute le film à l'acteur
                    FilmExtrejson.getRoles().add(roleFilm);

                }
            }               // gestion des roles
            else{
                FilmExtrejson.setRoles(null);
            }


            if(filmDto.genres() != null){
                for (String genre : filmDto.genres()){                                  // on boucle pour faire tous les genres de disponibles
                    Genre newGenre = new Genre(genre);                                  // création du genre
                    int indexGenre = ListGenreJson.indexOf(newGenre);                   // on récupère son index dans la liste de tous les genres
                    ListGenreJson.get(indexGenre).getFilms().add(FilmExtrejson);        // on ajoute le film au genre
                    FilmExtrejson.getGenres().add(ListGenreJson.get(indexGenre));       // on ajoute le genre au film
                    FilmExtrejson.getGenres().add(ListGenreJson.get(indexGenre));
                }
            }               // gestion des genres
            else {
                FilmExtrejson.setGenres(null);
            }

            ListFilmJson.add(FilmExtrejson);

        }



//        System.out.println(Arrays.toString(ListPaysJson.toArray()));      // affichage de tous les pays
//        System.out.println(Arrays.toString(ListGenreJson.toArray()));     // affichage de tous les genres

        System.out.println("Fin de la traduction du JSON");



    }
}
