package alibaba;

import java.util.HashMap;
import java.util.Map;

/**
 * 3.有一个字符串它的构成是词+空格的组合，如“北京 杭州 杭州 北京”， 要求输入一个匹配模式（简单的以字符来写），
 * 比如 aabb, 来判断该字符串是否符合该模式， 举个例子：
 * 1). pattern = "abba", str="北京 杭州 杭州 北京" 返回 true
 * 2). pattern = "aabb", str="北京 杭州 杭州 北京" 返回 false
 * 3). pattern = "baab", str="北京 杭州 杭州 北京" 返回 true
 */
public class StringPatternMatch {
    public static void main(String[] args) {
        String str = "北京 杭州 杭州 北京";
        String pattern = "abba";
        boolean b = matchPattern(str, pattern);
        System.out.println(b);
    }

    /**
     * 是否匹配
     * @param str 目标字符串
     * @param pattern 格式
     * @return boolean
     */
    private static boolean matchPattern(String str,String pattern){
        String[] strings = str.split(" ");
        // 字符串分割后的长度和匹配模式不一样长
        if(strings.length != pattern.length()){
            return false;
        }
        // 用Map存储(字符串,pattern)对应关系
        Map<String,Character> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            if(map.get(strings[i]) == null){
                map.put(strings[i],pattern.charAt(i));
            }else if(map.get(strings[i])!= pattern.charAt(i)){// 不匹配的情况
                return false;
            }
        }
        return true;
    }
}
