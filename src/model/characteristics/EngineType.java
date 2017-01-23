package model.characteristics;

/**
 * EngineType represents a concrete train engine.
 *
 * @author deniskovpaka
 */
public enum EngineType {
    DIESEL,
    ELECTRO,
    COAL,
    UKNOWN;

    public static EngineType convertString(String str) {
        for (EngineType type : EngineType.values()) {
            if (type.toString().equals(str.toUpperCase())) {
                return type;
            }
        }
        return null;
    }
}
