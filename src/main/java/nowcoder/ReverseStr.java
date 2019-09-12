package nowcoder;

import java.util.Scanner;

/**
 * 对于一个字符串，请设计一个算法，只在字符串的单词间做逆序调整，也就是说，字符串由一些由空格分隔的部分组成，你需要将这些部分逆序。
 * 给定一个原字符串A，请返回逆序后的字符串。例，输入"I am a boy!", 输出"boy! a am I"
 */
public class ReverseStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strings = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            res.append(strings[strings.length - 1 - i]+" ");
        }
        System.out.println(res.toString());
    }
}
