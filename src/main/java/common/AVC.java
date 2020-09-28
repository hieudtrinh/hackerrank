package common;

public class AVC<K, V> {
  private K attr;
  private V val;

  public K getAttr() {
    return attr;
  }

  public V getVal() {
    return val;
  }

  public AVC(K attr, V val) {
    this.attr = attr;
    this.val = val;
  }
}
