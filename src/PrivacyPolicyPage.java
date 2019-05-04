import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;

public class PrivacyPolicyPage implements Page {
    Node pageContent;
    String pageTitle;

    public PrivacyPolicyPage() {
        pageContent = buildPPPage();
        pageTitle = "Privacy Policy";
    }

    public Node getContent() {
        return pageContent;
    }

    public Node buildPPPage() {
        Label pp = new Label("Our Privacy Policy");
        pp.setStyle("-fx-font-size: 24; -fx-font-weight: bold");
        Image zucc = new Image("file:resources/images/ZUCC.jpg");
        ImageView goZuckYourself = new ImageView(zucc);
        VBox stuff = new VBox(pp, goZuckYourself);
        stuff.setPadding(new Insets(8,8,63,8));
        //stuff.setPrefHeight(576);
        stuff.setAlignment(Pos.CENTER);
        return stuff;
    }

    @Override
    public String getTitle() {
        return pageTitle;
    }

    @Override
    public boolean spawnsChildPage() {
        return false;
    }

}
