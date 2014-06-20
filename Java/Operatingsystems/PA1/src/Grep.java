import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;


public class Grep extends Filter{

	public Grep(BlockingQueue in, BlockingQueue out) {
		super(in, out);
		// TODO Auto-generated constructor stub
	}
	@SuppressWarnings("unchecked")
	public void run() {
        Object o = null;
        while(! this.done) {
            try {
				o = in.take();
				if(in.isEmpty() || ((String) o).contains("grep")) 
					this.done = true;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    // read from input queue, may block
            o = transform(o); // allow filter to change message
                  // forward to output queue
        }
    }
	@Override
	protected Object transform(Object o) {
		String command = (String) o;
		Scanner read = new Scanner(command);
		command = read.next();
		if(command.equals("grep")) {
			command = read.next();
		}
		for(int i = 0; i < out.size(); i++){
			String temp;
			try {
				temp = (String) out.take();
				if(temp.contains(command))
					out.put(temp);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return o;
	}

}
