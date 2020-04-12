package Busnies_Servic.Business_Layer.Trace;
import Busnies_Servic.Business_Layer.Game.League;
import Busnies_Servic.Business_Layer.Game.ScoreTable;

import java.util.Date;

public class TeamPersonalPage extends PersonalPage{

    protected Date yearOfFoundation;
    protected String presidentName;
    protected String stadiumName;
    protected FootballTeamStatistic teamStatistic;
    protected ScoreTable scoreTable;

    //photo club symbol
    //list of games include date, time, stadium, Competition (league)
    //club accomplishes
    //full time statistic??
    //personal photo
    //videos?? photos??
    //general info
    //results and next matches

    public TeamPersonalPage(String name){

        super(name);
        teamStatistic = new FootballTeamStatistic();
    }

    public Date getYearOfFoundation() {
        return yearOfFoundation;
    }

    public String getPresidentName() {
        return presidentName;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public FootballTeamStatistic getTeamStatistic() {
        return teamStatistic;
    }

    public ScoreTable getScoreTable() {
        return scoreTable;
    }

    public void setYearOfFoundation(Date yearOfFoundation) {

        if(yearOfFoundation != null){

            this.yearOfFoundation = yearOfFoundation;
        }
    }

    public void setPresidentName(String presidentName) {

        if (presidentName != null && presidentName.length() != 0) {

            this.presidentName = presidentName;
        }
    }

    public void setStadiumName(String stadiumName) {

        if (stadiumName != null && stadiumName.length() != 0) {

            this.stadiumName = stadiumName;
        }
    }

    public void setTeamStatistic(FootballTeamStatistic teamStatistic) {

        if(teamStatistic != null) {

            this.teamStatistic = teamStatistic;
        }
    }

    public void setScoreTable(ScoreTable scoreTable) {

        if(scoreTable != null) {

            this.scoreTable = scoreTable;
        }
    }

    @Override
    public String toString() {

        return "The Team: " + name +"\n" +
                "year of foundation: " + yearOfFoundation + "\n" +
                "president name: " + presidentName + "\n"+
                "stadium name: " + stadiumName +"\n" +
                "team statistic: " + teamStatistic.toString() + "\n" +
                "score table: " + scoreTable.toString();
    }
}
