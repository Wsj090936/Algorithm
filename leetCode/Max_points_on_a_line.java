package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * @author wushijia
 * 题目描述，给出一组二维平面上的数，求出共线的最大点数
 */
public class Max_points_on_a_line {
    public int maxPoints(Point[] points) {
        if(points.length <= 2){
        	return points.length;
        }
        int res = 0;
        for(int i = 0;i < points.length;i++){
        	Map<Double,Integer> map = new HashMap<>();//每次都需要重新定义map
        	int max = 1;//1是因为当前的起始点
        	int ptr = 0;//横坐标相同的点
        	int c = 0;//重复
        	for(int j = 0;j < points.length;j++){
        		if(j != i){
        			double x1 = points[i].x - points[j].x;//横坐标相减
        			double y1 = points[i].y - points[j].y;
        			if(x1 == 0 && y1 == 0){//重合
        				c++;
        			}else if(x1 == 0){//横坐标相同
        				if(ptr == 0){
        					ptr = 2;
        				}else{
        					ptr++;
        				}
        				max = Math.max(max, ptr);
        			}else{
        				double k = y1/x1;
        				if(map.get(k) == null){
        					map.put(k, 2);
        				}else{
        					map.put(k, map.get(k)+1);
        				}
        				max = Math.max(map.get(k), max);
        			}
        		}
        	}
        	res = Math.max(max+c, res);//每次取最大的，注意
        }
        return res;
    }
}
