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
        int hashSize = initialHashSize;
        size = 0;
        
        table = new Entry[hashSize];

    }
    
    private int firstHashValue(int key) {
        
        int M = hashSize + 1;
        return key % M;
    }
    
    private int secondHashValue(int key) {
        
        int M = hashSize + 1; 
        //System.out.print((((key/M) % (M/2)) * 2) + 1);
        return (key % M) + 1;
    }
    

    public void doubleTable() {
        
    }
    
    public void insert(int key, Seminar value) {
        
        //doubles the table if the table is more than %50 full
        if (size == (hashSize/2)) {
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
 
        for (int i = 0; i < hashSize; i++) {
            if (table[i] != null) {
                System.out.println(table[i].key + " "
                                   + table[i].value);
            }
        }
        
    }
    

    public void delete() {
        
    }
    
    public void search() {
        
    }
    
    public void print() {
        
    }

}
