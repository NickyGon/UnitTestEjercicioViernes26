package ejercicio3Static;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RoleObtainerStatic {

    public RoleObtainerStatic(){}

    public String getSession(String usr, String pwd){
        boolean isTrue=UserServiceStatic.isValidUser(usr,pwd);
        String deliver="";
        String permission="";
        if (isTrue){
            permission=UserServiceStatic.getRoles(usr,pwd);
            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY hh:mm:ss");
            String strDate = dateFormat.format(date);
            deliver="PERMISSION : "+permission+" - "+strDate;
        } else {
            deliver="Incorrect "+usr+" and "+pwd;
        }
        return deliver;
    }
}
