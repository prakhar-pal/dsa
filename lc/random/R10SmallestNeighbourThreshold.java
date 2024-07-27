package lc.random;

import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/description/
 */
public class R10SmallestNeighbourThreshold {
    public static void main(String[] args) {
        R10Solution  solution = new R10SolutionTwo();
        assert solution.findTheCity(4, new int[][] {
            {0,1,3},
            {1,2,1},
            {1,3,4},
            {2,3,1}
        }, 4) == 3;
        assert solution.findTheCity(5, new int[][] {
            {0,1,2},
            {0,4,8},
            {1,2,3},
            {1,4,2},
            {2,3,1},
            {3,4,1}
        }, 2) == 0;
        assert solution.findTheCity(6, new int[][] {
            {0,1,10},
            {0,2,1},
            {2,3,1},
            {1,3,1},
            {1,4,1},
            {4,5,10}

        }, 20) == 5;
    }
}

class City {
    int id;
    HashMap<Integer, Integer> connectedCities;
    public City(int id) {
        this.id = id;
        connectedCities = new HashMap<>();
    }
}

interface R10Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold);
}

class R10SolutionOne implements R10Solution {
    /** this TLEs */
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        City[] cities = new City[n];
        for(int i=0;i<n;i++) {
            cities[i] = new City(i);
        }
        for(int[] edge: edges) {
            int to = edge[0];
            int from = edge[1];
            int distance = edge[2];
            cities[to].connectedCities.put(from, distance);
            cities[from].connectedCities.put(to, distance);
        }
        int resultCityId = -1;
        int minCities = n + 1;
        for(int i=0;i<n;i++) {
            HashSet<Integer> reachedCities = new HashSet<>();
            dfs(i, cities, reachedCities, new HashSet<>(), distanceThreshold);
            if(reachedCities.size() <= minCities) {
                if(reachedCities.size() < minCities) {
                    resultCityId = i;
                    minCities = reachedCities.size();
                } else if(i > resultCityId) {
                    resultCityId = i;
                }
            }
        }
        return resultCityId;
    }
    private void dfs(int cityId, City[] cities, HashSet<Integer> reachedCities, HashSet<Integer> visitedSet,  int threshold) {
        if(visitedSet.contains(cityId) || threshold < 0) {
            return;
        }
        visitedSet.add(cityId);
        reachedCities.add(cityId);
        for(int connectedCity: cities[cityId].connectedCities.keySet()) {
            int distance = cities[cityId].connectedCities.get(connectedCity);
            if(threshold - distance >= 0) {  
                dfs(connectedCity, cities, reachedCities, visitedSet, threshold - distance);
            }
        }
        visitedSet.remove(cityId);
    }
}


class R10SolutionTwo implements R10Solution {
    // using floyd-warshall algorithm
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] adjMatrix = new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                adjMatrix[i][j] = i == j ? 0 : Integer.MAX_VALUE/2;
            }
        }
        for(int[] edge: edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            adjMatrix[from][to] = weight;
            adjMatrix[to][from] = weight;
        }
        for(int k=0;k<n;k++) {
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][k] + adjMatrix[k][j]);
                }
            }
        }
        int[] citiesWithinThreshold = new int[n];
        for(int i=0;i<n;i++) {
            int count = 0;
            for(int j=0;j<n;j++) {
                if(adjMatrix[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            citiesWithinThreshold[i] = count;
        }
        int cityId = -1, minCities = n;
        for(int i=0;i<n;i++) {
            if(citiesWithinThreshold[i] <= minCities) {
                minCities = citiesWithinThreshold[i];
                cityId = i;
            }
        }
        return cityId;
    }
}


