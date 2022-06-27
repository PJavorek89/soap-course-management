package com.in28minutes.webservices.soapcoursemanagement.soap;

import com.example.myschema.CourseDetails;
import com.example.myschema.GetCourseDetailRequest;
import com.example.myschema.GetCourseDetailResponse;
import com.in28minutes.webservices.soapcoursemanagement.soap.bean.Course;
import com.in28minutes.webservices.soapcoursemanagement.soap.service.CourseDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

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
        CourseDetails courseDetails = new CourseDetails();
        courseDetails.setId(course.getId());
        courseDetails.setName(course.getName());
        courseDetails.setDescription(course.getDescription());
        response.setCourseDetails(courseDetails);
        return response;
    }
}
