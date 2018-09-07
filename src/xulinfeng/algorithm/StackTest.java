package xulinfeng.algorithm;

import java.util.Stack;

/**
 * description
 *
 * @author xujiahong
 * @date 2018/7/30
 */
public class StackTest {

    public static void main(String[] args) {
        Stack stack = new Stack();
        String str = "12<a[b{c}]>}";
        char[] cha = str.toCharArray();
        for(char c : cha){
            switch (c) {
                case '{':
                case '[':
                case '<':
                    stack.push(c);
                    break;
                case '}':
                case ']':
                case '>':
                    if(!stack.isEmpty()){
                        char ch = stack.pop().toString().toCharArray()[0];
                        if(c=='}' && ch != '{'
                                || c==']' && ch != '['
                                || c==')' && ch != '('){
                            System.out.println("Error:"+ch+"-"+c);
                            return;
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
