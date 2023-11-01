
class LongWordChooser implements MyChooser<String> {

	@Override
	public boolean chooseElement(String s) {
		return s.length() > 5;
	}

} 

// Add your choosers here

class NumContainerChooser implements MyChooser<String>{
	
	@Override
	public boolean chooseElement(String s){
		for(int i = 0; i < 10; i++){
			if(s.contains(i + "")){return true;}
		}
		return false;
	}
}

class EvenIntChooser implements MyChooser<Integer>{

	@Override
	public boolean chooseElement(int i){
		return (i % 2 == 0);
	}
}