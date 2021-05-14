package com.example.module1.single;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private List<Staff> allStaffs = new ArrayList<>();

    public void addStaff(Staff staff) {
        allStaffs.add(staff);
    }

    public void showAllStaffs() {
        for (Staff per : allStaffs) {
            System.out.println("Obj   -->  " + per.toString());
        }
    }

}
