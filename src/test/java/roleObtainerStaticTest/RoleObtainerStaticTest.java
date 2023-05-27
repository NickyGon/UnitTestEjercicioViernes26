package roleObtainerStaticTest;


import ejercicio3Static.RoleObtainerStatic;
import ejercicio3Static.UserServiceStatic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.time.format.DateTimeFormatter;

public class RoleObtainerStaticTest {

    @BeforeAll
    public static void setup(){
        // PASO 1 crear el objeto mockeado de la clase donde se encuentra el método a mockear
        MockedStatic<UserServiceStatic> overrideUserServiceStaticMock = Mockito.mockStatic(UserServiceStatic.class);

        // PASO 2 adicionar comportamiento del metodo que se esta mockeando
        overrideUserServiceStaticMock.when(()-> UserServiceStatic.isValidUser("Jose","123")).thenReturn(true);
        overrideUserServiceStaticMock.when(()-> UserServiceStatic.getRoles("Jose","123")).thenReturn("CRUD");
        overrideUserServiceStaticMock.when(()-> UserServiceStatic.isValidUser("Jose","101")).thenReturn(false);

        // 3 LETRAS
        overrideUserServiceStaticMock.when(()-> UserServiceStatic.isValidUser("Juan","101")).thenReturn(true);
        overrideUserServiceStaticMock.when(()-> UserServiceStatic.getRoles("Juan","101")).thenReturn("CRU");
        overrideUserServiceStaticMock.when(()-> UserServiceStatic.isValidUser("Juan","123")).thenReturn(false);

        overrideUserServiceStaticMock.when(()-> UserServiceStatic.isValidUser("Maria","pwd")).thenReturn(true);
        overrideUserServiceStaticMock.when(()-> UserServiceStatic.getRoles("Maria","pwd")).thenReturn("CRD");
        overrideUserServiceStaticMock.when(()-> UserServiceStatic.isValidUser("Maria","per")).thenReturn(false);

        overrideUserServiceStaticMock.when(()-> UserServiceStatic.isValidUser("Ramones","124")).thenReturn(true);
        overrideUserServiceStaticMock.when(()-> UserServiceStatic.getRoles("Ramones","124")).thenReturn("CUD");
        overrideUserServiceStaticMock.when(()-> UserServiceStatic.isValidUser("Ramones","1123")).thenReturn(false);

        overrideUserServiceStaticMock.when(()-> UserServiceStatic.isValidUser("Mario","pawd")).thenReturn(true);
        overrideUserServiceStaticMock.when(()-> UserServiceStatic.getRoles("Mario","pawd")).thenReturn("RUD");
        overrideUserServiceStaticMock.when(()-> UserServiceStatic.isValidUser("Mario","paer")).thenReturn(false);

        // DOS LETRAS

        overrideUserServiceStaticMock.when(()-> UserServiceStatic.isValidUser("Manuel","151")).thenReturn(true);
        overrideUserServiceStaticMock.when(()-> UserServiceStatic.getRoles("Manuel","151")).thenReturn("CR");
        overrideUserServiceStaticMock.when(()-> UserServiceStatic.isValidUser("Manuel","153")).thenReturn(false);

        overrideUserServiceStaticMock.when(()-> UserServiceStatic.isValidUser("Manta","pwd")).thenReturn(true);
        overrideUserServiceStaticMock.when(()-> UserServiceStatic.getRoles("Manta","pwd")).thenReturn("CD");
        overrideUserServiceStaticMock.when(()-> UserServiceStatic.isValidUser("Manta","per")).thenReturn(false);

        overrideUserServiceStaticMock.when(()-> UserServiceStatic.isValidUser("Ramas","124")).thenReturn(true);
        overrideUserServiceStaticMock.when(()-> UserServiceStatic.getRoles("Ramas","124")).thenReturn("CU");
        overrideUserServiceStaticMock.when(()-> UserServiceStatic.isValidUser("Ramas","1123")).thenReturn(false);

        overrideUserServiceStaticMock.when(()-> UserServiceStatic.isValidUser("Derbez","pawd")).thenReturn(true);
        overrideUserServiceStaticMock.when(()-> UserServiceStatic.getRoles("Derbez","pawd")).thenReturn("RU");
        overrideUserServiceStaticMock.when(()-> UserServiceStatic.isValidUser("Derbez","paer")).thenReturn(false);

        overrideUserServiceStaticMock.when(()-> UserServiceStatic.isValidUser("Chavo","pawd")).thenReturn(true);
        overrideUserServiceStaticMock.when(()-> UserServiceStatic.getRoles("Chavo","pawd")).thenReturn("RD");
        overrideUserServiceStaticMock.when(()-> UserServiceStatic.isValidUser("Chavo","paer")).thenReturn(false);

        overrideUserServiceStaticMock.when(()-> UserServiceStatic.isValidUser("Quico","chusma")).thenReturn(true);
        overrideUserServiceStaticMock.when(()-> UserServiceStatic.getRoles("Quico","chusma")).thenReturn("UD");
        overrideUserServiceStaticMock.when(()-> UserServiceStatic.isValidUser("Quico","chisme")).thenReturn(false);

        // UNA LETRA

        overrideUserServiceStaticMock.when(()-> UserServiceStatic.isValidUser("Ale","qok")).thenReturn(true);
        overrideUserServiceStaticMock.when(()-> UserServiceStatic.getRoles("Ale","qok")).thenReturn("C");
        overrideUserServiceStaticMock.when(()-> UserServiceStatic.isValidUser("Ale","pok")).thenReturn(false);

        overrideUserServiceStaticMock.when(()-> UserServiceStatic.isValidUser("Jere","pina")).thenReturn(true);
        overrideUserServiceStaticMock.when(()-> UserServiceStatic.getRoles("Jere","pina")).thenReturn("R");
        overrideUserServiceStaticMock.when(()-> UserServiceStatic.isValidUser("Jere","pana")).thenReturn(false);

        overrideUserServiceStaticMock.when(()-> UserServiceStatic.isValidUser("Luke","black")).thenReturn(true);
        overrideUserServiceStaticMock.when(()-> UserServiceStatic.getRoles("Luke","black")).thenReturn("U");
        overrideUserServiceStaticMock.when(()-> UserServiceStatic.isValidUser("Luke","white")).thenReturn(false);

        overrideUserServiceStaticMock.when(()-> UserServiceStatic.isValidUser("Lori","2023")).thenReturn(true);
        overrideUserServiceStaticMock.when(()-> UserServiceStatic.getRoles("Lori","2023")).thenReturn("D");
        overrideUserServiceStaticMock.when(()-> UserServiceStatic.isValidUser("Lori","2012")).thenReturn(false);
    }

