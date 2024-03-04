package com.APITesting.gson.Difficuilt;

public class CreatebookingClass {

    private String firstname;

    private String lastname;

    private Integer totalprice;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Integer totalprice) {
        this.totalprice = totalprice;
    }

    public Boolean getDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(Boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    private Boolean depositpaid;

    private String additionalneeds;

    public BookingdateClass getBookingdate() {
        return bookingdate;
    }

    public void setBookingdate(BookingdateClass bookingdate) {
        this.bookingdate = bookingdate;
    }

    private BookingdateClass bookingdate;


}
