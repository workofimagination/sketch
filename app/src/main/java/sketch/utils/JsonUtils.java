package sketch.utils;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonUtils {
    public static String toJson(Object obj) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(obj);
        return jsonString;
    }
}
