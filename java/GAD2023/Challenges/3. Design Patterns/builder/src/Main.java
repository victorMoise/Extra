public class Main {
    public static void main(String[] args) {
        Person person1 = new Person.PersonBuilder("Jack")
                .job("Engineer")
                .university("Harvard")
                .build();
        Person person2 = new Person.PersonBuilder("John")
                .job("Teacher")
                .university("Cambridge")
                .drivingLicense(true)
                .isMarried(false)
                .build();

        System.out.println(person1);
        System.out.println(person2);
    }
}