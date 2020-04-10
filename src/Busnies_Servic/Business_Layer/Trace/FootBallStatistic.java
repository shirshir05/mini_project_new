package Busnies_Servic.Business_Layer.Trace;

public class FootBallStatistic { //current/yearly statistic consider also all time statistic

    protected int goals;
    protected int shots;
    protected int gameMinutes;
    protected int substitutions;
    protected int penalties;
    protected int redCards;
    protected int assists;
    protected int starts;
    protected int fouls;
    protected int yellowCards;
    protected int doubleYellowCards;

    public FootBallStatistic() {

    }

    public int getGoals() {
        return goals;
    }

    public int getShots() {
        return shots;
    }

    public int getGameMinutes() {
        return gameMinutes;
    }

    public int getSubstitutions() {
        return substitutions;
    }

    public int getPenalties() {
        return penalties;
    }

    public int getRedCards() {
        return redCards;
    }

    public int getAssists() {
        return assists;
    }

    public int getStarts() {
        return starts;
    }

    public int getFouls() {
        return fouls;
    }

    public int getYellowCards() {
        return yellowCards;
    }

    public int getDoubleYellowCards() {
        return doubleYellowCards;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public void setShots(int shots) {
        this.shots = shots;
    }

    public void setGameMinutes(int gameMinutes) {
        this.gameMinutes = gameMinutes;
    }

    public void setSubstitutions(int substitutions) {
        this.substitutions = substitutions;
    }

    public void setPenalties(int penalties) {
        this.penalties = penalties;
    }

    public void setRedCards(int redCards) {
        this.redCards = redCards;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public void setStarts(int starts) {
        this.starts = starts;
    }

    public void setFouls(int fouls) {
        this.fouls = fouls;
    }

    public void setYellowCards(int yellowCards) {
        this.yellowCards = yellowCards;
    }

    public void setDoubleYellowCards(int doubleYellowCards) {
        this.doubleYellowCards = doubleYellowCards;
    }

    @Override
    public String toString() {
        return "FootBallStatistic{" +
                "goals=" + goals +
                "shots=" + shots +
                "gameMinutes=" + gameMinutes +
                "substitutions=" + substitutions +
                "penalties=" + penalties +
                "redCards=" + redCards +
                "assists=" + assists +
                "starts=" + starts +
                "fouls=" + fouls +
                "yellowCards=" + yellowCards +
                "doubleYellowCards=" + doubleYellowCards;
    }
}
