package demo.designPatterns.strategy.compression;

import java.io.File;
import java.util.Set;

public class CompressionContext {
    private final CompressionStrategy compressionStrategy;

    public CompressionContext(CompressionStrategy compressionStrategy){
        this.compressionStrategy = compressionStrategy;
    }

    public void archiveFiles(Set<File> files){
        this.compressionStrategy.compressFile(files);
    }
}
