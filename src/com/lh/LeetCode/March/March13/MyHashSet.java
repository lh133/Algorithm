package com.lh.LeetCode.March.March13;

/**
 * 705. 设计哈希集合
 * 实现 MyHashSet 类：
 * void add(key) 向哈希集合中插入值 key 。
 * bool contains(key) 返回哈希集合中是否存在这个值 key 。
 * void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 * 提示：
 * 0 <= key <= 106
 * 最多调用 104 次 add、remove 和 contains 。
 *
 * @Author: LH
 * @Date: 2021/3/14 23:34
 */
public class MyHashSet {
    /**
     * Initialize your data structure here.
     */
    Node[] nodes = new Node[10009];

    public MyHashSet() {
    }

    public void add(int key) {
        // 根据key获得哈希桶的位置
        int idx = getIndex(key);
        // 判断链表中是否已经存在
        Node loc = nodes[idx], tmp = loc;
        if (loc != null) {
            Node prev = null;
            while (tmp != null) {
                if (tmp.key == key) {
                    return;
                }
                prev = tmp;
                tmp = tmp.next;
            }
            tmp = prev;
        }
        Node node = new Node(key);

        // 头插法
        // node.next = loc;
        // nodes[idx] = node;

        // 尾插法
        if (tmp != null) {
            tmp.next = node;
        } else {
            nodes[idx] = node;
        }
    }

    public void remove(int key) {
        int idx = getIndex(key);
        Node loc = nodes[idx];
        if (loc != null) {
            Node prev = null;
            while (loc != null) {
                if (loc.key == key) {
                    if (prev != null) {
                        prev.next = loc.next;
                    } else {
                        nodes[idx] = loc.next;
                    }
                    return;
                }
                prev = loc;
                loc = loc.next;
            }
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int idx = getIndex(key);
        Node loc = nodes[idx];
        if (loc != null) {
            while (loc != null) {
                if (loc.key == key) {
                    return true;
                }
                loc = loc.next;
            }
        }
        return false;
    }

    static class Node {
        private int key;
        private Node next;

        private Node(int key) {
            this.key = key;
        }
    }

    // 获取哈希桶的位置
    int getIndex(int key) {
        // 因为 nodes 的长度只有 10009，对应的十进制的 10011100011001（总长度为 32 位，其余高位都是 0）
        // 为了让 key 对应的 hash 高位也参与运算，这里对 hashCode 进行右移异或
        // 使得 hashCode 的高位随机性和低位随机性都能体现在低 16 位中
        int hash = Integer.hashCode(key);
        hash ^= (hash >>> 16);
        return hash % nodes.length;
    }
}

// https://leetcode-cn.com/problems/design-hashset/solution/yi-ti-san-jie-jian-dan-shu-zu-lian-biao-nj3dg/
class MyHashSet1 {
    int[] bs = new int[40000];

    public void add(int key) {
        int bucketIdx = key / 32;
        int bitIdx = key % 32;
        setVal(bucketIdx, bitIdx, true);
    }

    public void remove(int key) {
        int bucketIdx = key / 32;
        int bitIdx = key % 32;
        setVal(bucketIdx, bitIdx, false);
    }

    public boolean contains(int key) {
        int bucketIdx = key / 32;
        int bitIdx = key % 32;
        return getVal(bucketIdx, bitIdx);
    }

    void setVal(int bucket, int loc, boolean val) {
        if (val) {
            int u = bs[bucket] | (1 << loc);
            bs[bucket] = u;
        } else {
            int u = bs[bucket] & ~(1 << loc);
            bs[bucket] = u;
        }
    }

    boolean getVal(int bucket, int loc) {
        int u = (bs[bucket] >> loc) & 1;
        return u == 1;
    }
}

class Main {
    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(2);
        boolean b = hashSet.contains(2);
        System.out.println(b);
        hashSet.remove(2);
        boolean b1 = hashSet.contains(2);
        System.out.println(b1);
    }
}