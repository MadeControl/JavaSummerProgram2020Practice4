package com.epam.rd.java.basic.practice4;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part4 implements Iterable<String> {

    private static final String REGEX = "(\\w+\\s*)+\\.";
    private static final String FILE_CONTENT = Part1.readFromFile("part4.txt", "cp1251");

    public static void main(String[] args) {

        Part4 part4 = new Part4();
        StringBuilder stringBuilder = new StringBuilder();

        for (String s : part4) {
            stringBuilder.append(s).append(System.lineSeparator());
        }

        System.out.print(stringBuilder.toString());

    }

    @Override
    public Iterator<String> iterator() {
        return new MyClass();
    }

    private class MyClass implements Iterator<String> {

        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(FILE_CONTENT);

        @Override
        public boolean hasNext() {
            return matcher.find();
        }

        @Override
        public String next() {
            return matcher.group();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}
