import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.Assert;
import java.util.function.Consumer;

public class Consumer1 {
    @Test
    public void consumer1() {
        List<String> = new ArrayList<>(Arrays.asList('a', 'b', 'c'));
        Consumer<List<String>> consumer = l -> l.clear();
        consumer.accept(list);
        Assert.assertEquals(list, new ArrayList<>());
    }
}
