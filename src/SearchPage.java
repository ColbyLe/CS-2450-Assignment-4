import javafx.scene.Node;
import javafx.scene.layout.VBox;

public class SearchPage implements Page {
    private VBox searchPage;

    public SearchPage(String searchString) {

    }

    public Node getContent() {
        return searchPage;
    }
}
