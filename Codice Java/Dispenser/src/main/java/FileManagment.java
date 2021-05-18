
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mattia Luca
 */
public class FileManagment {

    /*Mattia:*/
    private String FilePath;

    public void setPath(String s) {
        FilePath = s;
    }

    public String getFilePath() {
        return FilePath;
    }

    public void WriteToFile(String Info) throws IOException {
        Path p = Paths.get(FilePath);
        Files.write(p, Info.getBytes(), StandardOpenOption.APPEND);
    }

    public Prodotto FromCSS(String s) {
        Prodotto p = new Prodotto();
        String[] spl = s.split(";");
        p.setNomeProdotto(spl[0]);
        p.setPrezzo(spl[1]);
        p.setImmProdotto(spl[2]);
        if ("true".equals(spl[3])) {
            p.setMaggiorenne(true);
        } else {
            p.setMaggiorenne(false);
        }
        p.setScorte(Integer.valueOf(spl[4]));
        return p;
    }

    public ArrayList ReadFile() throws FileNotFoundException {
        ArrayList<Prodotto> array = new ArrayList<Prodotto>();
        Scanner scanner = new Scanner(new File(FilePath));
        while (scanner.hasNextLine()) {
            array.add(FromCSS(scanner.nextLine()));
        }
        scanner.close();
        return array;
    }

    public String toCSS(Prodotto p) {
        if ("Sigarette.txt".equals(FilePath)) {
            return p.getNomeProdotto() + ";" + p.getPrezzo() + ";" + p.getImmProdotto() + ";" + p.isMaggiorenne() + ";" + p.getScorte() + "\n";
        } else if ("Bibite.txt".equals(FilePath)) {
            return p.getNomeProdotto() + ";" + p.getPrezzo() + ";" + p.getImmProdotto() + ";" + p.isMaggiorenne() + ";" + p.getScorte() + "\n";
        } else {
            return p.getNomeProdotto() + ";" + p.getPrezzo() + ";" + p.getImmProdotto() + ";" + p.isMaggiorenne() + ";" + p.getScorte() + "\n";
        }
    }

    /*Luca:*/
    public void stockUpdate(String order) throws FileNotFoundException, IOException {
        String save = FilePath;
        FilePath = "Sigarette.txt";
        ArrayList<Prodotto> siga = ReadFile();
        FilePath = "Bibite.txt";
        ArrayList<Prodotto> bibite = ReadFile();
        FilePath = "Snack.txt";
        ArrayList<Prodotto> snack = ReadFile();
        boolean trovato = false;
        String file = "";
        int pos = 0;
        for (int i = 0; i < siga.size(); i++) {
            if (siga.get(i).getNomeProdotto() == order) {
                file = "Sigarette.txt";
                trovato = true;
                pos = i;
                break;
            }
        }
        if (!trovato) {
            for (int i = 0; i < bibite.size(); i++) {
                if (bibite.get(i).getNomeProdotto() == order) {
                    file = "Bibite.txt";
                    trovato = true;
                    pos = i;
                    break;
                }
            }
        }
        if (!trovato) {
            for (int i = 0; i < snack.size(); i++) {
                if (snack.get(i).getNomeProdotto() == order) {
                    file = "Snack.txt";
                    trovato = true;
                    pos = i;
                    break;
                }
            }
        }
        ArrayList<Prodotto> array;
        if (file == "Sigarette.txt") {
            array = siga;
        } else if (file == "Bibite.txt") {
            array = bibite;
        } else {
            array = snack;
        }
        if (array.get(pos).getScorte() >= 2) {
            array.get(pos).setScorte(array.get(pos).getScorte() - 1);
            String contenuto = "";
            FilePath = file;
            for (int i = 0; i < array.size(); i++) {
                contenuto += toCSS(array.get(i));
            }
            WriteToFile(contenuto);
        } else {
            File inputFile = new File(file);
            File tempFile = new File("myTempFile.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String lineToRemove = toCSS(array.get(pos));
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                // trim newline when comparing with lineToRemove
                String trimmedLine = currentLine.trim();
                if (trimmedLine.equals(lineToRemove)) {
                    continue;
                }
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();
            boolean successful = tempFile.renameTo(inputFile);
        }
        FilePath = save;
    }
}