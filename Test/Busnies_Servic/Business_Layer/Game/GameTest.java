package Busnies_Servic.Business_Layer.Game;
import Busnies_Servic.Business_Layer.TeamManagement.TeamTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Observable;

import Busnies_Servic.Business_Layer.TeamManagement.Team;
import Busnies_Servic.Business_Layer.UserManagement.Player;
import Busnies_Servic.Business_Layer.UserManagement.Referee;
import Busnies_Servic.EventType;
import javafx.util.Pair;

import java.util.Date;
public class GameTest {

    private Game game;

    /**
     * Test - G1
     */
    @Test
    public void testGameConstructor() {

        /*
        TeamManager teamManager = new TeamManager(userName,password,email);
            assertEquals(teamManager.getUserName(),(userName));
            assertEquals(teamManager.getPassword(),getHash(password));
            assertEquals(teamManager.getEmail(),(email));
            assertNull(teamManager.getAppointedByTeamOwner());
         */


//        LocalDate date = LocalDate.of(1992, 11, 14);
//        Team team1 = new Team("Barcelona", "Camp Nou");
//        Team team2 = new Team("Real Madrid", "Bernabeo");
//        Game gameCompare = game;
//
//        //checking null or empty input
//        game = new Game(null, date, team1, team2);
//        assertEquals(gameCompare, game);
//
//        game = new Game("", date, team1, team2);
//        assertEquals(null, game.getDate());
//
//        game = new Game("Barcelona", null, team1, team2);
//
//        game = new Game("Barcelona", date, null, team2);
//
//        game = new Game("Barcelona", date, team1, null);

        //checking valid teams input

        /*
        //checking null or empty input
        if(f == null ||  f == "" || d == null || h == null || g == null){
            System.out.println("non valid input! all fields must be not null and not empty");
            return;
        }

        //checking valid teams input
        if(h.equals(g)){
            System.out.println("non valid teams input! team host can't ne equals to team guest");
            return;
        }

        game_id++;
        id = game_id;
        field=f;
        date=d;
        host=h;
        guest=g;
        eventList = new HashSet<>();
        */
    }
    /**
     * Test - G2
     */
    @Test
    public void testGetId() {

        LocalDate date = LocalDate.of(1992, 11, 14);
        Team team1 = new Team("Barcelona", "Camp Nou");
        Team team2 = new Team("Real Madrid", "Bernabeo");
        game = new Game("Bernabeo", date, team1, team2);

        Game game2 = new Game("Bernabeo", date, team1, team2);
        assertEquals(1, game.getId());
        assertEquals(2, game2.getId());
    }

    /**
     * Test - G3
     */
    @Test
    public void testGetHeadReferee() {

        LocalDate date = LocalDate.of(1992, 11, 14);
        Team team1 = new Team("Barcelona", "Camp Nou");
        Team team2 = new Team("Real Madrid", "Bernabeo");
        game = new Game("Bernabeo", date, team1, team2);

        assertEquals(null, game.getHeadReferee());

        Referee referee = new Referee("", "", "matanshus@gmail.com");
        game.setHeadReferee(referee);
        assertEquals(referee, game.getHeadReferee());
    }

    /**
     * Test - G4
     */
    @Test
    public void testGetLinesman1Referee() {

        LocalDate date = LocalDate.of(1992, 11, 14);
        Team team1 = new Team("Barcelona", "Camp Nou");
        Team team2 = new Team("Real Madrid", "Bernabeo");
        game = new Game("Bernabeo", date, team1, team2);

        assertEquals(null, game.getLinesman1Referee());

        Referee referee = new Referee("", "", "matanshus@gmail.com");
        game.setLinesman1Referee(referee);
        assertEquals(referee, game.getLinesman1Referee());
    }

    /**
     * Test - G5
     */
    @Test
    public void testGetLinesman2Referee() {

        LocalDate date = LocalDate.of(1992, 11, 14);
        Team team1 = new Team("Barcelona", "Camp Nou");
        Team team2 = new Team("Real Madrid", "Bernabeo");
        game = new Game("Bernabeo", date, team1, team2);

        assertEquals(null, game.getLinesman2Referee());

        Referee referee = new Referee("", "", "matanshus@gmail.com");
        game.setLinesman1Referee(referee);
        assertEquals(referee, game.getLinesman1Referee());
    }

    /**
     * Test - G6
     */
    @Test
    public void testSetHeadReferee() {

        LocalDate date = LocalDate.of(1992, 11, 14);
        Team team1 = new Team("Barcelona", "Camp Nou");
        Team team2 = new Team("Real Madrid", "Bernabeo");
        game = new Game("Bernabeo", date, team1, team2);

        game.setHeadReferee(null);
        assertEquals(null, game.getHeadReferee());

        Referee referee = new Referee("", "", "matanshus@gmail.com");
        game.setHeadReferee(referee);
        assertEquals(referee, game.getHeadReferee());
    }

    /**
     * Test - G7
     */
    @Test
    public void testSetLinesman1Referee() {

        LocalDate date = LocalDate.of(1992, 11, 14);
        Team team1 = new Team("Barcelona", "Camp Nou");
        Team team2 = new Team("Real Madrid", "Bernabeo");
        game = new Game("Bernabeo", date, team1, team2);

        game.setLinesman1Referee(null);
        assertEquals(null, game.getLinesman1Referee());

        Referee referee = new Referee("", "", "matanshus@gmail.com");
        game.setLinesman1Referee(referee);
        assertEquals(referee, game.getLinesman1Referee());
    }

