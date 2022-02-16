import java.math.BigInteger;
class MaxProductOfSplittedBinaryTree {
    double sum = 0;
    BigInteger max = BigInteger.valueOf(0);
    public int maxProduct(TreeNode root) {
        calculateSum(root);
        calculateProduct(root);

        return max.divideAndRemainder(BigInteger.valueOf(1000000007))[1].intValue();
    }

    private int calculateProduct(TreeNode root) {
        if(root == null)return 0;

        int left = calculateProduct(root.left);
        int right = calculateProduct(root.right);
        int curSum = left + right + root.val;
        BigInteger curProduct = BigInteger.valueOf(curSum).multiply(BigInteger.valueOf((int) sum - curSum));
        // System.out.println(max + " " + curProduct);
        // System.out.println(curProduct.compareTo(max));
        if(curProduct.compareTo(max) > 0){
            max = curProduct;
        }
        return curSum;
    }

    private void calculateSum(TreeNode root) {
        if(root == null)return;
        sum += root.val;
        calculateSum(root.left);
        calculateSum(root.right);
    }
}