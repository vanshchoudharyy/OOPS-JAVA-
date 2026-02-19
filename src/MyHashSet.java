public class MyHashSet {
    private static class Node {
        String value;
        Node next;

        Node(String value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node[] buckets;
    private int capacity;
    private int size;
    public MyHashSet() {
        capacity = 16;
        buckets = new Node[capacity];
        size = 0;
    }
    private int getIndex(String value) {
        int hash = value.hashCode();

        if (hash < 0) {
            hash = -hash;  // basically avoid negative index
        }

        return hash % capacity;
    }

    public boolean add(String value) {
        int index = getIndex(value);

        Node current = buckets[index];
        while (current != null) {
            if (current.value.equals(value)) {
                return false; // already exists
            }
            current = current.next;
        }
        Node newNode = new Node(value);
        newNode.next = buckets[index];
        buckets[index] = newNode;

        size++;
        return true;
    }
    public boolean contains(String value) {
        int index = getIndex(value);

        Node current = buckets[index];

        while (current != null) {
            if (current.value.equals(value)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }
    public boolean remove(String value) {
        int index = getIndex(value);

        Node current = buckets[index];
        Node previous = null;

        while (current != null) {
            if (current.value.equals(value)) {

                if (previous == null) {
                    buckets[index] = current.next;
                } else {
                    previous.next = current.next;
                }

                size--;
                return true;
            }

            previous = current;
            current = current.next;
        }

        return false;
    }

    public int size() {
        return size;
    }

    // main method
    public static void main(String[] args) {

        MyHashSet set = new MyHashSet();

        System.out.println("Add Apple: " + set.add("Apple"));
        System.out.println("Add Banana: " + set.add("Banana"));
        System.out.println("Add Apple again: " + set.add("Apple"));

        System.out.println("Size: " + set.size());

        System.out.println("Contains Banana: " + set.contains("Banana"));
        System.out.println("Remove Banana: " + set.remove("Banana"));
        System.out.println("Contains Banana: " + set.contains("Banana"));

        System.out.println("Final Size: " + set.size());
    }
}
