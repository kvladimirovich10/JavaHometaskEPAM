package hometask1.task6;

/**
 *  Class NoteService contents methods to handle with actions over notes
 */

class NoteService {

    /**
     * Method creates a new object of the class Contact, adds new contact to a contact list of the particular note
     * @param note - note to add the contact to
     * @param name - contact name
     * @param lastName - contact last name
     * @param phoneNumber - contact phone number
     * @param email - contact email
     */
    static void addContact(Note note,
                           String name,
                           String lastName,
                           String phoneNumber,
                           String email) {
        Contact contact = new Contact(name, lastName, phoneNumber, email);
        note.getNoteContacts().add(contact);
    }
}
