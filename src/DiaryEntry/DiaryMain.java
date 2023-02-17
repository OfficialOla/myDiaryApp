package DiaryEntry;

import javax.swing.*;
import java.util.Scanner;

public class DiaryMain {
    private static Scanner keyboardInput = new Scanner(System.in);
    //    static final String password = "1222";
    private static Diary diary = new Diary("OfficialOla", "1222");

    public static void main(String... args) {
        validateLogin();
        gotoMainMenu();
    }

    private static void gotoMainMenu() {
        String mainMenu = """
                      =========================
                      Welcome to my Entry
                      1 -> Create Entry
                      2 -> Check Entry
                      3 -> View Entry
                      4 -> Edit Entry
                      5 -> Delete Entry
                      6 -> Exit
                      =========================
                """;
        String userInput = input(mainMenu);
        switch (userInput.charAt(0)) {
            case '1' -> createEntry();
            case '2' -> checkEntry();
            case '3' -> viewEntry();
            case '4' -> editEntry();
            case '5' -> deleteEntry();
            case '6' -> exitEntry();
            default -> gotoMainMenu();
        }
    }
    private static void checkEntry() {
        String entryId = input("Enter entry id");
        diary.checkEntry(Integer.parseInt(entryId));
        viewEntry();
        gotoMainMenu();

    }
    private static void editEntry() {
//        validateMyPassword();
        String entryTitle = input("Enter entry title");
        String entryID = input("Enter entry id");
        String entryBody = input("Enter entry body");
        diary.editEntry(entryTitle, entryBody, Integer.parseInt(entryID));
        diary.animatedDisplay("loading");
        display("Entry successfully added");
        gotoMainMenu();
    }

    private static void createEntry() {
        String entryTitle = input("Enter entry title");
        String entryBody = input("Enter entry body");
        String id = input("Enter your id");
        diary.createEntry(entryTitle, entryBody, Integer.parseInt(id));
        diary.animatedDisplay("saving your entry");
//        display("Entry created successfully");
        gotoMainMenu();

    }

    private static void deleteEntry() {
        int entryID = 0;
        try {
            entryID = Integer.parseInt(input("Enter id"));
        } catch (NumberFormatException ex){
            display("Wrong number format");
            deleteEntry();
        }
        diary.deleteEntry(entryID);
        diary.animatedDisplay("loading");
        display("Entry successfully deleted");
        gotoMainMenu();
    }

    private static String input(String prompt) {
        return JOptionPane.showInputDialog(prompt);
    }

    private static void display(String prompt) {
        JOptionPane.showMessageDialog(null, prompt);
    }

    public static void viewEntry() {
        int entryID = 0;
        try {
            entryID = Integer.parseInt(input("Enter id"));
        } catch (NumberFormatException ex){
            display("Wrong number format");
            viewEntry();
        }
//        int entryID = Integer.parseInt(input("Enter entry ID "));
        display(diary.viewEntry(entryID));
        gotoMainMenu();
    }
    public  static void countEntry(){
//        display(diary.countEntry(entryId));
    }

    public static void exitEntry() {
        display("Thank you for using our application");
        System.exit(0);
    }

    public static void validateUsername(String userName) {
//    String passwordEntered = input("Enter password");
//    if (!Objects.equals(passwordEntered, password)){display("Invalid password");
//        main();
//    } else if (passwordEntered.equals(password))
//        gotoMainMenu();
    }

    public static void validatePassword(String userName, String Password) {
        if (!diary.getUserName().equalsIgnoreCase(userName)) throw new IllegalArgumentException("Wrong username");
        if (!diary.getPassword().equals(Password)) throw new IllegalArgumentException("Wrong password");
    }

    public static void validateLogin() {
        String userName = input("Enter userName");
        String password = input("Enter password");
        try {
            validatePassword(userName, password);
        } catch (IllegalArgumentException e) {
            display("Wrong credentials, try again!");
            validateLogin();
//    if (diary.getUserName().equals(userName)) throw new IllegalArgumentException("Wrong username");
//    if (diary.getPassword().equals(password))qewrewqrr` throw new IllegalArgumentException("Wrong password");
//    if (!Objects.equals(passwordEntered, password)){display("Invalid password");
//        main();
//    } else if  (passwordEntered.equals(password));
//}

        }

    }
}