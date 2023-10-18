public class LinkedGL<E> implements MyList<E> {

    class Node {
        E value;
        Node next;

        public Node(E value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    Node front;
    int size;

    public LinkedGL(E[] contents) {
        // Fill in this constructor
        this.size = contents.length;

        this.front = new Node(null, null);
        Node currentNode = this.front;

        for(int i = 0; i < this.size; i++){
            currentNode.next = new Node(contents[i], null);
            currentNode = currentNode.next;
        }
    }

    // Fill in all methods

    public boolean isEmpty(){
        if (this.size == 0){return true;}
        return false;
    }

    public E[] toArray(){
        E[] newArr = (E[])new Object[this.size];

        Node curNode = this.front; 

        for(int i = 0; i < this.size; i++){
            newArr[i] = (E) curNode.next;
        }
        return newArr;
    }

    public void transformAll(MyTransformer mt){
        /*Node oriCurNode = this.front;
        LinkedGL newLink = this;
        Node newCurNode = newLink.front;

        E val;

        for(int i = 0; i < this.size; i++){
            if(oriCurNode.next.value == null){
                val = null;
            }
            else{val = mt.transformElement((E) oriCurNode.next.value);}

            newCurNode.next.value = val;

            oriCurNode = oriCurNode.next;
            newCurNode = newCurNode.next;
        }
        this.front = newLink.front;

        Node oriCurNode = this.front;

        E val;

        for(int i = 0; i < this.size; i++){
            if(oriCurNode.next.value == null){
                val = null;
            }
            else{val = mt.transformElement((E) oriCurNode.next.value);}

            oriCurNode.next.value = val;

            oriCurNode = oriCurNode.next;
        }
        */

        Node oriCurNode = this.front;

        E val;

        for(int i = 0; i < this.size; i++){
            val = oriCurNode.next.value;
            if( val != null){
                oriCurNode.next.value = mt.transformElement((E) val);
            }
            oriCurNode = oriCurNode.next;
        }
    }

    public void chooseAll(MyChooser mc){
        Node curNode = this.front;
        boolean bq;
        E val;

        for(int i = 0; i < this.size; i++){
            val = curNode.next.value;
            if(val == null || ! mc.chooseElement((E) val)){
                //remove curNode.next node and reconnect the next next one to curNode
                curNode.next = curNode.next.next;
                this.size --;
            }
            curNode = curNode.next;
        }
    }

    
}