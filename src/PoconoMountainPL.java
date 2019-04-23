import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
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
        Homepage home = new Homepage();

        VBox homeBox = new VBox(getTopNav(), home.getContent(), getBottomNav());

        ScrollPane homePane = new ScrollPane(homeBox);
        homePane.setPrefViewportHeight(768);

        primaryScene = new Scene(homePane);
        primaryScene.getStylesheets().add("main.css");
        primaryStage.setScene(primaryScene);
        primaryStage.show();
    }

    private static VBox getTopNav() {
        Image bannerImg = new Image("file:resources/images/banner.png");
        ImageView banner = new ImageView(bannerImg);
        /*
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
        */
        HBox bannerBar = new HBox(banner);

        Button[] navB = new Button[4];
        navB[0] = new Button("Home");
        navB[1] = new Button("Discover");
        navB[2] = new Button("Events");
        navB[3] = new Button("About");
        TextField searchBar = new TextField("Find books and more");
        for(Button x:navB) {
            x.setOnMouseEntered(e -> {
                x.setStyle("-fx-background-color: rgb(0,131,131)");
            });

            x.setOnMouseExited(e -> {
                x.setStyle("-fx-background-color:  rgb(0,121,121)");
            });
        }


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

    private static HBox getBottomNav() {
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
}
