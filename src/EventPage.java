import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class EventPage implements Page {
    private Node pageContent;
    private String pageTitle;

    EventPage() {
        pageContent = buildEventpage();
        pageTitle = "Events";
    }

    private static Node buildEventpage() {
        Image eMusk = new Image("file:resources/images/ElectricSpaceMan.jpg");
        ImageView imgBox = new ImageView(eMusk);
        ImageView imgBox1 = new ImageView(eMusk);
        ImageView imgBox2 = new ImageView(eMusk);

        Label kidsTitle = new Label("PMPL Kids Program");
        Label teensTitle = new Label("PMPL Teens Program");
        Label adultsTitle = new Label("PMPL Adults Program");

        Label kidsText = new Label("Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
                "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip " +
                "ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore " +
                "eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, " +
                "sunt in culpa qui officia deserunt mollit anim id est laborum.");
        Label teensText = new Label("Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
                "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip " +
                "ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore " +
                "eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, " +
                "sunt in culpa qui officia deserunt mollit anim id est laborum.");
        Label adultsText = new Label("Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
                "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip " +
                "ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore " +
                "eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, " +
                "sunt in culpa qui officia deserunt mollit anim id est laborum.");
        kidsText.setWrapText(true);
        teensText.setWrapText(true);
        adultsText.setWrapText(true);

        VBox kids = new VBox(kidsTitle, imgBox, kidsText);
        VBox teens = new VBox(teensTitle, imgBox1, teensText);
        VBox adults = new VBox(adultsTitle, imgBox2, adultsText);

        VBox[] panels = {kids, teens, adults};


        for(int i = 0; i < panels.length; i++) {
            panels[i].setPrefWidth(976);
            panels[i].setAlignment(Pos.CENTER);
            panels[i].setPadding(new Insets(24, 24, 32, 24));
        }

        return new VBox(kids, teens, adults);
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
