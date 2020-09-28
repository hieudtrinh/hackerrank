package common;

public class NameValuePair {
    String name;
    String value;

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public NameValuePair(String name, String value) {
        this.name = name;
        this.value = value;
    }
}
