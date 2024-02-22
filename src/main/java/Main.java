import java.util.Scanner;

import manager.LivreManager;

public class Main {
	 public static void main(String[] args) {
	        LivreManager livreManager = new LivreManager();
	        Scanner scanner = new Scanner(System.in);
	        
	        afficherAide();

	        while (true) {
	            System.out.print("> ");
	            String commande = scanner.nextLine();
	            String[] commandeSplit = commande.split("\\s+");

	            switch (commandeSplit[0]) {
	                case "aide":
	                    afficherAide();
	                    break;
	                case "ajouter":
	                    if (commandeSplit.length == 6) {
	                        String titre = commandeSplit[1];
	                        String auteur = commandeSplit[2];
	                        String genre = commandeSplit[3];
	                        int anneePublication = Integer.parseInt(commandeSplit[4]);
	                        int nombrePages = Integer.parseInt(commandeSplit[5]);
	                        livreManager.ajouterLivre(titre, auteur, genre, anneePublication, nombrePages);
	                    } else {
	                        System.out.println("Format de commande incorrect. Utilisation : ajouter <titre> <auteur> <genre> <anneePublication> <nombrePages>");
	                    }
	                    break;
	                case "afficher":
	                    livreManager.afficherLivres();
	                    break;
	                case "rechercherTitre":
	                    if (commandeSplit.length == 2) {
	                        livreManager.rechercherParTitre(commandeSplit[1]);
	                    } else {
	                        System.out.println("Format de commande incorrect. Utilisation : rechercherTitre <titre>");
	                    }
	                    break;
	                case "rechercherAuteur":
	                    if (commandeSplit.length == 2) {
	                        livreManager.rechercherParAuteur(commandeSplit[1]);
	                    } else {
	                        System.out.println("Format de commande incorrect. Utilisation : rechercherAuteur <auteur>");
	                    }
	                    break;
	                case "rechercherGenre":
	                    if (commandeSplit.length == 2) {
	                        livreManager.rechercherParGenre(commandeSplit[1]);
	                    } else {
	                        System.out.println("Format de commande incorrect. Utilisation : rechercherGenre <genre>");
	                    }
	                    break;
	                case "rechercherAnnee":
	                    if (commandeSplit.length == 2) {
	                        int annee = Integer.parseInt(commandeSplit[1]);
	                        livreManager.rechercherParAnnee(annee);
	                    } else {
	                        System.out.println("Format de commande incorrect. Utilisation : rechercherAnnee <annee>");
	                    }
	                    break;
	                case "totalPages":
	                    if (commandeSplit.length == 2) {
	                        livreManager.afficherTotalPagesParAuteur(commandeSplit[1]);
	                    } else {
	                        System.out.println("Format de commande incorrect. Utilisation : totalPages <auteur>");
	                    }
	                    break;
	                case "modifierPages":
	                    if (commandeSplit.length == 3) {
	                        long idLivre = Long.parseLong(commandeSplit[1]);
	                        int nouveauNombrePages = Integer.parseInt(commandeSplit[2]);
	                        livreManager.modifierNombrePages(idLivre, nouveauNombrePages);
	                    } else {
	                        System.out.println("Format de commande incorrect. Utilisation : modifierPages <idLivre> <nouveauNombrePages>");
	                    }
	                    break;
	                case "supprimer":
	                    if (commandeSplit.length == 2) {
	                        long idLivre = Long.parseLong(commandeSplit[1]);
	                        livreManager.supprimerLivre(idLivre);
	                    } else {
	                        System.out.println("Format de commande incorrect. Utilisation : supprimer <idLivre>");
	                    }
	                    break;
	                case "quitter":
	                    System.out.println("Merci d'avoir utilisé le système de gestion de bibliothèque. Au revoir !");
	                    scanner.close();
	                    System.exit(0);
	                default:
	                    System.out.println("Commande invalide. Veuillez réessayer ou entrez 'aide' pour voir les commandes disponibles.");
	                    break;
	            }
	        }
	    }

	    private static void afficherAide() {
	        System.out.println("Instructions de l'Utilisateur :");
	        System.out.println("Ajouter un Livre : ajouter <titre> <auteur> <genre> <anneePublication> <nombrePages>");
	        System.out.println("Afficher tous les Livres : afficher");
	        System.out.println("Rechercher un Livre par Titre : rechercherTitre <titre>");
	        System.out.println("Rechercher un Livre par Auteur : rechercherAuteur <auteur>");
	        System.out.println("Rechercher un Livre par Genre : rechercherGenre <genre>");
	        System.out.println("Rechercher un Livre par Année de Publication : rechercherAnnee <annee>");
	        System.out.println("Afficher le Nombre Total de Pages de Tous les Livres par autheur : totalPages <auteur>");
	        System.out.println("Modifier le Nombre de Pages d'un Livre : modifierPages <idLivre> <nouveauNombrePages>");
	        System.out.println("Supprimer un Livre : supprimer <idLivre>");
	        System.out.println("Quitter le Programme : quitter");
	    }
}