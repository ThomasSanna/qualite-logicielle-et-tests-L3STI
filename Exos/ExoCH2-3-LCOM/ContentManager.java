package exercice;

import java.util.ArrayList;
import java.util.List;

public class ContentManager {
	private List<Content> contentList;
    private Database database;

    public ContentManager() {
        this.contentList = new ArrayList<>();
        this.database = new Database();
    }

    public void addContent(Content content) {
        contentList.add(content);
        System.out.println("Content added: " + content.getTitle());
    }

    public void removeContent(Content content) {
        contentList.remove(content);
        System.out.println("Content removed: " + content.getTitle());
    }

    public void displayAllContentTitles() {
        if (contentList.isEmpty()) {
            System.out.println("No content available.");
        } else {
            for (Content content : contentList) {
                System.out.println(content.getTitle());
            }
        }
    }

    public boolean saveContentToDatabase(Content content) {
        if(database.save(content)) {
            System.out.println("Content saved to database: " + content.getTitle());
            return true;
        } else {
            System.out.println("Failed to save content to database: " + content.getTitle());
            return false;
        }
    }

    public void printDatabaseStatus() {
        System.out.println("Database status: " + database.getStatus());
    }

    public Content findContentById(int id) {
        for (Content content : contentList) {
            if (content.getId() == id) {
                return content;
            }
        }
        return null;
    }

    public void archiveContent(Content content) {
        // Archiving content here would also likely interact with the database
        database.archiveContent(content);
        System.out.println("Content archived: " + content.getTitle());
    }

    public void loadContentFromDatabase() {
        List<Content> loadedContents = database.loadContent();
        contentList.addAll(loadedContents);
        System.out.println("Content loaded from database.");
    }

    public void updateContentRating(Content content, int rating) {
        content.setRating(rating);
        database.updateContentRating(content);
        System.out.println("Content rating updated to: " + rating + " for " + content.getTitle());
    }

    public void shareContentViaEmail(Content content, String email) {
        // Sharing content via email wouldn't typically interact with contentList or database
        System.out.println("Content titled '" + content.getTitle() + "' shared with " + email);
    }
}


