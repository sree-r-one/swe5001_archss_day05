// 10.	Demonstrate Interface Segregation.

public interface Document {
void open();
void save();
void print();
void sendViaEmail();
}

public class PDFDocument implements Document {

public void open() {
// Logic for opening a PDF document
}

public void save() {
// Logic for saving a PDF document
}

public void print() {
// Logic for printing a PDF document
}

public void sendViaEmail() {
// not used
}
}

public class WordDocument implements Document {

public void open() {
// Logic for opening a Word document
}

public void save() {
// Logic for saving a Word document
}

public void print() {
// not used
}

public void sendViaEmail() {
// Logic for sending a Word document via email
}
}

