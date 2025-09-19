// 10.	Demonstrate Interface Segregation.

/*
ANSWER: This code violates the Interface Segregation Principle (ISP).

INTERFACE SEGREGATION PRINCIPLE:
"No client should be forced to depend on methods it does not use"

CURRENT PROBLEMS:
1. Monolithic interface forces all implementations to provide methods they don't need
2. PDFDocument doesn't use sendViaEmail() but must implement it
3. WordDocument doesn't use print() but must implement it
4. Adding new methods affects ALL implementing classes
5. "Fat interface" creates unnecessary dependencies

ISP VIOLATIONS:
- PDFDocument: Forced to implement sendViaEmail() (marked as "not used")
- WordDocument: Forced to implement print() (marked as "not used")

IMPROVED DESIGN following ISP:

// 1. Segregate into smaller, focused interfaces
interface Openable {
    void open();
}

interface Saveable {
    void save();
}

interface Printable {
    void print();
}

interface Emailable {
    void sendViaEmail();
}

// 2. Implement only needed interfaces
class PDFDocument implements Openable, Saveable, Printable {
    public void open() {
        // Logic for opening a PDF document
    }

    public void save() {
        // Logic for saving a PDF document
    }

    public void print() {
        // Logic for printing a PDF document
    }
    // No sendViaEmail() - not needed!
}

class WordDocument implements Openable, Saveable, Emailable {
    public void open() {
        // Logic for opening a Word document
    }

    public void save() {
        // Logic for saving a Word document
    }

    public void sendViaEmail() {
        // Logic for sending a Word document via email
    }
    // No print() - not needed!
}

BENEFITS:
- Classes implement only what they actually use
- No empty or "not used" implementations
- Adding new capabilities doesn't break existing classes
- Better cohesion and separation of concerns
- Easier to test and maintain
*/

package maintainability;

// ISP VIOLATION: "Fat interface" forces clients to depend on methods they don't use
// PROBLEM: All implementing classes must provide ALL methods, even unused ones
// IMPROVEMENT: Split into smaller, focused interfaces (Openable, Saveable, Printable, Emailable)
interface Document {
    // METHOD 1: Used by both implementations
    void open();

    // METHOD 2: Used by both implementations
    void save();

    // METHOD 3: Only used by PDFDocument, not WordDocument
    void print();

    // METHOD 4: Only used by WordDocument, not PDFDocument
    void sendViaEmail();
}

// ISP VIOLATION: Forced to implement sendViaEmail() even though not used
// PROBLEM: Empty implementation violates ISP
// IMPROVEMENT: Implement only Openable, Saveable, Printable interfaces
class PDFDocument implements Document {

    public void open() {
        // Logic for opening a PDF document
    }

    public void save() {
        // Logic for saving a PDF document
    }

    public void print() {
        // Logic for printing a PDF document
    }

    // ISP VIOLATION: Forced to implement unused method
    // PROBLEM: "not used" comment indicates ISP violation
    // SOLUTION: Remove this method, use Emailable interface separately
    public void sendViaEmail() {
        // not used
    }
}

// ISP VIOLATION: Forced to implement print() even though not used
// PROBLEM: Empty implementation violates ISP
// IMPROVEMENT: Implement only Openable, Saveable, Emailable interfaces
class WordDocument implements Document {

    public void open() {
        // Logic for opening a Word document
    }

    public void save() {
        // Logic for saving a Word document
    }

    // ISP VIOLATION: Forced to implement unused method
    // PROBLEM: "not used" comment indicates ISP violation
    // SOLUTION: Remove this method, use Printable interface separately
    public void print() {
        // not used
    }

    public void sendViaEmail() {
        // Logic for sending a Word document via email
    }
}
