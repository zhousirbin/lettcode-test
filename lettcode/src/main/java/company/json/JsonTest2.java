package company.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonTest2 {
    public static void main(String args[]) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\"name\":\"Mahesh\", \"age\":21}";

        Student strudent = mapper.readValue(jsonString, Student.class);

        System.out.println(strudent);
    }
}
