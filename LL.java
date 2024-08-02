
public class LL{
    Node head;
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
        
    }
    public void addfirst(int data){
        Node newnode =new Node(data);
        if(head==null){
            head=newnode;
            return;
        }
        newnode.next=head;
        head=newnode;
    }
    public void addlast(int data){
        Node newnode =new Node(data);
        if(head==null){
            newnode=head;
            return;
        }
        Node temp =head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newnode;

    }
    public void printll(){
        Node temp=head;
        if(head==null){
            System.out.println("empty list");
            return;
        }
        while(temp != null){
            System.out.print(temp.data +"->");
            temp=temp.next;
        }
        System.out.print("NULL\n");
    }
    public void deletefirst(){
        if (head==null){
            System.out.print("empty one");
            return;
        }
        head=head.next;
    }
    public void deletelast(){
        if(head==null){
            System.out.print("empty one");
            return;
        }
        if(head.next==null){
            head=null;
            return;
        }
        Node temp =head;
        Node last=head.next;
        while(last.next!=null){
            last=last.next;
            temp=temp.next;
        }
        temp.next=null;
    }
    public static void main(String[] args) {
        LL list = new LL();
        list.addfirst(10);
        list.addfirst(11);
        list.addlast(12);
        list.printll();
        list.deletefirst();
        list.deletelast();
        list.printll();
    }

}