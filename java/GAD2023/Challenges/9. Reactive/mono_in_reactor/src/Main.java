import reactor.core.publisher.Mono;

public class Main {
    // Return an empty Mono
    Mono<Void> emptyMono() {
        return Mono.empty();
    }

    // Return a Mono that never emits any signal
    Mono<Object> monoWithNoSignal() {
        return Mono.never();
    }

    // Return a Mono that contains a "foo" value
    Mono<String> fooMono() {
        return Mono.just("foo");
    }

    // Create a Mono that emits an IllegalStateException
    Mono<Object> errorMono() {
        return Mono.error(new IllegalStateException());
    }
}
