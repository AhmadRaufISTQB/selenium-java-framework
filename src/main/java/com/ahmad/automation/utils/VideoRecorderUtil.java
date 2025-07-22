package com.ahmad.automation.utils;

import org.monte.media.Format;
import org.monte.media.math.Rational;
import org.monte.media.Registry;
import org.monte.screenrecorder.ScreenRecorder;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import static org.monte.media.AudioFormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

public class VideoRecorderUtil {

    private static ScreenRecorder screenRecorder;

    public static void startRecording(String testName) {
        try {
            File dir = new File("videos/");
            if (!dir.exists()) dir.mkdirs();

            GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment()
                    .getDefaultScreenDevice().getDefaultConfiguration();

            screenRecorder = new ScreenRecorder(gc,
                    gc.getBounds(),
                    new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
                    new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                            CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                            DepthKey, 24, FrameRateKey, Rational.valueOf(15),
                            QualityKey, 1.0f,
                            KeyFrameIntervalKey, 15 * 60),
                    new Format(MediaTypeKey, MediaType.AUDIO,
                            EncodingKey, ENCODING_PCM_SIGNED,
                            SampleRateKey, new Rational(44100, 1),
                            SampleSizeInBitsKey, 16,
                            ChannelsKey, 2,
                            FrameRateKey, Rational.valueOf(30),
                            SignedKey, true),
                    null, dir);

            screenRecorder.start();
        } catch (IOException | AWTException e) {
            e.printStackTrace();
        }
    }

    public static void stopRecording(String testName) {
        try {
            if (screenRecorder != null) {
                screenRecorder.stop();
                File latestFile = screenRecorder.getCreatedMovieFiles().get(0);
                latestFile.renameTo(new File("videos/" + testName + ".avi"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
