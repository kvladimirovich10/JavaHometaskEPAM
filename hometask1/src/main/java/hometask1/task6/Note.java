package hometask1.task6;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Class Note is a template of a note that is stored in the notebook
 * String title - stores a title of a note
 * String text  - stores a text of a note
 * String creationDate - stores the date when a user created a note
 * List<Contact> noteContacts - stores a list of all contacts that a added to the particular note
 */
class Note {
    private String title;
    private String text;
    private String creationDate;
    private List<Contact> noteContacts;

    Note(String title, String text) {
        this.title = title;
        this.text = text;
        creationDate = addCurrentDateTime();
        noteContacts = new ArrayList<>();
    }

    /**
     * Method create a formatted date
     *
     * @return String of a formatted date
     */
    private static String addCurrentDateTime() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, HH:mm d MMM yyyy");
        return sdf.format(cal.getTime());
    }

    String getTitle() {
        return title;
    }

    String getText() {
        return text;
    }

    String getCreationDate() {
        return creationDate;
    }

    List<Contact> getNoteContacts() {
        return noteContacts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Note note = (Note) o;

        return getTitle().equals(note.getTitle())
                && getText().equals(note.getText())
                && getCreationDate().equals(note.getCreationDate())
                && getNoteContacts().equals(note.getNoteContacts());
    }

    @Override
    public int hashCode() {
        int result = getTitle().hashCode();
        result = 31 * result + getText().hashCode();
        result = 31 * result + getCreationDate().hashCode();
        result = 31 * result + getNoteContacts().hashCode();
        return result;
    }
}
