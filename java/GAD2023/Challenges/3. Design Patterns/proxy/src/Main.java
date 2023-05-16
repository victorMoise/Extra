import java.util.prefs.AbstractPreferences;

public class Main {
    public static void main(String[] args) {
        RealEstateAgentProxy proxy = new RealEstateAgentProxy();
        for (int i = 1; i <= 5; i++) {
            Apartment apartment = new Apartment("Crangasi01", i * 100 );
            proxy.represent(apartment);
        }

        Student student1 = new Student("Ionescu", 400);
        Student student2 = new Student("Marcel", 100);
        Student student3 = new Student("Popescu", 1000);
        Student student4 = new Student("Mircea", 300);
        Student[] students = {student1, student2, student3, student4};

        for (Student student : students) {
            Apartment appForStudent = proxy.rent(student);
            System.out.println(student + " rented " + appForStudent);
        }
    }
}