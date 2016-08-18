package com.andy.com.andy.interview;

import java.util.Date;
public final class BrokenPerson
{
    private String firstName;
    private String lastName;
    private final Date dob;

    public BrokenPerson( String firstName,
                         String lastName, Date dob)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob =new Date(dob.getTime()) ;
    }

    public String getFirstName()
    {
        return this.firstName;
    }
    public String getLastName()
    {
        return this.lastName;
    }
    public Date getDOB()
    {
        return new Date(this.dob.getTime());
    }
/*  public Date getDOB()
  {
      return this.dob;
  }*/
}