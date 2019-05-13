package company.code.innerClass;

public class InnerClass {

    private int i=0;

    People people = new People();

    class Tree {

        public void drawSahpe() {
            System.out.println(i);  //外部类的private成员--内部类可以访问--外部的私有成员
        }
    }
}
