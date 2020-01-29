package net.core.tutorial.proficient._01_ConcurrencyAdvanced.exampleSimpleDateFormat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class BasicFeatures {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yy:hh:mm");
        String visualDate1 = formatter1.format(new Date(System.currentTimeMillis()));
        System.out.println(visualDate1);

        SimpleDateFormat formatter12 = new SimpleDateFormat("dd-MMM-yyyy:hh:mm");
        String visualDate12 = formatter12.format(new Date(System.currentTimeMillis()));
        System.out.println(visualDate12);


        // Using factory methods for DateFormat
        System.out.println("--------------------------");
        DateFormat formatter2 = DateFormat.getInstance();
        String visualDate2 = formatter2.format(new Date(System.currentTimeMillis()));
        System.out.println(visualDate2);

        DateFormat formatter3 = DateFormat.getDateInstance(DateFormat.MEDIUM);
        String visualDate3 = formatter3.format(new Date(System.currentTimeMillis()));
        System.out.println(visualDate3);

        DateFormat formatter4 = DateFormat.getTimeInstance(DateFormat.MEDIUM);
        String visualDate4 = formatter4.format(new Date(System.currentTimeMillis()));
        System.out.println(visualDate4);

        DateFormat formatter5 = DateFormat.getDateTimeInstance();
        String visualDate5 = formatter5.format(new Date(System.currentTimeMillis()));
        System.out.println(visualDate5);
        System.out.println("--------------------------");

        SimpleDateFormat formatter6 = new SimpleDateFormat("dd:MM:yyyy");
        Date myDate = new Date(System.currentTimeMillis());
        Date parsedDate = formatter6.parse("20:03:2015");
        System.out.println(myDate.getTime() + " ms : " + parsedDate.getTime() + " ms");
        System.out.println("--------------------------");

        // Applying Locales
        SimpleDateFormat franceDateFormatter = new SimpleDateFormat("dd-MMMMMMM-yyyy", Locale.FRANCE);
        Date someDate = new Date(System.currentTimeMillis() + 3600_000L*24*30*7);
        System.out.println(franceDateFormatter.format(someDate));
        System.out.println("--------------------------");

        // Changing Time Zones
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE dd-MMM-yy HH:mm:ssZ");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Europe/London"));
        System.out.println((simpleDateFormat.format(now)));
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        System.out.println((simpleDateFormat.format(now)));
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+3:00"));
        System.out.println((simpleDateFormat.format(now)));

    }
}
