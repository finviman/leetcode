package com.home;

public class ClassicBracket {

    public static void main(String[] args) {
        String s = "{}[()]";
        System.out.println(effectString(s));
    }

    private static boolean effectString(String s) {
        Stack stack = new Stack(s.length());
        for (int i = 0; i < s.length(); i++) {
            if (stack.size()>0 && pair(stack.getTop(), s.charAt(i))) {
                stack.pop();
            }else {
                stack.push(s.charAt(i));
            }
        }
        return stack.size()==0;
    }

    private static boolean pair(char a,char b) {
        return (a=='{' && b=='}')||(a=='[' && b==']')||(a=='(' && b==')');
    }

    static class Stack{
        private char[] data;
        int cur = -1;
        public Stack(int length) {
            this.data = new char[length];
        }

        public void push(char c) {
            if (cur+1>data.length-1) {
                throw new RuntimeException("full");
            }
            cur++;
            data[cur] = c;
        }

        public void pop() {
            if (cur>-1) {
                cur--;
            }
        }

        public int size() {
            return cur+1;
        }

        public char getTop() {
            if (cur>-1) {
                return data[cur];
            }else {
                throw new RuntimeException("empty");
            }
        }
    }
}
