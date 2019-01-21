import java.util.ArrayList;
import java.util.List;

public class GarbageDao {
	public Garbage getByID(int index){
		return new Garbage("test", 0, 0, 0, 0 );
	}

	public List<Garbage> getAll(){
		List<Garbage> devList = new ArrayList<>();
		devList.add(new Garbage("First", 99, 99, 99, 99));
		devList.add(new Garbage("Second", 22, 22, 22, 22));
		devList.add(new Garbage("Third", 33, 33, 33, 33));
		devList.add(new Garbage("Fourth", 44, 44, 44, 44));
		devList.add(new Garbage("Fifth", 44, 44, 44, 44));
//		devList.add(new Garbage("Sixth", 44, 44, 44, 44));
		return devList;
	}

	public boolean removeByID(int index) {
		return false;
	}

	public boolean update(Garbage item) {
		return false;
	}
}
