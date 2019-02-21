package company.rpc;

public class HelloServiceImpl implements HelloService{

    @Override
    public String sayHi(String name) {
        return "hi, "+name;
    }

    @Override
    public String sayHello(int i) {
        return "数字，"+i;
    }
}
