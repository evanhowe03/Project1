/**
 * 
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 */
public class CommandProcessor {
    
    private BufferedReader processor;
    public CommandProcessor(String file) {
    
        try {
            processor = new BufferedReader(new FileReader(file));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Initialize other data structures as needed
    }
    public void processCommands() {
        
        String line;
        try {
            while ((line = processor.readLine()) != null) {

                processCommand(line);
            }
            
            processor.close();
            
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Other methods will be added here
        private void processCommand(String command) {
            String[] parts = command.split(" ");
            String action = parts[0];
            
            //check for logical errors such as illegal duplicate insertions or deletions of records with non-existent keys
            switch (action) {
                case "insert":
                    // Parse parameters and call insert method
                    //split the lines below the insert command by new line and put them into a list "lines"
                    String[] lines = command.split("\n");
                    String title = lines[1].trim();
                    //split the long string 
                    String [] longOne = lines[2].split(" ");
                    int length = Integer.parseInt(longOne[1].trim());
                    short x = Short.parseShort(longOne[2].trim());
                    short y = Short.parseShort(longOne[3].trim());
                    int cost = Integer.parseInt(longOne[4].trim());
                    
                    String [] keywordLine = lines[3].split(" ");
                    for (int i = 0; i < keywordLine.length; i++) {
                        keywordLine[i] = keywordLine[i].trim();
                    }

                    String description = lines[4].trim();
                    
                    break;
                case "delete":
                    // Parse parameters and call delete method
                    break;
                case "search":
                    // Parse parameters and call search method
                    break;
                    // Add cases for other commands
                default:
                    // Handle unknown commands
                    break;
            }
        }

}
