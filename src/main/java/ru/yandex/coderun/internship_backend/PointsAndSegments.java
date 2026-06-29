package ru.yandex.coderun.internship_backend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 5. Точки и отрезки
 */
public class PointsAndSegments {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            String[] input = reader.readLine().split(" ");
            int nSegments = Integer.parseInt(input[0]);
            int mPoints = Integer.parseInt(input[1]);

            List<Event> events = new ArrayList<>(nSegments * 2 + mPoints);

            for (int i = 0; i < nSegments; i++) {
                input = reader.readLine().split(" ");
                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);

                int start = Math.min(a, b);
                int end = Math.max(a, b);
                events.add(new Event(start, 1, null));
                events.add(new Event(end, -1, null));
            }

            input = reader.readLine().split(" ");
            for (int i = 0; i < mPoints; i++) {
                events.add(new Event(Integer.parseInt(input[i]), 0, i));
            }

            events.sort(Comparator.comparingInt(Event::x)
                    .thenComparing((e1, e2) -> Integer.compare(e2.type(), e1.type())));

            Integer[] result = new Integer[mPoints];
            int counter = 0;
            for (var event : events) {
                counter += event.type();

                if (event.type() == 0) {
                    result[event.index()] = counter;
                }
            }

            StringBuilder output = new StringBuilder();
            for (var res : result) {
                output.append(res).append(' ');
            }
            writer.write(output.toString());
        }
    }

    private record Event(
            Integer x,
            Integer type, // 1 - start; 0 - point; -1 - end
            Integer index) {
    }
}
