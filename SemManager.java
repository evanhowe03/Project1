
/**
 * {Project Description Here}
 */

/**
 * The class containing the main method.
 *
 * @author {Your Name Here}
 * @version {Put Something Here}
 */

// On my honor:
// - I have not used source code obtained from another current or
//   former student, or any other unauthorized source, either
//   modified or unmodified.
//
// - All source code and documentation used in my program is
//   either my original work, or was derived by me from the
//   source code published in the textbook for this course.
//
// - I have not discussed coding details about this project with
//   anyone other than my partner (in the case of a joint
//   submission), instructor, ACM/UPE tutors or the TAs assigned
//   to this course. I understand that I may discuss the concepts
//   of this program with other students, and that another student
//   may help me debug my program so long as neither of us writes
//   anything during the discussion or modifies any computer file
//   during the discussion. I have violated neither the spirit nor
//   letter of this restriction.

/**
Project Schedule:
    1. Main/Parser first
    2. World Databse class next
    3. Hash table, implented with direct access to strings in memory (hidden behind record interface)
    4. Memory manager last

**/

//commandProcessor class will read the file
//should have a scanner and parser and should read the text file
//insert, delete, search, print -> hashtable, print -> block



/**
Main (program parameters, initialization) ==>
    Parser (Syntatic processing of commands) ==>
        "Database" or "World" (semantic processing of commands) ==>
            Various data structures classes
            
seminarDB -> Hashtable, seminarDB -> Memory Manager

Double Hashing

semManager mem_size hash_size  file1.txt
insert command: id, title, date, length, x, y, cost, kewyword, description
delete command
search command
print command: hashtable, blocks

milestone 1 -> submit starter 8/30
milestone 2 -> command processor + hashtable 9/6
    insert and print, search and delete 
milestone 3 -> hastable + basic memory manager 9/9


**/

public class SemManager {
    
    public SemManager() {
        //intentionally empty
    }
    /**
     * @param args
     *     Command line parameters
     */
    public static void main(String[] args) {
        // This is the main file for the program.
        
        if (args.length == 3) {
            Seminar dum = new Seminar();
            
            CommandProcessor processor = new CommandProcessor(args[2], Integer.parseInt(args[0]), Integer.parseInt(args[1]));

        }
        else {

            CommandProcessor hello = new CommandProcessor("P1Sample_input.txt", 50, 50);
        } 
        
    }
}
