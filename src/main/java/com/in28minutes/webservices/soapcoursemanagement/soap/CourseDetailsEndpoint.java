package com.in28minutes.webservices.soapcoursemanagement.soap;

import com.example.myschema.CourseDetails;
import com.example.myschema.GetAllCoursesDetailRequest;
import com.example.myschema.GetCourseDetailRequest;
import com.example.myschema.GetCourseDetailResponse;
import com.in28minutes.webservices.soapcoursemanagement.soap.bean.Course;
import com.in28minutes.webservices.soapcoursemanagement.soap.service.CourseDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class CourseDetailsEndpoint {

    //method
    //input-GetCourseDetailRequest
    //respond-GetCourseDetailResponse

    //http://in28minutes.com/courses
    //GetCourseDetailResponse

    @Autowired
    CourseDetailsService courseDetailsService;

    @PayloadRoot(namespace="http://in28minutes.com/courses",
    localPart="GetCourseDetailRequest")
    @ResponsePayload
    public GetCourseDetailResponse processCourseDetailRequest(@RequestPayload GetCourseDetailRequest request){
        GetCourseDetailResponse response = new GetCourseDetailResponse();

        Course course = courseDetailsService.findById(request.getId());
        /*
        CourseDetails courseDetails = new CourseDetails();
        courseDetails.setId(course.getId());
        courseDetails.setName(course.getName());
        courseDetails.setDescription(course.getDescription());
        response.setCourseDetails(courseDetails);

         */


        return mapCourse(course);
    }

    /*
    @PayloadRoot(namespace="http://in28minutes.com/courses",
            localPart="GetAllCourseDetailRequest")
    @ResponsePayload
    public GetCourseDetailResponse processAllCourseDetailRequest(@RequestPayload GetAllCoursesDetailRequest request){
        GetCourseDetailResponse response = new GetCourseDetailResponse();

        List<Course> courses = courseDetailsService.findAll();

        return mapCourse(courses);
    }

     */


    private GetCourseDetailResponse mapCourse(Course course){

        GetCourseDetailResponse courseDetailResponse = new GetCourseDetailResponse();

        CourseDetails courseDetails = new CourseDetails();

        courseDetails.setId(course.getId());
        courseDetails.setName(course.getName());
        courseDetails.setDescription(course.getDescription());

        courseDetailResponse.setCourseDetails(courseDetails);

        return courseDetailResponse;
    }
}
