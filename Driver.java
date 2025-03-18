package Management;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Driver {

    public static void main(String[] args) {
        int option;
        boolean flag = true;

        ArrayList<Student> list = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        while(flag) {
            System.out.println("Welcome to Student Management System");
            System.out.println("\"1: Add\"");
            System.out.println("\"2: Delete\"");
            System.out.println("\"3: Edit\"");
            System.out.println("\"4: Query\"");
            System.out.println("\"5: Quit\"");
            System.out.println("\"Select an option:\"");
            option = input.nextInt();

            switch(option){
                case 1:
                    addStudent(list);
                    break;
                case 2:
                    deleteStudent(list);
                    break;
                case 3:
                    updateStudent(list);
                    break;
                case 4:
                    queryStudent(list);
                    break;
                case 5:
                    System.out.println("Quit");
                    System.exit(0);
                default:
                    System.out.println("Oops! That's not a valid option. Please try again.");
                    break;
            }
        }
    }
    public static void addStudent(ArrayList<Student> list){

        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        //Creating empty student object;
        Student student = new Student();
        System.out.println("----------Add Student----------");

        System.out.print("Generating Student ID: ");
        int id = rand.nextInt(89999999) + 10000000;
        student.setId(id);
        System.out.println(student.getId());

        System.out.print("Enter Student name:");
        String name = input.nextLine();
        student.setName(name);

        System.out.print("Enter Student Age: ");
        int age = input.nextInt();
        student.setAge(age);
        input.nextLine();

        System.out.print("Enter Student Address: ");
        String address = input.nextLine();
        student.setAddress(address);

        //Add student to the arraylist
        list.add(student);
        System.out.println("Student with ID " + id + " has been Added to the System.");
    }
    public static void deleteStudent(ArrayList<Student> list){

        Scanner input = new Scanner(System.in);
        System.out.println("----------Delete Student----------");

        System.out.print("Please enter the ID of the student you want to delete:");
        int id = input.nextInt();
        boolean found = false;
        for(int i = 0; i < list.size(); i++) {
            if (id == list.get(i).getId()) {
                list.remove(i);
                System.out.println("Student with ID " + id + " has been deleted from the System.");
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("Student does not exist.");
        }
    }
    public static void updateStudent(ArrayList<Student> list){

        Scanner input = new Scanner(System.in);
        System.out.println("----------Update Student----------");
        System.out.print("Please enter the ID of the student you want to update:");
        int id = input.nextInt();
        input.nextLine();
        boolean found = false;
        for(int i = 0; i < list.size(); i++) {
            if(id == list.get(i).getId()) {
                Student student = list.get(i);
                boolean flag = true;
                while(flag) {
                    System.out.println("\"1: Change Name\"");
                    System.out.println("\"2: Change Age\"");
                    System.out.println("\"3: Change Address\"");
                    System.out.println("\"4: Quit Update\"");
                    System.out.println("\"Select an option:\"");
                    int option = input.nextInt();
                    input.nextLine();
                    switch (option) {
                        case 1:
                            System.out.print("Enter Student name:");
                            String name = input.nextLine();
                            student.setName(name);
                            System.out.println("The Name of the student with ID \" + id + \" has been changed.");
                            break;
                        case 2:
                            System.out.print("Enter Student Age: ");
                            int age = input.nextInt();
                            student.setAge(age);
                            input.nextLine();
                            System.out.println("The Age of the student with ID \" + id + \" has been changed.");
                            break;
                        case 3:
                            System.out.print("Enter Student Address: ");
                            String address = input.nextLine();
                            student.setAddress(address);
                            System.out.println("The address of the student with ID \" + id + \" has been changed.");
                            break;
                        case 4:
                            System.out.println("Quit Update Student Information");
                            flag = false;
                            found = true;
                            break;
                        default:
                            System.out.println("Oops! That's not a valid option. Please try again.");
                            break;
                    }
                }
            }
        }
        if(!found) {
            System.out.println("Student does not exist.");
        }
    }
    public static void queryStudent(ArrayList<Student> list){
        System.out.println("----------Query Student----------");
        if(list.size() == 0){
            System.out.println("Student list is Empty.");
            return;
        }
        else {
            System.out.println("Id\t\t\tName\t\tAge\t\tAddress");
            for (int i = 0; i < list.size(); i++) {
                Student student = list.get(i);
                System.out.println(student.getId() + "\t" + student.getName() + "\t" + student.getAge()
                        + "\t\t" + student.getAddress());
            }
        }
    }
}