package infrastructure;

/**
 * EngineType represents a concrete train engine.
 *
 * @author dkovpaka
 */
public enum EngineType {
    DIESEL (0),
    ELECTRO (1),
    COAL (2),
    UKNOWN(-1);

    private int engineType;

    EngineType(int engineType) {
        this.engineType = engineType;
    }
}
