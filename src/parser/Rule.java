package parser;

public class Rule {
	private String rightHandSide;
	private String leftHandSide;
	private int grammarSymbolsNumber;
	private String followString;
	private String[] followSet;
	public Rule(String leftHandSide, String rightHandSide, int grammarSymbolsNumber){
		this.leftHandSide = leftHandSide;
		this.rightHandSide = rightHandSide;
		this.grammarSymbolsNumber = grammarSymbolsNumber;
	}
	public Rule(String leftHandSide, String rightHandSide, int grammarSymbolsNumber, String followString){
		this.leftHandSide = leftHandSide;
		this.rightHandSide = rightHandSide;
		this.grammarSymbolsNumber = grammarSymbolsNumber;
		this.followString = followString;
		createFollowSet();
	}
	public Boolean findFollow(String x){
		for(int i = 0; i < followSet.length; i++){
			if(x.equals(followSet[i])){
				return true;
			}
		}
		return false;
	}
	private void createFollowSet(){
		if(followString.indexOf(' ') > -1){
		 followSet = followString.split(" ");
		}else{
			followSet = new String[1];
			followSet[0] = followString;
		}
	}
	public String getFollowString() {
		return followString;
	}
	public void setFollowString(String followString) {
		this.followString = followString;
	}
	public String[] getFollowSet() {
		return followSet;
	}
	public void setFollowSet(String[] followSet) {
		this.followSet = followSet;
	}
	public String getRightHandSide() {
		return rightHandSide;
	}
	public void setRightHandSide(String rightHandSide) {
		this.rightHandSide = rightHandSide;
	}
	public String getLeftHandSide() {
		return leftHandSide;
	}
	public void setLeftHandSide(String leftHandSide) {
		this.leftHandSide = leftHandSide;
	}
	public int getGrammarSymbolsNumber() {
		return grammarSymbolsNumber;
	}
	public void setGrammarSymbolsNumber(int grammarSymbolsNumber) {
		this.grammarSymbolsNumber = grammarSymbolsNumber;
	}
	public String toString(){
		return leftHandSide +" -> "+rightHandSide;
	}
}
