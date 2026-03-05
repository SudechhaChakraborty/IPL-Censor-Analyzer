package com.example.util;

import com.example.model.Match;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;

public class JSONHandler {

    private static ObjectMapper mapper = new ObjectMapper();

    public static List<Match> readJSON(String filePath) throws Exception {

        return mapper.readValue(
                new File(filePath),
                new TypeReference<List<Match>>() {}
        );
    }

    public static void writeJSON(String filePath, List<Match> matches) throws Exception {

        mapper.writerWithDefaultPrettyPrinter()
                .writeValue(new File(filePath), matches);
    }
}