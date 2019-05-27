package com.kodilla.exception.index;

import java.util.List;

public class IndexExceptionRunner{
    public static void main(String[] args){

        List<String> collection = new VideoCollector().getCollection();

        System.out.println(collection.get(0));
        System.out.println(collection.get(1));
    }
}
