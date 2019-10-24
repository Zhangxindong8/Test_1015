import java.util.LinkedList;
import java.util.List;

public class Demo01 {

    public ListNode removeElements(ListNode head, int val) {
        // 1. 链表为空的情况
        if(head == null) {
            return null;
        }
        // 2. 处理非头结点
        ListNode prev = head;
        ListNode node = head.next;
        while(node != null) {
            if(node.val == val) {
                prev.next = node.next;
                node = prev.next;
            }else {
                prev = node;
                node = node.next;
            }

        }
        // 3. 处理头结点
        if(head.val == val) {
            head = head.next;
        }
        return head;
    }

    public ListNode reverseList(ListNode head) {
        // 1. 判定空链表的情况
        if (head == null) {
            return null;
        }
        // 2. 只有一个元素
        if (head.next == null) {
            return head;
        }
        ListNode newHead = null;
        // 3. 处理一般的情况
        ListNode cur = head;
        ListNode prev = null;
        while(cur != null){
            ListNode next = cur.next;
            if (next == null) {
                // cur 已经指向最后一个节点了
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return newHead;
    }

    public ListNode middleNode(ListNode head) {
        ListNode cur = head;
        int steps = size(head) / 2;
        for (int i = 0; i < steps; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public ListNode FindKthToTail(ListNode head,int k) {
        int len = size(head);
        if(head == null || k <= 0 || k > len){
            return null;
        }
        int offset = len - k;
        ListNode cur = head;
        for (int i = 0; i < offset; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode newList = new ListNode(0);
        ListNode tail = newList;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                tail.next = new ListNode(l1.val);
                l1 = l1.next;
                tail = tail.next;
            } else {
                tail.next = new ListNode(l2.val);
                l2 = l2.next;
                tail = tail.next;
            }
        }
        if (l1 != null) {
            tail.next = l1;
        } else {
            tail.next = l2;
        }
        return newList.next;
    }


    public ListNode partition(ListNode pHead, int x) {
        if(pHead == null){
            return null;
        }
        if(pHead.next == null){
            return pHead;
        }
        ListNode smallHead = new ListNode(-1);
        ListNode smallTail = smallHead;
        ListNode bigHead = new ListNode(-1);
        ListNode bigTail = bigHead;
        ListNode cur = pHead;
        while (cur != null){
            if(cur.val < x){
                smallTail.next = new ListNode(cur.val);
                smallTail = smallTail.next;
                cur = cur.next;
            } else {
                bigTail.next = new ListNode(cur.val);
                bigTail = bigTail.next;
                cur = cur.next;
            }
        }
        smallTail.next = bigHead.next;
        return smallHead.next;
    }

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        if (pHead.next == null) {
            return pHead;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = pHead;
        ListNode prev = newHead;
        ListNode node = prev.next;
        while (node != null) {
            if (node.next != null && node.val == node.next.val) {
                while (node.next != null && node.val == node.next.val) {
                    node = node.next;
                }
                prev.next = node.next;
                node = node.next;
            } else  {
                prev = prev.next;
                node = node.next;
            }
        }
        return newHead.next;
    }

    public boolean chkPalindrome(ListNode A) {
        ListNode B = null;
        if(A == null || A.next == null){
            return  true;
        }
        ListNode cur = A;
        while(cur.next != null){
            B = addFirst(cur);
            cur = cur.next;
        }
        while(A != null){
            if(A.val != B.val){
                return false;
            }
            A = A.next;
            B = B.next;
        }
        return true;
    }

    public static ListNode addFirst(ListNode head){
        ListNode node = new ListNode(head.val);
        if(head == null){
            head = node;
        }
        node.next = head;
        head = node;
        return  head;
    }
    public int size(ListNode head) {
        int size = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            size++;
        }
        return size;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
           return null;
        }
        int lenA = size(headA);
        int lenB = size(headB);
        if(lenA > lenB){
            for(int i = 0; i < lenA - lenB; ++i,headA= headA.next);
        }
        else if (lenB > lenA){
            for(int i = 0; i < lenB - lenA; ++i,headB = headB.next);
        }
        while(headB != null){
           if(headB == headA){
               return headB;
           }
           headA = headA.next;
           headB = headB.next;
        }
        return null;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public ListNode detectCycle(ListNode head) {
        // 从链表头部出发, 到入口点的距离,
        // 和从快慢指针的交汇处出发, 到入口点的距离相等
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            // 不带环
            return null;
        }
        // 循环结束之后, fast 和 slow 就已经重合了
        ListNode cur1 = head;
        ListNode cur2 = fast;
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

//    int size(ListNode head){
//        int size = 0;
//        for( ; head != null; head = head.next,++size);
//        return size;
//    }
}
