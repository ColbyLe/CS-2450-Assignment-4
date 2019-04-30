import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.application.Application;

public class PoconoMountainPL extends Application {
    private Scene primaryScene;
    private TextField searchBar;
    private Node pageContent;
    private Page activePage;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        HomePage home = new HomePage();
        showPage(home, primaryStage);
        // display stage
        primaryStage.show();
    }

    private VBox getTopNav(Stage primaryStage) {
        Image bannerImg = new Image("file:resources/images/banner.png");
        ImageView banner = new ImageView(bannerImg);
        banner.setOnMouseClicked(e-> {
            showPage(new HomePage(), primaryStage);
        });

        searchBar = new TextField("Search our inventory");

        searchBar.setOnMouseClicked(e-> {
            searchBar.setText("");
        });

        searchBar.setPrefWidth(384);
        searchBar.setPrefHeight(46);

        HBox bannerBar = new HBox(banner);

        Button[] navB = new Button[4];
        navB[0] = new Button("Home");

        // Button actions should call showPage, passing a new instance of the appropriate Page class and the primary stage
        navB[0].setOnAction(e-> {
            showPage(new HomePage(), primaryStage);
        });

        navB[1] = new Button("Discover");
        // dummy event handler
        navB[1].setOnAction(e-> {
            showPage(new DiscoverPage(), primaryStage);

            /*
            VBox blank1 = new VBox();
            VBox pageBox = new VBox(getTopNav(primaryStage), blank1, getBottomNav(primaryStage));
            primaryScene = new Scene(pageBox);
            primaryStage.setScene(primaryScene);
            */
        });

        navB[2] = new Button("Events");
        navB[2].setOnAction(e-> {

        });


        navB[3] = new Button("About");
        navB[3].setOnAction(e-> {

        });

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


        HBox navBar = new HBox(navB[0], navB[1], navB[2], navB[3], searchBar);

        VBox topNav = new VBox(bannerBar, navBar);
        topNav.setPrefWidth(1024);
        return topNav;
    }

    private HBox getBottomNav(Stage primaryStage) {
        Hyperlink[] navLink = new Hyperlink[2];
        navLink[0] = new Hyperlink("Contact Us");
        navLink[1] = new Hyperlink("Privacy Policy");
        for(Hyperlink x:navLink) {
            x.setStyle("-fx-text-fill: black");
        }

        HBox botNav = new HBox(navLink[0], navLink[1]);
        botNav.setPrefHeight(64);
        botNav.setPadding(new Insets(8,8,8,8));
        botNav.setAlignment(Pos.CENTER_RIGHT);
        botNav.setStyle("-fx-background-color: rgb(0,121,121);");
        return botNav;
    }

    private HBox getSortBar() {
        ComboBox typeBox = new ComboBox();
        typeBox.getItems().addAll("All Types", "Book", "Journal", "Audiobook", "eBook", "VHS", "DVD", "Blu-Ray");

        Label typeLabel = new Label("Type");
        return new HBox(typeLabel, typeBox);
    }

    private void showPage(Page p, Stage primaryStage) {
        // get page content, then place in VBox between top nav bar and bottom nav bar

        // on search, pass text of searchBar to activePage

        Node extra;
        if(p.getClass().equals("SearchPage")) {
            extra = getSortBar();
        }
        else {
            extra = new HBox();
        }

        pageContent = p.getContent();
        pageContent.setOnMouseClicked(e-> {
            if(p.spawnsChildPage()) {
                showPage(p.getChildPage(), primaryStage);
            }
        });

        VBox pageBox = new VBox(getTopNav(primaryStage), extra, pageContent, getBottomNav(primaryStage));

        System.out.println(p.getClass());

        // add pageBox to ScrollPane
        ScrollPane pagePane = new ScrollPane(pageBox);
        pagePane.setPrefViewportHeight(768);
        pagePane.setPrefViewportWidth(1024);

        // set primary scene and add stylesheet
        primaryScene = new Scene(pagePane);
        primaryScene.getStylesheets().add("main.css");

        // set functionality for search bar
        primaryScene.setOnKeyPressed(e-> {
            if(e.getCode() == KeyCode.ENTER) {
                if(!(searchBar.getText().equals(""))) {
                    showPage(new SearchPage(searchBar.getText(), primaryStage, getTopNav(primaryStage), getBottomNav(primaryStage)), primaryStage);
                }
            }
        });

        // set primary stage
        primaryStage.setScene(primaryScene);
        primaryStage.setMaxWidth(1055);
        primaryStage.setTitle(p.getTitle());
    }
}
