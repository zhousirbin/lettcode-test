package company.design.action.command;

import java.util.ArrayList;

/**
 *  主要用于解耦，发送者和接收者的关系
 *
 *  1.FBSettingWindow， 功能类，--list<FunctionButton>主要用于构建，添加删除命令，建立list, 同时循环处理接口
 *  2，FunctionButton 包装命令类，调用者，增加方法或者变量
 *  3.command 抽象命令类，主要定义execute接口
 *  4. HelpCommand 继承command， 并定义实现，持有接受者（每个接收的方法，定义都不同）
 *  5.Handler 具体接收者，每个接受者都定义不同
 *
 */
public class CommandListTest {
    public static void main(String args[]) {
        FBSettingWindow fbsw = new FBSettingWindow("功能键设置");

        FunctionButton fb1,fb2;
        fb1 = new FunctionButton("功能键1");
        fb2 = new FunctionButton("功能键1");

        Command command1,command2;
        //通过读取配置文件和反射生成具体命令对象
        command1 = new MinimizeCommand();
        command2 = new HelpCommand();

        //将命令对象注入功能键
        fb1.setCommand(command1);
        fb2.setCommand(command2);

        fbsw.addFunctionButton(fb1);
        fbsw.addFunctionButton(fb2);
        fbsw.display();

        //调用功能键的业务方法
        fb1.onClick();
        fb2.onClick();
    }

}

//功能键设置窗口类
class FBSettingWindow {
    private String title; //窗口标题
    //定义一个ArrayList来存储所有功能键
    private ArrayList<FunctionButton> functionButtons = new ArrayList<>();

    public FBSettingWindow(String title) {
        this.title = title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void addFunctionButton(FunctionButton fb) {
        functionButtons.add(fb);
    }

    public void removeFunctionButton(FunctionButton fb) {
        functionButtons.remove(fb);
    }

    //显示窗口及功能键
    public void display() {
        System.out.println("显示窗口：" + this.title);
        System.out.println("显示功能键：");
        for (Object obj : functionButtons) {
            System.out.println(((FunctionButton)obj).getName());
        }
        System.out.println("------------------------------");
    }
}

//功能键类：请求发送者
class FunctionButton {
    private String name; //功能键名称
    private Command command; //维持一个抽象命令对象的引用

    public FunctionButton(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    //为功能键注入命令
    public void setCommand(Command command) {
        this.command = command;
    }

    //发送请求的方法
    public void onClick() {
        System.out.print("点击功能键：");
        command.execute();
    }
}


//帮助命令类：具体命令类
class HelpCommand extends Command {
    private HelpHandler hhObj; //维持对请求接收者的引用

    public HelpCommand() {
        hhObj = new HelpHandler();
    }

    //命令执行方法，将调用请求接收者的业务方法
    public void execute() {
        hhObj.display();
    }
}

//最小化命令类：具体命令类
class MinimizeCommand extends Command {
    private WindowHanlder whObj; //维持对请求接收者的引用

    public MinimizeCommand() {
        whObj = new WindowHanlder();
    }

    //命令执行方法，将调用请求接收者的业务方法
    public void execute() {
        whObj.minimize();
    }
}

//窗口处理类：请求接收者
class WindowHanlder {
    public void minimize() {
        System.out.println("将窗口最小化至托盘！");
    }
}

//帮助文档处理类：请求接收者
class HelpHandler {
    public void display() {
        System.out.println("显示帮助文档！");
    }
}