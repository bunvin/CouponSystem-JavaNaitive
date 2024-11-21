package Testing;

import beans.Coupon;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class FactoryUtils {

    //random start date- 2 weeks back
    //random end date- 2 weeks forward
    //random start and end date


    public static Date randomExpiredDate() {
        LocalDate now = LocalDate.now();
        LocalDate randomDate = now.minusDays(ThreadLocalRandom.current().nextInt(-21,0));
        LocalDateTime randomDateTime = randomDate.atStartOfDay();

        return Date.from(randomDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date randomDate() {
        LocalDate now = LocalDate.now();
        LocalDate randomDate = now.plusDays(ThreadLocalRandom.current().nextInt(0,21));
        LocalDateTime randomDateTime = randomDate.atStartOfDay();

        return Date.from(randomDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date randomEnd(Date startDate) {
        LocalDate start = LocalDate.from(startDate.toInstant());
        LocalDate randomEnd = start.plusDays(ThreadLocalRandom.current().nextInt(0,21));
        LocalDateTime randomEndTime = randomEnd.atStartOfDay();

        return Date.from(randomEndTime.atZone(ZoneId.systemDefault()).toInstant());
    }


}
