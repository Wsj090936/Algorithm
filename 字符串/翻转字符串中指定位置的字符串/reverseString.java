package algorithms;
//实现将任意位置的字符串翻转
public class reverseString {
	public static void main(String[] args){
		String str = "asdfghjk";
		System.out.println(Reverse(str,0,3));
	}
	public	static String Reverse(String str,int start,int end){//闭区间
		if(end-start<0){
			throw new RuntimeException("下标不对");
		}else{
		char[] B = str.toCharArray();
		for(int i = start,j = end;i<j;i++,j--){
			char temp = B[i];
			B[i] = B[j];
			B[j] = temp;
		}

		return new String(B);
		
	}
}
}
