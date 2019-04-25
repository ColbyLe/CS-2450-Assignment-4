import javafx.scene.Node;
import javafx.scene.layout.VBox;

public interface Page {
    // getContent returns a container Node that contains the page content
    abstract Node getContent();

    // getTitle returns the page title
    abstract String getTitle();

    // setSearchString is used to pass a search query to the active page
    abstract void setSearchString(String s);
}
