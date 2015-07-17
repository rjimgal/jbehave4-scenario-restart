package org.github.rjimgal.jbehave.tests.steps;

import org.jbehave.core.annotations.Given;
import org.springframework.stereotype.Component;

@Component
public class CommonSteps {

    @Given("something")
    public void something() throws Exception {
        System.out.println("Executing something...");
    }
    
}
