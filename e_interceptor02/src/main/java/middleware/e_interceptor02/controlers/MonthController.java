package middleware.e_interceptor02.controlers;

import middleware.e_interceptor02.entity.Month;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/months")
public class MonthController {

    @GetMapping("")
    public Month getMonth(HttpServletRequest request{
        /* @Pasquale non credo di aver capito
         returns a Month using a specific request attribute
         */
        Month month = (Month) request.getAttribute("month");
        return month;

    }
}
