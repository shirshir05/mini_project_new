import Busnies_Servic.Business_Layer.BudgetManagement.BudgetRegulationsTest;
import Busnies_Servic.Service_Layer.MainTestClass;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import test_busnies_users.SystemAdministratorTest;

public class mainTest {

    public static void main(String[] args){
        register();
        //SystemAdministratorTest();
    }

    private static void register(){
        System.out.println("----------------------TEST FOR LOGANDEXITCONTROLER----------------------------");
        Result result = JUnitCore.runClasses(BudgetRegulationsTest.class);
        for(Failure fail : result.getFailures()){
            System.out.println(fail.toString());
        }
        System.out.println("The number of test = " + result.getRunCount());
       System.out.println("The number of test fail = " + result.getFailureCount());
    }
    private static void SystemAdministratorTest(){
        System.out.println("----------------------TEST FOR SYSTEMADMINSTRATOR----------------------------");
        Result result = JUnitCore.runClasses(SystemAdministratorTest.class);
        for(Failure fail : result.getFailures()){
            System.out.println(fail.toString());
        }
        System.out.println("The number of test = " + result.getRunCount());
        System.out.println("The number of test fail = " + result.getFailureCount());
    }
}
