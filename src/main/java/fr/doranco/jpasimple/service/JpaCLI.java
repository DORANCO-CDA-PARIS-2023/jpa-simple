package fr.doranco.jpasimple.service;

import java.io.InputStream;
import java.util.Scanner;

public final class JpaCLI {

    private InputStream inputStream;


    public JpaCLI(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public int start() {
        Scanner sc = new Scanner(inputStream);

        int actionId;
        while ((actionId = getActions(sc)) != 10) {
            switch (actionId) {
                case 1 -> addBookAction(sc);
                case 2 -> displayAllBookAction(sc);
                case 3 -> findBookByTitleAction(sc);
                case 4 -> findBookByAuthorAction(sc);
                case 5 -> findBookByTypeAction(sc);
                case 6 -> findBookByYearPublishAction(sc);
                case 7 -> displayTotalPageNumberByAuthorAction(sc);
                case 8 -> updatePageNumberAction(sc);
                case 9 -> deleteBookAction(sc);
            }
        }
        return 0;
    }

    private void addBookAction(Scanner sc) {

    }

    private void displayAllBookAction(Scanner sc) {
        System.out.println("displayAllBookAction");
    }

    private void findBookByTitleAction(Scanner sc) {
        System.out.println("findBookByTitleAction");
    }

    private void findBookByAuthorAction(Scanner sc) {
        System.out.println("findBookByAuthorAction");
    }

    private void findBookByTypeAction(Scanner sc) {
        System.out.println("findBookByTypeAction");
    }

    private void findBookByYearPublishAction(Scanner sc) {
        System.out.println("findBookByYearPublishAction");
    }

    private void displayTotalPageNumberByAuthorAction(Scanner sc) {
        System.out.println("displayTotalPageNumberByAuthorAction");
    }

    private void updatePageNumberAction(Scanner sc) {
        System.out.println("updatePageNumberAction");
    }

    private void deleteBookAction(Scanner sc) {
        System.out.println("deleteBookAction");
    }

    private int getActions(Scanner sc) {
        int result = 0;

        do {
            String prompt = """
                    ========================================================================================
                    1. Ajouter un livre
                    2. Afficher tous les livres
                    3. Rechercher un livre par titre
                    4. Rechercher un livre par auteur
                    5. Rechercher un livre par genre
                    6. Rechercher un livre par année de publication
                    7. Afficher le nombre total de pages de tous les livres par auteur
                    8. Modifier le nombre de pages d'un livre
                    9. Supprimer un livre
                    10. Quitter le programme
                    ========================================================================================
                    Entrez votre choix →
                    """;
            System.out.print(prompt);
            try {
                int input = sc.nextInt();
                if (input > 0 && input < 11) {
                    result = input;
                }
            } catch (Exception ignored) {

            } finally {
                sc.nextLine();
            }
        } while (result == 0);

        return result;
    }

}
