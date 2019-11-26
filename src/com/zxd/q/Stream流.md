# Stream流
* 作用：真正的把函数式编程风格引入到了Java中
* 步骤：生成流 -> 中间操作 -> 终结操作
* 生成流：通过数据源(集合、数组等)生成流 
* 中间操作：一个流后面可以跟随一个或者多个中间操作。
    * 中间操作主要作用就是打开流，进行某种程度的数据过滤，然后返回一个新的流，交给下一个操作使用
    * 中间操作都会返回流对象本身
    * 中间操作可以直接调用遍历方法进行遍历
* 终结操作：一个流只能有一个终结操作，这个操作执行之后，流无法再被操作

# 没有使用流的时候
如果希望对集合中的元素进行筛选过滤，一般的做法就是：
* 将集合A根据条件一过滤为子集B
* 然后再根据条件二过滤为子集C
####代码展示：
```java
public class StreamDemo {
    public static void main(String[] args) {
        
        //定义一个集合
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");

        //对list集合中的元素进行过滤,只要以张开头的元素,存储到一个新的集合中
        List<String> listA = new ArrayList<>();
        for (String s : list) {
            if (s.startsWith("张")) {
                listA.add(s);
            }
        }

        //对listA集合进行过滤,只要姓名长度为3的人,存储到一个新集合中
        List<String> listB = new ArrayList<>();
        for (String s : listA) {
            if (s.length() == 3) {
                listB.add(s);
            }
        }

        //遍历listB集合
        for (String s : listB) {
            System.out.println(s);
        }
    }
}
```
采用Stream流的写法
```java
public class StreamDemo {
    public static void main(String[] args) {
        //创建一个List集合,存储姓名
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");

        //对list集合中的元素进行过滤,只要以张开头的元素,存储到一个新的集合中
        //对listA集合进行过滤,只要姓名长度为3的人,存储到一个新集合中
        //遍历listB集合
        list.stream()
                .filter(name -> name.startsWith("张"))
                .filter(name -> name.length() == 3)
                .forEach(name -> System.out.println(name));
    }
}
```
