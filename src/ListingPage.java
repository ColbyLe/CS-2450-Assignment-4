import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ListingPage implements Page {
    private Node pageContent;
    private String pageTitle, searchString;
    private ItemListing info;

    public ListingPage(ItemListing il) {
        pageTitle = "This is a Book";
    }

    public Node getContent() {
        Label[] listingContent = new Label[4];
        listingContent[0] = new Label(info.getTitle());
        listingContent[1] = new Label(info.getType());
        listingContent[2] = new Label(info.getInfo());
        listingContent[3] = new Label(info.getSummary());

        VBox contentBox = new VBox();

        for(Label x:listingContent) {
            contentBox.getChildren().add(x);
        }

        return contentBox;
    }
    public String getTitle() {
        return pageTitle;
    }

    public Page getChildPage() {
        return this;
    }


    public void setSearchString(String s) {
        searchString = s;
    }
}
