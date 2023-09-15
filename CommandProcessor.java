
import java.io.*;
import java.util.*;
import java.util.Scanner;

/**
 * @author Pallavi Chavan pallucha21 and Evan Howe evanhowe03
 *         The command processor class parses the file
 *         and creates the database class
 * @version 09/14/23
 */
public class CommandProcessor {
    // instantiate the database
    public SemDB database;

    /**
     * 
     * @param file
     *            this is the command file
     * @param initialMemorySize
     *            passed in by the args
     * @param initialHashSize
     *            passed in by the args
     * @throws Exception
     */
    public CommandProcessor(
        String file,
        int initialMemorySize,
        int initialHashSize)
        throws Exception {
        // set memory size
        int memSize = initialMemorySize;
        // set hashtable size
        int hashSize = initialHashSize;
        // create the database and pass in the
        // sizes
        database = new SemDB(memSize, hashSize);

        try {

            Scanner scanner = new Scanner(new File(file));

            while (scanner.hasNext()) {
                String word = scanner.next();

                if (word.equals("insert")) {
                    insert(scanner);
                }
                else if (word.equalsIgnoreCase("search")) {
                    search(scanner);
                }
                else if (word.equalsIgnoreCase("delete")) {
                    delete(scanner);
                }
                else {
                    print(scanner);
                }

            }

            scanner.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


    /**
     * Creates a seminar
     * Calls the add command
     * 
     * @param scanner
     *            take the
     *            scanner object
     * @throws Exception
     */
    public void insert(Scanner scanner) throws Exception {

        // creates and sets a variable for each
        // seminar parameter
        int id = scanner.nextInt();
        scanner.nextLine();
        // trim the extra whitespace off of title
        String title = scanner.nextLine().trim();
        String date = scanner.next();
        int length = scanner.nextInt();
        short x = scanner.nextShort();
        short y = scanner.nextShort();
        int cost = scanner.nextInt();
        scanner.nextLine();
        String line = scanner.nextLine();

        // trim the whitesoace between each keyword
        String[] words = line.trim().split("\\s+");
        // trim the whitespace for the description
        String des = scanner.nextLine().trim();

        // create a Seminar
        Seminar mySeminar = new Seminar(id, title, date, length, x, y, cost,
            words, des);

        // insert the seminar into the table
        database.add(id, mySeminar);
    }


    /**
     * calls the search command
     * 
     * @param scanner
     *            takes the
     *            scanner object
     */
    public void search(Scanner scanner) {
        // seminar we're seraching for
        int key = scanner.nextInt();
        database.search(key);
    }


    /**
     * calls the remove command
     * 
     * @param scanner
     *            takes the
     *            scanner object
     */
    public void delete(Scanner scanner) {
        // seminar we're deleting
        int key = scanner.nextInt();
        database.remove(key);
    }


    /**
     * calls the print command
     * 
     * @param scanner
     *            takes the
     *            scanner object
     */
    public void print(Scanner scanner) {
        String print = scanner.next();
        database.print(print);

    }

}
