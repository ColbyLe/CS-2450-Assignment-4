import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
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
        Label header = new Label("What We're Reading");
        header.setStyle("-fx-font-size: 20; -fx-font-weight: bold");
        header.setAlignment(Pos.CENTER);

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
            ItemListingPage mainListing = new ItemListingPage(il, currentBook);
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
                ItemListingPage mainListing = new ItemListingPage(il, finalI);
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
        coverBox.setAlignment(Pos.CENTER);

        for(ImageView x:coverView) {
            coverBox.getChildren().addAll(x);
        }

        VBox pageBox = new VBox(header, mainImgBox, coverBox, getItemBox());
        pageBox.setPadding(new Insets(16,16,16,64));
        pageBox.setSpacing(20);
        pageBox.setAlignment(Pos.TOP_CENTER);

        return new HBox(getCategoryBox(), pageBox);
    }

    private Node getItemBox() {
        Label header = new Label("Staff Picks");
        header.setStyle("-fx-font-size: 20; -fx-font-weight: bold");

        String iType = "Book";
        Label[] resultTitles = new Label[4];
        Label[] resultType = new Label[4];
        Label[] resultInfo = new Label[4];
        Label[] resultSummary = new Label[4];
        VBox[] resultBox = new VBox[4];

        ItemListing il1 = new ItemListing(iType);

        for(int i=0; i<4; i++) {
            resultTitles[i] = new Label(il1.getTitle());
            resultType[i] = new Label(il1.getType());
            resultInfo[i] = new Label(il1.getInfo());
            resultSummary[i] = new Label(il1.getSummary());

            resultTitles[i].setWrapText(true);
            resultInfo[i].setWrapText(true);
            resultSummary[i].setWrapText(true);

            resultTitles[i].setStyle("-fx-font-size: 16px");

            resultBox[i] = new VBox(resultTitles[i], resultType[i], resultInfo[i], resultSummary[i]);
            resultBox[i].setPadding(new Insets(8,8,8,8));
            resultBox[i].setStyle("-fx-background-color: white; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.12), 3, 0, 1, 2)");
            /*
            resultBox[i].setOnMouseClicked(e-> {
                pStage.setScene(buildListingScene(pStage, topNav, bottomNav));
            });
            */

            int finalI = i;

            resultBox[i].setOnMouseEntered(e-> {
                resultBox[finalI].setStyle("-fx-background-color: white; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.25), 3, 0, 2, 4)");
            });

            resultBox[i].setOnMouseExited(e-> {
                resultBox[finalI].setStyle("-fx-background-color: white; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.12), 3, 0, 1, 2)");
            });

            resultBox[i].setOnMouseClicked(e-> {
                hasChild = true;
                ItemListing il = new ItemListing(iType);
                ItemListingPage lp = new ItemListingPage(il, 0);
                pageContent = lp.getContent();
                pageTitle = lp.getTitle();
            });
        }
        VBox itemBox = new VBox(header);
        itemBox.setSpacing(16);
        for(VBox x : resultBox) {
            itemBox.getChildren().add(x);
        }
        return itemBox;
    }

    private Node getCategoryBox() {
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
        categoryBox.setPadding(new Insets(48,8,8,8));
        categoryBox.setSpacing(8);
        categoryBox.setStyle("-fx-background-color: gray");
        for(Label x:categories) {
            x.setStyle("-fx-text-fill: white; -fx-font-size: 14");
            categoryBox.getChildren().add(x);

            x.setOnMouseClicked(e-> {
                System.out.println("Clicked element: " + x.getText());
                SearchPage cPage = new SearchPage(x.getText(), false);
                pageContent = cPage.getContent();
                pageTitle = x.getText();
                hasChild = true;
            });

            x.setOnMouseEntered(e-> {
                x.setStyle("-fx-underline: true; -fx-text-fill: white; -fx-font-size: 14");
            });

            x.setOnMouseExited(e-> {
                x.setStyle("-fx-underline: false; -fx-text-fill: white; -fx-font-size: 14");
            });
        }

        categories[1].setOnMouseClicked(e-> {
            System.out.println("Clicked element: " + categories[1].getText());
            pageContent = getEbooksPage();
            pageTitle = "eBooks";
            hasChild = true;
        });

        return categoryBox;
    }

    private Node getEbooksPage() {
        VBox[] iconBoxes = new VBox[5];

        Image[] icons = new Image[5];
        icons[0] = new Image("file:resources/images/hoopla.jpg");
        icons[1] = new Image("file:resources/images/rb.jpg");
        icons[2] = new Image("file:resources/images/overdrive.jpg");
        icons[3] = new Image("file:resources/images/tumble.jpg");
        icons[4] = new Image("file:resources/images/zinio.png");


        Label[] iconText = new Label[5];
        iconText[0] = new Label("Hoopla");
        iconText[1] = new Label("rbDigital");
        iconText[2] = new Label("OverDrive");
        iconText[3] = new Label("TumbleBooks");
        iconText[4] = new Label("Zinio");

        for(int i=0; i<5; i++) {
            int finalI = i;

            ImageView iconView = new ImageView(icons[i]);
            //iconView.setStyle("-fx-background-color: white; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.12), 3, 0, 1, 2)");

            iconText[i].setStyle("-fx-font-size: 14");
            iconBoxes[i] = new VBox(iconView, iconText[i]);
            iconBoxes[i].setAlignment(Pos.CENTER);
            iconBoxes[i].setMinSize(240,240);
            iconBoxes[i].setMaxWidth(528);
            iconBoxes[i].setMaxHeight(240);
            iconBoxes[i].setStyle("-fx-background-color: white");

            iconBoxes[i].setOnMouseEntered(e-> {
                iconBoxes[finalI].setStyle("-fx-background-color: white; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.25), 3, 0, 2, 4)");
            });

            iconBoxes[i].setOnMouseExited(e-> {
                iconBoxes[finalI].setStyle("-fx-background-color: white; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.12), 3, 0, 1, 2)");
            });
        }

        GridPane ePane = new GridPane();
        ePane.setHgap(48);
        ePane.setVgap(48);
        ePane.setAlignment(Pos.CENTER);
        ePane.setPadding(new Insets(48,16,32,16));
        ePane.add(iconBoxes[0], 0,0);
        ePane.add(iconBoxes[1], 1,0);
        ePane.add(iconBoxes[2], 0,1);
        ePane.add(iconBoxes[3], 1,1);

        VBox paneBox = new VBox(ePane, iconBoxes[4]);
        paneBox.setPadding(new Insets(48,16,32,16));
        paneBox.setAlignment(Pos.CENTER);

        Label title = new Label("eBooks");
        title.setStyle("-fx-font-size: 20; -fx-font-weight: bold");
        Label spiel = new Label("Browse for eBooks with one of our partners:");
        spiel.setStyle("-fx-font-size: 16");

        VBox contentBox = new VBox(title, spiel, ePane, iconBoxes[4]);
        contentBox.setAlignment(Pos.TOP_CENTER);
        contentBox.setPadding(new Insets(16,16,16,64));

        return new HBox(getCategoryBox(), contentBox);
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
