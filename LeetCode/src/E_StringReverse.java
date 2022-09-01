
class E_StringReverse {
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;

        while(start <= end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start ++;
            end--;
        }
    }
    public static void main(String[] arg) {
    	E_StringReverse sol = new E_StringReverse();
        char[] s = {'h','e','l','l','o'};
        sol.reverseString(s);
        System.out.println(s);
    }
}