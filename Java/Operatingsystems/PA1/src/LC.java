import java.util.concurrent.BlockingQueue;


public class LC extends Filter{
	private int size = 0;
	public LC(BlockingQueue in, BlockingQueue out, int size) {
		super(in, out);
		// TODO Auto-generated constructor stub
		this.size = size;
	}

	@Override
	protected Object transform(Object o) {
		// TODO Auto-generated method stub
		
		return size;
	}

}
