package task2;import java.io.BufferedReader;import java.io.IOException;import java.io.InputStreamReader;import java.util.List;public class Main {    public static void main(String[] args) {        Office office = new Office();        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));        try {            while (true) {                int i = 1;                System.out.format("%n* what would you like to do? Type command 1,2 or 3");                System.out.format("%n%d  Show the list employees", i++);                System.out.format("%n%d  Add aa employee", i++);                System.out.format("%n%d  Exit%n%n", i);                int n = OfficeService.enterInt(reader);                while (n < 1 || n > i) {                    System.out.format("%n* Type command 1,2 or 3...%n");                    n = OfficeService.enterInt(reader);                }                switch (n) {                    case 1: {                        if (OfficeService.printEmployeeList(office.getEmplList()) == 1)                            OfficeService.chooseEmployee(office.getEmplList(), reader);                        continue;                    }                    case 2: {                        System.out.println("* give your note a title: ");                        String title = reader.readLine();                        System.out.println("* type your text: ");                        String text = reader.readLine();                        NotebookService.addNote(myNotebook.getNotes(), title, text, reader);                        continue;                    }                    case 3: {                        if (myNotebook.getNotes().size() != 0) {                            System.out.format("%n* choose the note number to delete%n");                            NotebookService.printAllNotes(myNotebook.getNotes());                            int j = Integer.parseInt(reader.readLine());                            NotebookService.deleteNote(myNotebook.getNotes(), j - 1);                        } else                            System.out.format("%n* no notes are added yet%n");                        continue;                    }                    case 4: {                        System.out.println("* Goodbye!");                        reader.close();                        return;                    }                }            }        } catch (IOException e) {            System.out.println(e.getMessage());        }    }}