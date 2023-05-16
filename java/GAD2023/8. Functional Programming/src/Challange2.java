import org.junit.Assert;
import org.junit.Test;
import java.util.Objects;
import java.util.function.Predicate;

public class PredicateTests {

    /**
     * Given the predicate p1, write a predicate that
     * returns true if the string it tests is not empty.
     * This is a NOT operation on the predicate p1.
     */
    @Test
    public void predicate_1() {
        Predicate<String> p1 = String::isEmpty;
        Predicate<String> notPredicate = p1.negate();
        Assert.assertFalse(notPredicate.test(""));
        Assert.assertTrue(notPredicate.test("Not empty!"));
    }

    /**
     * Given the two predicates p1 and p2, write a predicate
     * that returns true if the string it tests is
     * neither null, neither empty.
     * This is a AND operation on the predicates p1 and p2.
     */
    @Test
    public void predicate_2() {
        Predicate<String> p1 = Objects::nonNull;
        Predicate<String> p2 = s -> !s.isEmpty();
        Predicate<String> andPredicate = p1.and(p2);
        Assert.assertFalse(andPredicate.test(""));
        Assert.assertFalse(andPredicate.test(null));
        Assert.assertTrue(andPredicate.test("Not empty!"));
    }

    /**
     * Given the two predicates p1 and p2, write a predicate that
     * returns true if the tested string is of length 4, true if
     * it starts with a J, but false if it is of length 4 and starts
     * with a J. This is a XOR operation on the predicates p1 and p2.
     */
    @Test
    public void predicate_3() {
        Predicate<String> p1 = s -> s.length() == 4;
        Predicate<String> p2 = s -> s.startsWith("J");
        Predicate<String> xorPredicate = p1.xor(p2);
        Predicate<String> p3 = xorPredicate.and(s -> !(s.length() == 4 && s.startsWith("J")));
        Assert.assertTrue(p3.test("True"));
        Assert.assertTrue(p3.test("Julia"));
        Assert.assertFalse(p3.test("Java"));
    }
}
