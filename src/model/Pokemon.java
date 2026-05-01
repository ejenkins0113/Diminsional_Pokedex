package model;

public class Pokemon implements Comparable<Pokemon> {

    // ==== Attributes ====
    private int id;
    private String name;
    private String primaryType;
    private String secondaryType;   // can be null or empty if no secondary type
    private int level;
    private int hp;
    private int attack;
    private int defense;
    private String dimension;
    private int evolutionStage;     // 0 = base, 1 = first evolution, 2 = second evolution
    private boolean isMega;
    private boolean seen;
    private boolean caught;
    private String description;

    // ==== Constructor ====
    public Pokemon(int id, String name, String primaryType, String secondaryType,
                   int level, int hp, int attack, int defense,
                   String dimension, int evolutionStage, boolean isMega,
                   boolean seen, boolean caught, String description) {
        this.id = id;
        this.name = name;
        this.primaryType = primaryType;
        this.secondaryType = secondaryType;
        this.level = level;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.dimension = dimension;
        this.evolutionStage = evolutionStage;
        this.isMega = isMega;
        this.seen = seen;
        this.caught = caught;
        this.description = description;
    }

    // ==== Getters ====
    public int getId() { return id; }
    public String getName() { return name; }
    public String getPrimaryType() { return primaryType; }
    public String getSecondaryType() { return secondaryType; }
    public int getLevel() { return level; }
    public int getHp() { return hp; }
    public int getAttack() { return attack; }
    public int getDefense() { return defense; }
    public String getDimension() { return dimension; }
    public int getEvolutionStage() { return evolutionStage; }
    public boolean isMega() { return isMega; }
    public boolean isSeen() { return seen; }
    public boolean isCaught() { return caught; }
    public String getDescription() { return description; }

    // ==== Setters ====
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPrimaryType(String primaryType) { this.primaryType = primaryType; }
    public void setSecondaryType(String secondaryType) { this.secondaryType = secondaryType; }
    public void setLevel(int level) { this.level = level; }
    public void setHp(int hp) { this.hp = hp; }
    public void setAttack(int attack) { this.attack = attack; }
    public void setDefense(int defense) { this.defense = defense; }
    public void setDimension(String dimension) { this.dimension = dimension; }
    public void setEvolutionStage(int evolutionStage) { this.evolutionStage = evolutionStage; }
    public void setMega(boolean mega) { isMega = mega; }
    public void setSeen(boolean seen) { this.seen = seen; }
    public void setCaught(boolean caught) { this.caught = caught; }
    public void setDescription(String description) { this.description = description; }

    // ==== compareTo for sorting by ID ====
    @Override
    public int compareTo(Pokemon other) {
        return Integer.compare(this.id, other.id);
    }

    // ==== toString for display ====
    @Override
    public String toString() {
        String type = (secondaryType != null && !secondaryType.isEmpty())
                ? primaryType + "/" + secondaryType
                : primaryType;
        String mega = isMega ? " [MEGA]" : "";
        String status = (caught ? "Caught" : (seen ? "Seen" : "Unseen"));
        return String.format("#%03d %s%s | %s | Lv.%d | HP:%d ATK:%d DEF:%d | Dim: %s | Evo Stage: %d | %s",
                id, name, mega, type, level, hp, attack, defense, dimension, evolutionStage, status);
    }
}
