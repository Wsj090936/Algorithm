package string;
/**
 * 打印字符串中所有数字字串的和
 * @author wushijia
 *如：
 *	"A12B3"就输出15
 *	"A-12B--3"就输出-9
 */
public class S_244 {
	public static int getSum(String str){
		if(str == ""||str == null){
			return 0;
		}
		char[] array = str.toCharArray();
		int res = 0;
		int num = 0;
		boolean b = true;//true表示当前数为正，反之则表示为负
		int cur = 0;
		for(int i = 0;i < array.length;i++){
			cur = array[i] - '0';//这样就可以算出0-9了
			if(cur < 0 || cur > 9){//当不为0-9
				res = res + num;
				num = 0;
				if(array[i] == '-'){
					if(i - 1 >-1 &&array[i-1] == '-'){//两个以上的负号时
						b = !b;
					}else{
						b = false;
					}
				}
			}else{
				num = num*10+(b?cur:-cur);//判断正负
			}
		}
		res = res + num;//最后一次将num中的值加上
		return res;
	}
	public static void main(String[] args) {
		String str = "ABC126D";
		int sum = getSum(str);
		System.out.println(sum);
	}
}
