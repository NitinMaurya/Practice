package practice.designPatterns.strategy.compression;

import java.io.File;
import java.util.Set;

public class RARCompressionStrategy implements CompressionStrategy {
    @Override
    public void compressFile(Set<File> files) {
        System.out.println("Compressing files using RAR Compression");
    }
}
