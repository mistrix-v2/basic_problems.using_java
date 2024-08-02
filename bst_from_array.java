public class bst_from_array {
     static class Node{
        int data;
        Node left;
        Node right;
        
        Node(int data){
            this.data=data;
        }
    }
    public static void pre(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        pre(root.left);
        pre(root.right);
    }
    public static Node create(int arr[],int st,int end){
        if(st>end){
            return null;
        }
        int mid = (st+end)/2;
        Node root= new Node(arr[mid]);
        root.left=create(arr, st, mid-1);
        root.right=create(arr, mid+1, end);
        return root;
    }
    public static void main(String[] args) {
        int arr[]={1,3,5,8,10,11,12};
        Node root=create(arr, 0, arr.length-1);
        pre(root);
    }
}
