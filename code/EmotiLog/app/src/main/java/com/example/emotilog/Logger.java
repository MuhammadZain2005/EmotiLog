package com.example.emotilog;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Logger {
    private static final List<String> events = new ArrayList<>();
    public static void log(String emotion){
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
        String entry = emotion + " - " + timestamp;
        events.add(0,entry); // adding 0 gives latest time first , a bit slow but gets the work done.
    }
    // Now we can return a copy so it cant be modified outside
    public static List<String>  getAll() {
        return new ArrayList<>(events);
    }
}
