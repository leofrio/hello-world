package TabloGreat;


public class Stack { 
	private Element first;
    private Element top=null;
    private boolean error=false; 
    public boolean getError() {
        return error;
    }  
    
    public void setError(boolean error) {
		this.error = error;
	}

	public Element getTop() {
        return top;
    }
    public void push(char letter) { 
        Element brand=new Element(letter); 
        if(letter == '(') {
        	if(top == null) {
    			first=brand;
    			top=brand;
    			brand.setNext(null);
    			brand.setPrev(null);
    		} 
    		else {
    			top.setNext(brand);
    			brand.setPrev(top);
    			brand.setNext(null);
    			top=brand;
    		}
        } 
        if(letter == ')') {
            pop();
        }
    } 
    public boolean pop() {
        if(top == null) {
            return false; 
            
        }
        else {
            top=top.getPrev();
            return true;
        } 
    }  
    public boolean isEmpty() {
    	if(top== null) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public void empty() { 
    	first=null;
    	top=null;
    	error=false;
    }
}
