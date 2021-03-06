package hometask1.task6;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Notebook is a template for a notebook where all notes will be stored
 * List<Note> notes - a list of al notes in the particular notebook
 * String notebookName - a name of a notebook
 */
class Notebook {

    private List<Note> notes = new ArrayList<>();
    private String notebookName;

    Notebook(String notebookName) {
        this.notebookName = notebookName;
    }

    List<Note> getNotes() {
        return notes;
    }

    public String getNotebookName() {
        return notebookName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Notebook notebook = (Notebook) o;

        return getNotes().equals(notebook.getNotes()) && notebookName.equals(notebook.notebookName);
    }

    @Override
    public int hashCode() {
        int result = getNotes().hashCode();
        result = 31 * result + notebookName.hashCode();
        return result;
    }
}
