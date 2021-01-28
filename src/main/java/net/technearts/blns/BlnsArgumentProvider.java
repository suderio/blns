package net.technearts.blns;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Stream;
import java.util.logging.Logger;
import static java.nio.charset.StandardCharsets.UTF_8;

public class BlnsArgumentProvider implements ArgumentsProvider {
    private final static Logger LOGGER = Logger.getLogger("Blns Logger");
    private JSONArray jsonArray;

    public BlnsArgumentProvider() {
        JSONParser parser = new JSONParser();
        try {
            InputStream is = this.getClass().getResourceAsStream("/blns.json");
            Object obj = parser.parse(new BufferedReader(new InputStreamReader(is, UTF_8), 8192));
            jsonArray = (JSONArray) obj;
        } catch (Exception e) {
            LOGGER.severe("File blns.json not found! This is unexpected.");
            e.printStackTrace();
        }
    }

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return jsonArray.stream().map(s -> Arguments.of(s));
    }

    public Stream<String> provideStrings() {
        return jsonArray.stream();
    }
}
