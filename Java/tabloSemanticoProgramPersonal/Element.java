package TabloGreat;

public class Element {
    private char letter;
    private Element next;   
    private Element prev;
    public Element(char letter) {
        this.letter=letter;
    }
    
    public Element getPrev() {
		return prev;
	}

	public void setPrev(Element prev) {
		this.prev = prev;
	}

	public char getLetter() {
        return letter;
    }
    public void setLetter(char letter) {
    this.letter=letter;
    }
    public Element getNext() {
        return next;
    }
    public void setNext(Element next) {
        this.next=next;
    }
    
}
