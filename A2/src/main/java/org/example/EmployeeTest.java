package org.example;

import java.util.HashMap;
import java.util.Map;

public class EmployeeTest {

    public static void main(String[] args){
        Employee emp = new Employee();
        Map<Integer,String> details = new HashMap<>();
        details.put(1,"Dave");
        details.put(2,"Marcel");
        details.put(3,"Nichole");

        System.out.println(emp.addEmployee("Alia","Tremor","2000/01/01", "alia@gmail.com","female","6767854318","South Street","NS","NS","CA","E2T6V4"));
        System.out.println(emp.addWorkHistory(1,"TCS","developer","2021/01/01","2023/01/01","Worked as backend developer"));
        emp.updateEmployeeDetails(1,"Work Details","Accenture",details);
        emp.updateEmployeeSalary(1,"45900.89");
        emp.assignBonusToEmployees(600.27);

    }
}
