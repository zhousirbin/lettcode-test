package company.memory;

public class JavaVMStackSOF {
    private int stacklen = 1;
    public void stackLeak(){
        stacklen++;
        //System.out.println(stacklen);
        stackLeak();
    }

    public static void main(String[] args) throws Throwable{

       JavaVMStackSOF oom = new JavaVMStackSOF();
        System.out.println("zhou");
        try {

            oom.stackLeak();

        } catch (Throwable e) {
            System.out.println(oom.stacklen);
            System.out.println("zhou");

            throw e;
        }
    }
}
