package gestionefile;

import java.util.*;
import java.nio.file.*;


/**
 *
 * @author tommasowww
 * @version 31/01/24
 */
public class GestioneFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //1) LETTURA
        Lettore lettore = new Lettore("user.json");
        lettore.start();

        //2) ELABORAZIONE
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci il nome utente: ");
        String nomeUtente = scanner.nextLine();
        
        System.out.println("Inserisci la password: ");
        String password = scanner.nextLine();

        scanner.close();

        //3) SCRITTURA
        Scrittore scrittore = new Scrittore("output.csv", nomeUtente + "; " + password);
        Thread threadScrittore = new Thread(scrittore);
        threadScrittore.start();

        //4) COPIA
        String inputFile = "output.csv";
        String outputFile = "copia.csv";

        try {
            // copia il contenuto da file a file
            Files.copy(Paths.get(inputFile), Paths.get(outputFile), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copiato con successo");
        } catch (Exception e) {
            System.err.println("Errore durante la copia del file: " + e.getMessage());
        }

    }
    
}