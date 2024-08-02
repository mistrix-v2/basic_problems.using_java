class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class stackusingll {

    static class stack {
       static Node head = null;

        public boolean isempty() {
            return head == null;
        }

        public void push(int data) {
            Node newnode = new Node(data);
            if (head == null) {
                head = newnode;
                return;
            }
            newnode.next = head;
            head = newnode;
        }

        public int pop() {
            if (isempty()) {
                return -1; // Or throw an exception
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        public int peek() {
            if (isempty()) {
                return -1; // Or throw an exception
            }
            return head.data;
        }
    }

    public static void main(String args[]) {
        stack s = new stack();
        s.push(1);
        s.push(2);
        s.push(3);
        while (!s.isempty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
