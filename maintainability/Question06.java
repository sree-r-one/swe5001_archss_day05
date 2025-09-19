// 6.	In Java, show another way to catch multiple exception?

/*
ANSWER: Java provides several ways to catch multiple exceptions more efficiently.

CURRENT APPROACH PROBLEMS:
1. Repetitive catch blocks with empty bodies
2. Code duplication if handling logic is similar
3. More verbose and harder to maintain
4. No proper error handling or logging

ALTERNATIVE APPROACHES:

// Option 1: Multi-catch (Java 7+) - RECOMMENDED for similar handling
public void processFileImproved() {
    try {
        readFile();
        executeQuery();
    } catch (FileNotFoundException | IOException | SQLException e) {
        // Handle all exceptions the same way
        System.err.println("Operation failed: " + e.getMessage());
        logError(e);
    }
}

// Option 2: Multi-catch with different handling
public void processFileWithDifferentHandling() {
    try {
        readFile();
        executeQuery();
    } catch (FileNotFoundException | IOException e) {
        // Handle file-related exceptions
        System.err.println("File operation failed: " + e.getMessage());
        handleFileError(e);
    } catch (SQLException e) {
        // Handle database exceptions differently
        System.err.println("Database operation failed: " + e.getMessage());
        handleDatabaseError(e);
    }
}

// Option 3: Catch superclass exception
public void processFileWithSuperclass() {
    try {
        readFile();
        executeQuery();
    } catch (Exception e) {
        // Catches all exceptions (less specific)
        System.err.println("Operation failed: " + e.getClass().getSimpleName() + 
                          " - " + e.getMessage());
        handleGenericError(e);
    }
}

// Option 4: Try-with-resources + multi-catch
public void processFileWithResources() {
    try (FileInputStream fis = new FileInputStream("file.txt")) {
        readFile();
        executeQuery();
    } catch (FileNotFoundException | IOException | SQLException e) {
        handleError(e);
    }
}

BENEFITS OF MULTI-CATCH:
- Reduces code duplication
- Cleaner and more maintainable
- Single place to handle related exceptions
- Better error logging and handling
- Available since Java 7
*/

package maintainability;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class Question06 {

    // CURRENT APPROACH: Separate catch blocks for each exception
    // PROBLEM 1: Repetitive code structure
    // PROBLEM 2: Empty catch blocks (bad practice)
    // PROBLEM 3: No proper error handling or logging
    // ALTERNATIVE: Use multi-catch syntax (Java 7+)
    public void processFile() {
        // Process the file
        try {
            readFile();
            executeQuery();
        } catch (FileNotFoundException e) {
            // EMPTY CATCH: Bad practice - should log or handle
            // IMPROVEMENT: Add proper error handling
        } catch (IOException e) {
            // REPETITIVE: Similar handling as above
            // BETTER: catch (FileNotFoundException | IOException e)
        } catch (SQLException e) {
            // SEPARATE HANDLING: Could be combined if handling is similar
            // MULTI-CATCH OPTION: catch (IOException | SQLException e)
        }

        // IMPROVED VERSION using multi-catch:
        // catch (FileNotFoundException | IOException | SQLException e) {
        // System.err.println("Operation failed: " + e.getMessage());
        // logError(e);
        // }
    }

    private void executeQuery() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'executeQuery'");
    }

    private void readFile() throws FileNotFoundException, IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readFile'");
    }

}
