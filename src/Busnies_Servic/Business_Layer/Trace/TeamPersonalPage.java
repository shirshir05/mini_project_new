package Busnies_Servic.Business_Layer.Trace;
import java.util.Date;

public class TeamPersonalPage extends PersonalPage{

    protected String name;
    //photo club symbol
    //list of games include date, time, stadium, Competition (league)

    protected Date yearOfFoundation;
    protected String currentOwnerTeamName;
    protected String stadiumName;
    protected FootballTeamStatistic teamStatistic;


    //league table
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

}
