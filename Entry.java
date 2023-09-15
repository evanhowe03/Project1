
/**
 * @author Pallavi Chavan pallucha21 and Evan Howe evanhowe03
 * @version (2023-09-14)
 * The entry class which is given to the
 *         hash table.
 */
public class Entry{
    public int key;
    public Seminar value;
    public boolean tomb;
    public Handle hand;

    /**
     * 
     * @param k is the key 
     *      for the seminar
     * @param v is the Seminar
     * @param tombStone 
     *      the boolean for
     *      whether the space
     *      is a tombstone
     * @param id
     *      the associated
     *      handle
     */
    public Entry(int k, Seminar v, Boolean tombStone, Handle id) {
        
        this.key = k;
        this.value = v;
        this.tomb = tombStone;
        this.hand = id;
    }
  
}
