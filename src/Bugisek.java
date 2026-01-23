public class Bugisek {
    public String location;
    //TODO maybe smazat

    public String getLocation() {
        return location;
    }

    public boolean move(){
        return false;
    }

    @Override
    public String toString() {
        return "Bugisek{" +
                "location='" + location + '\'' +
                '}';
    }
}
