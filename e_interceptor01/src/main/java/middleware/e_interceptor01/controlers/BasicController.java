package middleware.e_interceptor01.controlers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("time")
public class BasicController {

    @GetMapping("")
    public String getCurrentDateTime(){
        //get curent data (local)
        LocalDate date = LocalDate.now();
        //formatazione data
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return date.format(formatter);
    }

}
