package design_patterns.facade.demo1;

import concepts.design_patterns.facade.demo1.Codec;
import concepts.design_patterns.facade.demo1.VideoFile;

public class BitrateReader {
    public static concepts.design_patterns.facade.demo1.VideoFile read(concepts.design_patterns.facade.demo1.VideoFile file, concepts.design_patterns.facade.demo1.Codec codec) {
        System.out.println("BitrateReader: reading file...");
        return file;
    }

    public static concepts.design_patterns.facade.demo1.VideoFile convert(VideoFile buffer, Codec codec) {
        System.out.println("BitrateReader: writing file...");
        return buffer;
    }
}