package company.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class JsonTest1 {
    public static void main(String args[]) throws IOException {
        List list = null;

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\"name\":\"Mahesh\", \"age\":21}";

        Student strudent = mapper.readValue(jsonString,Student.class);

        System.out.println(strudent);

        //map json to student
//        try {
//            Student student = mapper.readValue(jsonString, Student.class);
//            System.out.println(student);
//            //mapper.enable(Feature.INDENT_OUTPUT);
//            //把对象转成json string类型的
//            jsonString = mapper.writeValueAsString(student);
//            System.out.println(jsonString);
//
//        } catch (JsonParseException e) {
//            e.printStackTrace();
//        } catch (JsonMappingException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        public static <T extends Object> List<T> toList(String json, Class<T> clazz) {
//            List<T> list;
//            TypeFactory factory = TypeFactory.defaultInstance();
//
//            try {
//                if (json != null && !"".equals(json)) {
//                    list = mapper.readValue(json, factory.constructCollectionType(ArrayList.class, clazz));
//                } else {
//                    throw new Exception("json不能为空串。");
//                }
//            } catch (Exception ex) {
//
//            }
//            return list;
//        }
    }


}



