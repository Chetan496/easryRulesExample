package learningjeasy;

import java.util.HashMap;
import java.util.Map;

public class TransactionRule {
	
	private String ruleType;
	
	private String ruleName;
	
	private String condition; //an MVEL expression or a DB query..depending on rule type
	
	private Map<String, Object> ruleEvaluationParams;

	public TransactionRule(String ruleType, String ruleName) {
		super();
		this.ruleType = ruleType;
		this.ruleName = ruleName;
		this.ruleEvaluationParams = new HashMap<String, Object>();
	}

	public String getRuleType() {
		return ruleType;
	}

	public void setRuleType(String ruleType) {
		this.ruleType = ruleType;
	}

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	
	
	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	
	
	public void updateRuleEvaluationParams(String key, Object value) {
		this.ruleEvaluationParams.put(key, value) ;
	}
	
	
	public void setRuleEvaluationParams( Map<String, Object> mapOfParams) {
		this.ruleEvaluationParams = mapOfParams ;
	}

	@Override
	public String toString() {
		return "TransactionRule [ruleType=" + ruleType + ", ruleName=" + ruleName + ", condition=" + condition
				+ ", ruleEvaluationParams=" + ruleEvaluationParams + "]";
	}
	
	
	


	
	
	
}
