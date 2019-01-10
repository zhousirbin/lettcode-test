package test;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import java.io.IOException;
import java.util.List;

public class JsonTest1 {

    public static void main(String args[]) throws IOException {



        String jsonString1 = "{\"name_id\":\"Mahesh\", \"age_id\":21}";
        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
       // mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Student1 a= mapper.readValue(jsonString1,Student1.class);

        System.out.println(a.getAgeId()+a.getNameId());


        // 如果为字符串类型的整型，可以直接转换为整型。或者Integer,
        String jsonString2 = "{\"nameId\":\"Mahesh\", \"ageId\":21}";

        ObjectMapper mapper2 = new ObjectMapper();
        //mapper2.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        // mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Student2 b= mapper2.readValue(jsonString2,Student2.class);

        System.out.println("b"+b.getAgeId()+b.getNameId());




        String jsonString = "[{\"name_id\":\"Mahesh\", \"age_id\":21},{\"name_id\":\"zhou\", \"age_id\":21, \"an_id\":21}]";
        ObjectMapper mapper1 = new ObjectMapper();
        JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, Student1.class);
        mapper1.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        mapper1.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);  //不去管多余的参数，要不an_id会报错
        //如果是Map类型  mapper.getTypeFactory().constructParametricType(HashMap.class,String.class, Bean.class);
        List<Student1> lst =  (List<Student1>)mapper1.readValue(jsonString, javaType);

        System.out.println(lst);





    }
    public static <T> T toSnakeObject(String json, Class<T> clazz) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
//        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        T reqJson =  mapper.readValue(json, clazz);
        System.out.println(reqJson);
        return reqJson;
    }
}
