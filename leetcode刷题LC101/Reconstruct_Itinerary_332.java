package algorithms;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.List;

/*
 *  Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

	Note:
	If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
	All airports are represented by three capital letters (IATA code).
	You may assume all tickets form at least one valid itinerary.
	Example 1:
	tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
	Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
	Example 2:
	tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
	Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
	Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
	
	Credits:
	Special thanks to @dietpepsi for adding this problem and creating all test cases.
	题目要求我们生成一条路线，按着字字母的从小到大排序，并且出发点一定要为"JFK"
	这里用了PriorityQueue排序队列，默认里面存入的数据是按自然顺序排序的，数字按由小到大排序，字母按照字典顺序排序
 */
public class Reconstruct_Itinerary_332 {
    Map<String,PriorityQueue<String>> map = new HashMap<>();
    LinkedList<String> result = new LinkedList<>();
    public List<String> findItinerary(String[][] tickets) {
        for(String[] ticket : tickets){
            if(!map.containsKey(ticket[0])){
                PriorityQueue<String> q = new PriorityQueue<>();
                map.put(ticket[0],q);
            }
            map.get(ticket[0]).add(ticket[1]);
        }
        DFS("JFK");
        return result;
    }
    public void DFS(String s){
        PriorityQueue<String> q = map.get(s);
        while(q != null && !q.isEmpty()){
            DFS(q.poll());
        }
        result.addFirst(s);//递归调用DFS普通的add结果是按字典的从大到小的顺序排序的，所以调用addFirst()方法
    }
}
