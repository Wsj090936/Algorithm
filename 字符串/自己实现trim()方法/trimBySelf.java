package algorithms;
//用String类的方法自几写一个trim()去除字符串首位空格的方法
public class trimBySelf {
public static void main(String[] args) {
	String str = "   qw  er   ";
	System.out.println(myTrim(str));
}	
	
public static String myTrim(String str){
	int start = 0;
	int end = str.length()-1;
	while(start < end && str.charAt(start) == ' '){//用start纪录第一个不是空格的元素的下标
		start++;
	}
	while(start < end && str.charAt(end) == ' '){//用end纪录从字符串末尾开始第一个不是空格的元素的下标
		end--;
	}
	return str.substring(start, end+1);//end+1的原因是substring方法是左闭右开的
	
}
}
