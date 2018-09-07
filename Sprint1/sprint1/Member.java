package sprint1;

import java.io.*;
import java.util.*;

public class Member {

	private LocalDateTime dateCreated;
	private String firstName;
	private String lastName;
	private String screenName;
	private String emailAddress;
	
	public Member(String firstName, String lastName, String screenName, String emailAddress, LocalDateTime dateCreated ) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.screenName = screenName;
		this.emailAddress = emailAddress;
		this.dateCreated = dateCreated;
	}
}