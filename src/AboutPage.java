import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class AboutPage implements Page {

    private Node pageContent;
    private String pageTitle;
    private boolean hasChild;

    AboutPage() {
        pageContent = buildAboutpage();
        pageTitle = "About Us";
    }

    /*
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

        Label moreInfo = new Label("Mission & Vision Statements \n" +
                "\n" +
                "Mission Statement\n" +
                "Pocono Mountain Public Library strengthens the community by encouraging lifelong learning, stimulating intellectual curiosity, and promoting a literate and informed citizenry by providing a variety of information resources for all and enriching patrons’ lives through educational, cultural, and recreational programs.\n" +
                "\n" +
                "Vision Statement\n" +
                "Pocono Mountain Public Library envisions the following for the future of the library:\n" +
                "\n" +
                "Promoting the library as a community focal point\n" +
                "Maintaining an earnest focus on literacy\n" +
                "Identifying & meeting the informational needs of a changing population\n" +
                "Developing interesting & stimulating public programs\n" +
                "Investing in the most current & innovative technologies\n" +
                "Providing a skilled & knowledgeable staff\n" +
                "\n" +
                "Community Spaces\n" +
                "The R. Dale & Frances Hughes Community Room is a large conference room on the second floor that can be booked for large or small group or business meetings, as well as private parties. The rooms all have power point screens, access to power point projector, tables, chairs, Wi-Fi, hard wire network access, and teleconferencing (with advance booking). Some fees do apply,and a contract for using the room must be executed. Please call the library for rules and scheduling information. 570-894-8860\n" +
                "\n" +
                "The Library also has a small tutoring and conference room on the second floor that can accomodate 6 people. This room has a table, computer and white board for small group instruction, tutoring, home school and charter school use, proctor tests and other educational needs. Please call with any questions and to book it. 570-894-8860. There are no fees for this room if it is used for educational purposes.\n" +
                "\n" +
                "Community Outreach\n" +
                "The library director and other qualified library staff are available to come to your organization for library talks, library instruction, or other special library or literacy based events. Please contact the library director for more information. 570-894-8860\n" +
                "\n" +
                "Board of Trustees\n" +
                "Our dedicated, volunteer Board of Trustees are appointed from either Coolbaugh Township or Mount Pocono Borough, for three year appointments. People interested in serving on our board should contact a board officer or the library director. Board officers are expected to be involved in the community and assist with fundraising for the library.\n" +
                "\n" +
                "Danielle Rake, President (MPB) \n" +
                "Susan Miller, Vice-President (CT) \n" +
                "Phyllis Williams, Treasurer (CT) \n" +
                "Mary Mallard Barlieb, Secretary (CT) \n" +
                "Joyce Onsted (CT) \n" +
                "Jill Gunther (CT) \n" +
                "Stacy Stewart-Keeler (MPB) \n" +
                "vacant (MPB) \n" +
                "vacant (MPB) \n" +
                "\n" +
                "Library Board meetings are open to the public on the first Wednesday of each month at 7:00 pm in the second floor conference room.\n" +
                "\n" +
                "Library Director\n" +
                "Ann C. Shincovich, M.A., M.L.I.S.\n" +
                "Library Staff\n" +
                "Susanne: Children's Librarian \n" +
                "Linda: Circulation Manager \n" +
                "Lynn: Business Manager \n" +
                "Stephanie: Main Desk & Customer Service \n" +
                "Joe: Reference, Programs & Technology Librarian \n" +
                "Linnae: Cataloging Librarian \n" +
                "Mary Ann Lewis, YA Librarian (ALMC) \n" +
                "\n" +
                "Library Affiliations & Funding\n" +
                "Pocono Mountain Public Library belongs to the Easton District Libraries, and is a member of the Associated Libraries of Monroe County. \n" +
                "\n" +
                "The Libary receives annual State Aid from Pennsylvania Commonwealth Libraries, which is about 12% of our total operating budget, and one mill in tax support each from Mt. Pocono Borough and Coolbaugh Township which comprises the majority of our annual budget. We also receive one mill from Coolbaugh Township to support our new library building construction and bond repayment which ends in 2029. The Coolbaugh Township Supervisors are significant to the success of the library. \n" +
                "\n" +
                "As of 2018, the Library has received over $750,000 in major gifts from the R. Dale & Frances Hughes Foundation since 2012 for both capital and operating expenses.\n" +
                "Snow Closure\n" +
                "PMPL reserves the right to close for bad weather.\n" +
                "\n" +
                "If Pocono Mountain School District is CLOSED, the library is also CLOSED.\n" +
                "\n" +
                "Check the local listings on the tv or internet.\n" +
                "\n" +
                "Go to PMSD's Website\n" +
                "\n" +
                "No fines are charged for days the library is closed.\n" +
                "\n" +
                "Call 570-894-8860 if you have any questions.");
        info.setPrefWidth(976);
        importantInfo.setPrefWidth(976);
        moreInfo.setPrefWidth(976);
        importantInfo.setPadding(new Insets(5));
        importantInfo.setStyle("-fx-text-fill: yellow;" +
                "-fx-border-style: dotted;" +
                "-fx-background-color: gray;");
        VBox infoBox = new VBox(info, importantInfo, moreInfo);
        infoBox.setAlignment(Pos.CENTER);
        infoBox.setPadding(new Insets(24,24,32,24));
        infoBox.setSpacing(8);

        return new VBox(infoBox);
    }
    */

    public Node buildAboutpage() {
        return swapGeneralPage();
    }

    public Node getCategoryBox() {
        Label[] categories = new Label[4];
        categories[0] = new Label("General");
        categories[1] = new Label("Community Services");
        categories[2] = new Label("Staff");
        categories[3] = new Label("Board of Trustees");

        VBox categoryBox = new VBox();
        categoryBox.setPrefWidth(160);
        categoryBox.setPrefHeight(1024);
        categoryBox.setPadding(new Insets(48,8,8,8));
        categoryBox.setSpacing(8);
        categoryBox.setStyle("-fx-background-color: gray");
        for(Label x:categories) {
            x.setStyle("-fx-text-fill: white; -fx-font-size: 14");
            categoryBox.getChildren().add(x);

            x.setOnMouseEntered(e-> {
                x.setStyle("-fx-underline: true; -fx-text-fill: white; -fx-font-size: 14");
            });

            x.setOnMouseExited(e-> {
                x.setStyle("-fx-underline: false; -fx-text-fill: white; -fx-font-size: 14");
            });
        }

        categories[0].setOnMouseClicked(e-> {
            pageContent = swapGeneralPage();
            hasChild = true;
        });

        categories[1].setOnMouseClicked(e-> {
            pageContent = swapCommPage();
            hasChild = true;
        });

        categories[2].setOnMouseClicked(e-> {
            pageContent = swapStaffPage();
        });

        categories[3].setOnMouseClicked(e-> {
            swapBoardPage();
        });

        return categoryBox;
    }

    public Node swapGeneralPage() {
        Label title = new Label ("About Us");
        Label[] boxTitles = new Label[4];
        Text[] boxText = new Text[4];

        boxTitles[0] = new Label("Mission Statement");
        boxTitles[1] = new Label("Vision Statement");
        boxTitles[2] = new Label("Location");
        boxTitles[3] = new Label("Hours of Operation");

        boxText[0] = new Text("Pocono Mountain Public Library strengthens the community by encouraging lifelong learning, " +
                "stimulating intellectual curiosity, and promoting a literate and informed citizenry " +
                "by providing a variety of information resources for all " +
                "and enriching patrons’ lives through educational, cultural, and recreational programs.");

        boxText[1] = new Text("Pocono Mountain Public Library envisions the following for the future of the library:\n" +
                "Promoting the library as a community focal point\n" +
                "Maintaining an earnest focus on literacy\n" +
                "Identifying & meeting the informational needs of a changing population\n" +
                "Developing interesting & stimulating public programs\n" +
                "Investing in the most current & innovative technologies\n" +
                "Providing a skilled & knowledgeable staff\n");

        boxText[2] = new Text("Pocono Mountain Public Library \n" +
                "5500 Municipal Drive \n" +
                "Coolbaugh Township Municipal Center \n" +
                "Tobyhanna, PA 18466 \n" +
                "\n" +
                "Phone: (570) 894-8860 \n" +
                "Fax: (570) 894-8852");

        boxText[3] = new Text("Monday: 10:00 am - 6:00 pm \n" +
                "Tuesday: 10:00 am - 5:00 pm \n" +
                "Wednesday: 12:00 pm - 8:00 pm \n" +
                "Thursday: 10:00 am - 5:00 pm \n" +
                "Friday: 12:00 pm - 4:00 pm \n" +
                "Saturday: 12:00 pm - 4:00 pm \n" +
                "Sunday: Closed\n");

        VBox textBox = new VBox(title);
        for(int i=0; i<4; i++) {
            boxText[i].setWrappingWidth(840);
            textBox.getChildren().add(boxTitles[i]);
            textBox.getChildren().add(boxText[i]);
        }

        HBox contentBox = new HBox(getCategoryBox(), textBox);
        pageTitle = "About Us";
        return contentBox;
    }

    public Node swapCommPage() {
        Label title = new Label("Community Services");
        pageTitle = "Community Services";
        Label[] boxTitles = new Label[2];
        Text[] boxText = new Text[2];

        boxTitles[0] = new Label("Community Spaces");
        boxTitles[1] = new Label("Community Outreach");

        boxText[0] = new Text("The R. Dale & Frances Hughes Community Room is a large conference room on the second floor " +
                "that can be booked for large or small group or business meetings, " +
                "as well as private parties. The rooms all have power point screens, " +
                "access to power point projector, tables, chairs, Wi-Fi, hard wire network access, " +
                "and teleconferencing (with advance booking). Some fees do apply,and a contract for using the room must be executed. " +
                "Please call the library for rules and scheduling information.");
        boxText[1] = new Text("The library director and other qualified library staff are available to come to your organization for library talks, " +
                "library instruction, or other special library or literacy based events. " +
                "Please contact the library director for more information.\n");

        VBox textBox = new VBox(title);
        for(int i=0; i<2; i++) {
            boxText[i].setWrappingWidth(840);
            textBox.getChildren().add(boxTitles[i]);
            textBox.getChildren().add(boxText[i]);
        }

        pageTitle = "Community Services";
        return new HBox(getCategoryBox(), textBox);
    }

    public Node swapStaffPage() {
        Label title = new Label("Our Staff");
        Label[] staffTitles = new Label[8];
        Label[] staffNames = new Label[8];

        staffTitles[0] = new Label("Library Director:");
        staffNames[0] = new Label("\tAnn C. Shincovich, M.A., M.L.I.S.");

        staffTitles[1] = new Label("Circulation Manager:");
        staffNames[1] = new Label("\tLinda Davis");

        staffTitles[2] = new Label("Business Manager:");
        staffNames[2] = new Label("\tLynn Wesley");

        staffTitles[3] = new Label("Customer Service:");
        staffNames[3] = new Label("\tStephanie Moore");

        staffTitles[4] = new Label("Cataloging Librarian:");
        staffNames[4] = new Label("\tLinnae Allen");

        staffTitles[5] = new Label("Reference, Programs, and Technology Librarian:");
        staffNames[5] = new Label("\tJoe Nelson");

        staffTitles[6] = new Label("Childrens' Librarian:");
        staffNames[6] = new Label("\tSusanne Doe");

        staffTitles[7] = new Label("YA Librarian:");
        staffNames[7] = new Label("\tMary Ann Lewis");

        VBox textBox = new VBox(title);

        for(int i=0; i<8; i++) {
            textBox.getChildren().add(staffTitles[i]);
            textBox.getChildren().add(staffNames[i]);
        }

        pageTitle = "Our Staff";

        return new HBox(getCategoryBox(), textBox);
    }

    public void swapBoardPage() {

        pageTitle = "Board of Trustees";
    }

    public Node getContent() {
        return pageContent;
    }

    // getTitle returns the page title
    public String getTitle() {
        return pageTitle;
    }

    public boolean spawnsChildPage() {
        return hasChild;
    }
}
