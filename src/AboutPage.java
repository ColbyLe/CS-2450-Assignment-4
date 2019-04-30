import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class AboutPage implements Page {

    private Node pageContent;
    private String pageTitle;

    AboutPage() {
        pageContent = buildAboutpage();
        pageTitle = "About Us";
    }

    private static VBox buildAboutpage() {
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
        Label importantInfo = new Label("The library is closed on Sundays and some holidays. \n" +
                "\n" +
                "The library follows bad weather closing & snow days based on Pocono Mt. School District. See www.pmsd.org for more information. \n" +
                "You can also find the information on network TV news scroll, or via our facebook page. ");
        info.setPrefWidth(976);
        importantInfo.setPrefWidth(976);
        importantInfo.setPadding(new Insets(5));
        importantInfo.setStyle("-fx-text-fill: yellow;" +
                "-fx-border-style: dotted;" +
                "-fx-background-color: gray;");
        VBox infoBox = new VBox(info, importantInfo);
        infoBox.setAlignment(Pos.CENTER);
        infoBox.setPadding(new Insets(24,24,32,24));
        infoBox.setSpacing(8);

        return new VBox(infoBox);
    }

    public Node getContent() {
        return pageContent;
    }

    // getTitle returns the page title
    public String getTitle() {
        return pageTitle;
    }

    public boolean spawnsChildPage() {
        return false;
    }
}
