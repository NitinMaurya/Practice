package practice.designPatterns.strategy.compression;

import java.io.File;
import java.util.Set;

public interface CompressionStrategy {
    void compressFile(Set<File> files);
}
