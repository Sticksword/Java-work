import java.util.LinkedList;
import java.util.Queue;

public class Tree {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		int inStart = 0;
		int inEnd = inorder.length - 1;
		int postStart = 0;
		int postEnd = postorder.length - 1;

		return buildTree(inorder, inStart, inEnd, postorder, postStart, postEnd);
	}

	public TreeNode buildTree(int[] inorder, int inStart, int inEnd,
			int[] postorder, int postStart, int postEnd) {
		if (inStart > inEnd || postStart > postEnd)
			return null;

		int rootValue = postorder[postEnd];
		TreeNode root = new TreeNode(rootValue);

		int k = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == rootValue) {
				k = i;
				break;
			}
		}

		root.left = buildTree(inorder, inStart, k - 1, postorder, postStart,
				postStart + k - (inStart + 1));
		
		root.right = buildTree(inorder, k + 1, inEnd, postorder, postStart + k
				- inStart, postEnd - 1);

		return root;
	}

	public void breadthSearch(TreeNode root, Queue<TreeNode> queue) {
		if (root == null)
			return;
		queue.clear();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode node = (TreeNode) queue.remove();
			System.out.print(node.val + " ");
			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);
		}
	}

	public static void main(String[] args) {
		// String in = "4,2,7,5,8,1,3,9,6,11,10";
		String in = "154,97,63,149,2,34,147,64,100,20,40,67,51,93,72,158,136,35,33,156,10,75,99,42,49,30,77,128,54,44,76,151,146,23,68,80,21,36,50,139,82,159,117,167,85,173,144,152,28,1,168,18,157,171,71,15,112,155,94,3,102,174,121,135,16,109,113,41,26,84,115,120,104,163,166,56,161,8,32,88,170,129,140,116,133,79,101,92,57,58,124,162,45,73,95,90,47,19,108,4,125,172,141,70,43,110,86,12,17,37,160,5,169,24,29,48,130,165,150,61,138,11,66,52,119,69,13,164,148,62,126,7,145,27,14,81,131,60,91,114,96,74,143,132,25,31,55,103,9,118,123,106,122,65,111,6,127,142,105,137,134,153,89,39,83,46,53,59,22,38,98,78,107,87,0";
		String[] inStringArr = in.split(",");
		int[] inOrder = new int[inStringArr.length];
		for (int i = 0; i < inOrder.length; i++) {
			inOrder[i] = Integer.parseInt(inStringArr[i]);
		}

		// String post = "4,7,8,5,2,9,11,10,6,3,1";
		String post = "79,101,133,92,116,57,58,140,124,129,162,45,170,73,95,90,47,88,32,8,19,161,56,108,166,4,125,172,163,104,141,70,43,120,115,110,84,86,26,41,113,12,17,37,160,109,5,16,135,121,169,24,174,29,102,3,94,48,155,112,130,15,165,150,61,138,71,11,171,157,66,52,119,18,168,69,13,1,28,164,148,152,144,173,85,62,126,167,117,159,82,7,139,145,50,27,14,81,131,36,60,91,114,21,80,96,74,68,143,132,23,25,31,55,103,9,118,146,151,123,106,122,76,44,65,111,6,127,54,142,105,137,128,134,77,30,49,153,89,42,39,99,75,10,156,83,33,35,136,158,72,46,53,93,51,67,59,40,22,38,98,20,100,64,147,78,34,2,107,149,63,97,154,87,0";
		String[] postStringArr = post.split(",");
		int[] postOrder = new int[postStringArr.length];
		for (int i = 0; i < postOrder.length; i++) {
			postOrder[i] = Integer.parseInt(postStringArr[i]);
		}

		Tree myTree = new Tree();
		TreeNode myRoot = myTree.buildTree(inOrder, postOrder);
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		myTree.breadthSearch(myRoot, queue);
	}
}
