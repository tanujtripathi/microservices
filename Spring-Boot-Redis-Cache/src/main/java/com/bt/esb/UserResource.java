package com.bt.esb;


import com.bt.esb.model.Appointment;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.StringReader;
import java.util.Map;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


//import org.apache.http.client.ClientProtocolException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

@RestController
@RequestMapping("/esb")
public class UserResource {

    private UserRepository userRepository;

    public UserResource(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @GetMapping("/appt")
    public Appointment add() {
 
    	  ClientConfig config = new DefaultClientConfig();
    	  Client client = Client.create(config);
    	  String BusinessService = "http://www.mocky.io/v2/5cf2ce213300005817d0d129";
    	  String ApptService = "http://www.mocky.io/v2/5cf392f9330000ce1775855a";
    	  WebResource service = client.resource(UriBuilder.fromUri(ApptService).build());
    	  // getting XML data
    	  // System.out.println(service. path('restPath').path('resourcePath').accept(MediaType.APPLICATION_JSON).get(String.class));
    	  // getting JSON data
    	  // System.out.println(service. path("restPath").path("resourcePath").accept(MediaType.APPLICATION_XML).get(String.class));
    	  String xmlString =  service. path("restPath").path("resourcePath").accept(MediaType.APPLICATION_XML).get(String.class);
    	  StringReader sr = new StringReader(xmlString);
    	  
	    	//Business business = null;
	    	Appointment appt = null;
			try {
				JAXBContext jaxbContext = JAXBContext.newInstance(Appointment.class);
				Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
				appt = (Appointment) unmarshaller.unmarshal(sr);
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  String refNo  = appt.getRefNum();
    	  //System.out.println("Appt--->"+appt.getRefNum());
    	  //System.out.println("Appt--->"+appt.getServiceType());
    	
    	
        userRepository.save(appt);
        System.out.println("---------------Appt-Saved in RedisCache!!!------------------->");
        return userRepository.findByRefNo(refNo);
    }
    @GetMapping("/all")
    public Map<String, Appointment> all() {  
        return userRepository.findAllAppt();
    }
    
}
