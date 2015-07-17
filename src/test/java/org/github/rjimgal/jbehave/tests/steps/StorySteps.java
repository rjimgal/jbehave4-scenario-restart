package org.github.rjimgal.jbehave.tests.steps;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.failures.RestartingStoryFailure;
import org.junit.Assert;
import org.springframework.stereotype.Component;

@Component
public class StorySteps {

    private int executionCount = 0;

    @When("story is restarted")
    public void restartScenario() {
        if (executionCount < 2) {
            executionCount++;
            System.out.println("Restarting this story...");
            throw new RestartingStoryFailure("Please restart this story");
        }
    }

    @Then("story has been executed two times")
    public void twoExecutions() {
        if (executionCount != 2) {
            // Not using an assertion only since after a reset, scenario execution will never be a failure in JBehave 4
            System.out.println("***************** Story execution should be 2, but it is " + executionCount);
            Assert.assertEquals(2, executionCount);
        }
    }

}
