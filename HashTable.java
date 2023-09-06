import java.io.*;

/**
 * 
 */
public class HashTable<K, V> {

    private int hashSize;
    private int size;
    private Entry[] table;

    public HashTable(int initialMemorySize, int initialHashSize) {

        int memSize = initialMemorySize;
        hashSize = initialHashSize;
        size = 0;

        table = new Entry[hashSize];

    }
    
    public void getSize() {
        
    }
    
    
    public void getMem() {
        
    }


    private int firstHashValue(int key) {

        int M = hashSize + 1;
        return key % M;
    }


    private int secondHashValue(int key) {

        int M = hashSize + 1;
        // System.out.print((((key/M) % (M/2)) * 2) + 1);
        return (((key / M) % (M / 2)) * 2) + 1;
    }


    private void doubleTable() {
        
        hashSize = hashSize * 2;
        
        Entry[] newTable = new Entry[hashSize];

        // Rehash all existing entries into the new table
        for (int i = 0; i < size; i++) {
            if (table[i] != null) {
                int newIndex = firstHashValue(table[i].key); // Calculate new index
                int newStep = secondHashValue(table[i].key);   // Calculate new step

                // Find an empty slot in the new table using double hashing
                while (newTable[newIndex] != null) {
                    newIndex = (newIndex + newStep) % hashSize;
                }

                newTable[newIndex] = table[i]; // Insert the entry into the new table
            }
        }

        table = newTable; // Update the reference to the new table
    
        

    }


    public void insert(int key, Seminar value) {

        // doubles the table if the table is more than %50 full
        if (size >= (hashSize / 2)) {
            doubleTable();
            System.out.print("I doubled the table");
        }

        int hashing1 = firstHashValue(key);
        int hashing2 = secondHashValue(key);
        int i = 0;

        while (table[hashing1] != null && i < table.length) {

            hashing1 = (hashing1 + hashing2) % table.length;
            i++;
        }
        table[hashing1] = new Entry(key, value);
        size++;

    }


    public void printTable() {

        System.out.println("\nHash Table");

        for (int i = 0; i < size; i++) {
            if (table[i] != null) {
                System.out.println(table[i].key + " " + table[i].value
                    .toString());
            }
        }

    }


    public void delete(int key) {
        // System.out.println("HAHAHA");
        int index = findIndex(key);
        // System.out.println(table[index].key + "" +
        // table[index].value.toString());
        if (index != -1 && table[index] != null) {
            table[index].value = null;

            size--;

        }

    }


    public void search(int key) {

        int index = findIndex(key);

        if (table[index].value != null) {
            System.out.print(table[index].value + "HAHAHA" + table[index].value
                .toString());
            
        }

    }
    
    public Seminar searchAndReturn(int key) {

        int index = findIndex(key);

        if (table[index].value != null) {
            return (table[index].value);
        }
        
        return null;

    }


    private int findIndex(int key) {

        int hashing1 = firstHashValue(key);
        int hashing2 = secondHashValue(key);
        int i = 0;

        while (table[hashing1] != null && i < table.length) {

            if (table[hashing1].key == key) {
                return hashing1;
            }
            hashing1 = (hashing1 + hashing2) % table.length;
            i++;

        }

        return -1; // key not found

    }


    public void print(String printmythingy) {
        if (printmythingy.equalsIgnoreCase("blocks")) {
            System.out.println("Freeblock List:");
            for (int x = 0; x < hashSize; x++) {

                if (table[x] == null) {

                    // System.out.print(": " + x + " ");
                }
            }
        }

        if (printmythingy.equalsIgnoreCase("hashtable")) {
            System.out.println("Hashtable:");
            for (int x = 0; x < size; x++) {
                System.out.println("ID: " + x + " " + findIndex(x) + "");
            }

        }
        
    }

}
