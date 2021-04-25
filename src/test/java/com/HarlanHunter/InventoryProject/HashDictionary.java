package src.test.java.com.HarlanHunter.InventoryProject;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This is an implementation of a hash table using separate chaining. Entries in
 * the array contain Nodes, which form a chain of all key-value pairs with the
 * same key hash index.
 *
 * @author Hunter Mark Shaw
 * @author Harlan Chandler
 */
public class HashDictionary<K, V> implements Dictionary<K, V>, Serializable {

    private static final long serialVersionUID = 1L;
    private Object[] entries; //array of Nodes
    private int size;
    private static final int DEFAULT_CAPACITY = 17;
    private static final double THRESHOLD = 1.5;
    
    public HashDictionary() {
        this(DEFAULT_CAPACITY);
    }
    
    public HashDictionary(int initialCapacity) {
        entries = new Object[initialCapacity];
        size = 0;
    }

    @Override
    public Iterator<K> keys() {
        return new Iterator<K>() {
            private int count = 0;
            private int currentindex = 0;
            private Node currentNode = null;

            @Override
            public boolean hasNext() {
                return count < size;
            }

            @SuppressWarnings("unchecked")
            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                while (currentNode == null) {
                    currentNode = (Node)entries[currentindex++]; //Give the first node in table
                }

                K key = currentNode.getKey();
                currentNode = currentNode.getNext();
                count++;
                return key;
            }

        };
    }
    
    @Override
    public Iterator<V> elements() {
        return new Iterator<V>() {
            private int count = 0;
            private int currentindex = 0;
            private Node currentNode = null;

            @Override
            public boolean hasNext() {
                return count < size;
            }

            @SuppressWarnings("unchecked")
            @Override
            public V next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                while (currentNode == null) {
                    currentNode = (Node)entries[currentindex++]; //Give the first node in table
                }

                V value = currentNode.getValue();
                currentNode = currentNode.getNext();
                count++;
                return value;
            }
        };
    }

    @SuppressWarnings("unchecked")
    @Override
    public V get(K key) {
        int index = getHashIndex(key);
        Node n = (Node)entries[index];
        while (n != null && !n.getKey().equals(key)) {
            n = n.getNext();
        }
        if (n == null) {
            return null;
        }
        return n.getValue();
    }

    @SuppressWarnings("unchecked")
    @Override
    public V remove(K key) {
        if (key == null) {
            throw new NullPointerException();
        }
        int nodeIndex = getHashIndex(key);
		Node toRemove = (Node)entries[nodeIndex];
        if (toRemove == null) {
            return null;
        }
        if (toRemove.getKey().equals(key)) {
            entries[nodeIndex] = toRemove.getNext();
            size--;
            return toRemove.getValue();
        }
        Node prevNode = toRemove;
        toRemove = toRemove.getNext();
        while (toRemove != null) {
            if (toRemove.getKey().equals(key)) {
                prevNode.setNext(toRemove.getNext());
                size--;
                return toRemove.getValue();
            } else {
                prevNode = toRemove;
                toRemove = toRemove.getNext();
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        if (get(key) != null) {
            Node toChange = getNodeForKey(key);
            V oldValue = toChange.getValue();
            toChange.setValue(value);
            return oldValue;
        } else if (get(key) == null) {
            add(key, value);
            return null;
        } else {
            throw new NullPointerException(); // Throws NullPointerException as key or value is null.
        }
    }
    
    public void updateValue(K key, V value) {
    	Node currentN = getNodeForKey(key);
    	currentN.setValue(value);
    }

    @SuppressWarnings("unchecked")
    private void add(K key, V value) {
        Node currentNode = (Node)entries[getHashIndex(key)];
        Node toAdd = new Node(key, value);
        entries[getHashIndex(key)] = toAdd;
        toAdd.setNext(currentNode);
        size++;
    }

    @SuppressWarnings("unchecked")
    private Node getNodeForKey(K key) {
		Node currentNode = (Node)entries[getHashIndex(key)];
        while (!currentNode.getKey().equals(key)) {
            currentNode = currentNode.getNext();
            if (currentNode == null) {
                return null;
            }
        }
        return currentNode;
    }

    private int getHashIndex(K key) {
        int capacity = entries.length;
        int index = key.hashCode() % capacity;
        if (index < 0) {
            index += capacity;
        }
        return index;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
    
        private boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        if (n == 2 || n == 3) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }

        for (int i = 3; i < (int) Math.sqrt(n) + 1; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    private int nextPrime(int n) {
        int p = n + 1;
        while (!isPrime(p)) {
            p++;
        }
        return p;
    }
	
        private void resizeTable(int newCapacity) {
      if (!isPrime(newCapacity)) {
        newCapacity = nextPrime(newCapacity);
      }
      Object[] oldTable = entries;
      int oldSize = size;
      entries = new Object[newCapacity];
      size = 0;
      int currentIndex = 0;
      Node currentNode = null;

      while (size < oldSize) {
        while (currentNode == null) {
          currentNode = (Node)oldTable[currentIndex++];
        }
        while (currentNode != null) {
          add(currentNode.getKey(), currentNode.getValue());
          currentNode = currentNode.getNext();
        }
      }
    }

    private class Node {

        private K key;
        private V value;
        private Node next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }
}
