# jbehave4-scenario-restart

This maven project reproduces the issue in JBehave 4 with Scenario not being restarted after `RestartingScenarioFailure` Exception is thrown.

## Run using JBehave 4.0.1

Just execute `mvn clean test`

Output will look like:

```
...
Running story stories/restart_scenario.story
Executing something...
Restarting this scenario...
***************** Scenario execution should be 2, but it is 1
Using timeout for story restart_scenario.story of 300 secs.
Running story stories/restart_story.story
Executing something...
Restarting this story...
Executing something...
Restarting this story...
Executing something...
...
```

**Test will success even ScenarioSteps contains a failed assertion.**


## Run using JBehave 3.10

Just execute `mvn clean test -Pjbehave3`

Now this time scenario will be restarted too, and output will look like:

```
...
Running story stories/restart_scenario.story
Executing something...
Restarting this scenario...
Executing something...
Restarting this scenario...
Executing something...
Running story stories/restart_story.story
Executing something...
Restarting this story...
Executing something...
Restarting this story...
Executing something...
java.io.FileNotFoundException: /Users/rjimenez/workspace/jbehave4-scenario-restart/target/jbehave/storyDurations.props (No such file or directory)
...
```

Maven build will success too, although storyDurations.props file has not been created this time.
