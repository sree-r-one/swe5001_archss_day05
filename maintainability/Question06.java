// 6.	In Java, show another way to catch multiple exception?
package maintainability;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class Question06 {
    
    public void processFile() {
        // Process the file
        try {
            readFile();
            executeQuery();
        } catch (FileNotFoundException e) {
        
        } catch (IOException e) {
        
        } catch (SQLException e) {
        
        }
    }

    private void executeQuery() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'executeQuery'");
    }

    private void readFile() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readFile'");
    }
    

}
