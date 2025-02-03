package exercice;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private String status;

    public boolean save(Content content) {
        // Simulate saving content to the database
        status = "Content saved: " + content.getTitle();
        return true;
    }

    public List<Content> loadContent() {
        // Simulate loading content from the database
        return new ArrayList<>();
    }

    public void archiveContent(Content content) {
        // Simulate archiving content
        status = "Content archived: " + content.getTitle();
    }

    public void updateContentRating(Content content) {
        // Simulate updating content rating
        status = "Content rating updated: " + content.getTitle();
    }

    public String getStatus() {
        // Simulate getting the status of the database
        return status;
    }

}