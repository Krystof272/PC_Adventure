import java.util.HashMap;

public class NPC {
    private String id;
    private String name;
    private String homeLocationId;
    private String initialEncouterText;
    private HashMap<String, String> answers;

    public String getAnswer(String questionInt) {
        return answers.get(questionInt);
    }

    public String getInitialEncouterText() {
        return initialEncouterText;
    }

    public String getHomeLocationId() {
        return homeLocationId;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "\nNPC{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", homeLocationId='" + homeLocationId + '\'' +
                ", initialEncouterText='" + initialEncouterText + '\'' +
                ", answers=" + answers +
                '}';
    }
}
