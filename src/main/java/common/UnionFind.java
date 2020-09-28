package common;

/** UnionFind/Disjoint Set data structure implementation. */
public class UnionFind {
  // id[i] points to the parent of i, if id[i] = i the i is a root node
  int[] id;
  // sz[i] keep track of the size of each components
  int[] sz;
  // number of components
  int numComponents;
  // The number of elements in this union find
  private int size;

  public UnionFind(int size) {
    if (size <= 0) throw new IllegalArgumentException("size <= 0 is not allowed");
    this.size = size;
    this.numComponents = size;
    this.id = new int[size];
    this.sz = new int[size];

    for (int i = 0; i < size; i++) {
      id[i] = i;
      sz[i] = 1;
      }
  }

  /** @return The number of elements in the UnionFind/Disjoints set */
  public int size() {
    return size;
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
      sz[p_parent] -= 1; // remove p from it's parent, adjust the size of the parent.
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
