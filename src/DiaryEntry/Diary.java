package DiaryEntry;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class  Diary {
    private String userName;
    private boolean isLocked;
    private String password;
    public Diary(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    private ArrayList<Entry> entries = new ArrayList<>();
    public void createEntry(String title, String body, int id) {
        int entryNumber = entries.size() + 1;
        Entry firstEntry = new Entry(title, body, id);
        entries.add(entryNumber - 1, firstEntry);
        LocalDate dateTime = LocalDateTime.now().toLocalDate();
    }
    public Entry  checkEntry(int entryNumber) {
        entryNumber = entryNumber - 1;
        System.out.println(entries.toString());
        return entries.get(entryNumber);
    }
    public int countEntry(int entryNumber){
//        entryNumber += entries.size();
        return entries.size();
    }
    public int checkForNumberOfEntries() {
        return entries.size();
    }
    public String viewEntry(int entryId) {
        //entries.get(entryId);
        if(entries.get(entryId-1) == null) return "oops! you do not have an entry here";
//        return  entries.get(entryId -1);
        return checkEntry(entryId).toString();
        }

    public void deleteEntry(int entryId) {
        int del = entryId - 1;
        entries.remove(del);
        entries.add(del, null);
    }

    public void editEntry(String title, String body, int entryId) {
        int dell = entryId-1;
        Entry edit = entries.get(entryId -1);
        edit.setBody(body);
        edit.setTitle(title);
        entries.set(dell, edit);
    }
//    public boolean unlockedDiary(String password){
////        if (validatePassword(password)){
//            this.isLocked = false;
//        }
//        return false;
//    }
    public boolean isLocked(){
        return isLocked;
    }
    public void lockDiary(){
        this.isLocked = true;
    }
//    public boolean validatePassword(String password){
//        if (!isLocked){
//            addEn
//        }
//    }

    public void animatedDisplay(String action){
        JOptionPane.showMessageDialog(null, "Saving your details...");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        JOptionPane.showMessageDialog(null, "Details saved successfully.");
        }
    }

