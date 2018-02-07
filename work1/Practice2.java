package work1;

import java.util.Scanner;

public class Practice2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int res = 0;
		while(n!=0){
			n/=5;
			res = res+n;
		}
		System.out.println(res);
	}
}
