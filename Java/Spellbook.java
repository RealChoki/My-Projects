public class Spellbook {
    private String name;
    private Spell[] listOfSpells;
   
    public Spellbook(int numPages) {
        if (numPages < 1) {
            numPages = 1;
        }
        listOfSpells = new Spell[numPages];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Spell[] getSpells() {
        return listOfSpells;
    }

    public void learnSpell(Spell s) {
        for (int i = 0; i < listOfSpells.length; i++) {
            if (listOfSpells[i] == null) {
                listOfSpells[i] = s;
                break;
            }
        }
    }

    public void forgetSpell(String name) {
        for (int i = 0; i < listOfSpells.length; i++) {
            if (listOfSpells[i].getName().equals(name)) {
                listOfSpells[i] = null;
                break;
            }
        }
    }

    public void printBook() {
        System.out.println(this.name);
        for (Spell spell : listOfSpells) {
            if (spell != null) {
                System.out.println(spell.getName());
            }
        }
    }

    public static void main(String[] args) {
        Spellbook book = new Spellbook(4);

        Spell fireball = new Spell("Fireball", 1);
        Spell iceball = new Spell("Iceball", 2);
        Spell tornado = new Spell("Tornado", 3);
        Spell bababoi = new Spell("Bababoi", 4);
        
        book.learnSpell(fireball);
        book.learnSpell(iceball);
        book.learnSpell(tornado);
        book.learnSpell(bababoi);

        book.forgetSpell("Fireball");

        book.printBook();
    }    
}


//The listOfSpells array is properly initialized with the desired number of pages in the constructor.
//The learnSpell method iterates over the listOfSpells array to find an empty slot and assigns the spell s to that slot. Once the spell is added, the loop is terminated using break.
//The forgetSpell method also iterates over the listOfSpells array, checks if a spell exists with the given name, and removes it by setting the corresponding element to null.
//The main method creates instances of the Spell class with different names and page numbers, learns those spells, forgets the spell named "Fireball", and finally prints the contents of the spellbook.

