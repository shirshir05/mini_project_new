package Busnies_Servic.Business_Layer.Trace;




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

    protected FootballPlayerStatistic statistic;

    protected String seasonYear;

    //full time statistic??
    //personal photo
    //videos?? photos??
    //personal life info

    public PlayerPersonalPage(String name){
        super(name);

        statistic = new FootballPlayerStatistic();

    }

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

    public FootballPlayerStatistic getStatistic() {
        return statistic;
    }

    public String getSeasonYear() {
        return seasonYear;
    }

    public String getCountryOfBirth() {
        return countryOfBirth;
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

    public void setStatistic(FootballPlayerStatistic statistic) {

        this.statistic = statistic;
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
  
}
