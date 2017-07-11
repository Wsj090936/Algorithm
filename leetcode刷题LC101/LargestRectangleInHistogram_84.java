package algorithms;
/*
 * 求最大矩阵的大小  题号：84
 */
public class LargestRectangleInHistogram_84 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] stack = new int[n + 1];//栈中存放的是所给数组heights的下标
        int top = 0;
        int[] l = new int[n];//该数组中存储了每一个矩阵能延伸到左边的最终位置
        int[] r = new int[n];//该数组中存储了每一个矩阵能延伸到右边的最终位置
        for(int i = 0; i < n ;i++){//左边遍历
            for(;top > 0 && heights[i] <= heights[stack[top]];top--);
            l[i] = top == 0 ? 0 : stack[top] + 1;
            stack[++top] = i;
        }
            top = 0;
        for(int i = n - 1;i>=0;i--){
            for(;top > 0 && heights[i] <= heights[stack[top]];top--);
            r[i] = top == 0 ? n-1 : stack[top] - 1;
            stack[++top] = i;
        }
        int answer = 0;
        for(int i = 0;i < n;i++){
            answer = Math.max(answer,(r[i] - l[i] + 1) * heights[i]);
        }
        return answer;
    }
}
