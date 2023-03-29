package company.yuanma.collection;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ListTest {
    public static void main(String[] args){

        /*
        ArrayList
         */
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("b");

        list.size();

        int index = list.indexOf("b");
        int lastIndex = list.lastIndexOf("b");//最后的b位置
        System.out.println(index);
        System.out.println(lastIndex);

        Object[] list1 = list.toArray();//转化为数组
        for (Object s:list1) {
            System.out.println(s);
        }

        list.add(1,"w");//插入到1的位置
        System.out.println(list);

        //将原数组的某一段长度，复制到目的数组的指定起始位置
        String[] strings = {"a","b","c","d"};
        int size = strings.length;
        System.arraycopy(strings, 2, strings, 1, 2);//第一个是原数组，起始位置，目标数组，起始位置，复制的长度长度
        strings[--size] = null;
        for (String s:strings) {
            System.out.println(s);
        }

        //移除原数组的部分元素

        List<String> list3 = new ArrayList<>();
        list3.add("a");
        list3.add("c");


        //list.removeAll(list3);

        //保留原数组的部分元素
       // list.retainAll(list3);
        System.out.println(list);

        ListIterator<String>  listIterator = list.listIterator();

        System.out.println("删除");
        listIterator.next();
        listIterator.remove();//删除第一个元素
        System.out.println(list);

        System.out.println("listIterator");
        System.out.println(listIterator.hasPrevious());//返回bool值
        //System.out.println(listIterator.previous());
        System.out.println(listIterator.next());//listIterator的next为第一个元素。
        System.out.println(listIterator.nextIndex());


        System.out.println(list);

        int a =list.hashCode();
        System.out.println(a);


        /**
         * LinkedList.
         * 列表实现了双端队列，先进先出，poll和remove都是移除第一个。add，添加到队列后，
         * @return the first element in this list
         * @throws NoSuchElementException if this list is empty
         */
        LinkedList<String> list2 = new LinkedList<>();
        list2.add("a");
        list2.add("b");
        list2.add("c");
        list2.add("b");

        list2.addFirst("1");//添加到头部

        LinkedList<String> list4 = new LinkedList<>();
       // String a1 = list4.getFirst();


        /**
         * LinkedList.
         *
         * @return the first element in this list
         * @throws NoSuchElementException if this list is empty
         */

//        private E unlinkFirst(Node<E> f) {
//            // assert f == first && f != null;
//            final E element = f.item;
//            final LinkedList.Node<E> next = f.next;
//            f.item = null;
//            f.next = null; // help GC //去掉第一个指向第二个的关系
//            first = next;
//            if (next == null)
//                last = null;      //针对只有一个元素的情况
//            else
//                next.prev = null;   //去掉第二个指向第一个的关系，开始时候第二个指向第一个呢
//            size--;
//            modCount++;
//            return element;
//        }




        //这个比较方法比较经典
//        public boolean equals(Object o) {
//            if (o == this)
//                return true;
//            if (!(o instanceof List))
//                return false;
//
//            ListIterator<E> e1 = listIterator();
//            ListIterator<?> e2 = ((List<?>) o).listIterator();
//            while (e1.hasNext() && e2.hasNext()) {
//                E o1 = e1.next();
//                Object o2 = e2.next();
//                if (!(o1==null ? o2==null : o1.equals(o2)))
//                    return false;
//            }
//            return !(e1.hasNext() || e2.hasNext());
//        }

        HashMap<String,String> hashMap = new HashMap<>();

        Map<String,String> hashMap1= new ConcurrentHashMap<String,String>();
        int h=1127385397 ;

        int h1=11 >>> 2;
        System.out.println(h1);

        List<String> list5 = Arrays.asList("a","b","c");
        list5.set(0,"e");
        System.out.println(list5 );


        List<String> group = list5.subList(1,2);//Exception in thread "main" java.lang.UnsupportedOperationException,这是由于从Arrays.asList()返回的是返回java.util.Arrays$ArrayList，而不是ArrayList。Arrays$ArrayList和ArrayList都是继承AbstractList，add() 和remove()等方法在AbstractList中默认throw UnsupportedOperationException而不做任何操作。ArrayList重写这些方法对List进行操作，而Arrays$ArrayList却没有重写add()和 remove()等方法，
    //    group.clear();
        String s = group.get(0);
        System.out.println("s    "+s);
        List arrList = new ArrayList(group);
        arrList.clear();

        //group.clear();
        System.out.println("sublist");
        System.out.println(list5.toString());
        System.out.println(arrList.toString());


        List<String> stringList = Collections.nCopies(10,"a");//都是不允许修改的，
        System.out.println(stringList);
        stringList.add("b");//都是不允许修改的




    }
}
