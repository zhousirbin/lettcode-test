package company.exception;


public class Test1Exception {
    public Test1Exception() {
    }

    boolean testEx() throws Exception {
        boolean ret = true;
        try {
            ret = testEx1();
        } catch (Exception e) {
            System.out.println("testEx, catch exception");
            ret = false;
            throw e;
        } finally {
            System.out.println("testEx, finally; return value=" + ret);
            return ret;
        }
    }

    boolean testEx1() throws Exception {
        boolean ret = true;
        try {
            ret = testEx2();
            if (!ret) {
                return false;
            }
            System.out.println("testEx1, at the end of try");
            return ret;
        } catch (Exception e) {
            System.out.println("testEx1, catch exception");
            ret = false;
            throw e;
        } finally {
            System.out.println("testEx1, finally; return value=" + ret);
            return ret;
        }
    }

    boolean testEx2() throws Exception {
        boolean ret = true;
        try {
            int b = 12;
            int c;
            for (int i = 2; i >= -2; i--) {
                c = b / i;
                System.out.println("i=" + i);
            }
            return true;
        } catch (Exception e) {
            System.out.println("testEx2, catch exception");
            ret = false;
            throw e;
        } finally {
            System.out.println("testEx2, finally; return value=" + ret);
            return ret;
        }
    }

    boolean testEx3()  {
        boolean ret = true;
        try {
            int b = 12;
            int c;
            for (int i = 2; i >= -2; i--) {
                c = b / i;
                System.out.println("i=" + i);
            }
            return true;
        } catch (RuntimeException e) {
            System.out.println("testEx3, catch exception");
            ret = false;
            throw e;
        } finally {
            System.out.println("testEx3, finally; return value=" + ret);
           // return ret; //如果finally有返回值，将会导致异常不会返回
        }
    }

    public static void main(String[] args) {
        Test1Exception testException1 = new Test1Exception();
//        try {
//            testException1.testEx();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        for (int i=0;i<3;i++){
            try {
                testException1.testEx3();//在此处抛出异常，后面的就不执行了
//            testException1.testEx3();
            } catch (Exception e) {
                System.out.println(e);
                e.printStackTrace();
            }
        }

    }
}

