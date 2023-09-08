import java.io.*;

/**
 * 
 */
public class HashTable<K, V> {

    private int hashSize;
    private int size;
    private Entry[] table;
    private Boolean isDeleted;

    public HashTable(int initialMemorySize, int initialHashSize) {

        int memSize = initialMemorySize;
        hashSize = initialHashSize;
        size = 0;

        table = new Entry[hashSize];

    }

    public int getHashSize() {
        return hashSize;
    }

    public int firstHashValue(int key) {

        int M = hashSize + 1;
        return key % M;
    }

    public int secondHashValue(int key) {

        int M = hashSize + 1;
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
                
                if (j < hashSize) {
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
            System.out.print("I doubled the table");
        }

        int hashing1 = firstHashValue(key);
        int hashing2 = secondHashValue(key);
        int i = 0;

        while (table[hashing1] != null && i < hashSize) {

            if (table[hashing1].key == key) {
                // table[hashing1].value = value;
                System.out.print("\nInsert FAILED - There is already a record with ID " + key + "");
                return;

            }

            hashing1 = (hashing1 + hashing2) % table.length;
            i++;
        }

        table[hashing1] = new Entry(key, value);
        size++;
        System.out.println("Successfully inserted record with ID " + key + "");
        System.out.println(table[hashing1].value.toString());
        
        byte[] x = table[hashing1].value.serialize();
        System.out.println("Size: " + x.length + "");
    

        // TEMP FIX SOON
        // System.out.println("Memory pool expanded to bytes");
        // System.out.println("Hash Table Expanded to records");

    }

    
     public void printTable() {
      
     // System.out.println("\nHash Table");
     
     for (int i = 0; i < size; i++) { if (table[i] != null) {
         System.out.println(table[i].key + " " + table[i].value.toString()); } }
      
     }
     

    public void delete(int key) {
        // System.out.println("HAHAHA");
        int index = findIndex(key);
        // System.out.println(table[index].key + "" +
        // table[index].value.toString());

        if (index == -1) {

            System.out.print("\nDelete FAILED -- There is no record with ID " + key);

        } else if (table[index].key == key && table[index] != null) {

            table[index] = null;

            size--;
            System.out.print("\nRecord with ID " + key + " succesfully deleted from the database");

        }

    }

    public void search(int key) {

        int index = findIndex(key);

        if (index == -1) {
            System.out.print("\nSearch FAILED -- There is no record with ID " + key);

        } else if (table[index].key == key && table[index] != null) {
            System.out.println("Found record with ID " + table[index].key + ":");
            System.out.print(table[index].value.toString());

        }
    }

    public Seminar searchAndReturn(int key) {

        int index = findIndex(key);
        if (index == -1) {
            return null;
        }
        // else if (table[index].value != null) {
        else {
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
            System.out.print("\nHashtable:");
            for (int x = 0; x < hashSize; x++) {
                if (table[x] != null) {
                    // change to use id not hash value
                    // System.out.print("\n" + table[x].key + ": " + x + "");
                    System.out.print("\n" + x + ": " + table[x].key + "");

                }
            }
            System.out.print("\ntotal records: " + size);
        }

        if (printmythingy.equalsIgnoreCase("blocks")) {
            System.out.print("\nFreeBlockList:");

        }

    }
}
