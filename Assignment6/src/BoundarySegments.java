/**
 * @author Zac Bowhay
 * BoundarySegments.java is an interface that is implemented by Countries.java and States.java.
 */
import java.util.ArrayList;

public interface BoundarySegments {
	/**
	 * setBoundaryLength() is a method that must be implemented
	 * will set the length of the boundaries
	 */
	public void setBoundaryLength();
	/**
	 * setNeighbors(ArrayList<String> neighs) will update a places neighbors to neighs
	 * @param neighs the ArrayList<String> that will become the new list of neighbors
	 */
	public void setNeighbors(ArrayList<String> neighs);
}
