package DiaryEntry;

import java.time.LocalDateTime;

public class Entry {


    private String title;
    private String body;
    private final LocalDateTime date = LocalDateTime.now();

    public LocalDateTime getDate() {
        return date;
    }

    private int entryId;

    public Entry(String title, String body, int entryId) {
        this.title = title;
        this.body = body;
        this.entryId = entryId;

    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String checkTitle() {
        return title;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public String checkBody() {
        return body;
    }
    public void setEntryId(int entryId) {
        this.entryId = entryId;
    }

    public int checkEntryId() {
        return entryId;
    }

    public LocalDateTime checkDate() {
        LocalDateTime dateTime = LocalDateTime.now();
        return dateTime;
    }
    public String toString(){
        return String.format("""
                1. Entry Title: %s
                2. Entry Body: %s
                3. Entry Id: %s
                4. Entry date: %s
                5. Entry date 2: %s
                """,
                title, body, entryId, getDate(), checkDate());
    }
}
