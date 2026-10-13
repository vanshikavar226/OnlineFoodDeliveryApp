package com.company.payroll;
import com.company.hr.Employee;

public class Payroll {
    public void calculateBonus(Employee e) {
        e.setSalary(e.getSalary() * 1.10);
    }
}
