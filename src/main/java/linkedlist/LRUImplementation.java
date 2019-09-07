package linkedlist;

import java.util.HashMap;
import java.util.Set;

/**
 * 使用链表实现LRU缓存淘汰策略：
 * 思路：使用带有头结点的双向链表存储缓存
 */
public class LRUImplementation {

    public static void main(String[] args) {
        LRUImplementation LRU = new LRUImplementation();
        System.out.println("初始情况："+LRU);
        for (int i = 0; i < 5; i++) {
            LRU.set("key"+i,"value"+i);
        }
        System.out.println("放满元素之后："+LRU);
        LRU.get("key0");
        LRU.get("key4");
        LRU.set("key5","value5");
        LRU.set("key6","value6");
        System.out.println("超出缓存之后："+LRU);
    }

    private final int DEFAULT_CAPACITY = 5;
    private LinkedListNode head = new LinkedListNode(null);
    private LinkedListNode tail = null;
    private int size = 0;
    private HashMap<String, LinkedListNode> map = new HashMap<>(DEFAULT_CAPACITY);

    // get缓存中的数据，存在就返回，不存在返回null
    private String get(String key) {
        LinkedListNode current;
        if ((current = map.get(key)) == null) {
            return null;
        }
        // 将当前使用的节点放到链表的尾部
        remove(key);
        addToTail(key, current.value);
        return current.value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (size == 0) {
            return "[]";
        }
        sb.append("[");
        LinkedListNode node;
        for (node = head.next; node != null; node = node.next) {
            sb.append(node.value);
            if(node.next != null){
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public int getSize() {
        return size;
    }

    // 设置缓存中的数据
    private void set(String key, String value) {
        // 判断容量有没有超过最大容量
        if (size == DEFAULT_CAPACITY) {
            // 淘汰最近最少使用的缓存数据
            removeHead();
        }
        // 添加到链表的末尾
        addToTail(key, value);
    }

    private String removeHead() {
        LinkedListNode current = head.next;
        if (current == null) {
            return null;
        }
        LinkedListNode next = current.next;
        head.next = next;
        next.pre = head;
        current.next = null;
        current.pre = null;
        size--;
        // 从map中移除相应的k-v
        Set<String> keySet = map.keySet();
        String target = null;
        for (String key : keySet) {
            if (map.get(key) == current) {
                target = key;
                break;
            }
        }
        if (target != null) {
            map.remove(target);
        } else {
            System.out.println("无法移除head后面的首个节点。。。");
        }
        return current.value;
    }

    /**
     * 移除缓存中的指定key
     *
     * @param key key
     * @return key对应的value
     */
    public String remove(String key) {
        LinkedListNode current = map.get(key);
        if (current == null) {
            return null;
        }
        map.remove(key);
        LinkedListNode next = current.next;
        LinkedListNode pre = current.pre;
        pre.next = next;
        next.pre = pre;
        current.next = null;
        current.pre = null;
        size--;
        return current.value;
    }

    /**
     * 将节点加到尾部
     * @param key   key
     * @param value value
     * @return 成功与否
     */
    private boolean addToTail(String key, String value) {
        // 目前缓存中还没有元素
        if (tail == null) {
            tail = new LinkedListNode(value);
            tail.pre = head;
            head.next = tail;
            map.put(key, tail);
            size++;
            return true;
        }
        // 缓存中元素未满的情况
        LinkedListNode node = new LinkedListNode(value);
        node.pre = tail;
        tail.next = node;
        size++;
        map.put(key, node);
        tail = node;
        return true;
    }
}

// 单链表节点类
class LinkedListNode {
    String value;
    LinkedListNode next;
    LinkedListNode pre;

    public LinkedListNode(String value) {
        this.value = value;
        this.next = null;
        this.pre = null;
    }
}
