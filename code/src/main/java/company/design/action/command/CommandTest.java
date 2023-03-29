package company.design.action.command;

/**
 * @description 调用者持有命令类，命令类持有接收者, 通过新引入的命令类，实现调用者和接受者的解耦。
 *  可以通过命令，来随意更换下游接收者。
 * @author zhou
 * @date 2023/3/29~11:44
 */
public class CommandTest  {

    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command command = new ConcreteCommand(receiver);
        Invoker invoker = new Invoker(command);
        invoker.call();

        Receiver1 receiver1 = new Receiver1();
        Command command1 = new ConcreteCommand1(receiver1);
        Invoker invoker1 = new Invoker(command1);
        invoker1.call();

    }
}

//FunctionButton：功能键类，请求发送者--原始接口
//class FunctionButton {
//    private HelpHandler help; //HelpHandler：帮助文档处理类，请求接收者
//
//    //在FunctionButton的onClick()方法中调用HelpHandler的display()方法
//    public void onClick() {
//        help = new HelpHandler();
//        help.display(); //显示帮助文档
//    }
//}

/**
 *  命令模式的核心在于引入了命令类，通过命令类来降低发送者和接收者的耦合度
 *  在命令模式结构图中包含如下几个角色：
 *
 *        ● Command（抽象命令类）：抽象命令类一般是一个抽象类或接口，在其中声明了用于执行请求的execute()等方法，通过这些方法可以调用请求接收者的相关操作。
 *        ● ConcreteCommand（具体命令类）：具体命令类是抽象命令类的子类，实现了在抽象命令类中声明的方法，它对应具体的接收者对象，将接收者对象的动作绑定其中。在实现execute()方法时，将调用接收者对象的相关操作(Action)。
 *        ● Invoker（调用者）：调用者即请求发送者，它通过命令对象来执行请求。一个调用者并不需要在设计时确定其接收者，因此它只与抽象命令类之间存在关联关系。在程序运行时可以将一个具体命令对象注入其中，再调用具体命令对象的execute()方法，从而实现间接调用请求接收者的相关操作。
 *        ● Receiver（接收者）：接收者执行与请求相关的操作，它具体实现对请求的业务处理。
 *
 */
abstract class Command {
    public abstract void execute();
}

/**
 *  对于请求发送者即调用者而言，将针对抽象命令类进行编程，
 *  可以通过构造注入或者设值注入的方式在运行时传入具体命令类对象，
 *  并在业务方法中调用命令对象的execute()方法，其典型代码如下所示：
 *
 *
 */
class Invoker {
    private Command command;

    //构造注入
    public Invoker(Command command) {
        this.command = command;
    }

    //设值注入
    public void setCommand(Command command) {
        this.command = command;
    }

    //业务方法，用于调用命令类的execute()方法
    public void call() {
        command.execute();
    }
}

/**
 *
 * 体命令类继承了抽象命令类，它与请求接收者相关联，
 * 实现了在抽象命令类中声明的execute()方法，并在实现时调用接收者的请求响应方法action()
 */
class ConcreteCommand extends Command {
    private Receiver receiver; //维持一个对请求接收者对象的引用

    public ConcreteCommand(Receiver receiver){
        this.receiver = receiver;
    }

    public void execute() {
        receiver.action(); //调用请求接收者的业务处理方法action()
    }
}

/**
 * 请求接收者Receiver类具体实现对请求的业务处理，它提供了action()方法，用于执行与请求相关的操作
 *
 */
class Receiver {
    public void action() {
        System.out.println("action receiver");
        //具体操作
    }
}

/**
 *
 * 体命令类继承了抽象命令类，它与请求接收者相关联，
 * 实现了在抽象命令类中声明的execute()方法，并在实现时调用接收者的请求响应方法action()
 */
class ConcreteCommand1 extends Command {
    private Receiver1 receiver; //维持一个对请求接收者对象的引用

    public ConcreteCommand1(Receiver1 receiver){
        this.receiver = receiver;
    }

    public void execute() {
        receiver.action1(); //调用请求接收者的业务处理方法action()
    }
}

/**
 * 请求接收者Receiver类具体实现对请求的业务处理，它提供了action()方法，用于执行与请求相关的操作
 *
 */
class Receiver1 {
    public void action1() {
        System.out.println("action receiver");
        //具体操作
    }
}