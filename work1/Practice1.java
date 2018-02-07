package work1;

import java.util.Scanner;

/**
 * 进制转换，输入两个数m和n分别代表想要转换的数和进制，将m转换为对应的进制后输出
 * @author wushijia
 *
 */
public class Practice1 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		if(m == 0){
			System.out.println(0);
		}else{
			char[] table = new char[]{'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
			String res = "";
			while(m!=0){
				if(m<0){//m为负数的时候
					m = -m;
					System.out.print("-");
				}
				res = table[m%n]+res;
				m = m/n;
			}
			System.out.println(res);
		}
	}
}
