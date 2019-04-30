import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class PrivacyPolicyPage implements Page {

    public PrivacyPolicyPage() {}

    @Override
    public Node getContent() {
        Label spiel = new Label("We reserve the right to collect all of your data.");
        HBox stuff = new HBox(spiel);
        return stuff;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public boolean spawnsChildPage() {
        return false;
    }

}
