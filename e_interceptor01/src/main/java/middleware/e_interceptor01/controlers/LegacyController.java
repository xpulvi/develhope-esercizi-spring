package middleware.e_interceptor01.controlers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/legacy")
public class LegacyController {

    @GetMapping("")
    public String getOldCode(){
        // non sono sicuro che voglia questo.
        return "This is just old code: for(int i = 0, i>ches, i++)";
    }

}
