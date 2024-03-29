/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hilbert;

import java.util.LinkedList;

public class IntervalST<Value> {

    private Node root;   // root of the BST

    // BST helper node data type
    private class Node {

        Interval interval;      // key
        Value value;              // associated data
        Node left, right;         // left and right subtrees
        int N;                    // size of subtree rooted at this node
        int max;                  // max endpoint in subtree rooted at this node

        Node(Interval interval, Value value) {
            this.interval = interval;
            this.value = value;
            this.N = 1;
            this.max = interval.high;
        }
    }

    /*************************************************************************
     *  BST search
     *************************************************************************/
    public boolean contains(Interval interval) {
        return (get(interval) != null);
    }

    // return value associated with the given key
    // if no such value, return null
    public Value get(Interval interval) {
        return get(root, interval);
    }

    private Value get(Node x, Interval interval) {
        if (x == null) {
            return null;
        }
        int cmp = interval.compareTo(x.interval);
        if (cmp < 0) {
            return get(x.left, interval);
        } else if (cmp > 0) {
            return get(x.right, interval);
        } else {
            return x.value;
        }
    }

    /*************************************************************************
     *  randomized insertion
     *************************************************************************/
    public void put(Interval interval, Value value) {
        if (contains(interval)) {
           // System.out.println("duplicate");
            remove(interval);
        }
        root = randomizedInsert(root, interval, value);
    }

    // make new node the root with uniform probability
    private Node randomizedInsert(Node x, Interval interval, Value value) {
        if (x == null) {
            return new Node(interval, value);
        }
        if (Math.random() * size(x) < 1.0) {
            return rootInsert(x, interval, value);
        }
        int cmp = interval.compareTo(x.interval);
        if (cmp < 0) {
            x.left = randomizedInsert(x.left, interval, value);
        } else {
            x.right = randomizedInsert(x.right, interval, value);
        }
        fix(x);
        return x;
    }

    private Node rootInsert(Node x, Interval interval, Value value) {
        if (x == null) {
            return new Node(interval, value);
        }
        int cmp = interval.compareTo(x.interval);
        if (cmp < 0) {
            x.left = rootInsert(x.left, interval, value);
            x = rotR(x);
        } else {
            x.right = rootInsert(x.right, interval, value);
            x = rotL(x);
        }
        return x;
    }

    /*************************************************************************
     *  deletion
     *************************************************************************/
    private Node joinLR(Node a, Node b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }

