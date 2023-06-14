
public class Team{
    final private String teamName;
    private int score;
    private static int teamCounter;
    
    public Team(String teamName){
        this.teamName = teamName;
        this.teamCounter = teamCounter + 1;
    }

    public String getTeamName(){
        return this.teamName;
    }

    public int getScore(){
        return this.score;
    }

    public static void getTeamCounter(int teamCounter){

    }

    public void addScore(int score){
        this.score += score;
    }
    
    @Override
    public String toString(){
        return teamName + " " + score + " " + teamCounter; 
    }
    
}


/*
Darüber hinaus erstelle bitte eine Klasse Tournament
- mit einem Array teams vom Typ Team
- mit einem Attribut gameCount vom Typ int
und folgenden Funktionalitäten:

Die Anzahl der Teams im Turnier wird im Konstruktor übergeben. Wenn die Zahl kleiner als 2 ist, dann soll 2 angenommen werden, damit immer mindestens zwei Teams gegeneinander antreten.
Sowohl für die Teams im Turnier (teams) als auch die Anzahl der gespielten Spiele (gameCount) soll eine Getter-Methode implementiert werden.
Es soll eine Methode registerTeam(Team team) erstellt werden, welche ein neues Team im Spiel registriert. Wenn bereits alle freien Plätze im Turnier belegt sind, so tut die Methode nichts.
Es soll eine Methode isReady() implementiert werden, welche true zurückgibt, wenn alle freien Plätze im Turnier belegt sind. Solange noch Plätze frei sind, soll immer false zurückgegeben werden.
Es soll eine Methode playGame(Team team1, Team team2) implementiert werden, die zwei Teams gegeneinander antreten lässt. Zu Beginn der Methode sollen die Namen der Teams ausgegeben werden, die gegeneinander antreten. Es sollen daraufhin in der Methode mehrere Ausgaben erfolgen, was im Spiel passiert. Es soll dabei mindestens drei Spielrunden geben, in denen die Teams eine zufällige Anzahl von Punkten gewinnen. Final soll der Gewinner des Spiels die Punkte auf das Teamkonto gutgeschrieben bekommen. Der Verlierer bekommt keine Punkte. Sollte das Spiel unentschieden ausgehen, so bekommen beide Teams die selbe Punktzahl. Mit jedem gespielten Spiel soll der Zähler für die gespielten Spiele (gameCount) um eins erhöht werden.
Es soll eine Methode playChampionship() implementiert werden, die alle Teams eines Turniers mindestens zweimal gegeneinander antreten lässt. Der Gewinner des jeweiligen Spieles und der oder die Gewinner des gesamten Turnier sollen auf der Konsole ausgegeben werden.
Es soll eine Methode printScore() entwickelt werden, welche die Namen aller Teams und deren Punktzahl absteigend sortiert nach deren Punktzahl auf der Konsole ausgibt. Solange noch kein Spiel stattgefunden hat, soll lediglich die Meldung 'Bisher fand kein Spiel statt.' auf der Konsole ausgegeben werden.
Es soll eine Methode getWinner() entwickelt werden, welche den oder die Gewinner des Turnier nach Punkten (als Array vom Typ Team) zurückliefert. Solange noch kein Spiel stattgefunden hat, soll lediglich ein Array vom Typ Team mit der Größe 0 zurückgeliefert werden.
Erstelle eine Main-Methode, die ein neues Turnier startet und mindestens vier Teams im Turnier registriert. Sobald alle Team bereit sind, soll (mindestens) eine Meisterschaft gespielt werden. Danach soll der Punktestand aller Teams auf der Konsole ausgeben werden und final der oder die Gewinner des Turniers angezeigt werden.

PS: Es liegt an dir, ob du ein Quidditch-Turnier stattfinden lässt oder die Zauber:innen mit Hydro, Elektro-, Kryo- oder Pyrozauber gegeneinander antreten lässt oder auch nur ein einfaches Würfelturnier ausrichtest. Sei kreativ!


 */