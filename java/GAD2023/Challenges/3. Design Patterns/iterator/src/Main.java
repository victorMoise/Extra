public class Main {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3};
        ArrayCustomIterator iterator = new ArrayCustomIterator(arr);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}