package algorithms;

import java.util.Stack;
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
/*
思路:这道题可以利用栈来做，首先将列表nestedList中的元素从后往前依次入栈，根据栈的特性，就可以将列表中的第一个元素第一个处理
接下来需要根据hasnext()函数来判断下一个元素是否为整数，因此先利用peek()放法获取栈顶元素(也就是列表中第一个元素的值)，如果为
整数，则返回true，若不是，则它一定是一个列表，就将其弹出，并从后往前遍历它并将它之中的元素入栈，然后继续此循环。
*/
public class NestedIterator implements Iterator<Integer> {
  public Stack<NestedInteger> s = new Stack<NestedInteger>();
  public NestedIterator(List<NestedInteger> nestedList) {
      if(nestedList != null){
      for(int i = nestedList.size() - 1; i >= 0;--i){//将列表元素倒序入栈
          s.push(nestedList.get(i));
      }
    }
  }

  @Override
  public Integer next() {
      NestedInteger e = s.pop();
      return e.getInteger();
  }

  @Override
  public boolean hasNext() {
      while(!s.isEmpty()){
          NestedInteger e = s.peek();
          if(e.isInteger()){//如果为数字  返回true
              return true;
          }else{
              s.pop();//不是整数就将栈顶元素弹出，然后将弹出元素遍历并将其中的数字从后往前弹入栈中
              for(int i = e.getList().size()-1; i >= 0 ;--i){
                  s.push(e.getList().get(i));
              }
          }
      }
      return false;
  }
}
/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */