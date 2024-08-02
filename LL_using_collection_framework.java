import java.util.*;


class LL_using_collection_framework {
   public static void main(String args[]) {
       LinkedList<Integer> list = new LinkedList<Integer>();
       list.add(10);
       list.add(2);
       list.addLast(4);
       list.addFirst(5);
       list.add(3, 7);
       System.out.println(list);


       System.out.println(list.get(3));
       System.out.println(list.size());   
       list.remove(3);
       list.removeFirst();
       list.removeLast();
      
       System.out.println(list);
   }
}
