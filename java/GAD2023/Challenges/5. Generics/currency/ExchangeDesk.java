package currency;

import java.lang.reflect.Constructor;

public class ExchangeDesk {
    private Float rate = 0.23F;

    public <T extends Currency, F extends Currency> F convert(T currency, Class<F> toCurrencyClass, Float rate) throws Exception {
        Class[] cArg = new Class[1];
        cArg[0] = float.class;

        Constructor<F> ct = toCurrencyClass.getDeclaredConstructor(cArg);
        return ct.newInstance(rate * currency.getValue());
    }

    public <T extends Currency, F extends Currency> F convert(T currency, Class<F> toCurrencyClass) throws Exception {
        return convert(currency, toCurrencyClass, rate);
    }
}