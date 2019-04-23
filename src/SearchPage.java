import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class SearchPage implements Page {
    private Node pageContent;
    private String pageTitle;

    public SearchPage(String searchString) {
        if(!searchString.equals("")) {
            pageContent = buildSearchpage(searchString);
        }
        else {
            pageContent = buildBlankPage();
        }
        pageTitle = "Results for: \"" + searchString + "\"";
    }

    private VBox buildSearchpage(String searchString) {
        Label searchLabel = new Label("Results for: \"" + searchString + "\"");
        Label[] resultTitles = new Label[5];
        Label[] resultInfo = new Label[5];
        Label[] resultSummary = new Label[5];
        VBox[] resultBox = new VBox[5];

        searchLabel.setStyle("-fx-font-size: 20");

        for(int i=0; i<5; i++) {
            resultTitles[i] = new Label("This is a Book");
            resultInfo[i] = new Label("Call Number: A9EF74792027\nAuthor: John Doe III\nPublisher: [New York, N.Y.] : Hanover Square Press : Harlequin Enterprises, Limited, 2019.\n" +
                    "©2019\nDescription: 336 pages : illustrations ; 24 cm\n");
            resultSummary[i] = new Label("\"Lorem ipsum dolor sit amet, consectetur adipiscing elit, \" +\n" +
                    "                    \"sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. \" +\n" +
                    "                    \"Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip \" +\n" +
                    "                    \"ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore \" +\n" +
                    "                    \"eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, \" +\n" +
                    "                    \"sunt in culpa qui officia deserunt mollit anim id est laborum.\"");

            resultTitles[i].setWrapText(true);
            resultInfo[i].setWrapText(true);
            resultSummary[i].setWrapText(true);

            resultTitles[i].setStyle("-fx-font-size: 16px");

            resultBox[i] = new VBox(resultTitles[i], resultInfo[i], resultSummary[i]);
            resultBox[i].setOnMouseClicked(e-> {
                Page listing = new ListingPage();
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

    private VBox buildBlankPage() {
        Label searchLabel = new Label("Results for: \"\"");
        return new VBox(searchLabel);
    }

    public Node getContent() {
        return pageContent;
    }

    public String getTitle() {
        return pageTitle;
    }
}
