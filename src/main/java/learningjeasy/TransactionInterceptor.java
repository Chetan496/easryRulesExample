package learningjeasy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TransactionInterceptor {
	
	
	private List<TransactionRule> rules;

	public TransactionInterceptor() {
		this.rules = new ArrayList<TransactionRule>();
	}
	
	public void addRule(String  ruleType, String ruleName) {
		
		this.rules.add( new TransactionRule(ruleType, ruleName) ) ;
	}
	
	public boolean hasRuleWithNoConditionSet( String ruleName) {
		
		return this.rules.stream().anyMatch(transactionRule -> transactionRule.getRuleName().equals(ruleName) && transactionRule.getCondition() == null) ;
	}
	
	
	public void updateConditionForRule(String ruleName, String condition, Map<String, Object> mapOfParams) {
		
		/*we should really use a hashMap.. */
		Iterator<TransactionRule> iteratorForTransactionRules = this.rules.iterator() ;
		while(iteratorForTransactionRules.hasNext()) {
			
			TransactionRule nextTransRule = iteratorForTransactionRules.next();
			if(nextTransRule.getRuleName().equalsIgnoreCase(ruleName)) {
				nextTransRule.setCondition(condition);
				nextTransRule.setRuleEvaluationParams(mapOfParams);
			}
		}
		
	}
	
	


	@Override
	public String toString() {
		return "TransactionInterceptor [rules=" + rules + "]";
	}
	
	
	
	
}
