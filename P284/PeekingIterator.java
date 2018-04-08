import java.util.*;
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
  int nextNum;
  boolean justPeeked;
  Iterator<Integer> myIterator;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
      justPeeked = false;
      nextNum = 0;
      myIterator = iterator;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
    if (justPeeked) return nextNum;
    nextNum = myIterator.next();
    justPeeked = true;
    return nextNum;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
  @Override
  public void remove() {

  }
	@Override
	public Integer next() {
    if (justPeeked) {
      justPeeked = false;
      return nextNum;
    }
    return myIterator.next();
	}

	@Override
	public boolean hasNext() {
    if (justPeeked || myIterator.hasNext()) return true;
    return false;
	}
}
