import java.util.ArrayList;

public class RealEstateAgentProxy {
    private ArrayList<Apartment> represents;

    public RealEstateAgentProxy() {
        represents = new ArrayList<Apartment>();
    }
    public void represent(Apartment apartment) {
        represents.add(apartment);
    }

    public Apartment rent(Student student) {
        if (student.getName().startsWith("P")) {
            return null;
        }
        for (Apartment apartment: represents) {
            if (apartment.getMonthlyCost() <= student.getMoney()) {
                represents.remove(apartment);
                return apartment;
            }
        }

        return null;
    }
}
