package oCP2;

public abstract class Event {
	protected String name;
	public Event(String name) {
		this.name=name;
	}
	public String toString() {
		return name;
	}
}
