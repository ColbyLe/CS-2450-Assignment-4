import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Homepage implements Page{
    private VBox homeBox;

    Homepage() {
        homeBox = getHomepage();
    }

    public VBox getContent() {
        return homeBox;
    }

    private static VBox getHomepage() {
        Image pmImg = new Image("file:resources/images/MP_overlook.jpg");
        ImageView pm = new ImageView(pmImg);

        Label newsLabel = new Label("What's New at PMPL");
        newsLabel.setPrefWidth(976);
        newsLabel.setAlignment(Pos.BASELINE_LEFT);

        Label[] newsInfo = new Label[4];
        for(int i=0; i<4; i++) {
            newsInfo[i] = new Label("Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
                    "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                    "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip " +
                    "ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore " +
                    "eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, " +
                    "sunt in culpa qui officia deserunt mollit anim id est laborum.");
            newsInfo[i].setPrefWidth(976);
            newsInfo[i].setWrapText(true);

        }

        Label[] newsTitles = new Label[4];
        for(int i=0; i<4; i++) {
            newsTitles[i] = new Label("Lorem ipsum dolor sit amet");
            newsTitles[i].setPrefWidth(976);
            newsTitles[i].setAlignment(Pos.BASELINE_LEFT);
        }

        VBox newsBox = new VBox(newsLabel, newsTitles[0], newsInfo[0], newsTitles[1], newsInfo[1], newsTitles[2], newsInfo[2], newsTitles[3], newsInfo[3]);
        newsBox.setPadding(new Insets(32,24,32,24));
        newsBox.setSpacing(8);

        Label info = new Label("PMPL HOURS OF OPERATION:\n" +
                "Monday 10:00 am - 6:00 pm \n" +
                "Tuesday 10:00 am - 5:00 pm \n" +
                "Wednesday 12:00 pm - 8:00 pm \n" +
                "Thursday 10:00 am - 5:00 pm \n" +
                "Friday 12:00 pm - 4:00 pm \n" +
                "Saturday 12:00 pm - 4:00 pm \n" +
                "\n" +
                "\n" +
                "Pocono Mountain Public Library \n" +
                "5500 Municipal Drive \n" +
                "Coolbaugh Township Municipal Center \n" +
                "Tobyhanna, PA 18466 \n" +
                "\n" +
                "\n" +
                "Phone: (570) 894-8860 \n" +
                "Fax: (570) 894-8852");
        info.setPrefWidth(976);
        VBox infoBox = new VBox(info);
        infoBox.setAlignment(Pos.CENTER);
        infoBox.setPadding(new Insets(24,24,32,24));
        infoBox.setSpacing(8);

        return new VBox(pm, newsBox, infoBox);
    }
}
