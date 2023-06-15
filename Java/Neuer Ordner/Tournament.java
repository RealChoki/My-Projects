import java.util.Arrays;

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

    public boolean isReady(){
        for (Team spots: teams){
            if(spots != null){
                return true;
            }
        }

        return false;
    }

    public void playGame(Team team1, Team team2){
        System.out.println(team1.getTeamName() + " vs " + team2.getTeamName());
        for (int i=0 ; i<3; i++){
            int firstRandomScore = (int) Math.random() * 10;
            int secondRandomScore = (int) Math.random() * 10;
          
            if(firstRandomScore > secondRandomScore){
                team1.addScore(firstRandomScore);
            }else if (secondRandomScore > firstRandomScore){
                team2.addScore(secondRandomScore);
            }else{
                team1.addScore(firstRandomScore);
                team2.addScore(secondRandomScore);
            }

            this.gameCount++;
        }
    }

    public void playChampionship(){
        for (int i = 0; i < teams.length; i++){
            for (int j = teams.length; j > 0; j--){
                playGame(teams[i], teams[j]);

                if(teams[i].getScore() > teams[j].getScore()){
                    System.out.println(teams[i].getTeamName() + " won this round !!");
                }else if(teams[j].getScore() > teams[i].getScore()){
                    System.out.println(teams[j].getTeamName() + " won this round !!");
                }
            }
        }
    }

    public void printScore() {
    if (gameCount == 0) {
        System.out.println("Bisher fand kein Spiel statt.");
        return;
    }

    Team[] sortedTeams = Arrays.copyOf(teams, teams.length);

    // Bubble sort
    for (int i = 0; i < sortedTeams.length - 1; i++) {
        for (int j = 0; j < sortedTeams.length - i - 1; j++) {
            if (sortedTeams[j].getScore() < sortedTeams[j + 1].getScore()) {
                // Swap teams
                Team temp = sortedTeams[j];
                sortedTeams[j] = sortedTeams[j + 1];
                sortedTeams[j + 1] = temp;
            }
        }
    }

    for (Team team : sortedTeams) {
        System.out.println(team.getTeamName() + ": " + team.getScore());
    }
}

//highscore, look how many have same highscore,  Winnercount goes up, inisilize list with winner count, put winners in list
    public Team[] getWinner() {
    if (getGameCount() == 0) {
        return new Team[0];
    } else {
        int highScore = 0;
        int winnerCount = 0;
            for (int i = 0; i < teams.length; i++) {
                int score = teams[i].getScore();

                if (score >= teams[i+1].getScore()) {
                    highScore = score;  
                    
                }else{
                    highScore = teams[i+1].getScore();
                }
            }

            for (int i = 0; i < teams.length; i++) {
                if(teams[i].getScore() == highScore){
                    winnerCount++;
                }
            }
            Team[] winner = new Team[winnerCount];
            int index = 0;
            
            for (int i = 0; i < teams.length; i++){
                if (teams[i].getScore() == highScore){
                    winner[index] = teams[i];
                    index++;
                }
            }    
            return winner;
        }
    
    }
}
/*




. Der Gewinner des jeweiligen Spieles und der oder die Gewinner des gesamten Turnier sollen auf der Konsole ausgegeben werden.
Es soll eine Methode printScore() entwickelt werden, welche die Namen aller Teams und deren Punktzahl absteigend sortiert nach deren Punktzahl auf der Konsole ausgibt. Solange noch kein Spiel stattgefunden hat, soll lediglich die Meldung 'Bisher fand kein Spiel statt.' auf der Konsole ausgegeben werden.
Es soll eine Methode getWinner() entwickelt werden, welche den oder die Gewinner des Turnier nach Punkten (als Array vom Typ Team) zurückliefert. Solange noch kein Spiel stattgefunden hat, soll lediglich ein Array vom Typ Team mit der Größe 0 zurückgeliefert werden.
Erstelle eine Main-Methode, die ein neues Turnier startet und mindestens vier Teams im Turnier registriert. Sobald alle Team bereit sind, soll (mindestens) eine Meisterschaft gespielt werden. Danach soll der Punktestand aller Teams auf der Konsole ausgeben werden und final der oder die Gewinner des Turniers angezeigt werden.

PS: Es liegt an dir, ob du ein Quidditch-Turnier stattfinden lässt oder die Zauber:innen mit Hydro, Elektro-, Kryo- oder Pyrozauber gegeneinander antreten lässt oder auch nur ein einfaches Würfelturnier ausrichtest. Sei kreativ!













Bitte erstelle eine Klasse Team
- mit einem Attribut teamName vom Typ String und
- mit einem Attribut score vom Typ int und
- mit einer statischen Variable teamCounter vom Typ int
und folgenden Funktionalitäten:

Der Name des Teams darf nur über den Konstruktor gesetzt werden und niemals verändert werden.
Der Zähler für alle jemals erstellten Teams (teamCounter) soll im Konstruktor im 1 erhöht werden.
Für den Teamnamen und die Punkte des Teams soll jeweils eine Getter-Methode geschrieben werden.
Für die Anzahl aller jemals erstellten Teams (teamCounter) soll eine statische Klassenmethode namens getTeamCounter() geschrieben werden.
Es soll eine Methode addScore(int score) erstellt werden, welche die übergebene Punktzahl zur aktuellen Punktzahl des Teams addiert.
Für die Klasse Team soll die toString-Methode implementiert werden.
Darüber hinaus erstelle bitte eine Klasse Tournament
- mit einem Array teams vom Typ Team
- mit einem Attribut gameCount vom Typ int
und folgenden Funktionalitäten:

Die Anzahl der Teams im Turnier wird im Konstruktor übergeben. Wenn die Zahl kleiner als 2 ist, dann soll 2 angenommen werden, damit immer mindestens zwei Teams gegeneinander antreten.
Sowohl für die Teams im Turnier (teams) als auch die Anzahl der gespielten Spiele (gameCount) soll eine Getter-Methode implementiert werden.
Es soll eine Methode registerTeam(Team team) erstellt werden, welche ein neues Team im Spiel registriert. Wenn bereits alle freien Plätze im Turnier belegt sind, so tut die Methode nichts.
Es soll eine Methode isReady() implementiert werden, welche true zurückgibt, wenn alle freien Plätze im Turnier belegt sind. Solange noch Plätze frei sind, soll immer false zurückgegeben werden.
Es soll eine Methode playGame(Team team1, Team team2) implementiert werden, die zwei Teams gegeneinander antreten lässt. Zu Beginn der Methode sollen die Namen der Teams ausgegeben werden, die gegeneinander antreten. 
Es soll dabei mindestens drei Spielrunden geben, in denen die Teams eine zufällige Anzahl von Punkten gewinnen. Final soll der Gewinner des Spiels die Punkte auf das Teamkonto gutgeschrieben bekommen. 
Der Verlierer bekommt keine Punkte. Sollte das Spiel unentschieden ausgehen, so bekommen beide Teams die selbe Punktzahl. Mit jedem gespielten Spiel soll der Zähler für die gespielten Spiele (gameCount) um eins erhöht werden.
Es soll eine Methode playChampionship() implementiert werden, die alle Teams eines Turniers mindestens zweimal gegeneinander antreten lässt

 */