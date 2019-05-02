public class ItemListing {
    private String title, type, info, summary;

    public ItemListing(String itemType) {
        title = "This is a " + itemType;
        type = itemType;
        info = "Call Number: A9EF74792027\nAuthor: John Doe III\nPublisher: [New York, N.Y.] : Hanover Square Press : Harlequin Enterprises, Limited, 2019.\n" +
                "©2019\nDescription: 336 pages : illustrations ; 24 cm\n";
        summary = "Lorem ipsum dolor sit amet, consectetur adipiscing elit,\n" +
                "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
                "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip\n" +
                "ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore\n" +
                "eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident,\n" +
                "sunt in culpa qui officia deserunt mollit anim id est laborum.";
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getInfo() {
        return info;
    }

    public String getSummary() {
        return summary;
    }
}
