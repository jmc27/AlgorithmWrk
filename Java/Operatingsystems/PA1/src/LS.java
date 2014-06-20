import java.io.File;
import java.util.concurrent.BlockingQueue;


public class LS extends Filter{

	public LS(BlockingQueue in, BlockingQueue out) {
		super(in, out);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Object transform(Object o) {
		File currentdirectory = new File(Repl.dir);
		String[] ls = currentdirectory.list();
		return toStringArray(ls);
	}
	public String toStringArray(String[] pipes) {
		String output = Repl.dir + "\n";
		for (int i = 0; i < pipes.length; i++) {
			output += pipes[i] + "\n";
		}
		return output;
	}
}
