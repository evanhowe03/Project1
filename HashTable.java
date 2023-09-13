import java.io.*;

/**
 * 
 */
public class HashTable<K, V> {

	private int hashSize;
	private int size;
	private Entry[] table;

	public HashTable(int initialHashSize) {

		hashSize = initialHashSize;
		size = 0;

		table = new Entry[hashSize];

	}

	public int getHashSize() {
		return hashSize;
	}

	public int firstHashValue(int key) {

		int M = hashSize;
		return key % M;
	}

	public int secondHashValue(int key) {

		int M = hashSize;
		// System.out.print((((key/M) % (M/2)) * 2) + 1);
		return (((key / M) % (M / 2)) * 2) + 1;
	}

	private void doubleTable() {

		int oldSize = hashSize;
		Entry[] oldTable = table;

		hashSize = hashSize * 2;
		table = new Entry[hashSize];

		// Rehash all existing entries into the new table
		for (int i = 0; i < oldSize; i++) {
			if (oldTable[i] != null) {
				Entry entry = oldTable[i];
				int hash1 = firstHashValue(entry.key);
				int hash2 = secondHashValue(entry.key);

				int j = 0;
				while (table[hash1] != null && j < hashSize) {

					hash1 = (hash1 + hash2) % hashSize;
					j++;
				}

				if (j < hashSize && !oldTable[i].tomb) {
					table[hash1] = entry;
				}
			}

		}

	}

	public void insert(int key, Seminar value) throws Exception {

		// System.out.println("SIZE: "+size+" HASHZISE: "+hashSize+"");
		// doubles the table if the table is more than %50 full
		if (size >= (hashSize / 2)) {
			doubleTable();
			System.out.println("Hash Table expanded to " + hashSize + " records");
		}

		int hashing1 = firstHashValue(key);
		int hashing2 = secondHashValue(key);
		int i = 0;
		// print("hashtable");
		while (table[hashing1] != null && i < hashSize) {

			// if (table[hashing1].key == key && table[hashing1].value == null) {
			if (table[hashing1].value == null && table[hashing1].tomb == true) {
				// table[hashing1].value = value;
				if (table[hashing1].tomb) {
					table[hashing1].key = key;
					table[hashing1].value = value;
					table[hashing1].tomb = false;
					break;
				}
			} else if (table[hashing1].key == key) {
				System.out.println("Insert FAILED - There is already a record with ID " + key + "");
				return;
			}
			// table[hashing1].tomb = false;
			hashing1 = (hashing1 + hashing2) % table.length;
			i++;
		}

		// table[hashing1].key = key;
		table[hashing1] = new Entry(key, value, false);
		// table[hashing1].tomb = false;
		size++;
		System.out.println("Successfully inserted record with ID " + key + "");
		System.out.println(table[hashing1].value.toString());

		byte[] x = table[hashing1].value.serialize();
		System.out.println("Size: " + x.length + "");

		// TEMP FIX SOON
		// System.out.println("Memory pool expanded to bytes");
		// System.out.println("Hash Table Expanded to records");

	}
	/*
	 * 
	 * public void printTable() {
	 * 
	 * // System.out.println("\nHash Table");
	 * 
	 * for (int i = 0; i < size; i++) { if (table[i] != null) {
	 * System.out.println(table[i].key + " " + table[i].value.toString()); } }
	 * 
	 * }
	 */

	public void delete(int key) {
		int index = findIndex(key);
		if (index == -1) {
			System.out.println("Delete FAILED -- There is no record with ID " + key);
			return;
		} else if (table[index].key == key) {

			// table[index] = null;

			table[index].tomb = true;
			size--;
			System.out.println("Record with ID " + key + " successfully deleted from the database");
			table[index].value = null;
			// table[index].key = -1;

		}

	}

	public void search(int key) {

		int index = findIndex(key);

		if (index == -1 || table[index].tomb) {
			System.out.println("Search FAILED -- There is no record with ID " + key);

		} else if (table[index].key == key && table[index] != null) {
			if (table[index].value != null) {
				System.out.println("Found record with ID " + table[index].key + ":");
				System.out.println(table[index].value.toString());
			} else {
				System.out.println("Search FAILED -- There is no record with ID " + key);

			}

		}
	}

	public Seminar searchAndReturn(int key) {

		int index = findIndex(key);
		if (index == -1) {
			return null;
		} else {
			return (table[index].value);
		}

	}

	public int findIndex(int key) {

		int hashing1 = firstHashValue(key);
		int hashing2 = secondHashValue(key);
		int i = 0;

		while (table[hashing1] != null && i < hashSize) {

			if (table[hashing1].key == key) {
				return hashing1;
			}
			hashing1 = (hashing1 + hashing2) % table.length;
			i++;

		}

		return -1; // key not found

	}

	public void print(String printmythingy) {

		if (printmythingy.equalsIgnoreCase("hashtable")) {
			System.out.println("Hashtable:");
			for (int x = 0; x < hashSize; x++) {

				if (table[x] != null) {
					// System.out.println("X: " + x + " TOMB VALUE " + table[x].tomb + "");
					// change to use id not hash value
					// System.out.print("\n" + table[x].key + ": " + x + "");
					// System.out.println(table[x].tomb);
					if (table[x].tomb) {
						System.out.println("" + x + ": " + "TOMBSTONE");
					} // else if (table[x].value != null) {
						// else if (isSomethingEvenInThisIndexLmao(x)) {
					else {

						System.out.println("" + x + ": " + table[x].key + "");
					}

				}
			}
			System.out.println("total records: " + size);
		}

		if (printmythingy.equalsIgnoreCase("blocks")) {
			System.out.println("FreeBlockList:");

		}

	}

	/*
	 * public boolean isSomethingEvenInThisIndexLmao(int index) { if
	 * (table[index].value != null) { if (!table[index].tomb) { return true; } }
	 * return false; }
	 */
}
