package com.example.module1.single;

public class Test {
    public static void main(String[] args) {
        Company company=new Company();
        Staff staff=Boss.getBoss();
        Staff staff1=Boss.getBoss();
        company.addStaff(staff);
        company.addStaff(staff1);

        Staff vp1=new VP();
        Staff vp2=new VP();

        Staff staff2=new Staff();
        Staff staff3=new Staff();
        Staff staff4=new Staff();

        company.addStaff(vp1);
        company.addStaff(vp2);

        company.addStaff(staff2);
        company.addStaff(staff3);
        company.addStaff(staff4);

        company.showAllStaffs();



    }
}
