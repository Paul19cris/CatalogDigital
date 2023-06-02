package UI;

import Service.MateriiService;
import Service.ElevStudentService;

import java.util.Scanner;

public class UI {
    private MateriiService materiiService;
    private ElevStudentService elevStudentService;

    public UI(MateriiService materiiService, ElevStudentService elevStudentService) {
        this.materiiService = materiiService;
        this.elevStudentService = elevStudentService;
    }

    private void printMenu() {
        System.out.println("MENIU");
        System.out.println("----------------");
        System.out.println("1. Adauga");
        System.out.println("2. Sterge");
        System.out.println("3. Modifica");
        System.out.println("4. Afiseaza");
        System.out.println("5. Media Notelor");
        System.out.println("----------------");
        System.out.println("0. Iesire");
        System.out.println();
    }

    private int readCommands(String a) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introdu " + a + ":");
        int ok = 0;
        while (true) {
            String string = scanner.nextLine();
            try {
                ok = Integer.parseInt(string);
                break;
            }
            catch (Exception e) {
                System.out.println("Valoare Invalida.");
            }
        }
        return ok;
    }

    private void addElevStudent() {
        Scanner in = new Scanner(System.in);
        System.out.println("Adauga Student");
        System.out.println("----------------");
        System.out.println("Nume:");
        String nume = in.nextLine();
        System.out.println("Materie:");
        String materie = in.nextLine();
        int nota = readCommands("nota");
        try {
            System.out.println(elevStudentService.addElevStudent(nume, materie, nota));
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void addMaterie() {
        Scanner in = new Scanner(System.in);
        System.out.println("Adauga Materie");
        System.out.println("----------------");
        System.out.println("Nume:");
        String nume = in.nextLine();
        int credite = readCommands("credite");
        try {
            System.out.println(materiiService.addMaterie(nume, credite));
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void add() {
        Scanner scanner = new Scanner(System.in);
        int ok;
        while (true) {
            System.out.println("Ce vrei sa adaugi?");
            System.out.println("----------------");
            System.out.println("1. Elev / Student");
            System.out.println("2. Materie");
            System.out.println("----------------");
            System.out.println("0. Inapoi");
            System.out.println();
            ok = readCommands("optiunea");
            switch (ok) {
                case 0:
                    return;
                case 1:
                    addElevStudent();
                    break;
                case 2:
                    addMaterie();
                    break;
                default:
                    System.out.println("Comanda Invalida.");
                    break;
            }
            System.out.println();
        }
    }

    private void removeElevStudent() {
        Scanner in = new Scanner(System.in);
        System.out.println("Sterge Student");
        System.out.println("----------------");
        System.out.println("Nume:");
        String nume = in.nextLine();
        System.out.println("Materie:");
        String materie = in.nextLine();
        try {
            System.out.println(elevStudentService.removeElevStudent(nume, materie));
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void removeMaterie() {
        Scanner in = new Scanner(System.in);
        System.out.println("Adauga Materie");
        System.out.println("----------------");
        System.out.println("Nume:");
        String nume = in.nextLine();
        try {
            System.out.println(materiiService.removeMaterie(nume));
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void remove() {
        System.out.println("Ce vrei sa stergi?");
        System.out.println("----------------");
        System.out.println("1. Elev / Student");
        System.out.println("2. Materie");
        System.out.println("----------------");
        System.out.println("0. Inapoi");
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        int ok = readCommands("optiunea");
        switch (ok) {
            case 0:
                return;
            case 1:
                removeElevStudent();
                break;
            case 2:
                removeMaterie();
                break;
            default:
                System.out.println("Comanda Invalida.");
                break;
        }
    }

    private void updateElevStudent() {
        Scanner in = new Scanner(System.in);
        System.out.println("Modifica Student");
        System.out.println("----------------");
        System.out.println("Nume:");
        String nume = in.nextLine();
        System.out.println("Materie:");
        String materie = in.nextLine();
        int nota = readCommands("nota");
        try {
            System.out.println(elevStudentService.updateElevStudent(nume, materie, nota));
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void updateMaterie() {
        Scanner in = new Scanner(System.in);
        System.out.println("Modifica Materie");
        System.out.println("----------------");
        System.out.println("Nume:");
        String nume = in.nextLine();
        int credite = readCommands("credite");
        try {
            System.out.println(materiiService.updateMaterie(nume, credite));
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void update() {
        System.out.println("Ce vrei sa modifici?");
        System.out.println("----------------");
        System.out.println("1. Elev / Student");
        System.out.println("2. Materie");
        System.out.println("----------------");
        System.out.println("0. Inapoi");
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        int ok = readCommands("optiunea");
        switch (ok) {
            case 0:
                return;
            case 1:
                updateElevStudent();
                break;
            case 2:
                updateMaterie();
                break;
            default:
                System.out.println("Comanda Invalida.");
                break;
        }
    }

    private void displayElevStudent() {
        Scanner in = new Scanner(System.in);
        System.out.println("Afiseaza Student");
        System.out.println("----------------");
        try {
            System.out.println(elevStudentService.displayElevStudent());
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void displayMaterie() {
        Scanner in = new Scanner(System.in);
        System.out.println("Afiseaza Materie");
        System.out.println("----------------");
        try {
            System.out.println(materiiService.displayMaterie());
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void display() {
        System.out.println("Ce vrei sa afisezi?");
        System.out.println("----------------");
        System.out.println("1. Elev / Student");
        System.out.println("2. Materie");
        System.out.println("----------------");
        System.out.println("0. Inapoi");
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        int ok = readCommands("optiunea");
        switch (ok) {
            case 0:
                return;
            case 1:
                displayElevStudent();
                break;
            case 2:
                displayMaterie();
                break;
            default:
                System.out.println("Comanda Invalida.");
                break;
        }
    }


    private void aveargeElev() {
        Scanner in = new Scanner(System.in);
        System.out.println("Medii Elevi");
        System.out.println("----------------");
        try {
            System.out.println(elevStudentService.aveargeElev());
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void aveargeStudent() {
        Scanner in = new Scanner(System.in);
        System.out.println("Medii Studenti");
        System.out.println("----------------");
        try {
            System.out.println(elevStudentService.aveargeStudent());
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void avearge() {
        System.out.println("Ce medie vrei sa afisezi?");
        System.out.println("----------------");
        System.out.println("1. Elev");
        System.out.println("2. Student");
        System.out.println("----------------");
        System.out.println("0. Inapoi");
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        int ok = readCommands("optiunea");
        switch (ok) {
            case 0:
                return;
            case 1:
                aveargeElev();
                break;
            case 2:
                aveargeStudent();
                break;
            default:
                System.out.println("Comanda Invalida.");
                break;
        }
    }
    public void run() {
        int ok;
        while(true) {
            printMenu();
            ok = readCommands("optiunea");
            switch (ok) {
                case 0:
                    System.exit(0);
                case 1:
                    add();
                    break;
                case 2:
                    remove();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    display();
                    break;
                case 5:
                    avearge();
                    break;
                default:
                    System.out.println("Comanda Invalida.");
                    break;
            }
        }
    }
}
