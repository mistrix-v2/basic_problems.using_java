import java.util.*;
public class nextgreater{

    public static void main(String[] args) {
       int arr[]={5,7,3,4,8};
       Stack<Integer> s=new Stack<>();
       int next[]=new int[arr.length];
       for(int i=arr.length-1;i>=0;i--){
        while(!s.isEmpty() && arr[s.peek()]<=arr[i]){
            s.pop();
        }
        if(s.isEmpty()){
            next[i]=-1;
        }
        else{
            next[i]=arr[s.peek()];
        }
        s.push(i);
       }
       for(int i=0;i<next.length;i++){
        System.out.print(next[i]+" ");
       }
      System.out.println();      
        
    }
}