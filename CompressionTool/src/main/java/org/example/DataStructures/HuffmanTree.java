package org.example.DataStructures;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanTree {
    private Map<Character, Integer> characterToFrequencyMap = new HashMap<>();

    public void buildHuffmanTree() {
        var minHeap = new PriorityQueue<>(new HuffmanTreeNodeComparator());
        for (Map.Entry<Character, Integer> entry : this.characterToFrequencyMap.entrySet()) {
            HuffmanTreeNode node = new HuffmanTreeNode(entry.getKey().charValue(), entry.getValue().intValue(), null, null);
            minHeap.offer(node);
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
}
