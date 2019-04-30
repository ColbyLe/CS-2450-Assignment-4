import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;

public class PrivacyPolicyPage implements Page {

    public PrivacyPolicyPage() {}

    @Override
    public Node getContent() {
        Label spiel = new Label("We reserve the right to collect all of your data.");
        Text pp = new Text("The Pocono Mountain Public Library collects data from you, " +
                "through our interactions with you and through our products. " +
                "You provide some of this data directly, and we get some of it by collecting data about your interactions, " +
                "use, and experiences with our products. " +
                "The data we collect depends on the context of your interactions with the Pocono Mountain Public Library and the choices you make, " +
                "including your privacy settings and the products and features you use. We also obtain data about you from third parties.\n" +
                "\n" +
                "If you represent an organization, such as a business or school, " +
                "that utilizes Enterprise and Developer Products from the Pocono Mountain Public Library, " +
                "please see the Enterprise and developer products section of this privacy statement to learn how we process your data.\n" +
                "\n" +
                "You have choices when it comes to the technology you use and the data you share. When we ask you to provide personal data, " +
                "you can decline. Many of our products require some personal data to provide you with a service. " +
                "If you choose not to provide data necessary to provide you with a product or feature, " +
                "you cannot use that product or feature. " +
                "Likewise, where we need to collect personal data by law or to enter into or carry out a contract with you, " +
                "and you do not provide the data, we will not be able to enter into the contract; " +
                "or if this relates to an existing product you’re using, we may have to suspend or cancel it. " +
                "We will notify you if this is the case at the time. Where providing the data is optional, " +
                "and you choose not to share personal data, " +
                "features like personalization that use such data will not work for you.");
        pp.setBoundsType(TextBoundsType.VISUAL);
        VBox stuff = new VBox(spiel, pp);
        return stuff;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public boolean spawnsChildPage() {
        return false;
    }

}
