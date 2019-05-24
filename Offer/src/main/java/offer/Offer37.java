/*
package offer;

*/
/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 *//*


import javax.swing.tree.TreeNode;
public class Offer37 {
    String Serialize(TreeNode root) {
        StringBuilder string = new StringBuilder();
        S(root,string);
        return string.toString();
    }
    void S(TreeNode root,StringBuilder string){
        //当没有子节点的时候加上#！
        if(root==null){
            string.append("#!");
            return;
        }
        //在每个数据后面都加上！
        //所以当整个字符串用!分割以后 无节点的时候为#，有节点的时候为其数据
        string.append(root.val+"!");
        S(root.left,string);
        S(root.right,string);
    }
    TreeNode Deserialize(String str) {
        String[] string = str.split("!");
        TreeNode root = D(string);
        return root;
    }
    int index = 0;
    TreeNode D(String[] string){
        //当为#的时候说明没有，index后移 并且返回null
        if(string[index].equals("#")){
            index++;
            return null;
        }else{
            //当有节点的时候先构造节点，再对其左子树和右子树进行构造，次数的left和right不能互换方向，因为在序列化的时候的顺序是先序及先root再left,right。所以其顺序不可变
            TreeNode temp = new TreeNode(Integer.parseInt(string[index]));
            index++;
            temp.left=D(string);
            temp.right=D(string);
            return temp;
        }

    }
}

*/
