package test;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class JsonTest2 {
    public static void main(String args[]) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "[{\"name\":\"Mahesh\", \"age\":21},{\"name\":\"zhou\", \"age\":21}]";

        String jsonString1 = "[{\"name\":\"Mahesh\", \"age\":21},{\"name\":\"zhou\", \"age\":21}]";
        List list = null;
        list = mapper.readValue(jsonString, List.class);
        System.out.println(list);
        for (Object a:list
             ) {    System.out.println(a);

        }


        ObjectMapper mapper1 = new ObjectMapper();
        JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, Student.class);
       //如果是Map类型  mapper.getTypeFactory().constructParametricType(HashMap.class,String.class, Bean.class);
        List<Student> lst =  (List<Student>)mapper1.readValue(jsonString, javaType);

        System.out.println(lst);
        // Student student = mapper.readValue(jsonString, HashMap.class);

       // System.out.println(student);



        System.out.println("=================");

        Student[] students = mapper.readValue(jsonString, Student[].class);
        for (Student student : students) {
            System.out.println(">"+student.toString());
        }
    }
}
