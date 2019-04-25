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

    public SearchPage(String searchString, Stage primaryStage, Node tNav, Node bNav) {
        if(!searchString.equals("")) {
            topNav = tNav;
            bottomNav = bNav;
            pageContent = buildSearchpage(searchString, primaryStage);
        }
        else {
            pageContent = buildBlankPage();
        }
        pageTitle = "Results for: \"" + searchString + "\"";
    }

    private VBox buildSearchpage(String searchString, Stage pStage) {
        Label searchLabel = new Label("Results for: \"" + searchString + "\"");
        Label[] resultTitles = new Label[5];
        Label[] resultInfo = new Label[5];
        Label[] resultSummary = new Label[5];
        VBox[] resultBox = new VBox[5];

        searchLabel.setStyle("-fx-font-size: 20");

        for(int i=0; i<5; i++) {
            resultTitles[i] = new Label("This is a Book");
            resultInfo[i] = new Label("Call Number: A9EF74792027\nType: Book\nAuthor: John Doe III\nPublisher: [New York, N.Y.] : Hanover Square Press : Harlequin Enterprises, Limited, 2019.\n" +
                    "©2019\nDescription: 336 pages : illustrations ; 24 cm\n");
            resultSummary[i] = new Label("Lorem ipsum dolor sit amet, consectetur adipiscing elit,\n" +
                    "                    sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
                    "                    Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip\n" +
                    "                    ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore\n" +
                    "                    eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident,\n" +
                    "                    sunt in culpa qui officia deserunt mollit anim id est laborum.");

            resultTitles[i].setWrapText(true);
            resultInfo[i].setWrapText(true);
            resultSummary[i].setWrapText(true);

            resultTitles[i].setStyle("-fx-font-size: 16px");

            resultBox[i] = new VBox(resultTitles[i], resultInfo[i], resultSummary[i]);
            resultBox[i].setPadding(new Insets(8,8,8,8));
            resultBox[i].setStyle("-fx-background-color: white; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.12), 3, 0, 1, 2)");
            resultBox[i].setOnMouseClicked(e-> {
                pStage.setScene(buildListingScene(pStage, topNav, bottomNav));
            });

            final int finalI = i;

            resultBox[i].setOnMouseEntered(e-> {
                resultBox[finalI].setStyle("-fx-background-color: white; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.25), 3, 0, 2, 4)");
            });

            resultBox[i].setOnMouseExited(e-> {
                resultBox[finalI].setStyle("-fx-background-color: white; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.12), 3, 0, 1, 2)");
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

    private Scene buildListingScene(Stage pStage, Node topNav, Node bottomNav) {
        ListingPage lp = new ListingPage();
        VBox content = new VBox(topNav, lp.getContent(), bottomNav);
        Scene s1 = new Scene(content);
        s1.getStylesheets().add("main.css");

        return s1;
    }

    public void setSearchString(String s) {
        searchString = s;
    }

    public Node getContent() {
        return pageContent;
    }

    public String getTitle() {
        return pageTitle;
    }
}
