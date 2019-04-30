import javafx.scene.Node;
import javafx.scene.layout.VBox;

public interface Page {
    // getContent returns a container Node that contains the page content
    abstract Node getContent();

    // getTitle returns the page title
    abstract String getTitle();

    // corresponds with boolean hasChild field
    // true if page links to another page
    // false otherwise
    abstract boolean spawnsChildPage();

    // abstract Page getChildPage();
}
