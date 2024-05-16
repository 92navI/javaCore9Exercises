package com.navi.unit10.classes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class DirReader {

    public static HashMap<String, List<File>> parallelSearchAll(String path)
            throws IOException, InterruptedException, ExecutionException {
        var dir = new File(path);
        var exec = Executors.newCachedThreadPool();

        if (dir.isDirectory()) {
            var files = new ArrayList<File>(Arrays.asList(dir.listFiles()));
            var tasks = new ArrayList<Callable<File>>();
            var mapping = new ConcurrentHashMap<String, CopyOnWriteArraySet<File>>();

            files.forEach(file -> tasks.add(() -> {
                String[] text = Files.readString(file.toPath()).split("(\u0020|\n)");

                Arrays.stream(text).forEach((word) -> {
                    if (mapping.containsKey(word)) {
                        mapping.compute(word, (k, v) -> {
                            v.add(file);
                            return v;
                        });
                    } else
                        mapping.put(word, new CopyOnWriteArraySet<File>(List.of(file)));
                });
                return null;
            }));

            exec.invokeAll(tasks);
            return (HashMap<String, List<File>>) mapping.entrySet().stream().collect(
                    Collectors.toMap(
                            Entry::getKey,
                            e -> List.copyOf(e.getValue())));
        } else {
            throw new IOException("The file \"" + dir.toString() + "\" is not a directory.");
        }
    }

    public static List<File> parallelSearch(String path, String word) throws IOException {
        var dir = new File(path);

        if (dir.isDirectory()) {
            var files = new ArrayList<File>(Arrays.asList(dir.listFiles()));
            var outputs = new ArrayList<File>();

            files.parallelStream().forEach(f -> {
                try {
                    if (Files.readAllLines(f.toPath()).contains(word))
                        outputs.add(f);
                } catch (IOException ignored) {
                }
            });

            return outputs;
        } else {
            throw new IOException("The file \"" + dir.toString() + "\" is not a directory.");
        }
    }

    public static File threadSearch(String path, String word)
            throws IOException, InterruptedException, ExecutionException {
        var dir = new File(path);
        var exec = Executors.newCachedThreadPool();

        if (dir.isDirectory()) {
            var files = new ArrayList<File>(Arrays.asList(dir.listFiles()));
            var tasks = new ArrayList<Callable<File>>();

            files.forEach(file -> tasks.add(() -> {
                try (var reader = new Scanner(file);) {
                    while (reader.hasNextLine()) {
                        if (Thread.interrupted())
                            throw new InterruptedException("The thread was interrupted!");
                        if (reader.nextLine().contains(word))
                            return file;
                    }
                }
                throw new IOException("The word was not found in \"" + file + "\"");
            }));

            return exec.invokeAny(tasks);
        } else {
            throw new IOException("The file \"" + dir.toString() + "\" is not a directory.");
        }
    }
}