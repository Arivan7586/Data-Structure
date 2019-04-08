package arivan.Test4_8;

import java.util.*;

public class Test4_8 {
    /**
     * 练习ArrayList
     */
    public static void testArrayList() {
        List<String> list = new ArrayList<>();
        list.add("小黑");
        list.add("小白");
        list.add("阿怪");
        System.out.println("list的长度为："+list.size());
        System.out.println("list的第3个元素为："+list.get(2));
        System.out.println(list);
        list.set(2,"路飞");
        list.add(1,"索隆");

        System.out.println("小白的下标为："+list.indexOf("小白"));
        System.out.println("小白的下标为："+list.indexOf("小龙"));
        System.out.println(list);
        System.out.println(list.hashCode());

        System.out.println("--------------------");
        List<Person> list1 = new ArrayList<>();
        list1.add(new Person("小黑",20));
        list1.add(new Person("小黑",20));
        System.out.println(list1.get(0).equals(list1.get(1)));
        System.out.println(list1);

    }

    /**
     * 练习LinkedList
     */
    public static void testLinkedList() {
        List<Person> list = new LinkedList<>();
        //默认的是尾插法
        list.add(new Person("小黑",18));
        list.add(new Person("小白",19));
        list.add(new Person("小张",20));
        //插入法
        ((LinkedList<Person>) list).addFirst(new Person("小离",21));
        ((LinkedList<Person>) list).addFirst(new Person("小周",22));
        //System.out.println(list);
        Iterator<Person> iterator1 = list.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

        List<Integer> list1 = new LinkedList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);
        System.out.println(list1);
        //迭代器输出
        Iterator<Integer> iterator = list1.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            iterator.remove(); //删除元素
        }
        System.out.println(list1);
    }

    /**
     * 练习hashSet
     */
    public static void testHashSet() {
        Set<String> set = new HashSet<>();
        set.add("Tom");
        set.add("Jack");
        set.add("Alice");
        set.add("John");
        //set.add("John"); //不能放入相同元素
        set.add("Jim");
        System.out.println(set);
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println(set.contains("Jim"));
        set.clear();
        System.out.println(set);
        System.out.println(set.isEmpty());
    }

    /**
     * 练习treeSet
     */
    public static void testTreeSet() { //会进行排序
        Set<Person> set = new TreeSet<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return (o1.getAge()-o2.getAge()) *-1;
            }
        });
        set.add(new Person("Jack",18));
        set.add(new Person("Tom",19));
        set.add(new Person("Jim",20));
        set.add(new Person("Alice",21));
        //set.add(new Person("Jack",22));
        Iterator<Person> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        Set<Integer> set1 = new TreeSet<>();
        set1.add(1);
        set1.add(9);
        set1.add(7);
        set1.add(4);
        System.out.println(set1);

        //枚举输出
        Vector<String> vector = new Vector<>();
        vector.add("A");
        vector.add("B");
        vector.add("C");
        vector.add("D");
        Enumeration<String> enumeration = vector.elements();
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }
    }

    /**
     * 练习hashMap
     */
    public static void testHashMap() {
        Map<Integer, String> map = new HashMap<>();
        //key可以不可以重复、value可以重复
        map.put(1, "Jack");
        map.put(2, "Jack");
        map.put(3, "Tom");
        map.put(1, "Steven");
        map.put(null, "Alice");
        map.put(4, null);
        System.out.println(map);

        //map输出，需要转化为set
        // 1.将Map集合转为Set集合
        Set<Map.Entry<Integer, String>> set = map.entrySet();
        // 2.获取Iterator对象
        Iterator<Map.Entry<Integer, String>> iterator = set.iterator();
        // 3.输出
        while (iterator.hasNext()) {
            // 4.取出每一个Map.Entry对象
            Map.Entry<Integer, String> entry = iterator.next();
            // 5.取得key和value
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        System.out.println("------------------");

        Map<Integer,String> m = new Hashtable<>();
        m.put(1,"A");
        m.put(2,"B");
        //m.put(null,"C"); Hashtable中key和value都不能为null
        //m.put(3,null);
        System.out.println(m);

    }

    /**
     * 练习treeMap
     */
    public static void testTreeMap() {
        Map<Integer,String> map = new TreeMap<>();
        map.put(3,"小黑");
        map.put(2,"小王");
        map.put(4,"小里");
        map.put(1,"小张");
        Set<Map.Entry<Integer,String>> set = map.entrySet();
        Iterator<Map.Entry<Integer,String>> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        //取得所有key的信息
        Set<Integer> set1 = map.keySet();
        System.out.println(set1);

        //取得所有value信息
        for (String value : map.values()) {
            System.out.println(value);
        }
    }

    /**
     * 练习stack
     */
    public static void testStack() {
        Stack<Integer> strings = new Stack<>();
        strings.push(1);
        strings.push(2);
        strings.push(3);
        System.out.println(strings.search(4)); //查找元素，找到了返回下标
        System.out.println(strings.peek()); //查看栈顶元素
        System.out.println(strings);
        strings.pop();
        System.out.println(strings.peek());
        strings.pop();
        strings.pop();
        System.out.println(strings);
        System.out.println(strings.empty());

    }

    /**
     * 练习Queue
     */
    public static void testQueue() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5) ;
        System.out.println(queue);
        System.out.println("第一个元素为："+queue.peek());
        System.out.println("取得的元素为："+queue.poll());
        System.out.println(queue.peek());
    }
    public static void main(String[] args) {
        //testArrayList();
        //testLinkedList();
        //testHashSet();
        //testTreeSet();
        //testHashMap();
        //testTreeMap();
        //testStack();
        testQueue();
    }

}

class Person {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //自定义的类，需要覆写equals方法和hashcode方法
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}