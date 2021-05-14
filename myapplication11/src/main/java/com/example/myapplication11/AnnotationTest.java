package com.example.myapplication11;


import java.util.Arrays;
import java.util.List;

public class AnnotationTest {
    public static void main(String[] args) {

    }

    @SafeVarargs
    static void m(List<String>... stringLists) {
        Object[] array = stringLists;
        List<Integer> tmpList = Arrays.asList(42);
        array[0] = tmpList; // Semantically invalid, but compiles without warnings
        String s = stringLists[0].get(0); // Oh no, ClassCastException at runtime!
    }
}
