package br.com.agibank.javatest.utils;

import java.io.File;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class AgibankFileUtils {

    public static void deleteFile(File file) {
        FileUtils.deleteQuietly(file);
    }

    public static List<String> readLinesFromFile(File file) throws Exception {
        return FileUtils.readLines(file, Charset.forName("UTF-8"));
    }

}
