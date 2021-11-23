package group5.duan.library.enumration;

public enum StatusBorrow {
    NOT_YET("NOT_YET",1),
    ALREADY("ALREADY",2);

    private final String key;
    private final Integer value;

    StatusBorrow(String key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Integer getValue() {
        return value;
    }
}
