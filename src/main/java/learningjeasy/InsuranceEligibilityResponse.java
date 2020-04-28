package learningjeasy;

public class InsuranceEligibilityResponse {
	
	
	private boolean shouldMedicalQuestionsBeAnswered;

	public InsuranceEligibilityResponse() {
		super();

	}

	public boolean isShouldMedicalQuestionsBeAnswered() {
		return shouldMedicalQuestionsBeAnswered;
	}

	public void setShouldMedicalQuestionsBeAnswered(boolean shouldMedicalQuestionsBeAnswered) {
		this.shouldMedicalQuestionsBeAnswered = shouldMedicalQuestionsBeAnswered;
	}

	@Override
	public String toString() {
		return "InsuranceEligibilityResponse [shouldMedicalQuestionsBeAnswered=" + shouldMedicalQuestionsBeAnswered
				+ "]";
	}
	
	
	
	
}
