
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CommandSecond {

	public CommandSecond(String file) {

		try {

			Scanner scanner = new Scanner(new File(file));

			while (scanner.hasNext()) {
				String word = scanner.next();
				System.out.println(word);

				if (word.equals("insert")) {
				//	System.out.println("YESY");
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

	public void insert(Scanner scanner) {
		
		int id = scanner.nextInt();
		System.out.println(""+id+"");
		String title = scanner.nextLine();
		System.out.println(""+title+"");
		String date = scanner.next();
		int length = scanner.nextInt();
		short x = scanner.nextShort();
		short y = scanner.nextShort();
		int cost = scanner.nextInt();
		String line = scanner.nextLine();
		try {
			Scanner key = new Scanner(new File(line));
			String[] keyWord = new String[40];
			int size = 0;
			while (key.hasNext()) {
				keyWord[size] = key.next();
				size++;
			}
			key.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String des = scanner.nextLine();
		// this will call the seminar to create an instance of it
		System.out.println("ID: " + id + " TITLE: " + title + " DATE: " + date + " LENGTH: " + length + "  X: " + x
				+ " Y: " + y + " COST: " + cost + " LINE: " + line + "DES: " + des + "");
	}

	public void search(Scanner scanner) {
		int search = scanner.nextInt();
	}

	public void delete(Scanner scanner) {
		int delete = scanner.nextInt();
	}

	public void print(Scanner scanner) {
		String print = scanner.next();
	}

}
