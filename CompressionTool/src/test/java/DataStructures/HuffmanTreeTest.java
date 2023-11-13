package DataStructures;

import org.example.DataStructures.HuffmanTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class HuffmanTreeTest {
    @Test
    public void getCharacterFrequencyWhenCharacterDoesNotExistReturnsNegativeOne() {
        // Arrange.
        char c = 'z';
        HuffmanTree tree = new HuffmanTree();

        // Act.
        int frequency = tree.getCharactersFrequency(c);

        // Assert.
        Assertions.assertEquals(-1, frequency);
    }

    @Test
    public void getCharacterFrequencyWhenCharactersDoExistReturnsCorrectFrequency() {
        char space = ' ';
        char a ='a';
        char exPoint ='!';
        char question = '?';
        HuffmanTree tree = new HuffmanTree();
        String data = "Hel this is ta:!:!??(*i";

        // Act.
        tree.updateCharacterFrequency(data);

        // Assert.
        Assertions.assertEquals(3, tree.getCharactersFrequency(space));
        Assertions.assertEquals(1, tree.getCharactersFrequency(a));
        Assertions.assertEquals(2, tree.getCharactersFrequency(exPoint));
        Assertions.assertEquals(2, tree.getCharactersFrequency(question));
    }
}
