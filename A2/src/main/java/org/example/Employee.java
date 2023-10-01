package org.example;

import java.time.Period;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Employee {
    // Deficient Encapsulation: Making employee details map public
    public Map<Integer, String> employee = new HashMap<>();
    int employee_count;

    /**
     * To store the details of the employee
     *
     * @param firstName     of the employee
     * @param lastName      of the employee
     * @param dateOfBirth   of the employee
     * @param email         of the employee
     * @param gender        of the employee
     * @param phoneNumber   of the employee
     * @param dateOfBirth   of the employee
     * @param streetAddress of the employee
     * @param postalCode    of the employee
     * @param province      of the employee
     * @param country       of the employee
     * @param city          of the employee
     */

    public boolean addEmployee(String firstName, String lastName, String dateOfBirth, String email, String gender, String phoneNumber, String streetAddress, String city, String province, String country, String postalCode) {

        if (!firstName.isEmpty() && !lastName.isEmpty() && !dateOfBirth.isEmpty() && !email.isEmpty() && !gender.isEmpty() && !phoneNumber.isEmpty() && !streetAddress.isEmpty() && streetAddress.length() <= 40) {
            employee.put(++employee_count, firstName + " " + lastName + ", " + dateOfBirth + ", " + email + ", " + gender + ", " + phoneNumber + ", " + streetAddress + ", " + city + ", " + province + ", " + country + ", " + postalCode);
            return true;
        } else {
            System.out.println("Error in adding employee details");
            return false;
        }
    }

    /**
     * To store the work details of the employee
     *
     * @param employeeId     of the employee
     * @param companyName    of the employee
     * @param jobTitle       of the employee
     * @param startDate      of the employee
     * @param endDate        of the employee
     * @param jobDescription of the employee
     **/
    public boolean addWorkHistory(int employeeId, String companyName, String jobTitle, String startDate, String endDate, String jobDescription) {

        //Check if input  is empty or not
        if (employeeId > 0 && !companyName.isEmpty() && !jobTitle.isEmpty() && !startDate.isEmpty() && !endDate.isEmpty() && !jobDescription.isEmpty()) {
            // Check if the employee with the given ID exists in the employee map
            if (employee.containsKey(employeeId)) {
                // Get the employee details from the map
                String employeeDetails = (String) employee.get(employeeId);
                // Create a string to store the work history details
                String workHistory = companyName + ", " + jobTitle + ", " + startDate + ", " + endDate + ", " + jobDescription;
                // Check if the employee details already contain work history
                if (employeeDetails.contains("Work History:")) {
                    // If yes, append the new work history to the existing work history
                    employeeDetails = employeeDetails.replace("Work History:", "Work History:" + workHistory + "\n");
                } else {
                    // If no, add the new work history to the employee details
                    employeeDetails += "\nWork History:" + workHistory;
                }
                // Update the employee map with the updated employee details
                employee.put(employeeId, employeeDetails);
                return true;
            } else {
                System.out.println("Employee with ID " + employeeId + " does not exist!");
            }
        } else {
            System.out.println("Employee with ID " + employeeId + " does not exist!");
            return false;
        }
        return false;
    }

    /**
     * Updates the details of an employee based on their ID and a given field name and field value
     *
     * @param employeeId the ID of the employee
     * @param fieldName  the name of the field to be updated
     * @param fieldValue the new value of the field
     * @param employee   the map containing employee details
     */
    public void updateEmployeeDetails(int employeeId, String fieldName, String fieldValue, Map<Integer, String> employee) {
        // Retrieve the employee's existing details from the map
        String existingDetails = employee.get(employeeId);

        // Replace the old field value with the new field value
        String newDetails = existingDetails.replace(fieldName + ": " + fieldValue, fieldName + ": " + fieldValue);

        // Update the employee's details in the map
        employee.put(employeeId, newDetails);

    }

    /**
     * To add the salary of an employee
     * @param employeeId of the employee
     * @param salary to be added
     * @return
     */
    public boolean addEmployeeSalary(int employeeId, String salary) {
        if (employeeId > 0 && !salary.isEmpty()) {
            // Check if the employee with the given ID exists in the employee map
            if (employee.containsKey(employeeId)) {
                // Get the employee details from the map
                String employeeDetails = (String) employee.get(employeeId);
                employeeDetails += "\nSalary Details:" + salary;
                employee.put(employeeId, employeeDetails);
                return true;
            } else {
                System.out.println("Employee does not exists");
                return false;
            }
        } else {
            System.out.println("Empty input");
            return false;
        }
    }

    /**
     * Updates the  employee salary details
     * @param employeeId of the employee
     * @param newSalary to be added
     */
    public void updateEmployeeSalary(int employeeId, String newSalary) {
        String employeeDetails = employee.get(employeeId);
        if (employee != null) {
            if (employeeDetails.contains("Salary Details:")) {
                // If yes, append the new salary  to the existing salary
                employeeDetails = employeeDetails.replace("Salary Details:", "Salary Details:" + newSalary+ "\n");
                System.out.println("Salary updated for employee with ID " + employeeId);
            } else {
                System.out.println("Salary update failed for employee with ID " + employeeId);
            }
        } else {
            System.out.println("Employee with ID " + employeeId + " not found");
        }
    }

    /**
     * Assigning bonus to the employee
     * @param bonusAmount
     */
    public void assignBonusToEmployees(double bonusAmount) {
        // Determine the bonus eligibility based on employee count and company profits
        boolean isEligibleForBonus = employee_count >= 10 && calculateCompanyProfits() > 1000000;

        // If eligible, assign the bonus to all employees
        if (isEligibleForBonus) {
            for (String employeeDetails : employee.values()) {
                // Extract the employee's email address from the details string
                String[] detailsArray = employeeDetails.split(", ");
                String email = detailsArray[3];

                // Check the employee's project count and duration of employment
                int projectCount = getProjectCount(detailsArray[2]);
                int employmentDuration = getEmploymentDuration(detailsArray[1]);

                // If the employee has worked on at least 5 projects and for more than 5 years, award the bonus
                if (projectCount >= 5 && employmentDuration >= 5) {
                    // Send an email to the employee with the bonus details
                    String bonusMessage = "Congratulations! You have been awarded a bonus of $" + bonusAmount;
                    // sendEmail(email, bonusMessage);
                } else {
                    System.out.println("Not enough projects or employment duration to qualify for bonus.");
                }
            }
        } else {
            System.out.println("Not enough employees or company profits to qualify for bonus.");
        }
    }
    /*************** Helper functions *******************/
    // Method to calculate company profits
    private double calculateCompanyProfits() {
        // Calculate the company profits based on revenue and expenses
        double revenue = 80000000; // example revenue
        double expenses = 5000000; // example expenses
        double profits = revenue - expenses;
        return profits;
    }

    // Method to get the employee's project count
    private int getProjectCount(String projectDetails) {
        // Parse the project details string and count the number of projects
        String[] projectsArray = projectDetails.split(", ");
        int projectCount = projectsArray.length;
        return projectCount;
    }

    // Method to get the employee's employment duration
    private int getEmploymentDuration(String employmentStartDate) {
        // Calculate the employment duration in years
        LocalDate startDate = LocalDate.parse(employmentStartDate);
        LocalDate currentDate = LocalDate.now();
        int employmentDuration = Period.between(startDate, currentDate).getYears();
        return employmentDuration;
    }

}

 class Manager extends  Employee{

    public void setEmployeeSalary(Employee employee,int employeeId ,String salary){
        employee.addEmployeeSalary(employeeId,salary);

    }
    public  void addProjectDetails(int employeeId, int projectId, String projectName, String project ){}

}
