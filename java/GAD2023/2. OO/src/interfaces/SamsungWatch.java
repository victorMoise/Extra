package interfaces;

import java.sql.Time;
public class SamsungWatch implements Clock, SmartWatch{
    @Override
    public String getTime() {
        return new Time(System.currentTimeMillis()).toLocalTime().toString();
    }

    @Override
    public void sendEmail(String toEmail) {
        System.out.println("Email sent to " + toEmail);
    }
}
