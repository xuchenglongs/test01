package test;

import java.util.*;

public class TestCollection {

    public static void main(String[] args) {
        HashMap<Integer, User> map = new HashMap<>();
        User a = new User("a", 11);
        User b = new User("b", 22);
        User c = new User("c", 1);
        User d = new User("d", 0);
        map.put(1, a);
        map.put(3, b);
        map.put(2, c);
        map.put(0, d);

//       TreeMap<Integer, User> treeMap = new TreeMap<>(map);
//       System.out.println("treeMap:"+treeMap);

//        HashMap<Integer, User> hashMap = sortHashMap(map);
//        System.out.println(hashMap);

        ArrayList<User> userList = new ArrayList<>();
        userList.add(a);
        userList.add(b);
        userList.add(c);
        userList.add(d);

        HashMap<String, List<User>> map1 = new HashMap<>();
        map1.put("a",userList);
        map.put(null,null);

        sortHashMap2(map1);
        System.out.println(map1);
    }

    public static HashMap<Integer, User> sortHashMap(HashMap<Integer, User> map) {
        //map转为set,(取出键值对集合)
        Set<Map.Entry<Integer, User>> entrySet = map.entrySet();
        //set转为list，放入到list中，使用工具类排序方法
        ArrayList<Map.Entry<Integer, User>> list = new ArrayList<>(entrySet);
        //使用Collections集合工具类给list排序，排序规则使用匿名内部类实现
        Collections.sort(list, new Comparator<Map.Entry<Integer, User>>() {
            @Override
            public int compare(Map.Entry<Integer, User> o1, Map.Entry<Integer, User> o2) {
                return o1.getValue().getAge() - o2.getValue().getAge();
            }
        });
        LinkedHashMap<Integer, User> linkedHashMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, User> entry : list) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        return linkedHashMap;
    }
    public static void sortHashMap2(HashMap<String, List<User>> map) {
        Set<Map.Entry<String, List<User>>> set = map.entrySet();
        for (Map.Entry<String, List<User>> entry:set) {
            Collections.sort(entry.getValue());
        }
    }
}
