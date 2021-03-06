package hometask1.task6;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;


/**
 * Class NotebookService contents methods to handle with actions over notebook
 */
class NotebookService {
    /**
     * Method adds a note to the list of notes, adds a contact to the note
     * @param notes - note list
     * @param title - note title
     * @param text - note text
     * @param reader - object of a class BufferedReader to read from a console
     * @throws IOException for BufferedReader
     */
    static void addNote(List<Note> notes,
                        String title,
                        String text,
                        BufferedReader reader) throws IOException {

        Note note = new Note(title, text);
        notes.add(note);

        System.out.format("%n* would you like to add a contact? 1 YES | 0 NO%n");
        if (enterInt(reader) == 1) {
            contactInfoReader(note, reader);
        }

        System.out.format("%n* note '" + title + "' is added%n");
    }

    /**
     * Method reads info from a console and creates a new contact
     * @param note - note to add the contact to
     * @param reader - object of a class BufferedReader to read from a console
     * @throws IOException for BufferedReader
     */
    private static void contactInfoReader(Note note, BufferedReader reader) throws IOException {
        System.out.print("name: ");
        String name = reader.readLine();
        System.out.print("last name: ");
        String lastName = reader.readLine();
        System.out.print("phone: ");
        String phoneNumber = reader.readLine();
        System.out.print("email: ");
        String email = reader.readLine();
        NoteService.addContact(note, name, lastName, phoneNumber, email);
        System.out.println();
    }

    /**
     * Method deletes the note from the note list of a notebook
     * @param notes - list of notes
     * @param index - index of a note to delete in the note list
     * @throws IOException for BufferedReader
     */
    static void deleteNote(List<Note> notes, int index) throws IOException {

        String title = notes.get(index).getTitle();
        notes.remove(index);
        System.out.format("%n* note '" + title + "' is deleted%n");

    }

    /**
     * Method prints to a console all the stored notes in the note list
     * @param notes - note list
     * @return 0 if there is no notes in the notebook , 1 if it is not
     * @throws IOException for BufferedReader
     */
    static int printAllNotes(List<Note> notes) throws IOException {
        int i = 1;
        if (notes.size() == 0) {
            System.out.format("%n* no notes are added yet%n");
            return 0;
        } else {
            for (Note note : notes) {
                System.out.println(i++ + " '" + note.getTitle() + "' " + note.getCreationDate());
            }
        }
        return 1;
    }

    /**
     * Method selects a note from a note list by index from a console and calls method printNote
     * @param notes - note list
     * @param reader - object of a class BufferedReader to read from a console
     * @throws IOException for BufferedReader
     */
    static void chooseNote(List<Note> notes, BufferedReader reader) throws IOException {
        System.out.format("%n* type the note number to look through the note | 0 - back to the menu%n");
        int i = enterInt(reader);
        if (i == 0)
            return;
        while (i < 0 || i > notes.size()) {
            System.out.format("%n* can't find this note, try again!%n");
            i = Integer.parseInt(reader.readLine());
        }

        printNote(notes, i - 1);
    }

    /**
     * Method prints content of a note
     * @param notes - note list
     * @param index - index of a particular note in the note list
     * @throws IOException for BufferedReader
     */
    private static void printNote(List<Note> notes, int index) throws IOException {

        System.out.println("'" + notes.get(index).getTitle() + "'      Dated: " + notes.get(index).getCreationDate());
        System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
        System.out.println(notes.get(index).getText());

        if (notes.get(index).getNoteContacts().size() != 0) {
            System.out.format("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨%nContact:%n");
            for (Contact contact : notes.get(index).getNoteContacts()) {
                System.out.println("name: " + contact.getName());
                System.out.println("last name: " + contact.getLastName());
                System.out.println("phone: " + contact.getPhoneNumber());
                System.out.println("email: " + contact.getEmail());
            }
        }
        System.out.format("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨%n");
    }

    /**
     * Method reads a String from a console, tries to parse to int by calling method isInteger()
     * @param reader - object of a class BufferedReader to read from a console
     * @return parsed int from a String
     * @throws IOException for BufferedReader
     */
    static int enterInt(BufferedReader reader) throws IOException {
        String readLine = reader.readLine();
        while (!isInteger(readLine)) {
            System.out.println("Enter a valid number!");
            readLine = reader.readLine();
        }
        return Integer.parseInt(readLine);
    }

    /**
     * Method checks if a string can be parsed to int
     * @param s - String to parse to int
     * @return True if int, False if not
     */
    private static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }
}
