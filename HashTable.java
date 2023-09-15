import java.io.*;

/**
 * @author Pallavi Chavan pallucha21 and Evan Howe evanhowe03
 * @param <K> this is the key
 * @param <V> this is the value
 * @version 09/14/23
 */
public class HashTable<K, V> {
    private int hashSize; // hash
    private int size; // size
    private Entry[] table; // tab;e

    /**
     * HashTable constructor
     * 
     * @param initialHashSize this is the size of the hash table
     */
    public HashTable(int initialHashSize) {

        hashSize = initialHashSize;
        size = 0;

        table = new Entry[hashSize];

    }

    /**
     * return the size of the hash table
     */
    public int getHashSize() {
        return hashSize;
    }

    /**
     * calculate the first hashing value
     * 
     * @param key this is the key
     */
    public int firstHashValue(int key) {
        // the hashSize
        int m = hashSize;
        return key % m;
    }

    /**
     * calculate the second hashing value
     * 
     * @param key this is the key
     */
    public int secondHashValue(int key) {
        // the hashSize
        int m = hashSize;
        // System.out.print((((key/M) % (M/2)) * 2) + 1);
        return (((key / m) % (m / 2)) * 2) + 1;
    }

    /**
     * this doubles the hashtable by creating an empt y hashtable that's double the
     * initial size and rehashing all of the old val ues of the old table into the
     * new one
     */
    private void doubleTable() {
        // the size of the hashTable now
        int oldSize = hashSize;
        // a copy of the table now
        Entry[] oldTable = table;

        hashSize = hashSize * 2;
        // the now hashtable
        // has double the capacity
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

    /**
     * 
     * @param key   this represents the key value
     * @param value this the seminar
     * @param hand  this is the associated handle that you'll u se in the memManager
     * @return a boolean that represents if the inse rtion was succesful
     * @throws Exception
     */
    public boolean insert(int key, Seminar value, Handle hand) throws Exception {

        // doubles the table if the table is more than %50 full
        if (size >= (hashSize / 2)) {
            doubleTable();
            System.out.println("Hash Table expanded to " + hashSize + " records");
        }

        // creating hashing values based on key
        int hashing1 = firstHashValue(key);
        int hashing2 = secondHashValue(key);
        int i = 0;

        // go through the hash table
        while (table[hashing1] != null && i < hashSize) {
            // if there is a tombstone overwrite it
            if (table[hashing1].value == null && table[hashing1].tomb == true) {

                if (table[hashing1].tomb) {
                    table[hashing1].key = key;
                    table[hashing1].value = value;
                    table[hashing1].tomb = false;
                    break;

                }
            } // if there is a record there report a collision
            else if (table[hashing1].key == key) {
                System.out.println("Insert FAILED - There" + " is already a record with ID " + key + "");
                return false;
            }
            hashing1 = (hashing1 + hashing2) % table.length;
            i++;
        }
        // assign the spot in the hashtable to the new entry
        table[hashing1] = new Entry(key, value, false, hand);

        size++;

        System.out.println("Successfully inserted record with ID " + key + "");
        System.out.println(table[hashing1].value.toString());

        // find the serialized byte[x] of seminar
        byte[] x = table[hashing1].value.serialize();

        // print the size of seminar
        System.out.println("Size: " + x.length + "");
        return true;

        // TEMP FIX SOON
        // System.out.println("Memory pool expanded to bytes");
        // System.out.println("Hash Table Expanded to records");

    }

    /**
     * Deletes a seminar from the hashtable
     * 
     * @param key this the key value
     * @return whether the deletion was successful or not
     */
    public boolean delete(int key) {
        // retreive the hashtable index
        int index = findIndex(key);

        // if the record doesn't exist
        if (index == -1) {

            System.out.println("Delete FAILED -- " + "There is no reco" + "rd with ID " + key);
            return false;

        } // if there is a record with that key
        else if (table[index].key == key) {

            table[index].tomb = true;
            size--;
            System.out.println("Record with ID " + key + " successfu" + "lly deleted from the database");
            table[index].value = null;

        }
        return true;

    }

    /**
     * searches for the seminar by it's key
     * 
     * @param key this is the key you're searching for
     */
    public boolean search(int key) {

        int index = findIndex(key);

        if (index == -1 || table[index].tomb) {
            System.out.println("Search FAILED -- There is no re" + "co" + "rd with ID " + key);
            return false;

        } else if (table[index].key == key && table[index] != null) {
            if (table[index].value != null) {
                System.out.println("Found record with ID " + table[index].key + ":");
                System.out.println(table[index].value.toString());
            } else {
                System.out.println("Search FAILED --" + " There" + " is no record with ID " + key);
                return true;

            }

        }
        return true;
    }

    public boolean searchTest(int key) {

        int index = findIndex(key);

        if (index == -1 || table[index].tomb) {
          //  System.out.println("Search FAILED -- There is no re" + "co" + "rd with ID " + key);
            return false;

        } else if (table[index].key == key && table[index] != null) {
            if (table[index].value != null) {
               // System.out.println("Found record with ID " + table[index].key + ":");
              //  System.out.println(table[index].value.toString());
            } else {
                //System.out.println("Search FAILED --" + " There" + " is no record with ID " + key);
                return true;

            }

        }
        return true;
    }
    /**
     * Returns the seminar by it's key
     * 
     * @param key this the key you're looking for
     * @return the Seminar associate with the key
     */
    public Seminar searchAndReturn(int key) {

        int index = findIndex(key);
        if (index == -1) {
            return null;
        } else {
            return (table[index].value);
        }

    }

    /**
     * 
     * @param key
     * @return the handle for the seminar
     */
    public Handle returnHandle(int key) {
        // retrieve the hashing index
        int index = findIndex(key);
        if (index == -1) {
            return null;
        } else {
            return (table[index].hand);
        }
    }

    /**
     * Find the hashing index for the key
     * 
     * @param key this
     * @return the hashing index
     */
    public int findIndex(int key) {
        // first hashing value
        int hashing1 = firstHashValue(key);
        // second hashing value
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

    /**
     * 
     * @param printmythingy take in the string "hashtable" or "blocks"
     * @return whether it was requested to print blocks or hashtable
     */
    public boolean print(String printmythingy) {
        if (printmythingy.equalsIgnoreCase("hashtable")) {
            System.out.println("Hashtable:");
            for (int x = 0; x < hashSize; x++) {
                if (table[x] != null) {

                    if (table[x].tomb) {
                        System.out.println("" + x + ": " + "TOMBSTONE");
                    } else {

                        System.out.println("" + x + ": " + table[x].key + "");

                    }

                }
            }

            System.out.println("total records: " + size);
        }

        if (printmythingy.equalsIgnoreCase("blocks")) {
            System.out.println("FreeBlockList:");
            return true;
        }

        return false;

    }
}
