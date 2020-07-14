package json;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author zyh
 * @date 2020/6/12
 */
public class JsonTest {
    public static void Json2Map() {
        String json = "{\"name\":\"zitong\", \"age\":\"26\"}";
        Map<String, String> map = new HashMap<String, String>();
        ObjectMapper mapper = new ObjectMapper();

        try {
            map = mapper.readValue(json, new TypeReference<HashMap<String, String>>() {});
            System.out.println(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Map2Json() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = "";

            Map<String, String> map = new HashMap<String, String>();
            map.put("name", "zitong");
            map.put("age", "26");

            json = mapper.writeValueAsString(map);

            System.out.println(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Map2Json();
    }
}
