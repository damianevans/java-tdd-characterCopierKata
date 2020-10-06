package org.damo;

import org.damo.interfaces.Destination;
import org.damo.interfaces.Source;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class CharacterCopier {
    private Source source;
    private Destination destination;

    public CharacterCopier(Source source, Destination destination){

        this.source = source;
        this.destination = destination;
    }

    public void copy() throws Exception {
        if(!source.validate()) {
            throw new Exception("Validation failed");
        }

        char c = source.getChar();

        if(c == '\n')
            return;

        do {
            destination.setChar(c);
            c = source.getChar();
        } while (c != '\n');

    }
}
