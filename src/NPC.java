import java.util.HashMap;

public class NPC {
    private String id;
    private String name;
    private String homeLocationId;
    private String initialEncouterText;
    private HashMap<String, String> answers;

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
