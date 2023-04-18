// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman
/**
 * Hussein's Binary Search Tree
 * 27 March 2017
 * @author Hussein Suleman
 * @version 1.0.0
 */
public class BinaryTreeNode<dataType>
{
   dataType data;
   BinaryTreeNode<dataType> left;
   BinaryTreeNode<dataType> right;
   
   public BinaryTreeNode ( dataType d, BinaryTreeNode<dataType> l, BinaryTreeNode<dataType> r )
   {
      data = d;
      left = l;
      right = r;
   }
   
   BinaryTreeNode<dataType> getLeft () { return left; }
   BinaryTreeNode<dataType> getRight () { return right; }
}
