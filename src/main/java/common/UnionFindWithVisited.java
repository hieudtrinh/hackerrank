package common;

import java.util.Arrays;

/** UnionFind/Disjoint Set data structure implementation. */
public class UnionFindWithVisited {
  // id[i] points to the parent of i, if id[i] = i the i is a root node
  int[] id;
  // sz[i] keep track of the size of each components
  int[] sz;
  // number of components
  int numComponents;
  // The number of elements in this union find
  private int size;

  public UnionFindWithVisited(int size) {
    if (size <= 0) throw new IllegalArgumentException("size <= 0 is not allowed");
    this.size = size;
    this.numComponents = 0;
    this.id = new int[size];
    this.sz = new int[size];

    Arrays.fill(id, -1);  // -1 mean id has not been added
    Arrays.fill(sz, 0); // use for path compression to improve performance
  }

  /** @return The number of elements in the UnionFind/Disjoints set */
  public int size() {
    return size;
  }

  public void addComponent(int q) {
    if (id[q] == -1) {
      id[q] = q;
      sz[q] = 1; // initialize to 1, which kind of redundant to #line 24
      numComponents++;
    }
  }

  public boolean hasSeen(int q) {
    return id[q] != -1;
  }

  /** @return The number of components/sets in this UnionFind/Disjoints set */
  public int getNumComponents() {
    return numComponents;
  }

  /**
   * Find which component/set 'p' belongs to, takes amortized constant time.
   *
   * @param p root or ID
   * @return  component/set that containing p
   */
  int find(int p) {
    int root = p;
    while (root != id[root]) root = id[root];

    // Compress the path leading back to the root.
    // Doing this operation is called "path compression"
    // and is what gives us amortized time complexity.
    while (p != root) {
      int p_parent = id[p];
      id[p] = root;
      p = p_parent;
    }
    return root;
  }

  public void union(int p, int q) {
    int root1 = find(p);
    int root2 = find(q);
    // These elements are already in the same group.
    if (root1 == root2) return;

    // Merge smaller component/set into the larger one.
    if (sz[root1] < sz[root2]) {
      sz[root2] += sz[root1];
      id[root1] = root2;
    } else {
      sz[root1] += sz[root2];
      id[root2] = root1;
    }
    // Since the roots found are different, after we
    // merge them the number of components/sets has
    // decreased by one.
    numComponents--;
  }
}
