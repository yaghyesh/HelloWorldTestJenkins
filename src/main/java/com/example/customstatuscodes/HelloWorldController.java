package com.example.customstatuscodes;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CustomStatusCodesApplication.class);
    }

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name) throws Exception {
        if ( name.equals("test"))
            return "Hello World " + name;

       throw new PersonNotFoundException("Data not found on server");
    }

    @GetMapping("/hello2/{name}")
    public ResponseEntity<String> sayHello2(@PathVariable String name) throws Exception {
        if ( name.equals("test"))
            return ResponseEntity.ok( "Hello World " + name);
        else if (name.equals("shakti")){
            return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
        }
           // return ResponseEntity.notFound().build();

        throw new PersonNotFoundException("Data not found on server");
    }
    //SEO friendly urls  http://localhost:8080/test/shakti
    // http://localhost:8080/test?name=shakti
}
