package demo.designPatterns.strategy.compression.client;

import demo.designPatterns.strategy.compression.CompressionContext;
import demo.designPatterns.strategy.compression.RARCompressionStrategy;
import demo.designPatterns.strategy.compression.ZIPCompressionStrategy;

import java.util.Collections;
import java.util.HashSet;

public class Client {
    public static void main(String[] args) {
        CompressionContext context = new CompressionContext(new ZIPCompressionStrategy());
        CompressionContext newContext = new CompressionContext(new RARCompressionStrategy());
        context.archiveFiles(Collections.emptySet());
        newContext.archiveFiles(new HashSet<>());
    }
}
