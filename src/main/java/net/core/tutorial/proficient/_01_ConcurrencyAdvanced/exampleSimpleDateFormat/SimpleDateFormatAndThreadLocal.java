package net.core.tutorial.proficient._01_ConcurrencyAdvanced.exampleSimpleDateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatAndThreadLocal {

    public void parsingDateFromVariousThreads(){

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat[] dateFormats = FormatClass.getDateFormats();
                System.out.println("Thread 1 uses SimpleDateFormat[] : " + dateFormats);
                for (SimpleDateFormat someFormat: dateFormats) {
                    Date parsedDate = null;
                    try {
                        parsedDate = someFormat.parse("20-03-2015");
                    } catch (ParseException e) {
                        /*NOP*/
                    }
                    if(parsedDate != null){
                        System.out.println("Thread 1 has parsed the time: " + parsedDate.getTime() + " ms");
                        break;
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat[] dateFormats = FormatClass.getDateFormats();
                System.out.println("Thread 2 uses SimpleDateFormat[] : " + dateFormats);
                for (SimpleDateFormat someFormat: dateFormats) {
                    Date parsedDate = null;
                    try {
                        parsedDate = someFormat.parse("20/03/2015");
                    } catch (ParseException e) {
                        /*NOP*/
                    }
                    if(parsedDate != null){
                        System.out.println("Thread 2 has parsed the time: " + parsedDate.getTime() + " ms");
                        break;
                    }
                }
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat[] dateFormats = FormatClass.getDateFormats();
                System.out.println("Thread 3 uses SimpleDateFormat[] : " + dateFormats);
                for (SimpleDateFormat someFormat: dateFormats) {
                    Date parsedDate = null;
                    try {
                        parsedDate = someFormat.parse("20-03-2015:23:15");
                    } catch (ParseException e) {
                        /*NOP*/
                    }
                    if(parsedDate != null){
                        System.out.println("Thread 3 has parsed the time: " + parsedDate.getTime() + " ms");
                        break;
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All dates were parsed successfully");
    }

    public void formattingDateFromVariousThreads(){

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat[] dateFormats = FormatClass.getDateFormats();
                System.out.println("Thread 1 uses SimpleDateFormat[] : " + dateFormats);
                Date currentDate = new Date(System.currentTimeMillis());
                for (SimpleDateFormat someFormat: dateFormats) {
                    String visualDate = someFormat.format(currentDate);
                    System.out.println("Thread 1 has formatted date: " + visualDate);
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat[] dateFormats = FormatClass.getDateFormats();
                System.out.println("Thread 2 uses SimpleDateFormat[] : " + dateFormats);
                Date currentDate = new Date(System.currentTimeMillis());
                for (SimpleDateFormat someFormat: dateFormats) {
                    String visualDate = someFormat.format(currentDate);
                    System.out.println("Thread 2 has formatted date: " + visualDate);
                }
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat[] dateFormats = FormatClass.getDateFormats();
                System.out.println("Thread 3 uses SimpleDateFormat[] : " + dateFormats);
                Date currentDate = new Date(System.currentTimeMillis());
                for (SimpleDateFormat someFormat: dateFormats) {
                    String visualDate = someFormat.format(currentDate);
                    System.out.println("Thread 3 has formatted date: " + visualDate);
                }
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All dates were formatted successfully");
    }
}
