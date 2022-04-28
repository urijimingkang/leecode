package com.andy.tiger.test;
import java.util.Comparator;
import java.util.function.Consumer;

public class InteviewTest {
    public static void main(String[] args) {
        Comparator<Integer> com = (x, y) -> Integer.compare(x,y);
        com.compare(1,2);
    }
}
