package org.example.DataStructures;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.AbstractMap.SimpleEntry;

public class HuffmanTree {
    private Map<Character, Integer> characterToFrequencyMap = new HashMap<>();
    private HuffmanTreeNode root;
    private Map<Character, String> characterToCodeMap = new HashMap<>();

    public void buildHuffmanTree() {
        var minHeap = new PriorityQueue<>(new HuffmanTreeNodeComparator());
        for (Map.Entry<Character, Integer> entry : this.characterToFrequencyMap.entrySet()) {
            HuffmanTreeNode node = new HuffmanTreeNode(
                    entry.getKey().charValue(),
                    entry.getValue().intValue(),
                    null,
                    null,
                    false
            );
            minHeap.offer(node);
        }

        while (minHeap.size() > 1) {
            HuffmanTreeNode left = minHeap.poll();
            HuffmanTreeNode right = minHeap.poll();

            HuffmanTreeNode connectorNode = new HuffmanTreeNode(
                    ' ',
                    left.frequency() + right.frequency(),
                    left,
                    right,
                    true
            );
            minHeap.offer(connectorNode);
        }

        this.root = minHeap.poll();

        buildCharacterToCodeMap();
    }

    private void buildCharacterToCodeMap() {
        StringBuilder strBuilder = new StringBuilder();

        buildCharacterToCodeMapHelper(this.root, strBuilder);
    }

    private void buildCharacterToCodeMapHelper(HuffmanTreeNode root, StringBuilder strBuilder) {
        if (root == null) {
            throw new IllegalArgumentException("This should not happen.");
        }

        if (root.left() == null && root.right() == null) {
            this.characterToCodeMap.put(root.letter(), strBuilder.toString());
            strBuilder.deleteCharAt(strBuilder.length() - 1);
            return;
        }

        strBuilder.append("0");
        buildCharacterToCodeMapHelper(root.left(), strBuilder);
        strBuilder.append("1");
        buildCharacterToCodeMapHelper(root.right(), strBuilder);

        if (!strBuilder.isEmpty()) {
            strBuilder.deleteCharAt(strBuilder.length() - 1);
        }
    }

    public void updateCharacterFrequency(String line) {
        for (char c : line.toCharArray()) {
            int freq = characterToFrequencyMap.getOrDefault(c, 0).intValue();

            characterToFrequencyMap.put(c, freq + 1);
        }
    }

    public int getCharactersFrequency(Character c) {
        if (!this.characterToFrequencyMap.containsKey(c)) {
            return -1;
        }

        return this.characterToFrequencyMap.get(c).intValue();
    }
    public Map<Character, Integer> getCharacterToFrequencyMap() {
        return this.characterToFrequencyMap;
    }


    public HuffmanTreeNode getRoot() {
        return this.root;
    }

    public Map<Character, String> getCharacterToCodeMap() {
        return this.characterToCodeMap;
    }

    public String encode(String str) {
        StringBuilder stringBuilder = new StringBuilder();

        for (char c : str.toCharArray()) {
            stringBuilder.append(this.characterToCodeMap.get(c));
        }

        return stringBuilder.toString();
    }

    private SimpleEntry<Character, Integer> findLetter(String encoding, int startIndex) {
        var currentNode = this.root;

        int len = encoding.length();
        int currentIndex = startIndex;

        while (currentIndex < len && currentNode.isConnector()) {
            int direction = encoding.charAt(currentIndex);
            if (direction == '0') {
                currentNode = currentNode.left();
            } else {
                currentNode = currentNode.right();
            }
            currentIndex++;
        }

        return new SimpleEntry<>(currentNode.letter(), currentIndex);
    }

    public String decode(String encoding) {
        int i = 0;
        int len = encoding.length();
        StringBuilder stringBuilder = new StringBuilder();

        while (i < len) {
            var res = findLetter(encoding, i);

            i = res.getValue().intValue();
            stringBuilder.append(res.getKey());
        }

        return stringBuilder.toString();
    }
}
