package dependency_Injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyComponent {

    @Autowired
    protected String myComponentName = "Nik";

    public MyComponent(String myComponentName ) {
        this.myComponentName = myComponentName;
    }

    @GetMapping
    public String getMyComponentName() {

        return myComponentName + " myComponentImmutableName";
    }


}
