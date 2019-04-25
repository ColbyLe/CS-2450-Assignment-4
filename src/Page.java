import javafx.scene.Node;
import javafx.scene.layout.VBox;

public interface Page {
    abstract Node getContent();
    abstract String getTitle();
    abstract void setSearchString(String s);
}
