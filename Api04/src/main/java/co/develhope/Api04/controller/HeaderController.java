package co.develhope.Api04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api04")
public class HeaderController {

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = "/echo/{input:.+}", method = RequestMethod.GET)
    public ModelAndView getDomain(@PathVariable("input") String input) {

        ModelAndView modelandView = new ModelAndView("result");

        modelandView.addObject("user-agent", getUserAgent());
        modelandView.addObject("headers", getHeadersInfo());

        return modelandView;

    }

    //get user agent
    private String getUserAgent() {
        return request.getHeader("user-agent");
    }

    //get request headers
    private Map<String, String> getHeadersInfo() {

        Map<String, String> map = new HashMap<String, String>();

        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }

        return map;
    }

    @DeleteMapping("/echo")
    public String deliteRoute() {

        return "ciao io sono il delit";
    }

}
