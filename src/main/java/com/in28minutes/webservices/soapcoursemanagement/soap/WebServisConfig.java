package com.in28minutes.webservices.soapcoursemanagement.soap;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

//Enable Spring Web Services
@EnableWs
//Spring configuration file
@Configuration
public class WebServisConfig {
    //MessageDispatcherServlet
        //ApplicantionContext
        //url -> ws/*

    @Bean
    public ServletRegistrationBean messageDispatcher(ApplicationContext context){
        //map MessageDispatcherServlet to url
        //messageDispatcherServlet recieve a message and send it where it should be
        MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
        messageDispatcherServlet.setApplicationContext(context);
        messageDispatcherServlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(messageDispatcherServlet, "/ws/*");
    }

    //ws/courses.wsdl
    //PortType - CoursePort
    //NameSpace - http://in28minutes.com/courses
    //course-detail.xsd  -> generate wsdl file
    @Bean(name="courses")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema courseSchema){
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setPortTypeName("CoursePort");
        definition.setTargetNamespace("http://in28minutes.com/courses");
        definition.setLocationUri("/ws");
        definition.setSchema(courseSchema);
        return definition;
    }


    @Bean
    public XsdSchema courseSchema(){
        return new SimpleXsdSchema(new ClassPathResource("course-detail.xsd"));
    }

}
