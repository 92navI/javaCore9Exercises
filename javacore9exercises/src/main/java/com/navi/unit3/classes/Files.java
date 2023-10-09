package com.navi.unit3.classes;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;

public class Files {
    public static ArrayList<File> subDir(File file, FileFilter filter) throws IOException {
        if (file.isDirectory()) {
            var output = new ArrayList<File>();
            var list = file.listFiles(filter);
            for (File f : list) {
                output.add(f);
            }
            return output;
        } else {
            throw new IOException("The file is not a directory!");
        }
    }

    public static ArrayList<File> subDirAll(File file) throws IOException {
        return subDir(file, (f) -> true);
    }

    public static ArrayList<String> listIncluding(File file, FilenameFilter filter)
            throws IOException {
        if (file.isDirectory()) {
            var output = new ArrayList<String>();
            var list = file.list(filter);
            for (String f : list) {
                output.add(f);
            }
            return output;
        } else {
            throw new IOException("The file is not a directory!");
        }
    }

    public static ArrayList<String> listIncluding(File file, String filter) throws IOException {
        return listIncluding(file, (f, name) -> name.contains(filter));
    }
}
