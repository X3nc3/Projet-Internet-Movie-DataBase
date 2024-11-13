
# Internet Movie Database

Ce projet est un système de gestion de films basé sur Java, développé avec l'API de persistance JPA (Java Persistence API) et Hibernate comme fournisseur de persistance. Il permet de gérer des films, des acteurs, des réalisateurs, des genres, et d'autres entités connexes, avec des fonctionnalités avancées de recherche. Le projet utilise MariaDB comme base de données et offre une conversion des données en JSON.

**Lien du dépôt GitHub** : [Projet-Internet-Movie-DataBase](https://github.com/X3nc3/Projet-Internet-Movie-DataBase)

## Table des Matières

1. [Fonctionnalités](#fonctionnalités)
2. [Technologies Utilisées](#technologies-utilisées)
3. [Installation](#installation)
4. [Configuration](#configuration)
5. [Utilisation](#utilisation)
6. [Tests](#tests)
7. [Structure du Projet](#structure-du-projet)
8. [Auteurs](#auteurs)

---

## Fonctionnalités

- **Gestion des entités principales** : Acteurs, Films, Réalisateurs, Genres, Pays, Lieux, et Rôles.
- **Recherches avancées** :
  - Films par acteur.
  - Acteurs par film.
  - Films par année.
  - Castings principaux pour un film.
- **Exportation des données au format JSON** grâce à un traducteur intégré.
- **Tests unitaires** pour garantir la fiabilité du code.

---

## Technologies Utilisées

- **Java 22.0.2**
- **Jakarta Persistence API (JPA)** avec **Hibernate** comme fournisseur
- **Base de données** : MariaDB
- **Tests Unitaires** : JUnit
- **JSON** : Manipulation et sérialisation des données

---

## Installation

1. **Cloner le projet** :
   ```bash
   git clone https://github.com/X3nc3/Projet-Internet-Movie-DataBase.git
   cd Projet-Internet-Movie-DataBase
   ```

2. **Configurer la base de données MariaDB** :
   - Créez une base de données nommée `FilmBDD`.
   - Assurez-vous que votre serveur MariaDB fonctionne sur `localhost:3307` avec l'utilisateur `root` et le mot de passe `` (modifiable dans le fichier `persistence.xml`).

3. **Compiler et exécuter le projet** :
   - Importez le projet dans un IDE (IntelliJ IDEA ou Eclipse).
   - Configurez un SDK Java 22.0.2.
   - Exécutez la classe principale `Main.java`.

---

## Configuration

Le fichier principal de configuration est **`persistence.xml`** (situé dans `META-INF`). Voici un exemple de configuration :

```xml
<property name="jakarta.persistence.jdbc.url" value="jdbc:mariadb://localhost:3307/FilmBDD"/>
<property name="jakarta.persistence.jdbc.user" value="root"/>
<property name="jakarta.persistence.jdbc.password" value=""/>
<property name="hibernate.hbm2ddl.auto" value="update"/>
<property name="hibernate.show_sql" value="true"/>
<property name="hibernate.format_sql" value="true"/>
```

---

## Utilisation

- Lancez le projet via la classe principale `Main.java`.
- Explorez les fonctionnalités principales :
  - Création, mise à jour et suppression des entités.
  - Recherche avancée grâce à des classes telles que :
    - `RechercheActeurFilms`
    - `RechercheFilmActeur`
    - `RechercheFilmAnnees`

---

## Tests

Des tests unitaires sont disponibles pour valider les fonctionnalités principales, notamment :

- **`ActeurTest.java`** : Vérifie les opérations liées aux acteurs.
- **`FilmTest.java`** : Vérifie les opérations liées aux films.

Pour exécuter les tests, utilisez un IDE avec JUnit intégré.

---

## Structure du Projet

```
src/
├── main/
│   ├── java/
│   │   ├── bo/                      # Entités principales (Film, Acteur, etc.)
│   │   ├── dal/                     # Logique métier
│   │   ├── dto/                     # Objets de transfert de données
│   │   ├── Utils/                   # Outils (JSON, utilitaires divers)
│   │   └── Main.java                # Point d'entrée
│   └── resources/
│       └── META-INF/persistence.xml # Configuration JPA
│       └── films.json               # Data File
├── test/
│   ├── ActeurTest.java              # Tests unitaires pour Acteur
│   ├── FilmTest.java                # Tests unitaires pour Film
└── README.md
```

---

## Auteurs

**Projet développé par Groupe 2** :
- **Ogier Maxence**
- **Rhanbouri Omar**
- **MALEK Hassen**
- **Tunez Geoffroy**

Pour toute question, merci de contacter l’un des auteurs ou de soumettre une issue sur le [dépôt GitHub](https://github.com/X3nc3/Projet-Internet-Movie-DataBase).

---
