import java.util.ArrayList;
import java.util.List;

public class BFS {

	public static List<Boolean> left(List<Boolean> in) {
	    List<Boolean> out = List.of(true, in.get(1), in.get(2));
	    return out;
	}

	public static List<Boolean> right(List<Boolean> in) {
	    List<Boolean> out = List.of(false, in.get(1), in.get(2));
	    return out;
	}

	public static List<Boolean> suck(List<Boolean> in) {
	    if(in.get(0)) {
	        List<Boolean> out = List.of(in.get(0), false, in.get(2));
	        return out;
	    }
	    List<Boolean> out = List.of(in.get(0), in.get(1), false);
	    return out;
	}

	public static boolean goalTest(List<Boolean> in) {
	    if (!in.get(1) & !in.get(2)) {
	        return true;
	    }
	    return false;
	}
	
	public static List<Boolean> RunBFS(List<Boolean> state) {
	    ArrayList<List<Boolean>> frontier = new ArrayList<List<Boolean>>();
	    frontier.add(state);
	    ArrayList<List<Boolean>> explored = new ArrayList<List<Boolean>>();

	    while (!frontier.isEmpty()) {
	        List<Boolean> node = frontier.remove(0);
	        System.out.println("Expanding node: " + node);
	        explored.add(node);

	        List<List<Boolean>> actions = List.of(left(node), right(node), suck(node));

	        for (List<Boolean> a : actions) {
	            if (!frontier.contains(a) & !explored.contains(a)) {
	                if (goalTest(a)) {
	                    System.out.println("Goal state found! " + a);
	                    return a;
	                }
	                System.out.println("Node added to frontier: " + a);
	                frontier.add(a);
	            }
	        }
	    }
	    return state;
	}
	
	public static void main(String[] args) {
		List<Boolean> initial = List.of(true, true, true);
		RunBFS(initial);
	}
}
