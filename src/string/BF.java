package string;

public class BF {

    public int find(String str, String subStr) {
        if (str.length() < subStr.length()) {
            return -1;
        }
        outer:
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < subStr.length(); j++) {
                if (i + j < str.length()) {
                    if (str.charAt(i+j) != subStr.charAt(j)) {
                        continue outer;
                    }
                }
            }
            return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        BF bf = new BF();
        System.out.println(bf.find("1234abcd", "abc"));
        System.out.println(bf.find("1234abcd", "abcd"));
        System.out.println(bf.find("1234abcd", "abd"));
        System.out.println(bf.find("1234abcd", "1234abc"));
    }



}
