public class Person {
    private String name;
    private String job;
    private String university;
    private boolean drivingLicense;
    private boolean isMarried;

    private Person(PersonBuilder builder) {
        this.name = builder.name;
        this.job = builder.job;
        this.university = builder.university;
        this.drivingLicense = builder.drivingLicense;
        this.isMarried = builder.isMarried;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", university='" + university + '\'' +
                ", drivingLicense=" + drivingLicense +
                ", isMarried=" + isMarried +
                '}';
    }

    public static class PersonBuilder {
        private String name;
        private String job;
        private String university;
        private boolean drivingLicense;
        private boolean isMarried;

        public PersonBuilder(String name) {
            this.name = name;
        }

        public PersonBuilder job(String job) {
            this.job = job;
            return this;
        }

        public PersonBuilder university(String university) {
            this.university = university;
            return this;
        }

        public PersonBuilder drivingLicense(boolean drivingLicense) {
            this.drivingLicense = drivingLicense;
            return this;
        }

        public PersonBuilder isMarried(boolean isMarried) {
            this.isMarried = isMarried;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}
