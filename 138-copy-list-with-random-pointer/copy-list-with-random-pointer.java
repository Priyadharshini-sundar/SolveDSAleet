/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node current = head;
        Node result = null;
        Node prev = null;
        Map<Node, Node> nodeMap = new HashMap<>();

        while(current != null){
            Node newNode = new Node(current.val);
            nodeMap.put(current, newNode);
            if(prev == null) result = newNode;
            else prev.next = newNode;

            prev = newNode;
            current = current.next;
        }

        current = head;
        Node temp = result;

        while(current != null){
            temp.random = nodeMap.get(current.random);
            current = current.next;
            temp = temp.next;
        }
        return result;
    }
}