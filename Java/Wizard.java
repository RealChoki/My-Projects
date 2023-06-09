public class Wizard {
    private String firstName;
    private String lastName;
    private int yearOfBirth;
    private int exp;
    
    public Wizard(String firstName, String lastName, int yearOfBirth){
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
        this.exp = 0;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public int getYearOfBirth(){
        return yearOfBirth;
    }
    
    public int getExp(){
        return exp;
    }

    public void addExp(int points){
        this.exp += points;
    }

    public void castSpell(Spell s){
        int castingChance = (int) (Math.random()* 100);
        if(castingChance <= 75){
            System.out.println(s);
            addExp(s.getLevel());
        } else {
            System.out.println("Brzl");
        }
    }

    @Override
    public String toString(){
        return "Wizard: " + firstName + " " + lastName + ", Year of Birth: " + yearOfBirth + ", Exp: " + exp;
    }

    public static void main(String[] args){
        Wizard firstWizard = new Wizard("Luffy", "Monkey.D", 1997);
        Wizard secondWizard = new Wizard("Arlong", "The Saw", 1950);

        Spell spell = new Spell("Fireball", 10); // Create a spell object

        for (int i = 0; i < 100; i++) {
            firstWizard.castSpell(spell);
            secondWizard.castSpell(spell);
        }


        if(firstWizard.getExp() > secondWizard.getExp()){
            System.out.println("The Winner is: " + firstWizard.toString());
        }else if(firstWizard.getExp() < secondWizard.getExp()){
            System.out.println("The Winner is: " + secondWizard.toString());
        }else{
            System.out.println("It's a Draw !!");
        }
    }
}
    





/*
Erstelle eine Klasse Wizard
- mit einem Attribut firstName vom Datentyp String
- mit einem Attribut lastName vom Datentyp String
- mit einem Attribut yearOfBirth vom Datentyp int
- mit einem Attribut exp vom Datentyp int
und folgenden Eigenschaften: 

1.Die Klasse soll einen Konstruktor haben der die ersten 3 Eigenschaften entgegennimmt und die exp auf 0 setzt. x
2.Für alle Eigenschaften des Zauberers sollen Getter-Methoden geschrieben werden. x
3.Es soll eine Methode addExp(int points) geschrieben werden, welche die aktuelle Punktzahl um die übergebenen Punkte erhöht.x

4.Außerdem soll es eine Methode castSpell(Spell s) geben, welche mit 75-prozentiger Wahrscheinlichkeit gelingt und 
den Zauberspruch auf der Konsole ausgibt oder ggf. eine Meldung für einen Fehlschlag ausgibt bspw. "Brzl". Sofern 
der Zauberspruch gelingt, sollen die Erfahrungspunkte (exp) des Zauberers um den Level (level) des Zauberspruches erhöht
werden, wobei die Methode addExp benutzt werden soll.

5.Zuguterletzt soll die toString-Methode des Wizard überschrieben werden und alle Eigenschaften des Zauberers zurückliefern.
6.Versehe sowohl die Klasse als auch die Methode (inklusive Gettern und Settern) mit Dokumentationskommentaren.

Erstelle eine Main-Methode, welche zwei Zauberer erzeugt, die in einen Wettkampf treten, in dem sie 100 Zaubersprüche aufsagen. 
Derjenige Zauberer mit der größeren Erfahrungen (exp) gewinnt den Wettkampf. Der Gewinner soll auf der Konsole ausgegeben werden,
bei Gleichstand soll dies ausgegeben werden.
 */
