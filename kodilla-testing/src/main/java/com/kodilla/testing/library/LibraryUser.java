package com.kodilla.testing.library;

public class LibraryUser {
    private String firstname;
    private String lasttname;
    private String peselID;

    public LibraryUser(String firstname, String lasttname, String peselID) {
        this.firstname = firstname;
        this.lasttname = lasttname;
        this.peselID = peselID;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLasttname() {
        return lasttname;
    }

    public String getPeselID() {
        return peselID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LibraryUser that = (LibraryUser) o;

        if (!firstname.equals(that.firstname)) return false;
        if (!lasttname.equals(that.lasttname)) return false;
        return peselID.equals(that.peselID);

    }

    @Override
    public int hashCode() {
        int result = firstname.hashCode();
        result = 31 * result + lasttname.hashCode();
        result = 31 * result + peselID.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "LibraryUser{" +
                "firstname='" + firstname + '\'' +
                ", lasttname='" + lasttname + '\'' +
                ", peselID='" + peselID + '\'' +
                '}';
    }
}
