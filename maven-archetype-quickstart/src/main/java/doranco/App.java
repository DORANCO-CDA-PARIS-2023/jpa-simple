package doranco;

import java.util.List;
import java.util.Scanner;

import doranco.Entity.Chambre;
import doranco.Entity.Client;
import doranco.Entity.Hotel;
import doranco.Entity.Service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        try (EntityManagerFactory ef = Persistence.createEntityManagerFactory("CoursJpa")) {
            EntityManager em = ef.createEntityManager();
            Scanner scanner = new Scanner(System.in);

            while (true) {
                // ascii généré par ça: https://ascii-generator.site/t/ "Hotel Doranco"
                System.out.println(" _   _         _           _   \n" +
                        "( ) ( )       ( )_        (_ ) \n" +
                        "| |_| |   _   | ,_)   __   | | \n" +
                        "|  _  | /'_`\\ | |   /'__`\\ | | \n" +
                        "| | | |( (_) )| |_ (  ___/ | | \n" +
                        "(_) (_)`\\___/'`\\__)`\\____)(___)\n" +
                        "                               \n" +
                        "                               \n" +
                        " ___                                            \n" +
                        "(  _`\\                                          \n" +
                        "| | ) |   _    _ __    _ _   ___     ___    _   \n" +
                        "| | | ) /'_`\\ ( '__) /'_` )/' _ `\\ /'___) /'_`\\ \n" +
                        "| |_) |( (_) )| |   ( (_| || ( ) |( (___ ( (_) )\n" +
                        "(____/'`\\___/'(_)   `\\__,_)(_) (_)`\\____)`\\___/'\n" +
                        "                                                \n" +
                        "                                                ");
                System.out.println("_____________________________________________");
                System.out.println("Bienvenue dans le système de gestion d'hotel de Doranco");
                System.out.println("1. Créer un hôtel");
                System.out.println("2. Modifier un hôtel");
                System.out.println("3. Ajouter une chambre");
                System.out.println("4. Modifier une chambre");
                System.out.println("5. Modifier les services de l'hôtel");
                System.out.println("6. Afficher les détails pour chaque catégories");
                System.out.println("7. Quitter");
                System.out.println("_____________________________________________");
                System.out.print("Entrez le numéro de l'option choisie : ");

                String choix = scanner.nextLine();
                Hotel hotel = em.find(Hotel.class, 1L);

                switch (choix) {
                    case "1":
                        if (hotel != null) {
                            System.out.println("Un hôtel est déjà enregistré.");
                        } else {
                            creerHotel(scanner, em);
                        }
                        break;
                    case "2":
                        if (hotel == null) {
                            System.out.println("Aucun hôtel enregistré.");
                        } else {
                            modifierHotel(scanner, em, hotel);
                        }
                        break;
                    case "3":
                        if (hotel == null) {
                            System.out.println("Aucun hôtel enregistré.");
                        } else {
                            ajouterChambre(scanner, em, hotel);
                        }
                        break;
                    case "4":
                        if (hotel == null) {
                            System.out.println("Aucun hôtel enregistré.");
                        } else {
                            System.out.print("Entrez l'ID de la chambre à modifier: ");
                            Long chambreId = Long.parseLong(scanner.nextLine());
                            Chambre chambre = em.find(Chambre.class, chambreId);
                            if (chambre != null) {
                                modifierChambre(scanner, em, chambre);
                            } else {
                                System.out.println("Chambre non trouvée.");
                            }
                        }
                        break;
                    case "5":
                        if (hotel == null) {
                            System.out.println("Aucun hôtel enregistré.");
                        } else {
                            modifierServices(scanner, em, hotel);
                        }
                        break;
                    case "6": // rajout du sous menu pour afficher les données de chaque tables
                        afficherDetails(scanner, em);
                        break;
                    case "7":
                        System.out.println("A bientot !");
                        return;

                    default:
                        System.out.println("Option non reconnue, réessayez.");
                        break;
                }
            }
        }
    }

    // CREATION PART OF THE HOTEL ////////////////////////////////////
    private static void creerHotel(Scanner scanner, EntityManager em) {
        System.out.println("Création d'un nouvel hôtel.");
        System.out.print("Entrez le nom de l'hôtel: ");
        String nom = scanner.nextLine();

        System.out.print("Entrez l'adresse de l'hôtel: ");
        String adresse = scanner.nextLine();

        System.out.print("Entrez le nombre de chambres de l'hôtel: ");
        int nombreDeChambres = Integer.parseInt(scanner.nextLine());

        Hotel hotel = new Hotel();
        hotel.setNom(nom);
        hotel.setAdresse(adresse);
        hotel.setNombreDeChambres(nombreDeChambres);

        em.getTransaction().begin();
        em.persist(hotel);
        em.getTransaction().commit();

        System.out.println("Nouvel hotel : " + nom + " créé avec succès !");
    }

    private static void modifierHotel(Scanner scanner, EntityManager em, Hotel hotel) {
        System.out.println("Modification de l'hôtel existant:");

        System.out.print("Entrez le nouveau nom de l'hôtel (laissez vide pour ne pas changer): ");
        String nom = scanner.nextLine();
        if (!nom.isEmpty()) {
            hotel.setNom(nom);
        }

        System.out.print("Entrez la nouvelle adresse de l'hôtel (laissez vide pour ne pas changer): ");
        String adresse = scanner.nextLine();
        if (!adresse.isEmpty()) {
            hotel.setAdresse(adresse);
        }

        System.out.print("Entrez le nouveau nombre de chambres de lhôtel (laissez vide pour ne pas changer): ");
        String nombreDeChambres = scanner.nextLine();
        if (!nombreDeChambres.isEmpty()) {
            hotel.setNombreDeChambres(Integer.parseInt(nombreDeChambres));
        }

        em.getTransaction().begin();
        em.merge(hotel);
        em.getTransaction().commit();

        System.out.println("Hôtel modifié avec succès !");
    }
    // FIN HOTEL PART////////////////

    // CREATION & MODIFICATION CHAMBRE PART //////////////////////////
    private static void ajouterChambre(Scanner scanner, EntityManager em, Hotel hotel) {
        System.out.println("Ajout d'une nouvelle chambre.");

        System.out.print("Numéro de chambre: ");
        String numero = scanner.nextLine();

        System.out.print("Prix par nuit: ");
        Double prixParNuit = Double.parseDouble(scanner.nextLine());

        System.out.print("Type de chambre: ");
        String type = scanner.nextLine();

        Chambre chambre = new Chambre();
        chambre.setHotel(hotel);
        chambre.setNumero(numero);
        chambre.setPrixParNuit(prixParNuit);
        chambre.setType(type);

        em.getTransaction().begin();
        em.persist(chambre);
        em.getTransaction().commit();

        System.out.println("Chambre ajoutée avec succès.");
    }

    private static void modifierChambre(Scanner scanner, EntityManager em, Chambre chambre) {
        System.out.println("Modification de la chambre.");

        System.out.print("Nouveau numéro de chambre (laissez vide pour ne pas changer): ");
        String numero = scanner.nextLine();
        if (!numero.isEmpty()) {
            chambre.setNumero(numero);
        }

        System.out.print("Nouveau prix par nuit (laissez vide pour ne pas changer): ");
        String prixStr = scanner.nextLine();
        if (!prixStr.isEmpty()) {
            Double prixParNuit = Double.parseDouble(prixStr);
            chambre.setPrixParNuit(prixParNuit);
        }

        System.out.print("Nouveau type de chambre (laissez vide pour ne pas changer): ");
        String type = scanner.nextLine();
        if (!type.isEmpty()) {
            chambre.setType(type);
        }

        em.getTransaction().begin();
        em.merge(chambre);
        em.getTransaction().commit();

        System.out.println("Chambre modifiée avec succès.");
    }

    ///////////////// FIN CHAMBRE PART ///////////////

    // PART SUR LES SERVICES
    private static void modifierServices(Scanner scanner, EntityManager em, Hotel hotel) {
        Service service = em.createQuery("SELECT s FROM Service s WHERE s.hotel.id = :hotelId", Service.class)
                .setParameter("hotelId", hotel.getId())
                .getSingleResult();

        if (service == null) {
            service = new Service();
            service.setHotel(hotel);
        } else {
            // on affiche le bel ui
            System.out.println("État actuel des services : ");
            System.out.println("Piscine : " + service.getPiscine());
            System.out.println("Spa : " + service.getSpa());
            System.out.println("Restaurant : " + service.getRestaurant());
            System.out.println("Boisson : " + service.getBoisson());
        }

        System.out.print("Le service de piscine est-il disponible ? (oui/non) : ");
        service.setPiscine("oui".equalsIgnoreCase(scanner.nextLine()));

        System.out.print("Le service de spa est-il disponible ? (oui/non) : ");
        service.setSpa("oui".equalsIgnoreCase(scanner.nextLine()));

        System.out.print("Le service de restaurant est-il disponible ? (oui/non) : ");
        service.setRestaurant("oui".equalsIgnoreCase(scanner.nextLine()));

        System.out.print("Le service de boisson est-il disponible ? (oui/non) : ");
        service.setBoisson("oui".equalsIgnoreCase(scanner.nextLine()));

        em.getTransaction().begin();
        if (service.getId() == null) {
            em.persist(service); // Si jamais les services n'étaient pas déjà presents on fait persister
        } else {
            em.merge(service); // Sinon on update
        }
        em.getTransaction().commit();

        System.out.println("Services de l'hôtel mis à jour avec succès.");

        // on affiche le bel ui
        System.out.println("Voici le nouvel état des services : ");
        System.out.println("Piscine : " + service.getPiscine());
        System.out.println("Spa : " + service.getSpa());
        System.out.println("Restaurant : " + service.getRestaurant());
        System.out.println("Boisson : " + service.getBoisson());

    }

    private static void afficherDetails(Scanner scanner, EntityManager em) {
        while (true) {
            System.out.println("_____________________________________________");
            System.out.println("Afficher les détails");
            System.out.println("1. Détails Hôtel");
            System.out.println("2. Détails Services");
            System.out.println("3. Détails Chambres");
            System.out.println("4. Retour");
            System.out.println("_____________________________________________");
            System.out.print("Sélectionnez une option : ");

            String choix = scanner.nextLine();

            switch (choix) {
                case "1":
                    afficherDetailsHotel(em);
                    break;
                case "2":
                    afficherDetailsServices(em);
                    break;
                case "3":
                    afficherDetailsChambres(em);
                    break;
                case "4":
                    return; // Retour au menu dfe base
                default:
                    System.out.println("Option non reconnue, réessayez.");
                    break;
            }
        }
    }

    private static void afficherDetailsHotel(EntityManager em) {
        List<Hotel> hotels = em.createQuery("SELECT h FROM Hotel h", Hotel.class).getResultList(); // le SELECT * From
                                                                                                   // hotel me faisait
                                                                                                   // avoir une erreur :
                                                                                                   // https://www.baeldung.com/jpql-hql-criteria-query#1-using-jpql-queries
        for (Hotel hotel : hotels) {
            System.out.println("Nom de l'hôtel : " + hotel.getNom());
            System.out.println("Adresse : " + hotel.getAdresse());
            System.out.println("Nombre de chambres : " + hotel.getNombreDeChambres());
        }
    }

    private static void afficherDetailsServices(EntityManager em) {
        List<Service> services = em.createQuery("SELECT s FROM Service s", Service.class).getResultList();
        for (Service service : services) {
            System.out.println(
                    "ID: " + service.getId() + ", Piscine: " + service.getPiscine() + ", Spa: " + service.getSpa()
                            + ", Restaurant: " + service.getRestaurant() + ", Boisson: " + service.getBoisson());
        }
    }

    private static void afficherDetailsChambres(EntityManager em) {
        List<Chambre> chambres = em.createQuery("SELECT ch FROM Chambre ch", Chambre.class).getResultList();
        for (Chambre chambre : chambres) {
            System.out.println("ID: " + chambre.getId() + ", Numéro: " + chambre.getNumero() + ", Prix par Nuit: "
                    + chambre.getPrixParNuit() + ", Type: " + chambre.getType());
        }
    }

}
