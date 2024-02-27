package com.APITesting.TestNG.CRUD.Group;

import org.testng.annotations.Test;

public class Priority_Group {

@Test(groups = {"init"},priority = 0)
    public void Token(){

        System.out.println("Token Initiation");
    }
    @Test(groups = {"init"},priority = -1)
    public void BookingID(){

        System.out.println("BookingID Initiation");
    }

    @Test(dependsOnGroups = {"init.*"})
    public void REQUEST(){

        System.out.println("REQUEST START");
    }

}
