package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by petricek on 4/20/14.
 * yeah
 */
@Controller
public class GreetingController {
    private static AtomicLong counter = new AtomicLong();
    private static final String template = "Hello, %s!";

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public @ResponseBody Greeting greeting(@RequestParam(required = false, value = "name", defaultValue = "World") String name)
    {
        return new Greeting(counter.incrementAndGet(), String.format(template,name));
    }
}
