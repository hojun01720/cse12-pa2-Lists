
class UpperCaseTransformer implements MyTransformer<String> {

	@Override
	public String transformElement(String s) {
		return s.toUpperCase();
	}

}

// Add your transformers here

class StringToNumTransformer implements MyTransformer<String> {

	@Override
	public String transformElement(String s){
		String numStr = "";
		int num;
		for(int i = 0 ; i < s.length(); i++){
			num = s.charAt(i);
			numStr = numStr + num;
		}
		return numStr;
	}
}

class AddAThousand implements MyTransformer<Integer>{
	@Override
	public int transformElement(int i){
		return i + 1000;
	}
}