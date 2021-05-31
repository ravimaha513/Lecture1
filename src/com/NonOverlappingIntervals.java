package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NonOverlappingIntervals {

    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        int n = intervals.size();
        List<Double> starts = new ArrayList<>();
        List<Double> ends = new ArrayList<>();
        for(Interval x : intervals) {
            starts.add(x.start);
            ends.add(x.end);
        }
        Collections.sort(starts);
        Collections.sort(ends);
        int i = 0, j = 0, current = 0, result = 0;
        while(i < n) { // since last of ends would be greater than last of starts
            // hence i will reach to end before ends, so no need to check j < n
            if(starts.get(i) < ends.get(j)) {
                current++; // Need new meeting room
                result = Math.max(current, result); // Update result
                i++;
            } else {
                current--; // One meeting room is emptied, so need lesser meeting rooms now
                // No need to update result here because we only want to maximize result
                j++;
            }
        }

        return result;
    }
}

class Interval{

    Double start;
    Double end;
}
