package br.com.agibank.javatest.service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.google.common.collect.Lists;

import br.com.agibank.javatest.pojo.base.IData;
import br.com.agibank.javatest.service.DataAnalysisBEAService;
import br.com.agibank.javatest.service.DataAnalysisSystemService;
import br.com.agibank.javatest.utils.AgibankFileUtils;
import br.com.agibank.javatest.utils.DataFactory;

public class DataAnalysisSystemServiceImpl implements DataAnalysisSystemService {

    private static final long serialVersionUID = -5288650650746875332L;
    private List<IData> dataList = null;

    public void initDataAnalysisSystem() {
        try {
            for (File file : readFilesFromDirectory()) {
                List<String> contents = AgibankFileUtils.readLinesFromFile(file);
                dataList = Lists.newArrayList();
                for (String line : contents) {
                    read(line);
                }
                DataAnalysisBEAService data = new DataAnalysisBEAServiceImpl(dataList);
                AgibankFileUtils.deleteFile(file);
                generateDataOut(file, data.getSummarize().toString());
            }
        } catch (final Exception e) {
        }
    }

    private void generateDataOut(File file, String summarize) throws IOException {
        StringBuilder pathDirectoryOut = new StringBuilder();
        pathDirectoryOut.append(System.getenv("HOMEPATH")).append(File.separatorChar).append("data").append(File.separatorChar)
                .append("out").append(File.separatorChar).append(file.getName());
        File fileOut = new File(pathDirectoryOut.toString());
        BufferedWriter output = new BufferedWriter(new FileWriter(fileOut));
        output.write(summarize);
        output.close();
    }

    private Collection<File> readFilesFromDirectory() {
        StringBuilder pathDirectoryIn = new StringBuilder();
        pathDirectoryIn.append(System.getenv("HOMEPATH")).append(File.separatorChar).append("data").append(File.separatorChar).append("in");
        Collection<File> files = FileUtils.listFiles(new File(pathDirectoryIn.toString()), null, Boolean.FALSE);
        return files;
    }

    private void read(String line) {

        try {
            String[] tuple = line.split("ç");
            String idStr = tuple[0].trim();
            // Error in first caracter windows system file;
            if (idStr.length() == 4) {
                idStr = idStr.substring(1);
            }
            Integer id = Integer.parseInt(idStr);
            DataFactory dataFactory = new DataFactory();
            dataList.add(dataFactory.generateData(id, tuple));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}