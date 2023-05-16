package currency;

public class Main {
    public static void main(String[] args) throws Exception {
        RON leu = new RON(200F);
        ExchangeDesk exchangeDesk = new ExchangeDesk();
        System.out.println(exchangeDesk.convert(leu, USD.class));
        System.out.println(exchangeDesk.convert(leu, USD.class, 0.5F));
    }
}