        if (Math.random() * (size(a) + size(b)) < size(a)) {
            a.right = joinLR(a.right, b);
            fix(a);
            return a;
        } else {
            b.left = joinLR(a, b.left);
            fix(b);
            return b;
        }
    }

    // remove and return value associated with given interval;
    // if no such interval exists return null
    public Value remove(Interval interval) {
        Value value = get(interval);
        root = remove(root, interval);
        return value;
    }

    private Node remove(Node h, Interval interval) {
        if (h == null) {
            return null;
        }
        int cmp = interval.compareTo(h.interval);
        if (cmp < 0) {
            h.left = remove(h.left, interval);
        } else if (cmp > 0) {
            h.right = remove(h.right, interval);
        } else {
            h = joinLR(h.left, h.right);
        }
        fix(h);
        return h;
    }

    /*************************************************************************
     *  Interval searching
     *************************************************************************/
    // return an interval in data structure that intersects the given inteval;
    // return null if no such interval exists
    // running time is proportional to log N
    public Interval search(Interval interval) {
        return search(root, interval);
    }

    // look in subtree rooted at x
    public Interval search(Node x, Interval interval) {
        while (x != null) {
            if (interval.includes(x.interval)) {
                return x.interval;
            } else if (x.left == null) {
                x = x.right;
            } else if (x.left.max < interval.low) {
                x = x.right;
            } else {
                x = x.left;
            }
        }
        return null;
    }
    
     // look in subtree rooted at x
    public Interval search_intersections(Node x, Interval interval) {
        while (x != null) {
            if (interval.intersects(x.interval)) {
                return x.interval;
            } else if (x.left == null) {
                x = x.right;
            } else if (x.left.max < interval.low) {
                x = x.right;
            } else {
                x = x.left;
            }
        }
        return null;
    }

    // return *all* intervals in data structure that intersect the given interval
    // running time is proportional to R log N, where R is the number of intersections
    public Iterable<Interval> searchAll(Interval interval) {
        LinkedList<Interval> list = new LinkedList<Interval>();
        searchAll(root, interval, list);
        return list;
    }
    
    public Iterable<Interval> searchAll_intersections(Interval interval) {
        LinkedList<Interval> list = new LinkedList<Interval>();
        searchAll_intersections(root, interval, list);
        return list;
    }
    
       // return *all* intervals in data structure that intersect the given interval
    // running time is proportional to R log N, where R is the number of intersections


    
    // look in subtree rooted at x
    public boolean searchAll(Node x, Interval interval, LinkedList<Interval> list) {
        boolean found1 = false;
        boolean found2 = false;
        boolean found3 = false;
        if (x == null) {
            return false;
        }
        if (interval.includes(x.interval)) {
            list.add(x.interval);
            found1 = true;
        }
        if (x.left != null && x.left.max >= interval.low) {
            found2 = searchAll(x.left, interval, list);
        }
        if (found2 || x.left == null || x.left.max < interval.low) {
            found3 = searchAll(x.right, interval, list);
        }
        return found1 || found2 || found3;
    }
    
     // look in subtree rooted at x
    public boolean searchAll_intersections(Node x, Interval interval, LinkedList<Interval> list) {
        boolean found1 = false;
        boolean found2 = false;
        boolean found3 = false;
        if (x == null) {
            return false;
        }
        if (interval.intersects(x.interval)) {
            list.add(x.interval);
            found1 = true;
        }
        if (x.left != null && x.left.max >= interval.low) {
            found2 = searchAll_intersections(x.left, interval, list);
        }
        if (found2 || x.left == null || x.left.max < interval.low) {
            found3 = searchAll_intersections(x.right, interval, list);
        }
        return found1 || found2 || found3;
    }

    /*************************************************************************
     *  useful binary tree functions
     *************************************************************************/
    // return number of nodes in subtree rooted at x
    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.N;
        }
    }

    // height of tree (empty tree height = 0)
    public int height() {
        return height(root);
    }

    private int height(Node x) {
        if (x == null) {
            return 0;
        }
        return 1 + Math.max(height(x.left), height(x.right));
    }

    /*************************************************************************
     *  helper BST functions
     *************************************************************************/
    // fix auxilliar information (subtree count and max fields)
    private void fix(Node x) {
        if (x == null) {
            return;
        }
        x.N = 1 + size(x.left) + size(x.right);
        x.max = max3(x.interval.high, max(x.left), max(x.right));
    }

    private int max(Node x) {
        if (x == null) {
            return Integer.MIN_VALUE;
        }
        return x.max;
    }

    // precondition: a is not null
    private int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    // right rotate
    private Node rotR(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        fix(h);
        fix(x);
        return x;
    }

    // left rotate
    private Node rotL(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        fix(h);
        fix(x);
        return x;
    }

    /*************************************************************************
     *  Debugging functions that test the integrity of the tree
     *************************************************************************/
    // check integrity of subtree count fields
    public boolean check() {
        return checkCount() && checkMax();
    }

    // check integrity of count fields
    private boolean checkCount() {
        return checkCount(root);
    }

    private boolean checkCount(Node x) {
        if (x == null) {
            return true;
        }
        return checkCount(x.left) && checkCount(x.right) && (x.N == 1 + size(x.left) + size(x.right));
    }

    private boolean checkMax() {
        return checkMax(root);
    }

    private boolean checkMax(Node x) {
        if (x == null) {
            return true;
        }
        return x.max == max3(x.interval.high, max(x.left), max(x.right));
    }

    /*************************************************************************
     *  test client
     *************************************************************************/
    public static void main(String[] args) {

//
        // generate N random intervals and insert into data structure
        IntervalST<String> st = new IntervalST();
        for (int i = 0; i < 10; i++) {
            int low = i;
            int high = i + 10;
            Interval interval = new Interval(low, high,null);
            System.out.println(interval.toString());
            st.put(interval, null);
        }

        // print out tree statistics
        System.out.println("height:          " + st.height());
        System.out.println("size:            " + st.size());
        System.out.println("integrity check: " + st.check());
        System.out.println();


        // generate random intervals and check for overlap
       
            
            Interval interval = new Interval(10, 17,null);
          System.out.println("");
            for (Interval x : st.searchAll(interval)) {
                System.out.println("----->"+x.toString() + " ");
            }
       
        


    }
}