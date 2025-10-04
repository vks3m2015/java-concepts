package design_patterns.facade.demo1;

import concepts.design_patterns.facade.demo1.VideoConversionFacade;

import java.io.File;

//https://refactoring.guru/design-patterns/facade/java/example
public class Demo {

    public static void main(String[] args) {
        VideoConversionFacade converter = new VideoConversionFacade();
        File mp4Video = converter.convertVideo("youtubevideo.ogg", "mp4");
        // ...
    }
}
