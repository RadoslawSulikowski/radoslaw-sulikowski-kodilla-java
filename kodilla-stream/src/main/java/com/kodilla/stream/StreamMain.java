package com.kodilla.stream;

import com.kodilla.stream.Iterate.NumbersGenerator;
import com.kodilla.stream.beautifier.PoemBeautifier;

public class StreamMain {
    public static void main(String[] args){

        PoemBeautifier poemBeautifier = new PoemBeautifier();

        //Task beautifiers
        poemBeautifier.beautify("Some text to beautify", textToDecorate -> "ABC" + textToDecorate + "ABC");
        poemBeautifier.beautify("Some text to beautify", textToDecorate -> textToDecorate.toUpperCase());

        //Own beautifiers
        poemBeautifier.beautify("Some text to beautify",
                textToDecorate -> "(_8(|)" + textToDecorate.replace( " ","(_8(|) (_8(|)") + "(_8(|)");

        poemBeautifier.beautify("Some text to beautify", textToDecorate -> {
            StringBuilder beautifiedText = new StringBuilder();
            for(int i = 0; i < textToDecorate.length(); i++){
                if(i % 2 == 0){
                    beautifiedText.append(Character.toUpperCase(textToDecorate.charAt(i)));
                }
                if(i % 2 == 1){
                    beautifiedText.append(Character.toLowerCase(textToDecorate.charAt(i)));
                }
            }
            return beautifiedText.toString();
        });
        poemBeautifier.beautify("Some text to beautify", textToDecorate -> " (_8(|)" + textToDecorate + "(_8(|) ");

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);
    }
}

