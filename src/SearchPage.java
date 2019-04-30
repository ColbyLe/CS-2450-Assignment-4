import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SearchPage implements Page {
    private Node pageContent, topNav, bottomNav;
    private String pageTitle, searchString;
    private boolean hasChild;

    public SearchPage(String searchedString, Stage primaryStage, Node tNav, Node bNav) {
        if(!searchedString.equals("")) {
            topNav = tNav;
            bottomNav = bNav;
            pageContent = buildSearchpage(searchedString, primaryStage);
        }
        else {
            pageContent = buildBlankPage();
        }

        hasChild = false;

        pageTitle = "Results for: \"" + searchedString + "\"";
    }

    private VBox buildSearchpage(String searchString, Stage pStage) {
        Label searchLabel = new Label("Results for: \"" + searchString + "\"");
        Label[] resultTitles = new Label[5];
        Label[] resultType = new Label[5];
        Label[] resultInfo = new Label[5];
        Label[] resultSummary = new Label[5];
        VBox[] resultBox = new VBox[5];

        searchLabel.setStyle("-fx-font-size: 20");
        ItemListing il1 = new ItemListing("Book");

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

            final int finalI = i;

            resultBox[i].setOnMouseEntered(e-> {
                resultBox[finalI].setStyle("-fx-background-color: white; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.25), 3, 0, 2, 4)");
            });

            resultBox[i].setOnMouseExited(e-> {
                resultBox[finalI].setStyle("-fx-background-color: white; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.12), 3, 0, 1, 2)");
            });

            resultBox[i].setOnMouseClicked(e-> {
                hasChild = true;
                ItemListing il = new ItemListing("Book");
                ListingPage lp = new ListingPage(il);
                pageContent = lp.getContent();
            });
        }

        VBox content = new VBox(searchLabel);
        content.setPadding(new Insets(8,16,32,16));
        content.setSpacing(32);

        for(int i=0; i<5; i++) {
            content.getChildren().add(resultBox[i]);
        }
        return content;
    }

    private Node buildBlankPage() {
        Label searchLabel = new Label("Results for: \"\"");
        return new VBox(searchLabel);
    }

    /*
    private Scene buildListingScene(Stage pStage, Node topNav, Node bottomNav) {
        ListingPage lp = new ListingPage(new ItemListing("Book"));
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

    public Page getChildPage() {
        return new ListingPage(new ItemListing("Book"));
    }

    public String getTitle() {
        return pageTitle;
    }
}
