package design_patterns.facade.demo1;

import concepts.design_patterns.facade.demo1.Codec;
import concepts.design_patterns.facade.demo1.MPEG4CompressionCodec;
import concepts.design_patterns.facade.demo1.OggCompressionCodec;
import concepts.design_patterns.facade.demo1.VideoFile;

public class CodecFactory {

    public static Codec extract(VideoFile file) {
        String type = file.getCodecType();
        if (type.equals("mp4")) {
            System.out.println("CodecFactory: extracting mpeg audio...");
            return new MPEG4CompressionCodec();
        }
        else {
            System.out.println("CodecFactory: extracting ogg audio...");
            return new OggCompressionCodec();
        }
    }
}
