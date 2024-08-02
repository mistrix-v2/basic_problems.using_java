import java.util.ArrayList;

public class searchbst {

        static class Node{
            int data;
            Node left;
            Node right;
            Node(int data){
                this.data=data;
            }
        }
        public static Node insert(Node root,int val){
             if(root==null){
                root=new Node(val);
                return root;
             }
             if(root.data>val){
                root.left=insert(root.left, val);
             }else{
                root.right=insert(root.right, val);
             }
             return root;
        }
        public static void inorder(Node root){
            if(root==null){
            return;
            }
            inorder(root.left);    
            System.out.print(root.data+" ");
            inorder(root.right);
        }
        public static boolean search(Node root,int val){
            if(root==null){
                return false;
            }
            if(root.data==val){
                return true;
            }
            if(root.data>val){
                return search(root.left, val);
            }
            else{
                return search(root.right, val);
            }
        }
        public static Node delete(Node root,int val){
            if(root.data<val){
                root.right=delete(root.right, val);
            }
            else if(root.data>val){
                root.left=delete(root.left, val);
            }
            else{
                if(root.left==null && root.right==null){
                    return null;
                }
                if(root.left==null){
                    return root.right;
                }
                else if (root.right==null){
                    return root.left;
                }

                Node IS=findinordersuccessor(root.right);
                root.data=IS.data;
                root.right=delete(root.right, IS.data);
            }
            return root;
        }
        public static Node findinordersuccessor(Node root){
            while(root.left!=null){
                root=root.left;
            }
            return root;
        }
        public static void prange(Node root,int k1,int k2){
            if(root==null){
                return;
            }
            if(root.data>=k1 && root.data<=k2){
                prange(root.left, k1, k2);
                System.out.print(root.data+" ");
                prange(root.right, k1, k2);
            }
            else if(root.data<=k1){
                prange(root.left, k1, k2);
            }
            else{
                prange(root.right, k1, k2);
            }
        }
        public static void printpath(ArrayList<Integer>path){
            for(int i=0;i<path.size();i++){
                System.out.print(path.get(i)+"->");
            } 
            System.out.println("null");
        }
        public static void printr2f(Node root, ArrayList<Integer>path){
            if(root==null){
                return;
            }
            path.add(root.data);
            if(root.left==null && root.right==null){
                printpath(path);
            }
            printr2f(root.left, path);
            printr2f(root.right, path);
            path.remove(path.size()-1);
        }
        public static boolean isvalid(Node root,Node min,Node max){

            if (root==null){
                return true;
            }
            if(min!=null && root.data<=min.data){
                return false;
            }
            else if(max!=null && root.data>=max.data){
                return  false;
            }
            return isvalid(root.left, min, root)
                    && isvalid(root.right, root, max); 

        }
        public static void main(String[] args) {
            int values[]={8,5,3,1,4,6,10,11,12,12,14};
            Node root=null;
            for(int i=0;i<values.length;i++){
                root=insert(root, values[i]);
            }
            inorder(root);
     System.out.println();
     if(search(root, 6)){
        System.out.println("found"); 
     }else{
        System.out.println("not found");
     }

     System.out.println("\n\n");
     root= delete(root, 8);
     System.out.println();
     inorder(root);
     System.out.println("\n\n");
     prange(root, 3, 11);
    printr2f(root, new ArrayList<>());
    System.out.println();
    if(isvalid(root, null, null)){
        System.out.println("valid");
    }else{
        System.out.println("invalid");
    }
    }
    
    
}
