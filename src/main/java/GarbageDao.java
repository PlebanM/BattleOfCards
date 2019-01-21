import java.util.ArrayList;
import java.util.List;

public class GarbageDao {
	public Garbage getByID(int index){
		return new Garbage("test", 0, 0, 0, 0, 0 );
	}

	public List<Garbage> getAll(){
		return new ArrayList<Garbage>();
	}

	public boolean removeByID(int index) {
		return false;
	}

	public boolean update(Garbage item) {
		return false;
	}
}
