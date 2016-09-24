package core.collection.map;

import java.util.HashMap;
import java.util.Map;

public class HashMapPuzzle {
    public static void main(String...args) {
        Friend friend1 = new Friend("Tom", 24);
        Friend friend2 = new Friend("Dick", 25);
        Friend friend3 = new Friend("Harry", 24);

        Map<Friend, Integer> friends = new HashMap<>();
        friends.put(friend3, 1);
        friends.put(friend3, 2);
        friends.put(friend3, 3);
        for (Friend friend : friends.keySet()) {
            System.out.println(friends.get(friend));
        }

    }
}

class Friend {

    String name;
    int age;

    public Friend(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
        /*
         * if (obj == this) return true; if (!(obj instanceof Friend)) return false; Friend friend = (Friend) obj;
         * return friend.getName() == this.getName();
         */
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
