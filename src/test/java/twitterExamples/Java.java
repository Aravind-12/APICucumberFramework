package twitterExamples;

public class Java {

    public static int IndexCheck(String s1, String s2) {
        int pos = 0;
        if (s1.contains(s2) == true) {
            pos = (s1.indexOf(s2));
            return pos;
        } else {
            return 1;
        }

    }

    public static void main(String args[]) {

        String str1 = "Go green";
        String str2 = "Go";
        IndexCheck(str1, str2);

    }
}
