package com.company.alg;


import java.util.Arrays;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * For example, given
 * s = “leetcode”,
 * dict = [“leet”, “code”].
 *
 * Return true because “leetcode” can be segmented as “leet code”.
 * "aaaaaaa",["aaaa","aa"]
 */
public class World_break {
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] state = new boolean[s.length() + 1];// 表示从0到len长度的单词存在字典中
        Arrays.fill(state,false);
        state[0] = true;// 初始状态
        for(int i = 1;i <= s.length();i++){// 包左不包右
            for(int j = 0;j < i;j++){
                if(state[j] && dict.contains(s.substring(j,i))){// 如果j之前的单词在字典中并且之后的也在
                    state[i] = true;
                    break;
                }
            }
        }
        return state[s.length()];
    }

}
