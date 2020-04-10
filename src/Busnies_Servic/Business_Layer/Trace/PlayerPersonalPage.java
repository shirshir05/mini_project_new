package Busnies_Servic.Business_Layer.Trace;

import Busnies_Servic.Role;
//import Busnies_Servic.StatisticParameter;

import java.util.Date;

public class PlayerPersonalPage extends PersonalPage{

    //name
    protected Date dateOfBirth; //const??
    protected String countryOfBirth; //const??
    protected String cityOfBirth; //const??
    protected String height; //in cm
    protected String weight; //in kg
    protected String position;
    protected String jerseyNumber;
   // protected FootBallStatistic statistic;
    protected String seasonYear;

    //full time statistic??
    //personal photo
    //videos?? photos??
    //personal info

    public PlayerPersonalPage(String name){
        super(name);
        //statistic = new FootBallStatistic();
    }
/*
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getConutryOfBirth() {
        return countryOfBirth;
    }

    public String getCityOfBirth() {
        return cityOfBirth;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

    public String getPosition() {
        return position;
    }

    public String getJerseyNumber() {
        return jerseyNumber;
    }

    public FootBallStatistic getStatistic() {
        return statistic;
    }

    public String getSeasonYear() {
        return seasonYear;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setConutryOfBirth(String conutryOfBirth) {
        this.countryOfBirth = conutryOfBirth;
    }

    public void setCityOfBirth(String cityOfBirth) {
        this.cityOfBirth = cityOfBirth;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setJerseyNumber(String jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public void setStatistic(StatisticParameter statisticParameter, int newValue) {

        switch (statisticParameter) {
            case goals:
                statistic.setGoals(newValue);
                break;
            case shots:
                statistic.setShots(newValue);
                break;
            case gameMinutes:
                statistic.setGameMinutes(newValue);
                break;
            case substitutions:
                statistic.setSubstitutions(newValue);
                break;
            case penalties:
                statistic.setPenalties(newValue);
                break;
            case redCards:
                statistic.setRedCards(newValue);
                break;
            case assists:
                statistic.setAssists(newValue);
                break;
            case starts:
                statistic.setStarts(newValue);
                break;
            case fouls:
                statistic.setFouls(newValue);
                break;
            case yellowCards:
                statistic.setYellowCards(newValue);
                break;
            case doubleYellowCards:
                statistic.setDoubleYellowCards(newValue);
                break;
            default:
                System.out.println("please choose a valid statistic parameter");
        }
    }

    public void setSeasonYear(String seasonYear) {
        this.seasonYear = seasonYear;
    }

    @Override
    public String toString() {

        return "The Player: " + name +"\n" +
                "date of Birth: " + dateOfBirth + "\n" +
                "country of Birth:" + countryOfBirth + "\n"+
                "city of birth:" + cityOfBirth +"\n" +
                "height:" + height + "\n" +
                "weight:" + weight + "\n" +
                "position:" + position + "\n" +
                "jerseyNumber:" + jerseyNumber + "\n" +
                "seasonYear:" + seasonYear + "\n" +
                "statistic: " + "\n" +
                statistic.toString();
    }
    */
}
