package greedymethod;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Imran on 2/17/2020.
 */
class Time {
    int start;
    int finish;

    public Time(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }
}

public class ActivitySelection {
    public static void solve(int[] start, int[] finish) {
        int size = start.length;
        Time[] time = new Time[size];
        for (int i = 0; i < size; i++) {
            time[i] = new Time(start[i], finish[i]);
        }
        Arrays.sort(time, new Comparator<Time>() {
            @Override
            public int compare(Time o1, Time o2) {
                return o1.finish - o2.finish;
            }
        });
        int temp = 0;
        for (int i = 0; i < size; i++) {
            if (i == 0)
                System.out.println(time[i].start + "   " + time[i].finish);
            else if (time[i].start >= time[temp].finish) {
                System.out.println(time[i].start + "   " + time[i].finish);
                temp = i;
            }
        }
    }

    public static void main(String[] args) {
        int s[] = {1, 3, 0, 5, 8, 5};
        int f[] = {2, 4, 6, 7, 9, 9};

        solve(s, f);

    }
}
