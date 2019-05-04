import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.awt.*;

public class ItemListingPage implements Page {
    private Node pageContent;
    private String pageTitle, searchString;
    private ItemListing info;
    private boolean hasChild;
    private Image bookCover;

    public ItemListingPage(ItemListing il, int i) {
        pageTitle = il.getTitle();
        info = il;
        hasChild = false;
        switch(i) {
            case 1: bookCover = new Image("file:resources/images/Seveneves.jpg");
                break;
            case 2: bookCover = new Image("file:resources/images/Annihilation.jpg");
                break;
            case 3: bookCover = new Image("file:resources/images/Wicked.jpg");
                break;
            default: bookCover = new Image("file:resources/images/Mars.jpg");
        }

        buildListingPage();
    }

    public Node getContent() {
       return pageContent;
    }

    public void buildListingPage() {
        Label[] listingContent = new Label[4];
        listingContent[0] = new Label(info.getTitle());
        listingContent[0].setStyle("-fx-font-size: 20; -fx-font-weight: bold");
        listingContent[1] = new Label(info.getType());
        listingContent[2] = new Label(info.getInfo());
        listingContent[3] = new Label(info.getSummary());

        //Image bookCover = new Image("file:resources/images/Mars.jpg");
        ImageView coverView = new ImageView(bookCover);
        coverView.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.12), 3, 0, 1, 2)");
        VBox coverBox = new VBox(coverView);
        coverBox.setPadding(new Insets(8,8,8,64));

        VBox infoBox = new VBox();
        infoBox.setPadding(new Insets(8,8,8,64));
        //infoBox.setStyle("-fx-background-color: white; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.12), 3, 0, 1, 2)");
        infoBox.setPrefHeight(340);
        for(Label x:listingContent) {
            x.setWrapText(true);
            infoBox.getChildren().add(x);
        }

        VBox contentBox = new VBox(coverBox, infoBox);
        contentBox.setPadding(new Insets(20));
        contentBox.setSpacing(12);
        contentBox.setMaxHeight(640);
        contentBox.setStyle("-fx-background-color: white; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.12), 3, 0, 1, 2)");

        HBox bigBox = new HBox(contentBox);
        //bigBox.setMinHeight(768);
        bigBox.setSpacing(12);
        bigBox.setPadding(new Insets(12));
        bigBox.setAlignment(Pos.CENTER);

        pageContent = bigBox;
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

    /*
    public void setSearchString(String s) {
        searchString = s;
    }
    */
}
