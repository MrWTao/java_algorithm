package leetcode.easy;

import java.util.LinkedList;
import java.util.Scanner;

public class BiliBili {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList<Integer> stack = new LinkedList<>();
        while(n!=0){
            if(n%2==0){
                n = (n-2)/2;
                stack.addLast(3);
            }else{
                n = (n-1)/2;
                stack.addLast(2);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(stack.size()>0){
            sb.append(stack.removeLast());
        }
        System.out.println(sb.toString());
    }
}
