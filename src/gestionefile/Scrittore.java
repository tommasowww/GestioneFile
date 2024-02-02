package gestionefile;

import java.io.*;
import java.util.logging.*;

/**
 *
 * @author tommasowww
 * @version 31/01/24
 */

public class Scrittore implements Runnable{

    String nomeFile;
    String messaggio;
    
    public Scrittore(String nomeFile, String messaggio){
        this.nomeFile = nomeFile;
        this.messaggio = messaggio;
    }
    
    @Override
    public void run() {
        scrivi();
    }
    /**
     * Scrive un file di testo usando la classe BufferedWriter
     */
    public void scrivi() {
        try (BufferedWriter br = new BufferedWriter(new FileWriter(nomeFile))) {
            // scrivo nel buffer
            br.write(messaggio);
            br.write("\n\r");
            // svuota il buffer e salva i dati
            br.flush();
        } catch (IOException ex) {
            Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
