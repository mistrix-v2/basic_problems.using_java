import java.util.*;

public class bst_to_balanced {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
        }
    }
    static class info{
        boolean isbst;
        int size;
        int min;
        int max;
        public info(boolean isbst,int size,int min,int max){
            this.isbst=isbst;
            this.size=size;
            this.min=min;
            this.max=max;
        }
    }
    public static int maxbst=0;
    public static info largest(Node root){
        if(root==null){
            return new info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        info linfo= largest(root.left);
        info rinfo= largest(root.right);
        int size=linfo.size+rinfo.size+1;
        int min=Math.min(root.data,Math.min(linfo.min,rinfo.min));
        int max=Math.max(root.data,Math.max(linfo.max,rinfo.max));
        if(root.data<=linfo.max || root.data>=rinfo.min){
            return new info(false,size,min,max);
        }
        if(linfo.isbst && rinfo.isbst){
            maxbst=Math.max(maxbst, size);
            new info(true, size, min, max);
        }
        return new info(false, size, min, max);
    }

    public static void pre(Node root){
        if (root==null){
            return;
        }
        System.out.print(root.data+" ");
        pre(root.left);
        pre(root.right);
    }
    public static void inorder(Node root,ArrayList<Integer>path){
        if(root==null){
            return;
        }
        inorder(root.left,path);
        path.add(root.data);
        inorder(root.right,path);
    }
    public static Node createbst(ArrayList<Integer>inord,int st,int end){
        if(st>end){
            return null;
        }
        int mid=(st+end)/2;
        Node root= new Node(inord.get(mid));
        root.left=createbst(inord, st, mid-1);
        root.right=createbst(inord, mid+1, end);
        return root;
    }
    public static Node balance(Node root){
        ArrayList<Integer> inord = new ArrayList<>();
        inorder(root, inord);
        root=createbst(inord, 0, inord.size()-1);
        return root;
    }
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left= new Node(6);
        root.left.left=new Node(5);
        root.left.left.left=new Node(3);
        root.right=new Node(10);
        root.right.right= new Node(11);
        root.right.right.right=new Node(12);
         System.out.println();
        info in= largest(root);
        System.out.println(maxbst); 

    }

}
