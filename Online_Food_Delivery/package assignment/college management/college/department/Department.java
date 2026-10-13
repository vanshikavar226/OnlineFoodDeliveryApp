package college.department;

public class Department {
    private String deptName;

    public Department(String deptName) {
        this.deptName = deptName;
    }

    public void displayDepartment() {
        System.out.println("Department   : " + deptName);
    }
}
