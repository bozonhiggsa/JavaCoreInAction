package net.core.tutorial.proficient._01_ConcurrencyAdvanced.exampleSimpleDateFormat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class FormatClass {

    private static final String[] DATE_PATTERNS = new String[]{"dd-MM-yyyy:hh:mm", "dd-MM-yyyy", "dd/MM/yyyy"};

    private static final ThreadLocal<SimpleDateFormat[]> DATE_FORMATS = new ThreadLocal<SimpleDateFormat[]>()
    {
        @Override
        protected SimpleDateFormat[] initialValue() {
            List<SimpleDateFormat> formatList = new ArrayList<>();
            for (String pattern: DATE_PATTERNS)             {
                formatList.add(new SimpleDateFormat(pattern));
            }
            return formatList.toArray(new SimpleDateFormat[formatList.size()]);
        }
    };

    public static SimpleDateFormat[] getDateFormats() {
        return DATE_FORMATS.get();
    }

}