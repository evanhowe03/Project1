
import java.io.*;
import java.util.*;
import java.util.Scanner;

public class CommandProcessor {

    public SemDB database;

    public CommandProcessor(String file, int initialMemorySize, int initialHashSize) throws Exception {

        int memSize = initialMemorySize;
        int hashSize = initialHashSize;

        database = new SemDB(memSize, hashSize);

        try {

            Scanner scanner = new Scanner(new File(file));

            while (scanner.hasNext()) {
                String word = scanner.next();

                if (word.equals("insert")) {
                    // System.out.println("YESY");
                    insert(scanner);
                } else if (word.equalsIgnoreCase("search")) {
                    search(scanner);
                } else if (word.equalsIgnoreCase("delete")) {
                    delete(scanner);
                } else {
                    print(scanner);
                }

            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
 

    }

    public void insert(Scanner scanner) throws Exception {

        int id = scanner.nextInt();
        scanner.nextLine();
        String title = scanner.nextLine().trim();
        String date = scanner.next();
        int length = scanner.nextInt();
        short x = scanner.nextShort();
        short y = scanner.nextShort();
        int cost = scanner.nextInt();
        scanner.nextLine();
        String line = scanner.nextLine();

        // String[] words = line.split(" ");
        String[] words = line.trim().split("\\s+");
        String des = scanner.nextLine().trim();
        // this will call the seminar to create an instance of it
        // System.out.println("INSERT ID: " + id + " TITLE: " + title + " DATE: " + date
        // + " LENGTH: " + length + " X: " + x
        // + " Y: " + y + " COST: " + cost + " LINE: " + line + " DES: " + des + "");

        // create a Seminar
        Seminar mySeminar = new Seminar(id, title, date, length, x, y, cost, words, des);

        // insert the seminar into the table
        database.add(id, mySeminar);
        //table.printTable();

    }

    public void search(Scanner scanner) {
        int key = scanner.nextInt();
        database.search(key);
    }

    public void delete(Scanner scanner) {
        int key = scanner.nextInt();
        // System.out.println("DELETE: "+delete+"");
        database.remove(key);
    }

    public void print(Scanner scanner) {
        String print = scanner.next();
        database.print(print);
        //table.printTable();
    }
       
 

}
