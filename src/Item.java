public class Item {
    private String id;
    private String name;
    private String description;

    @Override
    public String toString() {
        return "\nItem{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
