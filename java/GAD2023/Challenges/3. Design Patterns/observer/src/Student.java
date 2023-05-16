public class Student implements Observer {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("Student " + this.name + " learned about " + message);
    }

    public void listenTo(Teacher teacher) {
        teacher.register(this);
    }

    public void stopListeningTo(Teacher teacher) {
        teacher.unregister(this);
    }
}
