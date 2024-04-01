// print all subsets of a given string
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class SolutionP1StringSubsetsRecursive {
    public List<String> getAllSubstrings(String str){
        List<String> list = new ArrayList<>();
        if(str == null){
            list.add("");
            return list;
        }
        else {
            list.add("");
            list.add(str.charAt(0)+"");
            if(str.length() == 1) return list;
            else {
                List<String> sublist = getAllSubstrings(str.substring(1));
                List<String> finalList = new ArrayList<>();
                for(String ch: list){
                    for(String finalListStr: sublist){
                        finalList.add(ch.concat(finalListStr));
                    }
                }
                return finalList;
            }
        }
    }
}

public class P1StringSubsetsRecursive {
    public static void main(String[] args){
        // String str = "abc";
        String str;
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();
        SolutionP1StringSubsetsRecursive sol = new SolutionP1StringSubsetsRecursive();
        List<String> list = sol.getAllSubstrings(str);
        for(String s: list){
            if(s.equals("")) System.out.print("-\t");
            else System.out.print(s+"\t");
        }
        System.out.println();
    }
}
