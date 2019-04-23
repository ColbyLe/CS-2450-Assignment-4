import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.application.Application;

public class PoconoMountainPL extends Application {
    Scene primaryScene;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        VBox homeBox = new VBox(getTopNav(), getHomepage(), getBottomNav());

        ScrollPane homePane = new ScrollPane(homeBox);
        homePane.setPrefViewportHeight(768);

        primaryScene = new Scene(homePane);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
    }

    private VBox getTopNav() {
        Image bannerImg = new Image("file:resources/images/banner.png");
        ImageView banner = new ImageView(bannerImg);
        Button[] loginB = new Button[2];
        loginB[0] = new Button("Log In");
        loginB[1] = new Button("Sign Up");

        for(Button x:loginB) {
            x.setPrefWidth(144);
            x.setPrefHeight(32);
            x.setAlignment(Pos.CENTER);
        }
        HBox buttonBar = new HBox(loginB[0], loginB[1]);
        buttonBar.setSpacing(32);
        buttonBar.setPadding(new Insets(32,32,0,32));
        buttonBar.setPrefWidth(384);
        buttonBar.setAlignment(Pos.BASELINE_CENTER);

        HBox bannerBar = new HBox(banner, buttonBar);

        Button[] navB = new Button[4];
        navB[0] = new Button("Home");
        navB[1] = new Button("Discover");
        navB[2] = new Button("Events");
        navB[3] = new Button("About");
        TextField searchBar = new TextField("Find books and more");

        for(Button x:navB){
            x.setPrefWidth(160);
            x.setPrefHeight(46);
            x.setAlignment(Pos.CENTER);
        }

        searchBar.setPrefWidth(384);
        searchBar.setPrefHeight(46);
        HBox navBar = new HBox(navB[0], navB[1], navB[2], navB[3], searchBar);

        VBox topNav = new VBox(bannerBar, navBar);
        topNav.setPrefWidth(1024);
        return topNav;
    }

    private HBox getBottomNav() {
        Hyperlink[] navLink = new Hyperlink[3];
        navLink[0] = new Hyperlink("Contact Us");
        navLink[1] = new Hyperlink("Site Map");
        navLink[2] = new Hyperlink("Privacy Policy");

        HBox botNav = new HBox(navLink[0], navLink[1], navLink[2]);
        botNav.setPrefHeight(64);
        botNav.setPadding(new Insets(8,8,8,8));
        botNav.setAlignment(Pos.CENTER_RIGHT);
        return botNav;
    }

    private VBox getHomepage() {
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
        VBox justInfo = new VBox(info);
        justInfo.setAlignment(Pos.CENTER);
        justInfo.setPadding(new Insets(24,24,32,24));
        justInfo.setSpacing(8);

        VBox homepage = new VBox(pm, newsBox, justInfo);
        return homepage;
    }


}
