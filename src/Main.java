public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
    }
}

// my idea was correct but not my execution
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}


// my attempt, basically in one pass trying to link odds to odds and evens to evens and take final odd and link to first even
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return head;
        }

        ListNode dummy = new ListNode(-1);
        head = dummy.next;
        ListNode lead = head.next.next;
        ListNode lag = head;
        ListNode even = head.next;
        ListNode storeEven = even; // will be 2. need this as 'head' of evens list

        while(lead != null){
            lag.next = lead;
            even.next = even.next.next;
            lag = lag.next;
            even = even.next;
            lead = lead.next.next;
        }
        lag.next = storeEven;

        return head;
    }
}

/*

1,2,3,4,5,6



 */