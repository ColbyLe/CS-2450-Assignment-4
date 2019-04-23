import javafx.scene.Node;
import javafx.scene.layout.VBox;

public class ListingPage implements Page {
    private Node pageContent;
    private String pageTitle;

    public ListingPage() {
        pageTitle = "This is a Book";
    }

    public Node getContent() {
        return new VBox();
    }
    public String getTitle() {
        return pageTitle;
    }
}
