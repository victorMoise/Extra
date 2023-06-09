import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public class Main {
    // Capitalize the user username, firstname and lastname
    static Mono<User> capitalizeOne(Mono<User> mono) {
        return mono.map(user -> new User(
                user.getFirstName().toUpperCase(),
                user.getLastName().toUpperCase(),
                user.getUsername().toUpperCase()
        ));
    }

    // Capitalize the users username, firstName and lastName
    static Flux<User> capitalizeMany(Flux<User> flux) {
        return flux.map(user -> new User(
                user.getFirstName().toUpperCase(),
                user.getLastName().toUpperCase(),
                user.getUsername().toUpperCase()
        ));
    }

    // Capitalize the users username, firstName and LastName using asyncCapitalizeUser
    static Flux<User> asyncCapitalizeMany(Flux<User> flux) {
        return flux.flatMap(UserManipulation::asyncCapitalizeUser);
    }

    static Mono<User> asyncCapitalizeUser(User u) {
        return Mono.just(new User(
                u.getFirstName().toUpperCase(),
                u.getLastName().toUpperCase(),
                u.getUsername().toUpperCase()
        ));
    }
}