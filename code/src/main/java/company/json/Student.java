package company.json;

import javax.validation.constraints.Min;

public class Student {

        @Min(value = 123)
        private String name;
        private Integer age;
        public Student(){}
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }
        public String toString(){
            return "Student [ name: "+name+", age: "+ age+ " ]";
        }

}
