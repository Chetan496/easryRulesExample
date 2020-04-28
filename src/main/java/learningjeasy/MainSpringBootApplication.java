package learningjeasy;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.core.InferenceRulesEngine;
import org.jeasy.rules.core.RulesEngineParameters;
import org.jeasy.rules.mvel.MVELRuleFactory;
import org.jeasy.rules.support.YamlRuleDefinitionReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.common.collect.ImmutableMap;


@SpringBootApplication

public class MainSpringBootApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(MainSpringBootApplication.class);
	
    public static void main(String[] args) {
        SpringApplication.run(MainSpringBootApplication.class, args);
        logger.info("Application has started, Hello from Spring boot.. Hi!");
        
        
        //testRuleEngineForInsurance();
        testRuleEngineForTransactionRules();
    }

	private static void testRuleEngineForInsurance() {
		MVELRuleFactory ruleFactory = new MVELRuleFactory(new YamlRuleDefinitionReader());
        try {
			Rules rules = ruleFactory.createRules(new FileReader("D:\\eclipseWorkspaceForjBPM\\jeasy\\src\\main\\resources\\insuranceEligibilityRules.yml"));
			RulesEngine rulesEngine = new DefaultRulesEngine();
			Facts facts = new Facts();
			
			LoanRequest loanRequest = new LoanRequest(1499);
			facts.put("loanRequest", loanRequest) ;
			InsuranceEligibilityResponse insuranceEligibilityResponse = new InsuranceEligibilityResponse();
			facts.put("insuranceEligibilityResponse", insuranceEligibilityResponse);
			
			rulesEngine.fire(rules, facts);
			
			logger.info("after firing the rules");
			logger.info("insuranceEligibilityResponse: " + insuranceEligibilityResponse);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private static void testRuleEngineForTransactionRules() {
		MVELRuleFactory ruleFactory = new MVELRuleFactory(new YamlRuleDefinitionReader());
		TransactionRequest transactionRequest = new TransactionRequest("wallet", "MambuSavings", 1000.0, "2372378", "467836", "CLIENT638248");
		TransactionInterceptor transactionInterceptor = new TransactionInterceptor();
        try {
			Rules rules = ruleFactory.createRules(new FileReader("D:\\eclipseWorkspaceForjBPM\\jeasy\\src\\main\\resources\\transactionRulesToApply.yml"));
			
			RulesEngine rulesEngine = new DefaultRulesEngine();
			Facts facts = new Facts();
			
			facts.put("transactionRequest", transactionRequest) ;
			facts.put("transactionInterceptor", transactionInterceptor) ;
			
			rulesEngine.fire(rules, facts);
			
			logger.info("after firing the rules");
			logger.info("transactionInterceptor: " + transactionInterceptor);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        try {
        	//now the transactionInterceptor will be already populated with the rules to execute
        	//we now need to choose the conditions dynamically
			Rules rules = ruleFactory.createRules(new FileReader("D:\\eclipseWorkspaceForjBPM\\jeasy\\src\\main\\resources\\conditionsForEachTransactionRule.yml"));
			
			RulesEngine rulesEngine = new DefaultRulesEngine();
			Facts facts = new Facts();
		
			facts.put("transactionRequest", transactionRequest) ;
			facts.put("transactionInterceptor", transactionInterceptor) ;
			
			rulesEngine.fire(rules, facts);
			
			logger.info("after firing the rules");
			logger.info("transactionInterceptor: " + transactionInterceptor);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	


   
}
