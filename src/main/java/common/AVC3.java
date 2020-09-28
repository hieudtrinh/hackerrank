package common;

public class AVC3<K, V, R> {
  private K attr1;
  private V attr2;
  private R ans;

  public K getAttr1() {
    return attr1;
  }

  public V getAttr2() {
    return attr2;
  }

  public R getAns() {
    return ans;
  }

  public AVC3(K attr, V val, R ans) {
    this.attr1 = attr;
    this.attr2 = val;
    this.ans = ans;
  }
}
