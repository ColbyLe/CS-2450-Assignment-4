import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class EventPage implements Page {
    private Node pageContent;
    private String pageTitle;

    public EventPage() {
        pageContent = buildEventpage();
        pageTitle = "Events";
    }

    private static Node buildEventpage() {
        EventListing[] events = new EventListing[5];
        HBox[] eventNodes = new HBox[5];
        VBox[] eventInfo = new VBox[5];
        Label title = new Label("Our Events");
        title.setStyle("-fx-font-size: 20; -fx-font-weight: bold");

        for(int i=0; i<5; i++) {
            events[i] = new EventListing(i);
            Image eventImage = events[i].getImage();
            ImageView eventImageView = new ImageView(eventImage);

            Text name = new Text(events[i].getName());
            Text when = new Text(events[i].getDatetime());
            Text desc = new Text(events[i].getDescription());
            desc.setWrappingWidth(540);
            eventInfo[i] = new VBox(name, when, desc);

            eventNodes[i] = new HBox(eventImageView, eventInfo[i]);
            eventNodes[i].setStyle("-fx-background-color: white; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.12), 3, 0, 1, 2)");
            eventNodes[i].setMaxWidth(768);
            eventNodes[i].setPadding(new Insets(8));
            eventNodes[i].setSpacing(8);
        }

        VBox contentBox = new VBox(title);
        contentBox.setSpacing(32);
        contentBox.setPadding(new Insets(16,16,32,16));
        contentBox.setAlignment(Pos.CENTER);

        for(HBox x : eventNodes) {
            contentBox.getChildren().add(x);
        }

        return contentBox;
    }

    public Node getContent() {
        return pageContent;
    }

    // getTitle returns the page title
    public String getTitle() {
        return pageTitle;
    }

    public boolean spawnsChildPage() {
        return false;
    }
}
