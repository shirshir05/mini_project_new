package Busnies_Servic.Service_Layer;

import Busnies_Servic.Business_Layer.Game.League;
import Busnies_Servic.Business_Layer.Game.Season;
import Busnies_Servic.Business_Layer.TeamManagement.Team;
import Busnies_Servic.Business_Layer.UserManagement.*;

import java.io.*;
import java.util.HashSet;

public class SearchLogger {
    private String dataPath ="./lib/spellingDict.txt";


    /**
     * Search data according word
     * @param keyWord
     * @return
     */
    public String findData(String keyWord){
        DataManagement.getCurrent().addSearch(keyWord);
        try
        {
            File file=new File(dataPath);
            FileReader fr=new FileReader(file);
            BufferedReader br=new BufferedReader(fr);
            StringBuffer sb=new StringBuffer();
            String line;
            while((line=br.readLine())!=null)
            {
                if (line.contains(keyWord)){
                    //sb.append(line.substring(line.indexOf(':')+1));
                    sb.append(line);
                    sb.append("\n");
                }
            }
            fr.close();
            return sb.toString();

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Show the history of Search
     * @return
     */
    public String showSearchHistory(){
        StringBuffer sb=new StringBuffer();
        for (String s : DataManagement.getCurrent().getSearch()){
            sb.append(s);
            sb.append("\n");
        }
        return sb.toString();
    }




}
