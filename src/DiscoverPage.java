import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DiscoverPage implements Page {
    private Node pageContent;
    private String pageTitle;
    boolean hasChild;
    private int currentBook;

    public DiscoverPage() {
        pageContent = buildDiscoverPage();
        pageTitle = "Discover";
        hasChild = true;
        currentBook = 0;
    }

    private Node buildDiscoverPage() {
        Label[] categories = new Label[10];
        categories[0] = new Label("Books");
        categories[1] = new Label("eBooks");
        categories[2] = new Label("Audiobooks");
        categories[3] = new Label("Newspaper Articles");
        categories[4] = new Label("Journal Articles");
        categories[5] = new Label("VHS");
        categories[6] = new Label("DVD");
        categories[7] = new Label("Blu-ray");
        categories[8] = new Label("Maps");
        categories[9] = new Label("Gov't Documents");

        VBox categoryBox = new VBox();
        categoryBox.setPrefWidth(160);
        categoryBox.setPrefHeight(1024);
        categoryBox.setPadding(new Insets(8));
        categoryBox.setSpacing(8);
        categoryBox.setStyle("-fx-background-color: rgb(255,121,121)");
        for(Label x:categories) {
            x.setStyle("-fx-text-fill: black");
            categoryBox.getChildren().add(x);

            x.setOnMouseClicked(e-> {
                System.out.println("Clicked element: " + x.getText());
                SearchPage cPage = new SearchPage(x.getText(), false);
                pageContent = cPage.getContent();
                pageTitle = x.getText();
                hasChild = true;
            });

            x.setOnMouseEntered(e-> {
                x.setStyle("-fx-underline: true; -fx-text-fill: black");
            });

            x.setOnMouseExited(e-> {
                x.setStyle("-fx-underline: false; -fx-text-fill: black");
            });
        }

        Image[] covers = new Image[4];
        covers[0] = new Image("file:resources/images/ElectricSpaceMan.jpg");
        covers[1] = new Image("file:resources/images/Seveneves.jpg");
        covers[2] = new Image("file:resources/images/Annihilation.jpg");
        covers[3] = new Image("file:resources/images/Wicked.jpg");

        ImageView[] coverView = new ImageView[4];

        Image mainImg = new Image("file:resources/images/ElectricSpaceMan.jpg");
        ImageView mainImgBox = new ImageView(mainImg);
        mainImgBox.setStyle("-fx-background-color: white; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.12), 3, 0, 1, 2)");

        mainImgBox.setOnMouseClicked(e-> {
            ItemListing il = new ItemListing("Book");
            ListingPage mainListing = new ListingPage(il, currentBook);
            pageContent = mainListing.getContent();
            hasChild = true;
        });

        for(int i=0; i<4; i++) {
            coverView[i] = new ImageView(covers[i]);
            coverView[i].setPreserveRatio(true);
            coverView[i].setFitWidth(100);
            coverView[i].setStyle("-fx-background-color: white; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.12), 3, 0, 1, 2)");
            int finalI = i;

            coverView[i].setOnMouseClicked(e -> {
                ItemListing il = new ItemListing("Book");
                ListingPage mainListing = new ListingPage(il, finalI);
                pageContent = mainListing.getContent();
                hasChild = true;
            });

            coverView[i].setOnMouseEntered(e -> {
                coverView[finalI].setStyle("-fx-background-color: white; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.25), 3, 0, 2, 4)");
                mainImgBox.setImage(coverView[finalI].getImage());
                currentBook = finalI;
            });

            coverView[i].setOnMouseExited(e -> {
                coverView[finalI].setStyle("-fx-background-color: white; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.12), 3, 0, 1, 2)");
            });
        }

        HBox coverBox = new HBox();
        coverBox.setSpacing(12);
        coverBox.setPadding(new Insets(8));

        for(ImageView x:coverView) {
            coverBox.getChildren().addAll(x);
        }

        VBox pageBox = new VBox(mainImgBox, coverBox);
        pageBox.setPadding(new Insets(8));
        pageBox.setSpacing(32);
        pageBox.setAlignment(Pos.TOP_CENTER);

        return new HBox(categoryBox, pageBox);
    }

    @Override
    public Node getContent() {
        return pageContent;
    }

    @Override
    public String getTitle() {
        return pageTitle;
    }

    @Override
    public boolean spawnsChildPage() {
        return hasChild;
    }

}
