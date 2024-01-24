package com.github.nguyentiennam.main;

import com.github.nguyentiennam.bean.Faculty;
import com.github.nguyentiennam.bean.Person;
import com.github.nguyentiennam.bean.Student;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoParentBean {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Person person = (Person) context.getBean("person");
        System.out.println(person);

        Person student = (Student) context.getBean("student");
        System.out.println(student);

        Person student1 = (Student) context.getBean("student1");
        System.out.println(student1);

        /*demo inject collection
        * */
        Faculty faculty = (Faculty) context.getBean("faculty");
        System.out.println(faculty);

    }
}
