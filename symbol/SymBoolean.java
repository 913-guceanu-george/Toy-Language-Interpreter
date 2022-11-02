package symbol;

public class SymBoolean implements ISymbol {
    private Boolean value;
    private String type;
    private String label;

    SymBoolean(Boolean val, String label) {
        this.setType("bool");
        this.value = val;
        this.setLabel(label);
    }

    @Override
    public Boolean getValueBool() {
        return this.value;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String getLabel() {
        return this.label;
    }

    @Override
    public Integer getValueInt() {
        return null;
    }

}
