package model;

/**
 * Represents a Pokemon entry in the Dimensional Pokedex.
 *
 * <p>This model stores identity, stats, type information, dimensional origin,
 * evolution state, ownership/visibility flags, and descriptive text.</p>
 */
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

    /**
     * Creates a fully populated Pokemon instance.
     *
     * @param id unique Pokedex identifier
     * @param name Pokemon name
     * @param primaryType primary elemental type
     * @param secondaryType optional secondary elemental type (nullable)
     * @param level current level
     * @param hp current HP stat
     * @param attack current attack stat
     * @param defense current defense stat
     * @param dimension dimensional origin label
     * @param evolutionStage evolution stage index (0 = base)
     * @param isMega whether this form is mega evolved
     * @param seen whether the Pokemon has been seen in the dex
     * @param caught whether the Pokemon has been caught
     * @param description lore or description text
     */
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

    /**
     * @return the Pokemon's Pokedex identifier
     */
    public int getId() { return id; }

    /**
     * @return the Pokemon's display name
     */
    public String getName() { return name; }

    /**
     * @return the Pokemon's primary type
     */
    public String getPrimaryType() { return primaryType; }

    /**
     * @return the Pokemon's secondary type, or null/empty when not set
     */
    public String getSecondaryType() { return secondaryType; }

    /**
     * @return the Pokemon's level
     */
    public int getLevel() { return level; }

    /**
     * @return the Pokemon's HP stat
     */
    public int getHp() { return hp; }

    /**
     * @return the Pokemon's attack stat
     */
    public int getAttack() { return attack; }

    /**
     * @return the Pokemon's defense stat
     */
    public int getDefense() { return defense; }

    /**
     * @return the Pokemon's dimension label
     */
    public String getDimension() { return dimension; }

    /**
     * @return the Pokemon's evolution stage index
     */
    public int getEvolutionStage() { return evolutionStage; }

    /**
     * @return true when this Pokemon is in mega form
     */
    public boolean isMega() { return isMega; }

    /**
     * @return true when this Pokemon has been seen
     */
    public boolean isSeen() { return seen; }

    /**
     * @return true when this Pokemon has been caught
     */
    public boolean isCaught() { return caught; }

    /**
     * @return the Pokemon's lore/description text
     */
    public String getDescription() { return description; }

    /**
     * Updates the Pokemon's identifier.
     *
     * @param id new identifier value
     */
    public void setId(int id) { this.id = id; }

    /**
     * Updates the Pokemon's name.
     *
     * @param name new name value
     */
    public void setName(String name) { this.name = name; }

    /**
     * Updates the Pokemon's primary type.
     *
     * @param primaryType new primary type
     */
    public void setPrimaryType(String primaryType) { this.primaryType = primaryType; }

    /**
     * Updates the Pokemon's secondary type.
     *
     * @param secondaryType new secondary type (nullable)
     */
    public void setSecondaryType(String secondaryType) { this.secondaryType = secondaryType; }

    /**
     * Updates the Pokemon's level.
     *
     * @param level new level value
     */
    public void setLevel(int level) { this.level = level; }

    /**
     * Updates the Pokemon's HP stat.
     *
     * @param hp new HP value
     */
    public void setHp(int hp) { this.hp = hp; }

    /**
     * Updates the Pokemon's attack stat.
     *
     * @param attack new attack value
     */
    public void setAttack(int attack) { this.attack = attack; }

    /**
     * Updates the Pokemon's defense stat.
     *
     * @param defense new defense value
     */
    public void setDefense(int defense) { this.defense = defense; }

    /**
     * Updates the Pokemon's dimension label.
     *
     * @param dimension new dimension name
     */
    public void setDimension(String dimension) { this.dimension = dimension; }

    /**
     * Updates the Pokemon's evolution stage.
     *
     * @param evolutionStage new stage index
     */
    public void setEvolutionStage(int evolutionStage) { this.evolutionStage = evolutionStage; }

    /**
     * Updates mega-evolution flag.
     *
     * @param mega true if mega form is active
     */
    public void setMega(boolean mega) { isMega = mega; }

    /**
     * Updates seen status.
     *
     * @param seen true if seen
     */
    public void setSeen(boolean seen) { this.seen = seen; }

    /**
     * Updates caught status.
     *
     * @param caught true if caught
     */
    public void setCaught(boolean caught) { this.caught = caught; }

    /**
     * Updates description text.
     *
     * @param description new lore text
     */
    public void setDescription(String description) { this.description = description; }

    /**
     * Compares Pokemon by ID in ascending order.
     *
     * @param other Pokemon to compare with
     * @return negative, zero, or positive based on ID ordering
     */
    @Override
    public int compareTo(Pokemon other) {
        return Integer.compare(this.id, other.id);
    }

    /**
     * Builds a formatted one-line summary for console display.
     *
     * @return human-readable Pokemon summary string
     */
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
