package lc.trees;
import java.util.*;
public class T35ReconstructItinerary {
    public static void main(String[] args) {
        T35Solution solution = new T35Solution();
        assert solution.findItinerary(Arrays.asList(
                Arrays.asList("JFK", "SFO"),
                Arrays.asList("JFK", "ATL"),
                Arrays.asList("SFO", "ATL"),
                Arrays.asList("ATL", "JFK"),
                Arrays.asList("ATL", "SFO")
        )).equals(List.of("JFK","ATL","JFK","SFO","ATL","SFO"));
    }
}

class T35Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        // Step 1: Build graph
        Map<String, PriorityQueue<String>> flights = new HashMap<>();
        for (List<String> t : tickets) {
            flights.computeIfAbsent(t.get(0), k -> new PriorityQueue<>()).add(t.get(1));
        }

        // Step 2: Result list
        LinkedList<String> itinerary = new LinkedList<>();

        // Step 3: DFS (Hierholzer)
        dfs("JFK", flights, itinerary);

        return itinerary;
    }

    private void dfs(String airport, Map<String, PriorityQueue<String>> flights, LinkedList<String> itinerary) {
        PriorityQueue<String> nextAirports = flights.get(airport);
        while (nextAirports != null && !nextAirports.isEmpty()) {
            dfs(nextAirports.poll(), flights, itinerary);
        }
        itinerary.addFirst(airport); // add when you can’t go further
    }
}
