package com.in28minutes.webservices.soapcoursemanagement.soap.service;

import com.in28minutes.webservices.soapcoursemanagement.soap.bean.Course;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class CourseDetailsService {

    private static List<Course> courses = new ArrayList<>();

    static {
        Course course1 = new Course(1, "Spring", "10 steps");
        courses.add(course1);

        Course course2 = new Course(2, "Spring MVC", "10 Examples");
        courses.add(course2);

        Course course3 = new Course(3, "Spring boot", "6K students");
        courses.add(course3);

        Course course4 = new Course(4, "Maven", "Most popular maven courses");
        courses.add(course4);
    }


        //course - 1
        //Course findById(int id)
    public Course findById(int id){
        for(Course course : courses){
            if(course.getId() == id){
                return course;
            }

        }
        return null;
    }


        //courses
        //List<Course> findAll()
    public List<Course> findAll(){
        return courses;
    }


        //delete course
        //Course deleteById(int id)
    public int deleteById(int id){
        Iterator<Course> iterator = courses.iterator();
        while(iterator.hasNext()){
          Course course = iterator.next();
          if(course.getId() == id){
              iterator.remove();
              return 1;
          }
        }
        return 0;
    }



}
