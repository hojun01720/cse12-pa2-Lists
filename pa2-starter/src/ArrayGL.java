public class ArrayGL<E> implements MyList<E> {

    E[] elements;
    int size;

    public ArrayGL(E[] initialElements) {
        this.elements = initialElements;
        this.size = initialElements.length;
    }

    // Fill in all required methods here

    public boolean isEmpty(){
        if(this.size == 0){return true;}
        return false;
    }

    public E[] toArray(){
        E[] newArr = (E[])new Object[this.size];
        
        for(int i = 0; i < this.size; i++){
            newArr[i] = (E) this.elements[i];
        }
        return newArr;
    }

    public void transformAll(MyTransformer mt){
        for(int i = 0; i < this.size; i++){
            if(this.elements[i] != null){
                this.elements[i] = mt.transformElement( this.elements[i]);
            }
        }
    }

    public void chooseAll(MyChooser mc){

        int indNum = this.size;

        for(int i = 0; i < this.size; i++){
            if(this.elements[i] == null || ! mc.chooseElement(this.elements[i]) ) {
                this.elements[i] = null;
                indNum --;
            }
        }

        E[] newArr = (E[]) new Object[indNum];

        int newArrInd = 0;
        for(int i = 0; i < this.size; i++){
            if(this.elements[i] != null){
                newArr[newArrInd] = this.elements[i];
                newArrInd ++;
            }
        }
        this.elements = newArr;
        this.size = this.elements.length;

    }
}