package task6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class NotebookMain {
    /**
     * A start point of the program, implementation of a finite-state machine
     * @param args - argument from a console
     */
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Notebook myNotebook = new Notebook("My Notebook");

        try {
            while (true) {
                int i = 1;
                System.out.format("%n* what would you like to do? Type command 1,2,3 or 4");
                System.out.format("%n%d  Show the list of notes", i++);
                System.out.format("%n%d  Add a note", i++);
                System.out.format("%n%d  Delete a note", i++);
                System.out.format("%n%d  Exit%n%n", i);

                int n = NotebookService.enterInt(reader);

                while (n < 1 || n > 4) {
                    System.out.format("%n* Type command 1,2,3 or 4...%n");
                    n = NotebookService.enterInt(reader);
                }

                switch (n) {
                    case 1: {
                        if (NotebookService.printAllNotes(myNotebook.getNotes()) == 1)
                            NotebookService.chooseNote(myNotebook.getNotes(), reader);
                        continue;
                    }
                    case 2: {
                        System.out.println("* give your note a title: ");
                        String title = reader.readLine();

                        System.out.println("* type your text: ");
                        String text = reader.readLine();

                        NotebookService.addNote(myNotebook.getNotes(), title, text, reader);
                        continue;
                    }
                    case 3: {
                        if (myNotebook.getNotes().size() != 0) {
                            System.out.format("%n* choose the note number to delete%n");
                            NotebookService.printAllNotes(myNotebook.getNotes());

                            int j = Integer.parseInt(reader.readLine());
                            NotebookService.deleteNote(myNotebook.getNotes(), j - 1);
                        } else
                            System.out.format("%n* no notes are added yet%n");
                        continue;
                    }
                    case 4: {
                        System.out.println("* Goodbye!");
                        reader.close();
                        return;
                    }
                }

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
