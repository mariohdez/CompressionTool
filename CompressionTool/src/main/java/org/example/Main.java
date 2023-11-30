package org.example;

import org.example.DataStructures.HuffmanTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    private static HuffmanTree huffmanTree = new HuffmanTree();

    public static void main(String[] args) {
        if (args.length != 1) {
            throw new IllegalArgumentException("Must include the filename as part of the command line arguments.");
        }

        String filePath = args[0];
        Path path = Path.of(URI.create("file:///"+filePath));

        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line = null;

            while ((line = reader.readLine()) != null) {
                huffmanTree.updateCharacterFrequency(line);
            }
        } catch (IOException ioe) {
            System.err.format("IOException: %s%n", ioe);
            System.err.println(ioe.getStackTrace());
        }

        System.out.println("done.");
    }
}