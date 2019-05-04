import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SearchPage implements Page {
    private Node pageContent, topNav, bottomNav;
    private String pageTitle, searchString, category;
    private boolean hasChild;

    public SearchPage(String searchedString, boolean isSearch) {
        hasChild = true;
        if(isSearch) {
            category = "Book";
            pageTitle = " Results for: \"" + searchedString + "\"";
        }

        else {
            category = searchedString;
            pageTitle = " " + searchedString;
        }

        if(!searchedString.equals("")) {
            pageContent = buildSearchpage(searchedString);
        }
        else {
            pageContent = buildBlankPage();
        }

        // System.out.println("Searched string: " + searchedString);
        // System.out.println("Page title: " + pageTitle);
    }

    private Node buildSearchpage(String searchString) {
        Label searchLabel = new Label(pageTitle);
        Label[] resultTitles = new Label[5];
        Label[] resultType = new Label[5];
        Label[] resultInfo = new Label[5];
        Label[] resultSummary = new Label[5];
        VBox[] resultBox = new VBox[5];

        searchLabel.setStyle("-fx-font-size: 20; -fx-font-weight: bold");
        ItemListing il1 = new ItemListing(category);

        for(int i=0; i<5; i++) {
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
                ItemListing il = new ItemListing(category);
                ItemListingPage lp = new ItemListingPage(il, 0);
                pageContent = lp.getContent();
                pageTitle = lp.getTitle();
            });
        }

        VBox searchContent = new VBox(searchLabel);
        searchContent.setPadding(new Insets(8,16,32,16));
        searchContent.setSpacing(32);
        searchContent.setAlignment(Pos.CENTER);

        for(VBox x : resultBox) {
            searchContent.getChildren().add(x);
        }

        return new HBox(getCategoryBox(), searchContent);
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

        VBox categoryBar = new VBox();
        categoryBar.setPrefWidth(160);
        categoryBar.setPrefHeight(1024);
        categoryBar.setPadding(new Insets(48,8,8,8));
        categoryBar.setSpacing(8);
        categoryBar.setStyle("-fx-background-color: gray");
        for(Label x:categories) {
            x.setStyle("-fx-text-fill: white; -fx-font-size: 14");
            categoryBar.getChildren().add(x);

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

        return categoryBar;
    }

    private Node buildBlankPage() {
        Label searchLabel = new Label("Results for: \"\"");
        return new HBox(getCategoryBox(), searchLabel);
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


    public void setSearchString(String s) {
        searchString = s;
    }

    public Node getContent() {
        return pageContent;
    }

    @Override
    public boolean spawnsChildPage() {
        return hasChild;
    }


    public String getTitle() {
        return pageTitle;
    }
}
