public class Apartment {
    String location;
    Integer monthlyCost;

    public Apartment(String location, Integer monthlyCost) {
        this.location = location;
        this.monthlyCost = monthlyCost;
    }

    public String getLocation() {
        return this.location;
    }

    public Integer getMonthlyCost() {
        return this.monthlyCost;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "location='" + location + '\'' +
                ", monthlyCost=" + monthlyCost +
                '}';
    }
}