    /**
     * Test - G8
     */
    @Test
    public void testSetLinesman2Referee() {

        LocalDate date = LocalDate.of(1992, 11, 14);
        Team team1 = new Team("Barcelona", "Camp Nou");
        Team team2 = new Team("Real Madrid", "Bernabeo");
        game = new Game("Bernabeo", date, team1, team2);

        game.setLinesman1Referee(null);
        assertEquals(null, game.getLinesman2Referee());

        Referee referee = new Referee("", "", "matanshus@gmail.com");
        game.setLinesman2Referee(referee);
        assertEquals(referee, game.getLinesman2Referee());
    }

    /**
     * Test - G9
     */
    @Test
    public void testGetDate() {

        LocalDate date = LocalDate.of(1992, 11, 14);
        Team team1 = new Team("Barcelona", "Camp Nou");
        Team team2 = new Team("Real Madrid", "Bernabeo");
        game = new Game("Bernabeo", date, team1, team2);

        assertEquals(date, game.getDate());
    }

    /**
     * Test - G10
     */
    @Test
    public void testChangeDate() {

        LocalDate date = LocalDate.of(1992, 11, 14);
        Team team1 = new Team("Barcelona", "Camp Nou");
        Team team2 = new Team("Real Madrid", "Bernabeo");
        game = new Game("Bernabeo", date, team1, team2);

        assertEquals(date, game.getDate());

        LocalDate date2 = LocalDate.of(1995, 5, 23);

        game.changeDate(date2);
        assertEquals(date2, game.getDate());
    }

    /**
     * Test - G11
     */
    @Test
    public void testGetHost() {

        LocalDate date = LocalDate.of(1992, 11, 14);
        Team team1 = new Team("Barcelona", "Camp Nou");
        Team team2 = new Team("Real Madrid", "Bernabeo");
        game = new Game("Bernabeo", date, team1, team2);

        assertEquals(team1, game.getHost());
    }

    /**
     * Test - G12
     */
    @Test
    public void testGetGuest() {

        LocalDate date = LocalDate.of(1992, 11, 14);
        Team team1 = new Team("Barcelona", "Camp Nou");
        Team team2 = new Team("Real Madrid", "Bernabeo");
        game = new Game("Bernabeo", date, team1, team2);

        assertEquals(team2, game.getGuest());
    }

    /**
     * Test - G13
     */
    @Test
    public void testSetHost() {

        LocalDate date = LocalDate.of(1992, 11, 14);
        Team team1 = new Team("Barcelona", "Camp Nou");
        Team team2 = new Team("Real Madrid", "Bernabeo");
        Team team3 = new Team("Roma", "Bernabeo");
        game = new Game("Bernabeo", date, team1, team2);

        assertEquals(team1, game.getHost());

        game.setHost(team2);
        assertEquals(team1, game.getHost());

        game.setHost(null);
        assertEquals(team1, game.getHost());

        game.setHost(team3);
        assertEquals(team3, game.getHost());

        game.setHost(team1);
        assertEquals(team1, game.getHost());
    }

    /**
     * Test - G14
     */
    @Test
    public void testSetGuest() {

        LocalDate date = LocalDate.of(1992, 11, 14);
        Team team1 = new Team("Barcelona", "Camp Nou");
        Team team2 = new Team("Real Madrid", "Bernabeo");
        Team team3 = new Team("Roma", "Bernabeo");
        game = new Game("Bernabeo", date, team1, team2);

        assertEquals(team2, game.getGuest());

        game.setGuest(team1);
        assertEquals(team2, game.getGuest());

        game.setGuest(null);
        assertEquals(team2, game.getGuest());

        game.setGuest(team3);
        assertEquals(team3, game.getGuest());
    }

    /**
     * Test - G15
     */
    @Test
    public void getScore() {

        //need to complete
    }

    /**
     * Test - G16
     */
    @Test
    public void testUpdate_score() {
        //need to complete
    }

    /**
     * Test - G17
     */
    @Test
    public void testUpdateNewEvent() {

        LocalDate date = LocalDate.of(1992, 11, 14);
        Team team1 = new Team("Barcelona", "Camp Nou");
        Team team2 = new Team("Real Madrid", "Bernabeo");
        Team team3 = new Team("Roma", "Bernabeo");
        game = new Game("Bernabeo", date, team1, team2);

        //team name doesn't exist
        assertEquals(false, game.updateNewEvent("team1.getName()", "messi", EventType.foul));

        //player doesn't exist
        assertEquals(false, game.updateNewEvent(team1.getName(), "messi", EventType.foul));
        assertEquals(false, game.updateNewEvent(team2.getName(), "messi", EventType.foul));

        team1.addOrRemovePlayer(new Player("messi", "123456", "31212fsf@gmail.com"), 1);
        team2.addOrRemovePlayer(new Player("Ronaldo", "123456", "31212fsf@gmail.com"), 1);
        assertEquals(true, game.updateNewEvent(team1.getName(), "messi", EventType.foul));
        assertEquals(true, game.updateNewEvent(team2.getName(), "Ronaldo", EventType.foul));

    }
}
