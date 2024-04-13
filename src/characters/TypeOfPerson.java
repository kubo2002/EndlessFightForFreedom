package characters;

public enum TypeOfPerson {
    KNIGHT("knight", 2);

    private final String name;
    private final int numberOfFrames;

    TypeOfPerson(String name, int numberOfFrames) {
        this.name = name;
        this.numberOfFrames = numberOfFrames;
    }

    public String getName() {
        return this.name;
    }

    public int getNumberOfFrames() {
        return this.numberOfFrames;
    }
}
