/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package first;

import java.util.ArrayList;

/**
 *
 * @author amit
 */
public class BST <E extends Comparable <E>> {

   
    private class TreeNode<E>{
            E data;
            TreeNode <E> left,right ;
            public TreeNode(E data){
                this.data = data;
                left = null;
                right = null;
            }
        }
    protected TreeNode <E> root;
    protected int size = 0;
    
    public BST(){};
    
    public boolean insert(E data){
        if(root == null){
            root = new TreeNode(data);
            return true;
        }
        TreeNode<E> parent = null;
        TreeNode <E> current = root;
        while(current != null){
            if(data.compareTo(current.data) < 0){
                parent = current;
                current = current.left;
            }
            else if(data.compareTo(current.data)>0){
                parent = current;
                current = current.right;
            }
            else{
                return false;
            }
        }
        if(data.compareTo(parent.data)<0){
            parent.left = new TreeNode (data);
        }
        else{
            parent.right = new TreeNode(data);
        }
        size++;
        return true;
        
    }
    
    
    public boolean search(E data){
        TreeNode <E> current = root;
        while (current != null){
            if(data.compareTo(current.data ) < 0){
                current = current.left;
            }
            else if (data.compareTo(current.data)>0){
                current = current.right;
            }
            else{
                return true;
            }
        }
        return false;
    }
    
