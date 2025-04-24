package co.edu.umanizales.myfirstapi.model;

public class Location {
    private String code;
    private String name;
    private String stateCode;
    private boolean isCapital;

    public Location(String code, String name, String stateCode, boolean isCapital) {
        this.code = code;
        this.name = name;
        this.stateCode = stateCode;
        this.isCapital = isCapital;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public String getStateCode() { return stateCode; }
    public boolean isCapital() { return isCapital; }

    public void setCode(String code) { this.code = code; }
    public void setName(String name) { this.name = name; }
    public void setStateCode(String stateCode) { this.stateCode = stateCode; }
    public void setCapital(boolean capital) { isCapital = capital; }
}
