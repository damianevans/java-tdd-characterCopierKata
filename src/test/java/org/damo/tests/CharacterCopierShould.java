package org.damo.tests;

import org.damo.CharacterCopier;
import org.damo.tests.testdoubles.DestinationSpy;
import org.damo.tests.testdoubles.SourceStub;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class CharacterCopierShould {
    @Test
    public void NotCopy_WhenOnlyGivenNewline() throws Exception {
        SourceStub sourceStub = new SourceStub("\n");
        DestinationSpy destinationSpy = new DestinationSpy();
        CharacterCopier copier=new CharacterCopier(sourceStub, destinationSpy);
        copier.copy();
        assertThat(destinationSpy.getCopiedCharacters()).isEqualTo("");
    }

    @Test
    public void CopyA_WhenGiven_AandNewline() throws Exception {
        SourceStub sourceStub = new SourceStub("A\n");
        DestinationSpy destinationSpy = new DestinationSpy();
        CharacterCopier copier=new CharacterCopier(sourceStub, destinationSpy);
        copier.copy();
        assertThat(destinationSpy.getCopiedCharacters()).isEqualTo("A");
    }

    @Test
    public void CopyABC_WhenGiven_ABCandNewline() throws Exception {
        SourceStub sourceStub = new SourceStub("ABC\n");
        DestinationSpy destinationSpy = new DestinationSpy();
        CharacterCopier copier=new CharacterCopier(sourceStub, destinationSpy);
        copier.copy();
        assertThat(destinationSpy.getCopiedCharacters()).isEqualTo("ABC");
    }

    @Test
    public void ThrowException_WhenNotPassedANewLine() {


        assertThatThrownBy( () -> {
            SourceStub sourceStub = new SourceStub("ABC");
            DestinationSpy destinationSpy = new DestinationSpy();
            CharacterCopier copier=new CharacterCopier(sourceStub, destinationSpy);
            copier.copy();
        } ).hasMessage("Source has no newline character");
    }
}
