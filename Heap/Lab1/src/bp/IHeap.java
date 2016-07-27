package bp;

import java.time.LocalDate;

public interface IHeap {

	boolean isEmpty();

	int getSize();

	void clear();

	void insert(LocalDate valueToInsert);

	LocalDate delete();

	String toString();
}
