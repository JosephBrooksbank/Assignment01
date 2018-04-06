/**
 * Class added for assignment; Simply character object with name
 */
class GameCharacter {
    /**
     * The name of the character
     */
    private final String name;

    /**
     * Basic constructor
     *
     * @param name Name of character
     */
    public GameCharacter(String name) {
        this.name = name;
    }

    /**
     * implementation of toString which returns the name of the Character
     */
    public String toString() {
        return name;
    }

    /**
     * implementation of equals method
     *
     * @param other The object to compare for equality
     * @return Whether or not the objects are equal (same name of character, in this case)
     */
    public boolean equals(Object other) {
        // Checking if object is null
        if (other == null) {
            return false;
        }

        // Checking if object is correct class
        if (this.getClass() != other.getClass()) {
            return false;
        }

        // Checking if other character object has same name (is equal)
        return this.toString().equals(other.toString());
    }
}


