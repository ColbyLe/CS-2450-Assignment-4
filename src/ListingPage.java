import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.awt.*;

public class ListingPage implements Page {
    private Node pageContent;
    private String pageTitle, searchString;
    private ItemListing info;

    public ListingPage(ItemListing il) {
        pageTitle = "This is a Book";
        info = il;
    }

    public Node getContent() {
        Label[] listingContent = new Label[4];
        listingContent[0] = new Label(info.getTitle());
        listingContent[0].setStyle("-fx-font-size: 16");
        listingContent[1] = new Label(info.getType());
        listingContent[2] = new Label(info.getInfo());
        listingContent[3] = new Label(info.getSummary());

        Image bookCover = new Image("file:resources/images/theMusk.jpg");
        ImageView coverView = new ImageView(bookCover);

        VBox contentBox = new VBox(coverView);
        contentBox.setPadding(new Insets(8));

        for(Label x:listingContent) {
            x.setWrapText(true);
            contentBox.getChildren().add(x);
        }

        return contentBox;
    }
    public String getTitle() {
        return pageTitle;
    }

    @Override
    public boolean spawnsChildPage() {
        return false;
    }

    public Page getChildPage() {
        return this;
    }

    public void setSearchString(String s) {
        searchString = s;
    }
}
