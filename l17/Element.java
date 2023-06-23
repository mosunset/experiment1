public class Element {
    private Object data;
    private Element next;

    public Element() {

    }

    public Element(Object obj) {
        this.data = obj;
    }

    public Object getData() {
        return this.data;
    }

    public Element getNextElement() {
        return this.next;
    }

    public void setNextElement(Element nextElement) {
        this.next = nextElement;
    }

    public String toString() {
        if (this.next != null) {
            return this.data.toString() + " -> ";
        } else {
            return this.data.toString();
        }
    }
}
