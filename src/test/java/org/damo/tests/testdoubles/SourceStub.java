package org.damo.tests.testdoubles;

import org.damo.interfaces.Source;

public class SourceStub implements Source {

    private String initalData;
    int counter = 0;

    public SourceStub(String initalData) {
        this.initalData = initalData;
    }

    public char getChar() {
        char c = initalData.charAt(counter);
        counter++;
        return c;
    }

    @Override
    public boolean validate() {
        return initalData.contains("\n");
    }
}
