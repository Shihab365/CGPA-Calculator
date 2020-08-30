package com.blueeyelab.cgpa.cgpacalculator;

public class Items {

    private String credit;
    private String gpa;
    private String total;
    private String rmk;

    public Items(String credit, String gpa, String total, String rmk) {
        this.credit = credit;
        this.gpa = gpa;
        this.total = total;
        this.rmk = rmk;
    }

    public String getCredit() {
        return credit;
    }

    public String getGpa() {
        return gpa;
    }

    public String getTotal() {
        return total;
    }

    public String getRmk() {
        return rmk;
    }
}
