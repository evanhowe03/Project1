import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.junit.Test;

/**
 * @author Pallavi Chavan pallucha21 and
 * @author Evan Howe evanhowe03
 *         The hashtable test class
 *         tests the hashtable's method
 * @version 09/14/23
 */
public class HashTableTest extends student.TestCase {

    private HashTable table;
    private HashTable dou;
    private Seminar mySeminar;
    private Seminar empty;
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor =
        new ByteArrayOutputStream();

    /**
     * the setUp method
     * creates a seminar
     * an different kinds of hashTables
     */
    public void setUp() {

        System.setOut(new PrintStream(outputStreamCaptor));

        String title = "fish"; // Seminar title
        String date = "0610071600"; // Seminar date
        int length = 30; // Seminar length
        String[] keywords = { "fish", "hampster", "wheel" }; // Seminar keywords
        short x = 60; // Seminar x coord
        short y = 20; // Seminar y coord
        String desc =
            "Introduction to   bioinformatics and computation biology"; // Seminar
                                                                        // description
        int cost = 300; // Seminar cost
        int id = 1; // Seminar ID
        mySeminar = new Seminar(id, title, date, length, x, y, cost, keywords,
            desc);
        empty = new Seminar();
        table = new HashTable(50);
        dou = new HashTable(1);

        // id = table.findIndex(1);
    }


    /**
     * test the getter for hash
     * size
     */
    public void testHashSize() {
        assertEquals(50, table.getHashSize());
    }


    // tests the insert function
    @Test
    public void testInsert() throws Exception {

        table.insert(3, mySeminar, null);
        assertNotNull(table.searchAndReturn(3));
        assertEquals(mySeminar, table.searchAndReturn(3));

        table.insert(3, mySeminar, null);
        String printedText = outputStreamCaptor.toString().trim();
        assertEquals("Successfully inserted record with ID 3\n"
            + "ID: 1, Title: fish\n"
            + "Date: 0610071600, Length: 30, X: 60, Y: 20, Cost: 300\n"
            + "Description: Introduction to   bioinformatics and computation biology\n"
            + "Keywords: fish, hampster, wheel\n" + "Size: 125\n"
            + "Insert FAILED - There is already a record with ID 3",
            printedText);

    }


    /**
     * tests the findIndex method
     * 
     * @throws Exception
     */
    public void testFindIndex() throws Exception {
        table.insert(3, mySeminar, null);
        assertEquals(3, table.findIndex(3));

        assertEquals(-1, table.findIndex(10000));

    }


    /**
     * tests the firsHashValue method
     */
    public void testFirstHashValue() {

        assertEquals(table.firstHashValue(0), 0);
        assertEquals(table.firstHashValue(-1), -1);
        assertEquals(table.firstHashValue(59), 9);
        assertEquals(table.firstHashValue(5), 5);
    }


    /**
     * tests the secondHashValue method
     */
    public void testSecondHashValue() {
        assertEquals(1, table.secondHashValue(-5));
        assertEquals(1, table.secondHashValue(5));
        assertEquals(1, table.secondHashValue(0));
        assertEquals(41, table.secondHashValue(1000));
    }


    /**
     * tests the delete method
     * 
     * @throws Exception
     */
    public void testDelete() throws Exception {

        table.insert(3, mySeminar, null);
        assertNotNull(table.searchAndReturn(3));

        table.delete(3);
        assertNull(table.searchAndReturn(3));

    }


    /**
     * another way to test the
     * delete method
     */
    public void testDelete2() {
        table.delete(0);
        String printedText = outputStreamCaptor.toString().trim();
        assertEquals("Delete FAILED -- There is no record with ID 0",
            printedText);
    }


    /**
     * tests the method that
     * returns a seminar
     * given its key
     * 
     * @throws Exception
     */
    public void testSearchAndReturn() throws Exception {
        table.insert(4, mySeminar, null);
        assertEquals(mySeminar, table.searchAndReturn(4));

        assertNull(table.searchAndReturn(7));
        assertNull(table.searchAndReturn(10000));
        // assertNull(table.searchAndReturn(-100));
    }


    /**
     * tests the search method
     * 
     * @throws Exception
     */
    public void testSearch() throws Exception {
        table.insert(4, mySeminar, null);

        table.search(4);
        String printedText = outputStreamCaptor.toString().trim();
        assertEquals("Successfully inserted record with ID 4\n"
            + "ID: 1, Title: fish\n"
            + "Date: 0610071600, Length: 30, X: 60, Y: 20, Cost: 300\n"
            + "Description: Introduction to   bioinformatics and computation biology\n"
            + "Keywords: fish, hampster, wheel\n" + "Size: 125\n"
            + "Found record with ID 4:\n" + "ID: 1, Title: fish\n"
            + "Date: 0610071600, Length: 30, X: 60, Y: 20, Cost: 300\n"
            + "Description: Introduction to   bioinformatics and computation biology\n"
            + "Keywords: fish, hampster, wheel", printedText);

    }


    /**
     * tests the doublTable
     * method
     * 
     * @throws Exception
     */
    public void testDoubleTable() throws Exception {

        assertEquals(50, table.getHashSize());
        for (int x = 0; x < 30; x++) {

            table.insert(x, mySeminar, null);
        }
        assertEquals(100, table.getHashSize());
        assertEquals(1, dou.getHashSize());

    }

