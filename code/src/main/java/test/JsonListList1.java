package test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class JsonListList1 {
    public static void main(String args[]) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "[{\"name\":\"Mahesh\", \"age\":21},{\"name\":\"zhou\", \"age\":21}]";

        String jsonString1 = "[[{\"name\":\"Mahesh\", \"age\":21},{\"name\":\"zhou\", \"age\":21}],[{\"name\":\"xiaoming\", \"age\":21},{\"name\":\"xioahong\", \"age\":21}]]";

        String jsonString2 = "[[{\"name\":\"Mahesh\", \"age\":21},{\"name\":\"zhou\", \"age\":21}],[{\"name\":\"xiaoming\", \"age\":21},{\"name\":\"xioahong\", \"age\":21}]]";
        List list = null;

        list = mapper.readValue(jsonString, List.class);
        JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, Student.class);
        List<Student> list1 = mapper.readValue(jsonString,javaType);

        System.out.println(list);

        System.out.println("list1"+list1);
        for (Object a:list
                ) {    System.out.println(a);

        }

//        new TypeReference<List<List<Student>>>() {}

        // 这个可以实现
        List<Student3> list2 = mapper.readValue(jsonString1,new TypeReference<List<List<Student>>>() {});
        System.out.println("list2"+list2);


//        JavaType javaType1 = mapper.getTypeFactory().constructParametricType(List.class, Student3.class);
//
//        List<Student3> list3 = mapper.readValue(jsonString1,javaType1);
//        System.out.println("list3"+list3);


       Type a =  TypeUtils.getParameterizedType(List.class, Student3.class);

        List<Student3> list4 = mapper.readValue(jsonString1,mapper.getTypeFactory().constructType(a));
        System.out.println("list4"+list4);


        // 这个可以实现
        List<Student3> list5 = mapper.readValue(jsonString1,new TypeReference<List<Student3>>() {});
        System.out.println("list5"+list5);

    }
}
