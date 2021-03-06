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
    boolean hasChild;
    Image bookCover;

    public ListingPage(ItemListing il, int i) {
        pageTitle = "This is a " + il.getTitle();
        info = il;
        hasChild = false;
        switch(i) {
            case 1: bookCover = new Image("file:resources/images/Seveneves.jpg");
                break;
            case 2: bookCover = new Image("file:resources/images/Annihilation.jpg");
                break;
            case 3: bookCover = new Image("file:resources/images/Wicked.jpg");
                break;
            default: bookCover = new Image("file:resources/images/ElectricSpaceMan.jpg");
        }
    }

    public Node getContent() {
        Label[] listingContent = new Label[4];
        listingContent[0] = new Label(info.getTitle());
        listingContent[0].setStyle("-fx-font-size: 16");
        listingContent[1] = new Label(info.getType());
        listingContent[2] = new Label(info.getInfo());
        listingContent[3] = new Label(info.getSummary());

        //Image bookCover = new Image("file:resources/images/ElectricSpaceMan.jpg");
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
        return hasChild;
    }

    /*
    public Page getChildPage() {
        return this;
    }
    */

    public void setSearchString(String s) {
        searchString = s;
    }
}
