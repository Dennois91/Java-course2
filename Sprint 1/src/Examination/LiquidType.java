package Examination;

public enum LiquidType {
    MEATEATER("Protein blend"),
    PALMTREE("Tap-water"),
    CACTUS("Mineral-water");

    private final String liquidType;

    LiquidType(String liquidType) {
        this.liquidType = liquidType;
    }

    public String getLiquidType() {
        return liquidType;
    }
}
