/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.flp.csv2sql.parser;

import com.ibm.icu.text.CharsetDetector;
import com.ibm.icu.text.CharsetMatch;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author feherlaszlo
 */
public class CSVParser {

    private File file;
    private String charset;
    private Reader reader;
    private String selector = ",";
    private ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();

    public CSVParser(File file) throws FileNotFoundException, IOException {
        this.file = file;
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file.getAbsolutePath()));
        CharsetDetector cd = new CharsetDetector();
        cd.setText(bis);
        CharsetMatch cm = cd.detect();

        if (cm != null) {
            reader = cm.getReader();
            charset = cm.getName();
        } else {
            throw new UnsupportedCharsetException("");
        }
    }

    public ArrayList<ArrayList<String>> parse() {
        Charset charset = Charset.forName(this.charset);
        try (BufferedReader reader = Files.newBufferedReader(this.file.toPath(), charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(selector);
                ArrayList<String> aDetails = new ArrayList();
                for (int i = 0; i < details.length; i++) {
                    aDetails.add(details[i]);
                }
                this.data.add(aDetails);
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        return this.data;
    }

    //getters setters
    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public String getSelector() {
        return selector;
    }

    public void setSelector(String selector) {
        this.selector = selector;
    }

}
