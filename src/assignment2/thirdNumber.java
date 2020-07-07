package assignment2;

import java.awt.font.FontRenderContext;
import java.lang.reflect.Array;
import java.util.Arrays;

public class thirdNumber {
    public static void thirdNum() {
        int ary[] = new int[40];
        for (int i = 10; i < ary.length+10; i++) {
            ary[i-10] = i;
        }
        for (int i = 0; i < ary.length; i+= 3){
            System.out.println(ary[i]);
        }
    }

    public static void main(String[] args) {
        thirdNum();
    }
}
