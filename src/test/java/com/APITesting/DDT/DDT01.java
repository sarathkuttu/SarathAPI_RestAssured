package com.APITesting.DDT;

import org.testng.annotations.Test;

public class DDT01 {

    @Test(dataProvider ="getData",dataProviderClass = UtilExcel.class)
public void testLogin(String username,String password){

        System.out.println(username);
        System.out.println(password);
    }
}
