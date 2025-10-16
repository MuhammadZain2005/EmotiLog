package com.example.emotilog;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SummaryLogger {

    public static Map<String, Integer> getCounts() {
        List<String> events = Logger.getAll();
        Map<String, Integer> counts = new HashMap<>();

        for (String entry : events) {
            // entry looks like: "Happy - 2025-09-29 22:01:03"
            // Split Entry to get emoji used and use in summary.
            String[] parts = entry.split(" - ");
            if (parts.length < 1) continue;

            String emotion = parts[0].trim();
            counts.put(emotion, counts.getOrDefault(emotion, 0) + 1);
        }
        return counts;
    }

    public static int getTotal() {
        return Logger.getAll().size();
    }

    public static int getCount(String emotion) {
        return getCounts().getOrDefault(emotion, 0);
    }
}
