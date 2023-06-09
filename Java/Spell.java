public class Spell {
    private final String name;
    private final int level;

    /**
     * Konstruktor für die Klasse Spell.
     *
     * @param name  Der Name des Zauberspruches.
     * @param level Das Level des Zauberspruches.
     */
    public Spell(String name, int level) {
        this.name = name;
        this.level = level;
    }

    /**
     * Getter-Methode für den Namen des Zauberspruches.
     *
     * @return Der Name des Zauberspruches.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter-Methode für das Level des Zauberspruches.
     *
     * @return Das Level des Zauberspruches.
     */
    public int getLevel() {
        return level;
    }

    /**
     * Gibt den Namen und das Level des Zauberspruches als kombinierten String zurück.
     *
     * @return Der kombinierte String aus Name und Level des Zauberspruches.
     */
    public String toString() {
        return "Spell name: " + name + " / Spell Level: " + level;
    }

    public static void main(String[] args) {
        // Erzeugung von drei unterschiedlichen Zaubersprüchen
        Spell spell1 = new Spell("Za Wata", 999);
        Spell spell2 = new Spell("Za Winda", 46);
        Spell spell3 = new Spell("Serious Punch", 3);

        // Ausgabe der Zaubersprüche
        System.out.println(spell1.toString());
        System.out.println(spell2.toString());
        System.out.println(spell3.toString());
    }
}

