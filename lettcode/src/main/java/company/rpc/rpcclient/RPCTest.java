package company.rpc.rpcclient;

import company.rpc.HelloService;
import company.rpc.HelloServiceImpl;
import company.rpc.servicecenter.Server;
import company.rpc.servicecenter.ServiceCenter;

import java.io.IOException;
import java.net.InetSocketAddress;

public class RPCTest {

    public static void main(String[] args) throws IOException {
        Server serviceServer = new ServiceCenter(8088);
        new Thread(new Runnable() {
            public void run() {
                try {

                    serviceServer.register(HelloService.class, HelloServiceImpl.class);
                    serviceServer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        HelloService service = RPCClient.getRemoteProxyObj(HelloService.class, new InetSocketAddress("localhost", 8088));
        System.out.println(service.sayHi("test"));
        System.out.println(service.sayHello(1));

//        serviceServer.stop();

    }
}