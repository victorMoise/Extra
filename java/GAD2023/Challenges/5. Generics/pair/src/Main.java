public class Main {
    public static void main(String[] args) {
        Running runningShoe1 = new Running("RED", 41);
        Running runningShoe2 = new Running("RED", 41);
        Pair<Running> pairOK = new Pair<>(runningShoe1, runningShoe2);
        System.out.println(pairOK);

        Boot bootShoe = new Boot("RED", 42);
//        Pair<Shoe> pairBoot = new Pair<>(runningShoe1, bootShoe);

        Running runningShoe3 = new Running("BLACK", 41);
//        Pair<Shoe> pairNotOK1 = new Pair<>(runningShoe1, runningShoe3);

        Running runningShoe4 = new Running("BLACK", 41);
//        Pair<Shoe> pairNotOK2 = new Pair<>(runningShoe1, runningShoe3);

        Heels heels1 = new Heels("Blue", 37);
        Heels heels2 = new Heels("Blue", 37);
        Pair<Shoe> heelsPair = new Pair<>(heels1, heels2);
        System.out.println(heelsPair);
    }
}