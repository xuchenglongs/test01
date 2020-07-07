package test;

import java.util.ArrayList;
import java.util.List;

public class TestLink {
    public static void main(String[] args) {
        TestLink link = new TestLink();

        ListNode node1 = link.createNode(1);
        ListNode node2 = link.createNode(2);
        ListNode node3 = link.createNode(3);
        ListNode node4 = link.createNode(4);
        ListNode node5 = link.createNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

//        ListNode listNode = reverseList2(node1);
//        System.out.println("listNode.val:" + listNode.val);
        ListNode listNode = removeNthFromEnd(node1, 2);
        while (listNode.next != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
        System.out.println(listNode.val);
    }

    public ListNode createNode(int x) {
        return new ListNode(x);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode cursor = head;
        ListNode tail = null;//尾指针
        int length = 1;
        while (cursor.next != null)//循环 得到总长度
        {
            cursor = cursor.next;
            length++;
        }
        int loop = length - (k % length);//得到循环的次数
        tail = cursor;//指向尾结点
        tail.next = head;//改成循环链表
        cursor = head;//指向头结点
        for (int i = 0; i < loop; i++) {//开始循环
            cursor = cursor.next;
            tail = tail.next;
        }
        tail.next = null;//改成单链表
        return cursor;//返回当前头
    }

    public ListNode rotateRight2(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int lenght = 1;
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
            lenght++;
        }
        k %= lenght;
        if (k == 0) return head;
        head = temp.next;
        for (int i = 0; i < lenght - k; i++) {
            temp = temp.next;
        }
        ListNode newHead = temp.next;
        temp.next = null;
        return newHead;
    }

    /**
     * 链表反转
     * @param head 链表头节点
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        int lenght = 0;
        ListNode tmp = head;
        ArrayList<ListNode> list = new ArrayList<>();
        while (tmp.next != null) {
            list.add(tmp);
            tmp = tmp.next;
            lenght++;
        }
        list.add(tmp);
        ListNode node = null;

        for (int i = 0; i <= lenght; i++) {
            if (i == lenght) {
                node = list.get(lenght - i);
                node.next = null;
                return tmp;
            }
            node = list.get(lenght - i);
            node.next = list.get(lenght - i - 1);
        }
        return tmp;
    }
       public static ListNode reverseList1(ListNode head) {
        // 虚拟头，用于存放反转结果
        ListNode result = new ListNode(0);

        ListNode item = head;
        ListNode next;
        while(true){
            if(item == null){
                break;
            }
            // 为了保证循环正常后移，先把下一个元素临时取出来
            next = item.next;
            // 因为需要移动到result链表中最前一个，所以我们需要把result的next节点，赋值给最新元素的item
            item.next = result.next;
            // 然后再把item插入到result当中
            result.next = item;
            // 元素后移继续循环
            item = next;
        }
        // 由于我们使用的虚拟头，第一个元素是无效的，直接取下一个节点就行了
        return result.next;
    }

    public static ListNode reverseList2(ListNode head) {
        // 虚拟头，用于存放反转结果
        ListNode result = new ListNode(0);
        ListNode item = head;
        ListNode next;
        while(true){
            if(item == null){
                break;
            }
            next = item.next;
            item.next = result.next;
            result.next = item ;
            item = next;
        }
        return result.next;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode first = start;
        ListNode second = start;
        for(int i=1;i<=n+1;i++){
            first = first.next;
        }

        while(first!=null){
            first=first.next;
            second = second.next;
        }
        second.next = second.next.next;
        head = start.next;

        return head;
    }

}
