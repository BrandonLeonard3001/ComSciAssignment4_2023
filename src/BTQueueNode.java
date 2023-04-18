// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman
/**
 * Hussein's Binary Search Tree
 * 27 March 2017
 * @author Hussein Suleman
 * @version 1.0.0
 */
public class BTQueueNode<dataType>
{
   BinaryTreeNode<dataType> node;
   BTQueueNode<dataType> next;
   
   public BTQueueNode ( BinaryTreeNode<dataType> n, BTQueueNode<dataType> nxt )
   {
      node = n;
      next = nxt;
   }
}
