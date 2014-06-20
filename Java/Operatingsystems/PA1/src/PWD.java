import java.util.concurrent.BlockingQueue;


public class PWD extends Filter{

	public PWD(BlockingQueue in, BlockingQueue out) {
		super(in, out);
		// TODO Auto-generated constructor stub
	}
	@Override
	protected Object transform(Object o) {
		// TODO Auto-generated method stub
		this.dir = Repl.dir;
		return this.dir;
	}

}
