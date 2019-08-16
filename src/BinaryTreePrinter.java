public class BinaryTreePrinter {

    // original idea from https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram
    private static StringBuilder toString(StringBuilder prefix, AVL_Tree node, boolean isTail, StringBuilder sb) {
        if (node.getRightChild() != null) {
            toString(new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), node.getRightChild(), false, sb);
        }
        sb.append(prefix).append(isTail ? "└── " : "┌── ").append(node.getData().toString()).append(" ").append(node.getBalanceFactorAsString()).append("\n");
        if (node.getLeftChild() != null) {
            toString(new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), node.getLeftChild(), true, sb);
        }
        return sb;
    }

    public static String print(AVL_Tree node) {
        return toString(new StringBuilder(), node, true, new StringBuilder()).toString();
    }
}
