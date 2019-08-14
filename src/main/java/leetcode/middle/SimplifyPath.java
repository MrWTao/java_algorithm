package leetcode.middle;

import java.util.LinkedList;

/**
 * 以Unix风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 * 输入："/a//b////c/d//././/.."
 * 输出："/a/b/c"
 */
public class SimplifyPath {

    public static void main(String[] args) {
        String path = "/a//b////c/d//././/..";
        String s = new SimplifyPath().simplifyPath(path);
        System.out.println(s);
    }

    private String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        String[] strings = path.split("/");
        for (int i = 0; i < strings.length; i++) {
            strings[i] += "/";
        }
        if(strings.length == 0){
            return "/";
        }
        LinkedList<String> list = new LinkedList<>();
        list.addLast(strings[0]);
        for (int i = 1; i < strings.length; i++) {
            if(strings[i].equals("/")||strings[i].equals("./")){
                continue;
            }else if(strings[i].equals("../")){
                if(list.size()==1){
                    list.addFirst("/");
                    list.removeLast();
                }else {
                    list.removeLast();
                }
            }else {
                list.addLast(strings[i]);
            }
        }
        while(list.size()>0){
            sb.append(list.removeFirst());
        }
        String res = sb.toString();
        if(res.length()>1){
            res = res.substring(0,res.length()-1);
        }
        return res;
    }
}
