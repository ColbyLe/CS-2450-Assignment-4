import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class SearchPage implements Page {
    private VBox searchPage;

    public SearchPage(String searchString) {
        searchPage = buildSearchpage(searchString);
    }

    private VBox buildSearchpage(String searchString) {
        Label searchLabel = new Label("Results for: " + searchString);
        return new VBox(searchLabel);
    }

    public Node getContent() {
        return searchPage;
    }
}
