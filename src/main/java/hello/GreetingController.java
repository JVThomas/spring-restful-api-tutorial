package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//classes with @RestController ensures that every method returns a domain object instead of view
//shorthand for @Controller and @ResponseBody rolled together
@RestController
public class GreetingController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	//@RequestMapping annotation ensures that the /greeting url is mapped to the Greeting method
	//by default it maps all REST methods to the function
	//can specify specific mappings lik so: @RequestMapping(method=GET)
	@RequestMapping("/greeting")
	
	//RequestParam binds the value of the String parameter name into the name argument
	//defaultValue provides the value "World" if no such value exists
	public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name){
		
		//here we create a new Greeting obkect and assign it an incremented id and templated msg
		//id is done via incrementAndGet() of the AtomicLong obj. counter
		//String.format() used to insert name subsitution into template
		return new Greeting(counter.incrementAndGet(),String.format(template, name));
	}
}
