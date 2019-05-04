import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
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

        HBox retContent = new HBox(getCategoryBar(), searchContent);
        return retContent;
    }

    private Node getCategoryBar() {
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

        return categoryBar;
    }

    private Node buildBlankPage() {
        Label searchLabel = new Label("Results for: \"\"");
        return new VBox(searchLabel);
    }

    /*
    private Scene buildListingScene(Stage pStage, Node topNav, Node bottomNav) {
        ItemListingPage lp = new ItemListingPage(new ItemListing("Book"));
        VBox content = new VBox(topNav, lp.getContent(), bottomNav);
        Scene s1 = new Scene(content);
        s1.getStylesheets().add("main.css");

        return s1;
    }
    */

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

    /*
    public Page getChildPage() {
        return new ItemListingPage(new ItemListing("Book"), 0);
    }
    */

    public String getTitle() {
        return pageTitle;
    }
}
