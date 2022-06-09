package chapter03.lec14;

public enum JavaCountry {
    KOREA("KO"),
    AMERICA("US")
    ;
    private final String code;
    public String getCode() {
        return code;
    }
    JavaCountry(String code) {
        this.code = code;
    }
}
