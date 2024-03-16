package ArraysAndHashing;

import java.util.*;


public class EncodeAndDecode{
    private static String delim = ",";

    public static String encode(String[] strs) {
       StringBuilder encoder = new StringBuilder();

       for (String str : strs) {
           encoder.append(str).append(delim);
       }
       encoder.deleteCharAt(encoder.length()-1);

       return encoder.toString();
    }

    public static String[] decode(String str) {
        return str.split(delim);
    }

    public static void main(String[] args) {
        String[] strs = {"Hi","I","Am","A","List","of","strings"};
        String[] expected = {"Hi","I","Am","A","List","of","strings"};

        String encoded = encode(strs);
        String[] decoded = decode(encoded);

        System.out.println(decoded[0]);
        System.out.println(expected[0]);
    }
}
