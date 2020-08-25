package ie.cct.customhttp;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CustomHTTPController {
	
	private ArrayList<User> registrations;
	private User user;
	private double longitude;
    private double latitude; 

	public CustomHTTPController() {
		registrations = new ArrayList<User>();
		
	}

	
//this methods is when registration new user.
	
	@PostMapping("registration")
	 public ArrayList<User> registratrion(@RequestBody User user) {
          registrations.add(user);
		 return registrations; 
		 
	 }
	
// this methods is when login the user with email and password	
	
	@GetMapping("login")
	public ArrayList<User> login(@RequestParam("email") String username, @RequestParam String password ) {
		
		ArrayList<User> log = new ArrayList<User>();
		for (User user2 :registrations) {
			String email = user2.getEmail();
			String pass = user2.getPassword();
			if(username.equals(email) && (password.equals(pass))) {
				user = user2;
				log =registrations; 
			}else {
				throw new UnauthorizedExeption();
			}
		}
		return log;
	}
	
	// this methods is when login the user with email,password, latituded and longiuted,
	//when the user login send the actual location and send it from Fronend to service, here this parameter is updated
	@GetMapping("login2")
	public ArrayList<User> loginwithLatLong(@RequestParam("email") String username, @RequestParam String password,  @RequestParam double lat,  @RequestParam double lon) {
		
		ArrayList<User> log = new ArrayList<User>();
		for (User user2 :registrations) {
			String email = user2.getEmail();
			String pass = user2.getPassword();
			if(username.equals(email) && (password.equals(pass))) {
				user = user2;
				user.setLatitude(lat);
				user.setLongitude(lon);
				log =registrations; 
			}else {
				throw new UnauthorizedExeption();
			}
		}
		return log;
	}
   
	


	// this method show all user register 
	@GetMapping("show")
	 public ArrayList<User> showAllUser(){
      return registrations;	
	}
	
	
	// this method show the User that is log in
	@GetMapping("userlogin")
	 public User userLoginon(){
		return user;
	}	

	
	
	// This method show the distancia from the location from user log in and the other user. 
	// also show the distancia from 0 and max km. the max km recive from frontend 
	
	@GetMapping("showdistance")
	 public ArrayList<User> showUserLocation(@RequestParam int max){
        //String str= null;
		ArrayList<User> users = registrations;
		ArrayList<User> userDist = new ArrayList<User>();
   
		for (int j = 0; j < users.size(); j++) {
		if(userLogin(users.get(j))==false) 		      
		{ 		
        	double dist= distanceTo(users.get(j).getLatitude(), users.get(j).getLongitude());
    	       if (dist>=0 && dist<=max){   
    	    	   userDist.add(users.get(j));
    	       }
        
        }
		
	}
    	
		 return userDist;
	}
	

	private double distanceTo(double latitude2,double longitude2) {
        double STATUTE_KM_PER_NAUTICAL_MILE = 1.852;
		this.latitude=user.getLatitude();
		this.longitude=user.getLongitude();
        double lat1 = Math.toRadians(this.latitude);
        double lon1 = Math.toRadians(this.longitude);
        
        double lat2 = Math.toRadians(latitude2);
        double lon2 = Math.toRadians(longitude2);

        // great circle distance in radians, using law of cosines formula
        double angle = Math.acos(Math.sin(lat1) * Math.sin(lat2)
                               + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon1 - lon2));
        double nauticalMiles = 60 * Math.toDegrees(angle);
        double statuteKm = STATUTE_KM_PER_NAUTICAL_MILE * nauticalMiles;
        return statuteKm;
 
    }

		
	
	private boolean userLogin(User use) {
		boolean sw=false;
		if(user.getEmail().trim().equals(use.getEmail().trim())) 
		{
			sw=true;
		}      
		return sw;	
	}
	
		

	
	
		 
}
	
	
	
	
	

	
	


