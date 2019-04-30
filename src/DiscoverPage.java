import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DiscoverPage implements Page {
    private Node pageContent;
    private String pageTitle;
    boolean hasChild;

    public DiscoverPage() {
        pageContent = buildDiscoverPage();
        pageTitle = "Discover";
        hasChild = false;
    }

    private static Node buildDiscoverPage() {
        Hyperlink[] categories = new Hyperlink[10];
        categories[0] = new Hyperlink("Books");
        categories[1] = new Hyperlink("eBooks");
        categories[2] = new Hyperlink(("Audiobooks"));
        categories[3] = new Hyperlink("Newspaper Articles");
        categories[4] = new Hyperlink("Journal Articles");
        categories[5] = new Hyperlink("VHS");
        categories[6] = new Hyperlink("DVD");
        categories[7] = new Hyperlink("Blu-ray");
        categories[8] = new Hyperlink("Maps");
        categories[9] = new Hyperlink("Gov't Documents");

        VBox categoryBox = new VBox();
        categoryBox.setPrefWidth(160);
        categoryBox.setPrefHeight(1024);
        categoryBox.setPadding(new Insets(8));
        categoryBox.setSpacing(8);
        categoryBox.setStyle("-fx-background-color: rgb(255,121,121)");
        for(Hyperlink x:categories) {
            x.setStyle("-fx-text-fill: black");
            categoryBox.getChildren().add(x);
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

        for(int i=0; i<4; i++) {
            coverView[i] = new ImageView(covers[i]);
            coverView[i].setPreserveRatio(true);
            coverView[i].setFitWidth(100);
            coverView[i].setStyle("-fx-background-color: white; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.12), 3, 0, 1, 2)");
            int finalI = i;

            coverView[i].setOnMouseClicked(e -> {
                mainImgBox.setImage(coverView[finalI].getImage());
            });

            coverView[i].setOnMouseEntered(e -> {
                coverView[finalI].setStyle("-fx-background-color: white; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.25), 3, 0, 2, 4)");
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
        return false;
    }

    /*
    public Page getChildPage() {
        return this;
    }
    */
}
