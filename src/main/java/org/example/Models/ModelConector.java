package org.example.Models;

public class ModelConector {
    String URL = "jdbc:mysql://localhost/db_pdf";
    String USER = "root";
    String PASS = "";

    public void setURL(String URL) {
        this.URL = URL;
    }

    public void setUSER(String USER) {
        this.USER = USER;
    }

    public void setPASS(String PASS) {
        this.PASS = PASS;
    }

    public String getURL() {
        return URL;
    }

    public String getUSER() {
        return USER;
    }

    public String getPASS() {
        return PASS;
    }
}
