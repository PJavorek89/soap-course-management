package com.in28minutes.webservices.soapcoursemanagement.soap;

import com.example.myschema.CourseDetails;
import com.example.myschema.GetCourseDetailRequest;
import com.example.myschema.GetCourseDetailResponse;
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

    @PayloadRoot(namespace="http://in28minutes.com/courses",
    localPart="GetCourseDetailRequest")
    @ResponsePayload
    public GetCourseDetailResponse processCourseDetailRequest(@RequestPayload GetCourseDetailRequest request){
        GetCourseDetailResponse response = new GetCourseDetailResponse();
        CourseDetails courseDetails = new CourseDetails();
        courseDetails.setId(request.getId());
        courseDetails.setName("Microservices course");
        courseDetails.setDescription("Good course");
        response.setCourseDetails(courseDetails);
        return response;
    }
}
