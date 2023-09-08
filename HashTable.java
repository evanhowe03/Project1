
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import org.junit.Test;

import student.TestCase;

/**
 * @author {Your Name Here}
 * @version {Put Something Here}
 */
public class SemManagerTest extends TestCase {
	/**
	 * Sets up the tests that follow. In general, used for initialization
	 */
	public void setUp() {
		// Nothing here
	}

	/**
	 * Get code coverage of the class declaration.
	 */
	public void testMInitx() {
		SemManager sem = new SemManager();
		// SemManager nullSem = null;
		// assertNull(nullSem);
		assertNotNull(sem);
		// SemManager.main(null);
	}

	@Test
	public void testScanner() {
		String testInput = "word1 word2 word3";
		Scanner scanner = new Scanner(testInput);

		assertTrue(scanner.hasNext());
		assertEquals("word1", scanner.next());
		assertTrue(scanner.hasNext());
		assertEquals("word2", scanner.next());
		assertTrue(scanner.hasNext());
		assertEquals("word3", scanner.next());

		assertFalse(scanner.hasNext());

	}

	public void testWords() {
		String test = "insert search delete print";

		Scanner scanner = new Scanner(test);

		assertTrue(scanner.hasNext());
		assertEquals("insert", scanner.next());
		assertEquals("search", scanner.next());
		assertEquals("delete", scanner.next());
		assertEquals("print", scanner.next());

	}

	public void testMain() throws NumberFormatException, Exception {

		SemManager sem = new SemManager();
		String[] args = new String[3];
		args[0] = "512";
		args[1] = "4";
		args[2] = "P1Sample_input.txt";
		// SemManager sem = new SemManager();
		SemManager.main(args);
		String output = systemOut().getHistory();
		String referenceOutput = readFile("P1Sample_output.txt");
		// assertFuzzyEquals(referenceOutput, output);
		assertFuzzyEquals(referenceOutput, output);

		assertNotNull(sem);
	}

	public String readFile(String name) {
		String fileFish = "";
		try {

			Scanner scan = new Scanner(new File(name));

			while (scan.hasNextLine()) {
				fileFish += scan.nextLine() + "\n";
			}
			scan.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		return fileFish;
	}
}
