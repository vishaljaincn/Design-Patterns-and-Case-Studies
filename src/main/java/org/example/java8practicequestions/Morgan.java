package org.example.java8practicequestions;

public class Morgan {
    public static void main(String[] args) {
        String s = "vishal";
        StringBuilder sb = new StringBuilder("anil");
        Morgan m = new Morgan();
        m.addString(s);
        m.addStringBuilder(sb);
        System.out.println(s);
        System.out.println(sb);
        String v = "morgan";
        String v1 = new String("morgan");
        System.out.println(v == v1); // false, because v1 is a new String object
    }

    public void addString(String s) {
        s += " jain";
        System.out.println(s);
    }

    public void addStringBuilder(StringBuilder sb) {
        sb.append(" jain");
        System.out.println(sb);
    }
}
