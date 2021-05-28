package com.example.customstatuscodes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND , reason = "Person is not found in system")
public class PersonNotFoundException extends RuntimeException{
    public PersonNotFoundException(String message) {
        super(message);
    }
}

//Broken authentication


// Information disclosure

// Invalid credentials  Invalid userid or password
//Invalid userid
// Invalid password
