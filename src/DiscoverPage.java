import javafx.scene.Node;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.VBox;

public class DiscoverPage implements Page {
    private Node pageContent;
    private String pageTitle;

    public DiscoverPage() {
        pageContent = buildDiscoverPage();
        pageTitle = "Discover";
    }

    private static Node buildDiscoverPage() {
        Hyperlink[] categories = new Hyperlink[10];
        categories[0] = new Hyperlink("Books");
        categories[1] = new Hyperlink("eBooks");
        categories[2] = new Hyperlink(("Audiobooks"));
        categories[3] = new Hyperlink("Newspaper Articles");
        categories[4] = new Hyperlink("Journal Articles");
        categories[5] = new Hyperlink("VHS");
        categories[6] = new Hyperlink("DVD");
        categories[7] = new Hyperlink("Blu-ray");
        categories[8] = new Hyperlink("Maps");
        categories[9] = new Hyperlink("Government Documents");

        VBox categoryBox = new VBox();
        categoryBox.setPrefWidth(320);
        categoryBox.setPrefHeight(1024);

        for(Hyperlink x:categories) {
            categoryBox.getChildren().add(x);
        }



        return null;
    }

    @Override
    public Node getContent() {
        return pageContent;
    }

    @Override
    public String getTitle() {
        return pageTitle;
    }

    @Override
    public boolean spawnsChildPage() {
        return false;
    }

    @Override
    public Page getChildPage() {
        return this;
    }
}
