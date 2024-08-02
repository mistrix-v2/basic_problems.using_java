public class mirrorbst {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
        }
    }
    public static Node mirror(Node root){
        if(root==null){
            return null;
        }
        Node ls= mirror(root.left);
        Node rs= mirror(root.right);
        root.left=rs;
        root.right=ls;
        return root;
    }
    public static void pre(Node root){
        if(root==null){
            return ;
        }
        System.out.print(root.data+" ");
        pre(root.left);
        pre(root.right);
    }
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left=new Node(4);
        root.right= new Node(6);
        root.left.left=new Node(1);
        root.left.right=new Node(3);
        
        root= mirror(root);
        pre(root);

    }
}
