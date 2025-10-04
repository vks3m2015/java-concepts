package design_patterns.facade.demo1;

import concepts.design_patterns.facade.demo1.AudioMixer;
import concepts.design_patterns.facade.demo1.BitrateReader;
import concepts.design_patterns.facade.demo1.Codec;
import concepts.design_patterns.facade.demo1.CodecFactory;
import concepts.design_patterns.facade.demo1.MPEG4CompressionCodec;
import concepts.design_patterns.facade.demo1.OggCompressionCodec;
import concepts.design_patterns.facade.demo1.VideoFile;

import java.io.File;

public class VideoConversionFacade {

    public File convertVideo(String fileName, String format) {
        System.out.println("VideoConversionFacade: conversion started.");
        concepts.design_patterns.facade.demo1.VideoFile file = new concepts.design_patterns.facade.demo1.VideoFile(fileName);
        concepts.design_patterns.facade.demo1.Codec sourceCodec = CodecFactory.extract(file);
        Codec destinationCodec;
        if (format.equals("mp4")) {
            destinationCodec = new MPEG4CompressionCodec();
        } else {
            destinationCodec = new OggCompressionCodec();
        }
        concepts.design_patterns.facade.demo1.VideoFile buffer = concepts.design_patterns.facade.demo1.BitrateReader.read(file, sourceCodec);
        VideoFile intermediateResult = BitrateReader.convert(buffer, destinationCodec);
        File result = (new AudioMixer()).fix(intermediateResult);
        System.out.println("VideoConversionFacade: conversion completed.");
        return result;
    }
}
