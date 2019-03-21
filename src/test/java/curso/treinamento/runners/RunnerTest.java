package curso.treinamento.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src\\test\\resources\\features\\login.feature"},
		glue = {"curso.treinamento.steps"},
		snippets = SnippetType.CAMELCASE,
		tags = {})

public class RunnerTest {
	
}