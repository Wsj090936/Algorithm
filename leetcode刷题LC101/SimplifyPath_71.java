package algorithms;

import java.util.Stack;
/*
 *  Given an absolute path for a file (Unix-style), simplify it.

	For example,
	path = "/home/", => "/home"
	path = "/a/./b/../../c/", => "/c"
	思路:本题的意思是让我们简化一个路径名，首先，我们知道Unix下的路径名中，各目录之间都由"/"隔开，并且"."表示当前目录下，".."表示上一级目录
	所以我们可以将该路径字符串按照"/"拆分为几个字符串，拆分出的字符串有这样几个:① 一个目录名 ② "" ③ "." ④ ".."
	然后判断每一个字符串的内容，如果为""或者为"."我们就不做处理如果为一个正常的目录名，则将其入栈，如果为".."，但是栈中无元素，则表示为根目录，
	同样我们不做处理，但如果栈中有元素，则将栈顶元素弹出，然后依次循环。最后输出简化后的路径名可以将栈顶元素依次弹出，并将其与"/"拼接起来即可。
 */
public class SimplifyPath_71 {
	public static void main(String[] args) {
		String s = "/..";
		System.out.println(simplifyPath(s));
	}
    public static String simplifyPath(String path) {
    	Stack<String> s = new Stack<>();
    	String[] path1 = path.split("/");//根据斜线将字符串分为几个字符串数组
    	String ss = "";
    	for(int i = 0;i < path1.length;++i){
    		if(path1[i].equals("") || path1[i].equals(".")){//遇到""或者"."就不做处理
    			
    		}else if(path1[i].equals("..")){
    			if(!s.isEmpty())//如果遇到"..",并且栈中无元素，则表明为根目录，不做处理
    				s.pop();
    		}else{
    			s.push(path1[i]);
    		}
    	}
    	if(s.isEmpty()){
    		return "/";
    	}
    	while(!s.isEmpty()){
    		ss = "/"+s.pop()+ss;
    	}
    	
		return ss;
        
    }
}
