package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest1 {

    public static void main(String[] args){

        List<User>  list = new ArrayList<>();
        User user = new User();
        user.setId(1);
        user.setName("zhou");
        User user1 = new User();
        user1.setId(2);
        user1.setName("zhan");
        User user2 = new User();
        user2.setId(3);
        user2.setName("yong");
        list.add(user);
        list.add(user1);
        list.add(user2);
        List<Integer> ids=list.stream().map(User::getId).collect(Collectors.toList());
        List<String> tableNames=list.stream().map(User::getName).collect(Collectors.toList());
        System.out.println(tableNames);

    }

}
