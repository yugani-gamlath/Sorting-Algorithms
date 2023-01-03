
//package stringsorting;

import java.util.Arrays;

public class Stringsorting {

    public static void main(String[] args) {

        String[] name = { "Kamal", "Nishadi", "Kalana" };

        for (int i = 0; i < name.length; i++) {

            Arrays.sort(name);

        }
        System.out.println();

        System.out.println("sorted Array");

        for (int j = 0; j < name.length; j++) {
            System.out.println(name[j] + " ");

        }

    }

}
