import javafx.scene.image.Image;

public class EventListing {
    private Image eventImage;
    private String name, datetime, description;

    public EventListing(int i) {
        switch(i) {
            case 1:
                eventImage = new Image("file:resources/images/event2.jpg");
                name = "Free Shredding Truck Event";
                datetime = "5/3/2019 9:00AM to 12:00PM";
                description = "Shred your documents at the mobile truck in our neighborhood. " +
                        "Destroy old documents, protect personal information, help the environment and gain space!" +
                        "The truck will be located at the curb outside the library, and is equipped with a video monitoring system for secure, onsite shredding.";
                break;
            case 2:
                eventImage = new Image("file:resources/images/event1.jpg");
                name = "May 4th Coloring";
                datetime = "05/04/2019 9:30AM to 5:00PM";
                description = "May the 4th be with you on this Star Wars coloring day.  " +
                        "Everybody is welcome to come in to color some special themed pages.";
                break;
            case 3:
                eventImage = new Image("file:resources/images/event3.jpg");
                name = "Childrens' Story Time";
                datetime = "Saturdays 10:30AM to 11:30AM";
                description = "Do you struggle with parenting? " +
                        "Are your kids between the ages of 4 and 10? " +
                        "Wish someone else would raise them, but can't afford daycare? " +
                        "Then PMPL's Childrens' Story Time is the solution for you!";
                break;
            case 4:
                eventImage = new Image("file:resources/images/event4.jpg");
                name = "US Citizenship Classes";
                datetime = "Fridays 9:30AM to 12:30PM";
                description = "Would you like to become a U.S. Citizen? " +
                        "Join our citizenship classes to prepare for the Naturalization Interview, " +
                        "learn the English language, " +
                        "gain the subject knowledge to successfully pass your interview, " +
                        "and get help filling out and submitting your N400 form.";
                break;
            default:
                eventImage = new Image("file:resources/images/event0.png");
                name = "Adult Literacy Tutoring";
                datetime = "Fridays 2:00PM to 4:00PM";
                description = "Stop by for free tutoring. Tutors can help with reading, writing and conversation skills, as well as practical problems, such as understanding paperwork or using the internet. " +
                        "No appointments required. All walk-in tutoring sessions are on a first-come, first-served basis.";
                break;
        }
    }

    public Image getImage() {
        return eventImage;
    }

    public String getName() {
        return name;
    }

    public String getDatetime() {
        return datetime;
    }

    public String getDescription() {
        return description;
    }
}
