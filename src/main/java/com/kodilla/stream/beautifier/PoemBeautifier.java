package com.kodilla.stream.beautifier;

public class PoemBeautifier {

    public void beautify(String stringToBeautify, PoemDecorator poemDecorator) {
        poemDecorator.decorate(stringToBeautify);
    }
}
