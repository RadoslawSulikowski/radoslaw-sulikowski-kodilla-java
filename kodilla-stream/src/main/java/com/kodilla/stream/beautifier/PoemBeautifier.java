package com.kodilla.stream.beautifier;

public class PoemBeautifier{



    public void beautify(String textToBeautify, PoemDecorator poemDecorator){
        String decoratedText = poemDecorator.decorate(textToBeautify);
        System.out.println("Beautified text: " + decoratedText);


    }
}
