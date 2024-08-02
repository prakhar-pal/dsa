package lc.random;
import java.util.*;

/**
 * https://leetcode.com/problems/minimum-genetic-mutation/
 */
public class R23MinimumGeneticMutation {
    public static void main(String[] args) {
        R23Solution solution = new R23Solution();
        assert solution.minMutation("AACCGGTT", "AACCGGTA", new String[] {"AACCGGTA"}) == 1;
        assert solution.minMutation("AACCGGTT", "AAACGGTA", new String[] {"AACCGGTA","AACCGCTA","AAACGGTA"}) == 2;
        assert solution.minMutation("AACCTTGG", "AATTCCGG", new String[] {"AATTCCGG","AACCTGGG","AACCCCGG","AACCTACC"}) == -1;
        assert solution.minMutation("AACCGGTT", "AAACGGTA", new String[] {"AACCGATT","AACCGATA","AAACGATA","AAACGGTA"}) == 4;
        assert solution.minMutation("AACCGGTT", "AACCGGTA", new String[] {}) == -1;
    }
}

class R23Solution {
    char[] geneVariants = new char[] { 'A', 'C', 'G', 'T'};
    public int minMutation(String startGene, String endGene, String[] bank) {
        int moves = 0;
        Queue<String> queue = new LinkedList<>();
        HashSet<String> geneSet = new HashSet<>();
        HashSet<String> generatedSet = new HashSet<>();
        for(String gene: bank) {
            geneSet.add(gene);
        }
        queue.add(startGene);
        HashSet<String> visited = new HashSet<>();
        while (queue.size() > 0) {
            int length = queue.size();
            for(int i=0;i<length;i++) {
                String candidate = queue.poll();
                visited.add(candidate);
                if(candidate.equals(endGene) && geneSet.contains(candidate)) {
                    return moves;
                }
                queue.addAll(addNextVariants(candidate, geneSet, visited, generatedSet));
            }
            moves++;
        }
        return -1;
    }

    private HashSet<String> addNextVariants(String candidate, HashSet<String> geneSet, HashSet<String> visited, HashSet<String> generatedSet) {
        HashSet<String> set = new HashSet<>();
        for(String gene: geneSet) {
            int mmindex = -1;
            for(int i=0;i<candidate.length();i++) {
                if(gene.charAt(i) != candidate.charAt(i)) {
                    if(mmindex != -1) {
                        break;
                    }
                    mmindex = i;
                }
            }
            if(mmindex != -1) {
                String option = candidate.substring(0, mmindex) + gene.charAt(mmindex) + candidate.substring(mmindex+1);
                if(geneSet.contains(option) && !visited.contains(option) && !generatedSet.contains(option)) {
                    set.add(option);
                }
            }
        }
        generatedSet.addAll(set);
        return set;
    }
}


