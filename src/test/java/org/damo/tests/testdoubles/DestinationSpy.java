package org.damo.tests.testdoubles;

import org.damo.interfaces.Destination;

public class DestinationSpy implements Destination {

    String copiedCharacters = new String();

    public void setChar(char c) {
        copiedCharacters += c;
    }

    public String getCopiedCharacters() {
        return copiedCharacters;
    }
}
