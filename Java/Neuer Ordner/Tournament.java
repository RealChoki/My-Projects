
public class Tournament {
    private int gameCount;
    private Team[] teams;

    public Tournament(int teamsAmount){
        if(teamsAmount < 2){
            teamsAmount = 2;
        }
        teams = new Team[teamsAmount];
    }

    public Team[] getTeams(){
        return this.teams;
    }

    public int getGameCount(){
        return this.gameCount;
    }

    public void registerTeam(Team team){
        for (int i=0 ; i< teams.length; i++){
            if(teams[i] == null){
                teams[i] = team;
            }
        }
    }
}
/*
Es soll eine Methode isReady() implementiert werden, welche true zurückgibt, wenn alle freien Plätze im Turnier belegt sind. Solange noch Plätze frei sind, soll immer false zurückgegeben werden.
Es soll eine Methode playGame(Team team1, Team team2) implementiert werden, die zwei Teams gegeneinander antreten lässt. Zu Beginn der Methode sollen die Namen der Teams ausgegeben werden, die gegeneinander antreten. Es sollen daraufhin in der Methode mehrere Ausgaben erfolgen, was im Spiel passiert. Es soll dabei mindestens drei Spielrunden geben, in denen die Teams eine zufällige Anzahl von Punkten gewinnen. Final soll der Gewinner des Spiels die Punkte auf das Teamkonto gutgeschrieben bekommen. Der Verlierer bekommt keine Punkte. Sollte das Spiel unentschieden ausgehen, so bekommen beide Teams die selbe Punktzahl. Mit jedem gespielten Spiel soll der Zähler für die gespielten Spiele (gameCount) um eins erhöht werden.
Es soll eine Methode playChampionship() implementiert werden, die alle Teams eines Turniers mindestens zweimal gegeneinander antreten lässt. Der Gewinner des jeweiligen Spieles und der oder die Gewinner des gesamten Turnier sollen auf der Konsole ausgegeben werden.
Es soll eine Methode printScore() entwickelt werden, welche die Namen aller Teams und deren Punktzahl absteigend sortiert nach deren Punktzahl auf der Konsole ausgibt. Solange noch kein Spiel stattgefunden hat, soll lediglich die Meldung 'Bisher fand kein Spiel statt.' auf der Konsole ausgegeben werden.
Es soll eine Methode getWinner() entwickelt werden, welche den oder die Gewinner des Turnier nach Punkten (als Array vom Typ Team) zurückliefert. Solange noch kein Spiel stattgefunden hat, soll lediglich ein Array vom Typ Team mit der Größe 0 zurückgeliefert werden.
Erstelle eine Main-Methode, die ein neues Turnier startet und mindestens vier Teams im Turnier registriert. Sobald alle Team bereit sind, soll (mindestens) eine Meisterschaft gespielt werden. Danach soll der Punktestand aller Teams auf der Konsole ausgeben werden und final der oder die Gewinner des Turniers angezeigt werden.

PS: Es liegt an dir, ob du ein Quidditch-Turnier stattfinden lässt oder die Zauber:innen mit Hydro, Elektro-, Kryo- oder Pyrozauber gegeneinander antreten lässt oder auch nur ein einfaches Würfelturnier ausrichtest. Sei kreativ!


 */