package Busnies_Servic.Business_Layer.Trace;

import java.util.Date;

public class CoachPersonalPage extends PersonalPage{

    protected Date dateOfBirth;
    protected String countryOfBirth;
    protected String yearOfExperience;
    protected String numOfTitles;
    //protected photo
    //previous teams


    public CoachPersonalPage(String name){
        super(name);
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getCountryOfBirth() {
        return countryOfBirth;
    }

    public String getYearOfExperience() {
        return yearOfExperience;
    }

    public String getNumOfTitles() {
        return numOfTitles;
    }

    public void setDateOfBirth(Date dateOfBirth) {

        if(dateOfBirth != null){

            this.dateOfBirth = dateOfBirth;
        }
    }

    public void setCountryOfBirth(String countryOfBirth) {

        if(countryOfBirth != null && countryOfBirth.length() != 0){

            this.countryOfBirth = countryOfBirth;
        }
    }

    public void setYearOfExperience(String yearOfExperience) {

        if(yearOfExperience != null && yearOfExperience.length() != 0){

            this.yearOfExperience = yearOfExperience;
        }
    }

    public void setNumOfTitles(String numOfTitles) {

        if(numOfTitles != null && numOfTitles.length() != 0){

            this.numOfTitles = numOfTitles;
        }
    }

    @Override
    public String toString() {

        return "The Coach: " + name +"\n" +
                "date of Birth: " + dateOfBirth + "\n" +
                "country of Birth: " + countryOfBirth + "\n"+
                "year of experience: " + yearOfExperience + "\n"+
                "num of titles: " + numOfTitles;
    }
}

