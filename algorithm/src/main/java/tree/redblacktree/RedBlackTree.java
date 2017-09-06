package tree.redblacktree;


/**
 * Created by wjk on 2017/4/3.
 */
public class RedBlackTree<K, V> {
    private enum EnumReadBlack {
        red, black;
    }


    static class Node<K, V> {
        private Node<K, V> left;
        private Node<K, V> right;
        private K key;
        private V value;
        private EnumReadBlack color;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            //新建的节点都是红色
            this.color = EnumReadBlack.red;
        }

    }


    private Node<K, V> rotatoLeft(Node<K, V> node) {
        Node resultNode = node.right;
        //颜色
        resultNode.color = node.color;
        node.color = EnumReadBlack.red;

        //子节点
        node.left = node;
        node.right = resultNode.left;
        return resultNode;
    }


    private Node<K, V> rotatoRight(Node<K, V> node) {
        Node resultNode = node.left;
        resultNode.color = node.color;
        node.color = EnumReadBlack.red;

        node.left = resultNode.right;
        resultNode.right = node;
        return resultNode;

    }

    private Node<K, V> rotatoColor(Node<K, V> node) {
        node.left.color = node.color;
        node.right.color = node.color;
        node.color = EnumReadBlack.red;
        return node;
    }


    private V get(Node node, K key) {
        if (node == null) {
            return null;
        }

        return null;
    }

    private Node put(Node node, K key, V value) {
        if (node == null) {
            return new Node(key, value);
        }
        return node;

    }

}
