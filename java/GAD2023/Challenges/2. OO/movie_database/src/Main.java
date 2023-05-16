public class Main {
    public static void findStudios(Studio[] studios) {
        for (Studio studio : studios) {
            if (studio.getFilms().length > 2) {
                System.out.println(studio);
            }
        }
    }

    public static void main(String[] args) {
        Prize prize1 = new Prize("Oscar", 1998);
        Actor actor1 = new Actor(30, "Actor1", new Prize[]{prize1});
        //System.out.println(actor1);

        Film film1 = new Film(2022, "Avatar", new Actor[]{actor1});
        Film film2 = new Film(2024, "Avatar", new Actor[]{actor1});
        Film film3 = new Film(2025, "Avatar", new Actor[]{actor1});

        Studio studio1 = new Studio("Studio1", new Film[]{film1});
        //System.out.println(studio1);
        Studio studio2 = new Studio("Studio2", new Film[]{film2});
        Studio studio3 = new Studio("Studio3", new Film[]{film1, film2, film3});
        Studio[] studios = new Studio[]{studio1, studio2, studio3};

        findStudios(studios);
    }
}