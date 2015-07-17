package org.github.rjimgal.jbehave.tests.steps;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.failures.RestartingScenarioFailure;
import org.junit.Assert;
import org.springframework.stereotype.Component;

@Component
public class ScenarioSteps {

    private int executionCount = 0;

    @When("scenario is restarted")
    public void restartScenario() {
        if (executionCount < 2) {
            executionCount++;
            System.out.println("Restarting this scenario...");
            throw new RestartingScenarioFailure("Please restart this scenario");
        }
    }

    @Then("scenario has been executed two times")
    public void twoExecutions() {
        if (executionCount != 2) {
            // Not using an assertion only since after a reset, scenario execution will never be a failure in JBehave 4
            System.out.println("***************** Scenario execution should be 2, but it is " + executionCount);
            Assert.assertEquals(2, executionCount);
        }
    }

}