    @ParameterizedTest
    @CsvSource(
            {
                    "Jose,123,PERMISSION : CRUD - ",
                    "Jose,101,Incorrect Jose and 101",
                    "Juan,101,PERMISSION : CRU - ",
                    "Juan,123,Incorrect Juan and 123",
                    "Maria,pwd,PERMISSION : CRD - ",
                    "Maria,per,Incorrect Maria and per",
                    "Ramones,124,PERMISSION : CUD - ",
                    "Ramones,1123,Incorrect Ramones and 1123",
                    "Mario,pawd,PERMISSION : RUD - ",
                    "Mario,paer,Incorrect Mario and paer",
                    "Manuel,151,PERMISSION : CR - ",
                    "Manuel,153,Incorrect Manuel and 153",
                    "Manta,pwd,PERMISSION : CD - ",
                    "Manta,per,Incorrect Manta and per",
                    "Ramas,124,PERMISSION : CU - ",
                    "Ramas,1123,Incorrect Ramas and 1123",
                    "Derbez,pawd,PERMISSION : RU - ",
                    "Derbez,paer,Incorrect Derbez and paer",
                    "Chavo,pawd,PERMISSION : RD - ",
                    "Chavo,paer,Incorrect Chavo and paer",
                    "Quico,chusma,PERMISSION : UD - ",
                    "Quico,chisme,Incorrect Quico and chisme",
                    "Ale,qok,PERMISSION : C - ",
                    "Ale,pok,Incorrect Ale and pok",
                    "Jere,pina,PERMISSION : R - ",
                    "Jere,pana,Incorrect Jere and pana",
                    "Luke,black,PERMISSION : U - ",
                    "Luke,white,Incorrect Luke and white",
                    "Lori,2023,PERMISSION : D - ",
                    "Lori,2012,Incorrect Lori and 2012",
            }
    )
    public void verifyRoles(String usr, String pwd,String expected) {
        RoleObtainerStatic roleObtainerStatic= new RoleObtainerStatic();

        String actual=roleObtainerStatic.getSession(usr,pwd);
        String data = java.time.LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).substring(0,10);
        //Para concatenar la fecha al resultado esperado SOLO si el test es positivo (el actual proporciona roles y fecha)
        //y no negativo (incorrect Name and PWD) para evitar interferencia en las respuestas esperadas con tal de
        //actualizar a la fecha del dia a ejecutarse
        if(actual.contains(expected+" "+data)){
            expected+=" "+data;
        }
        System.out.println(expected);
        System.out.println(actual);
        Assertions.assertTrue(actual.contains(expected),"ERROR, el sistema ha fallado");

    }


}