    public boolean delete(E data){
            TreeNode<E> parent = null;
            TreeNode <E> current = root;
            while(current != null){
                if(data.compareTo(current.data) < 0){
                    parent = current;
                    current = current.left;
                }
                else if (data.compareTo(current.data)> 0){
                    parent = current;
                    current = current.right;
                }
                else{
                    break;
                }
            }
            if (current == null ){
                return false;
            }
            //CASE 1 :  only root element in BST and that needs to be deleted
            if(current == root && current .right == null && current.left == null ){
                root = null;
                return true;
            }
            //case 2: onl root and its right child in BST root neeeds to be delted
            if (current.left == null){
                if(parent == null){
                    root = current.right;
                }
                //case 2b : only right child
                else{
                    if(parent.left == current){
                        parent.left = current.right;
                    }
                    else{
                        parent.right = current.right;
                    }
                    current = null;
                }
                return true;
            }
            //case 3:  no right subt ree
            if(current.right == null){
                if(parent == null){
                    root = current.left;
                }
                else{
                    if(parent.left == current){
                        parent.left = current.left;
                        
                    }
                    else{
                        parent.right = current.left;
                    }
                    current = null;
                }
                return true;
            }
            else {
            
            // case 4: main case node has both subtrees
            TreeNode<E> tmp = current.right;
            TreeNode<E> tmp_parent = null ;
            while(tmp.left != null){
                tmp_parent = tmp;
                tmp = tmp.left;
      
            }
            current.data = tmp.data;
            // 2 cases possible 
            // case 1 tmp node is a leaf
            if(tmp.right == null && tmp_parent != null){
                tmp_parent.left = null;
            }
            else{
                tmp_parent.left = tmp.right;
            }
            size--;
            return true;
    }}
    public void inorder(TreeNode<E> root){
        if(root == null ){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public void get_depth(){
        int x = get_depth(root);
        System.out.println("Depth is :"+x);
    }
    private int get_depth(TreeNode <E> root){
        int depth = -1;
        if(root != null){
            int depth_left = get_depth(root.left);
            int depth_right = get_depth(root.right);
            depth = Math.max(depth_left,depth_right);
            depth = depth + 1;
        }
        return depth;
        
    }
    public boolean hasPathSum(int sum){
        return hasPathSum(root,sum);
    }
    public void printPath(){
        ArrayList<TreeNode> arr = new ArrayList<>();
        int len = 0;
        printPath( root,arr,len);
    }
    private void printPath(TreeNode <E> root, ArrayList <TreeNode> arr, int len){
        if (root == null) return;
        arr.add(len, root);
        len = len + 1;
        if(root.right == null && root.left == null){
            printVal(arr,len);
        }
        printPath(root.left,arr,len);
        printPath(root.right,arr,len);
    }
    private void printVal(ArrayList <TreeNode> arr, int len){
        for(int i = 0; i < len; i++){
            TreeNode Tmp = arr.get(i);
            System.out.print(Tmp.data+" ");
        }
        System.out.println("");
        
    }
    private boolean hasPathSum(TreeNode <E> root, int sum){
        
        if (root == null){
            return false;
        }
        Object x = root.data;
        int val = (int)x;
        if(sum == val){
            return true;
        }
        else{
                sum = sum - val;
                return (hasPathSum(root.left,sum)||(hasPathSum(root.right,sum)));
            
        }
    }
    public void PrintPathSum(int sum){
        ArrayList <TreeNode> arr = new ArrayList<>();
        int len = 0;
        printPathSum(arr,len,root, sum);
        
    }
    private void printPathSum(ArrayList<TreeNode> arr, int len, TreeNode<E> root,int sum){
        if (root == null ) return;
        Object x = root.data;
        int val = (int)x;
         arr.add(len, root);
         len = len +1;
        if(sum == val){
            
            printVal(arr,len);
            return;
        }
        else{
            if(root.left != null){
                printPathSum(arr,len,root.left,sum-val);}
            if(root.right != null){
                printPathSum(arr,len,root.right,sum-val);
            }
        }}
    public void printLowest(){
        printLowest(root);
    }
    public void printMax(){
        printMax(root);
    }
    private void printLowest(TreeNode<E> root){
        if(root.left == null){
            System.out.println("The lowest is :"+ root.data);
            return;
        }
        printLowest(root.left);
    }
    public void levelNodes(int height){
        levelNodes(root,height);
    }
    private void levelNodes(TreeNode<E> root, int height){
        if(root == null || height < 0){
            return;
        }
        if(height == 0){
            System.out.println(root.data);
        }
        height = height - 1;
        levelNodes(root.left,height);
        levelNodes(root.right,height);
    }
    private void printMax(TreeNode<E> root){
        if(root.right == null){
            System.out.println("The max is :"+ root.data);
            return;
        }
        printMax(root.right);
    }
    public  int distance(E data){
        TreeNode<E> target = new TreeNode<E>(data);
        return distance(root,target);
    }
   // public int distance( int tar){
     //   return (root,new T)
   // }
    private int distance(TreeNode<E> src, TreeNode<E> tar){
        int k = -1;
        if(src== null){
            return -1;
        }
        if(src.data.equals(tar.data)){
            k = 0;
            return k;
        }
        
        int dl = distance(src.left,tar);
        int dr = distance(src.right,tar);
        if(dl != -1){
             k = 1+ dl;
            return k;
        }
        else{
             k = 1 + dr;
            return k;
        }
    }
    public void printKdown(int k){
        printKdown(root,k);
    }
    
    private void printKdown(TreeNode<E> root, int k){
        if(root == null || k < 0){
            return;
        }
        if (k == 0){
            System.out.println(root.data);
        }
        printKdown(root.left,k-1);
        printKdown(root.right,k-1);
    }
    
   
    private int printKdown(TreeNode<E> root, E data, int k){
        if (root == null){
            return -1;
        }
        if(data.compareTo(root.data) == 0){
            printKdown(root,k);
            return 0;
        }
        int dl = printKdown(root.left,data,k);
        if(dl != -1){
            if(k == (dl + 1)){
                System.out.println(root.data);
            }
            else{
                printKdown(root.right,k-dl-2);
                
            }
            return dl+1;
        }
        int dr = printKdown(root.right, data, k);
        
        if(dr != -1){
            System.out.println("the dr val is :"+ dr);
            if (k == (dr + 1) ){
                System.out.println(root.data);
            }
            else{
                printKdown(root.left,k-dr-2);
                
                
            }
            return dr+1;
        }
        return -1;
    }
    public void printKdown(E data, int k){
        printKdown(root,data,k);
    }
    public int nodeDepth(E data){
        return nodeDepth(root,data);
    }
    public boolean  leaf(TreeNode <E> root){
        return (root.left == null && root.right== null);
    }
    
    
    private int altnodeDepth(TreeNode<E> root, E data){
        if (root == null ){
            return -1;
        }
        if (root.data.compareTo(data) == 0){
            return 0;
        }
        int dl = altnodeDepth(root.left,data);
        int dr = altnodeDepth(root.right, data);
        if(dl >= 0){
            return dl+ 1;
        }
        if(dr >= 0){
            return dr+1;
        }
        return -1;
    }
    public int altDepth(E data){
        return altnodeDepth(root,data);
    }
     
    private int nodeDepth(TreeNode<E> root, E data){
        int depth = -1;
        if(root != null){
            if (root.data.compareTo(data) == 0){
                depth = 0;
            }
            int dl = nodeDepth (root.left,data);
            int dr = nodeDepth(root.right,data);
            if(dl >= 0){
                depth = dl + 1;
            }
            if(dr >= 0){
                depth = dr + 1;
            }
        }
        return depth;   
    }
    private void printKfromLeaf(){
        
    }
    public void LCA(E data1, E data2){
        TreeNode<E> x = LCA(root, data1, data2);
        System.out.println("The ancestors of supplied nodes are "+ x.toString());
    }
    private TreeNode<E> LCA(TreeNode<E> root, E data1, E data2){
        
        // Base case 1:: if any one of target equals node
        if(root.data.equals(data1) || root.data.equals(data2)){
            return root;
        }
        
        // base case 2 :: targets are immediate left and right children of root
        else if ((root.left.data.equals(data1)&&root.right.data.equals(data2))|| (root.left.data.equals(data2)&&root.right.data.equals(data1))){
            return root;
        }
        
        // base case 3 :: if LCA is not in this particular branch of the BST
        else if (root == null){
            return root;
        }
        
        // inductive case : recur in LST and RST of root node
        else{
            // search in LST
            TreeNode<E> xLeft = LCA(root.left, data1, data2);
            // search in RST
            TreeNode<E> xRight = LCA(root.right, data1, data2);
            // if one node is RST and other in LST , then root is the LCA 
            if(xLeft != null && xRight != null){
                return root;
            }
            // if both nodes are in RST , then node returned by querying RST is LCA
            else if(xLeft == null){
                return xRight;
            }
            
            // if both nodes are in LST , then node returned by querying LST is LCA
            else{
                return xLeft;
            }
        }
    }
    public void getDiameter(){
        System.out.println(getDiameter(root));
    }
    private int getDiameter(TreeNode<E> root){
        if (root == null){
            return 0;
        }
        int lHeight = height(root.left);
        int rHeight = height(root.right);
        int lDiameter = getDiameter(root.left);
        int rDiameter = getDiameter(root.right);
        int height = lHeight + rHeight + 1;
        return Math.max(Math.max(lDiameter, rDiameter),height);
        
    }
    private int height(TreeNode<E> root){
        if (root == null){
            return 0;
        }
        else{
            return 1+ Math.max(height(root.left),height(root.right));
        }
    }
}


    
   

