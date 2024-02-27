package com.APITesting.TestNG.CRUD.Group;

import org.testng.annotations.Test;

public class GroupingDemo {

    @Test(groups = {"sanity", "high-level"})
    public void Sanity() {

        System.out.println("SANITY");
    }


    @Test(groups = {"reg", "end-to-end", "high-level"})
    public void Regression() {

        System.out.println("Regression");
    }

    @Test(groups = {"smoke", "high-level"})
    public void Smoke() {

        System.out.println("Smoke");
    }
}
