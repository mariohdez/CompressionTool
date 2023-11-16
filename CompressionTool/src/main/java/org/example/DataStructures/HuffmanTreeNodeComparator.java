package org.example.DataStructures;

import java.util.Comparator;

public class HuffmanTreeNodeComparator implements Comparator<HuffmanTreeNode> {
    @Override
    public int compare(HuffmanTreeNode a, HuffmanTreeNode b) {
        return a.frequency() - b.frequency();
    }
}