    /*
     * public void testPrintTable() {
     * 
     * table.printTable(); String printedText =
     * outputStreamCaptor.toString().trim(); assertEquals("", printedText);
     * 
     * table.insert(4, mySeminar); String text =
     * outputStreamCaptor.toString().trim();
     * assertEquals("Successfully inserted record with ID 4\n" +
     * mySeminar.toString() + "\nSize:", text);
     * 
     * String yolo = outputStreamCaptor.toString().trim();
     * assertEquals("Successfully inserted record with ID 4\n" +
     * mySeminar.toString() + "\nSize:", yolo); }
     */


    /**
     * tests print method
     * for the string "Hashtable"
     */
    public void testPrintHashtable() {

        table.print("hashtable");

        String printedText = outputStreamCaptor.toString().trim();
        assertEquals("Hashtable:\n" + "total records: 0", printedText);

    }


    /**
     * tests the print method
     * for the string "blocks"
     */
    public void testPrintBlocks() {

        table.print("blocks");

        String printedText = outputStreamCaptor.toString().trim();
        assertEquals("FreeBlockList:", printedText);

    }


    /**
     * tests the insert method
     * 
     * @throws Exception
     */
    public void testInsert2() throws Exception {
        table.insert(1, mySeminar, null);

        table.insert(1, empty, null);
        String printedText = outputStreamCaptor.toString().trim();
        assertEquals("Successfully inserted record with ID 1\n"
            + "ID: 1, Title: fish\n"
            + "Date: 0610071600, Length: 30, X: 60, Y: 20, Cost: 300\n"
            + "Description: Introduction to   bioinformatics and computation biology\n"
            + "Keywords: fish, hampster, wheel\n" + "Size: 125\n"
            + "Insert FAILED - There is already a record with ID 1",
            printedText);

    }


    /**
     * tests the serach method
     */
    public void testSarch2() {
        table.search(2);
        String printedText = outputStreamCaptor.toString().trim();
        assertEquals("Search FAILED -- There is no record with ID 2",
            printedText);
        assertEquals(50, table.getHashSize());
    }


    /**
     * tests the print method
     * in a different way
     * 
     * @throws Exception
     */
    public void testPrint2() throws Exception {
        table.insert(1, mySeminar, null);
        table.print("hashtable");
        String printedText = outputStreamCaptor.toString().trim();
        assertEquals("Successfully inserted record with ID 1\n"
            + "ID: 1, Title: fish\n"
            + "Date: 0610071600, Length: 30, X: 60, Y: 20, Cost: 300\n"
            + "Description: Introduction to   bioinformatics and computation biology\n"
            + "Keywords: fish, hampster, wheel\n" + "Size: 125\n"
            + "Hashtable:\n" + "1: 1\n" + "total records: 1", printedText);

    }


    /**
     * tests the entire hashtable
     * 
     * @throws NumberFormatException
     * @throws Exception
     */
    public void testHash() throws NumberFormatException, Exception {
        SemManager sem = new SemManager();
        String[] args = new String[3];
        args[0] = "512";
        args[1] = "4";
        args[2] = "test.txt";
        SemManager.main(args);

        String printedText = outputStreamCaptor.toString();
        // String output = systemOut().getHistory();
        String referenceOutput = readFile("outputtest.txt");

        assertEquals(printedText, referenceOutput);
    }


    /**
     * tests the entire hashtable
     * 
     * @throws NumberFormatException
     * @throws Exception
     */
    public void testHash2() throws NumberFormatException, Exception {
        SemManager sem = new SemManager();
        String[] args = new String[3];
        args[0] = "512";
        args[1] = "4";
        args[2] = "P1Sample_input.txt";
        SemManager.main(args);

        String printedText = outputStreamCaptor.toString();
        // String output = systemOut().getHistory();
        String referenceOutput = readFile("P1Sample_output.txt");

        assertEquals(referenceOutput, referenceOutput);

    }


    /**
     * tests the entire hashtable
     * 
     * @throws NumberFormatException
     * @throws Exception
     */
    public void testHash3() throws NumberFormatException, Exception {
        SemManager sem = new SemManager();
        String[] args = new String[3];
        args[0] = "516";
        args[1] = "1";
        args[2] = "empty.txt";
        SemManager.main(args);

        String printedText = outputStreamCaptor.toString();
        String referenceOutput = readFile("d.txt");
        assertFuzzyEquals(printedText, referenceOutput);

    }


    /**
     * tests the entire hashtable
     * 
     * @throws NumberFormatException
     * @throws Exception
     */
    public void testSearch4() throws NumberFormatException, Exception {
        SemManager sem = new SemManager();
        String[] args = new String[3];
        args[0] = "256";
        args[1] = "2";
        args[2] = "double.txt";
        SemManager.main(args);

        String printedText = outputStreamCaptor.toString();
        String referenceOutput = readFile("doubleoutput.txt");
        assertFuzzyEquals(referenceOutput, printedText);
    }


    /**
     * tests the entire hashtable
     * 
     * @param name
     * @return
     */
    public String readFile(String name) {
        String fileFish = "";
        try {

            Scanner scan = new Scanner(new File(name));

            while (scan.hasNextLine()) {
                fileFish += scan.nextLine() + "\n";
            }
            scan.close();
        }
        catch (FileNotFoundException e) {

            e.printStackTrace();
        }

        return fileFish;
    }

}
