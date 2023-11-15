package DataStructures;

public class HuffmanTreeNode {
    private int frequency;

    private char letter;

    private HuffmanTreeNode left;

    private HuffmanTreeNode right;

    public HuffmanTreeNode(char letter, int frequency) {
        this.letter = letter;
        this.frequency = frequency;
    }

    public HuffmanTreeNode(char letter, int frequency, HuffmanTreeNode left, HuffmanTreeNode right) {
        this.letter = letter;
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public char getLetter() {
        return letter;
    }

    public HuffmanTreeNode getLeft() {
        return left;
    }

    public void setLeft(HuffmanTreeNode left) {
        this.left = left;
    }

    public HuffmanTreeNode getRight() {
        return right;
    }

    public void setRight(HuffmanTreeNode right) {
        this.right = right;
    }
}
