package com.sofy.book.util;

public class IdGenerator {
    private static int id = 0;

    public static int GenerateId(){
        return id++;
    }
}
