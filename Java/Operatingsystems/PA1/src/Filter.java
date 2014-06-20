import java.nio.file.Path;
import java.util.concurrent.*;

public abstract class Filter implements Runnable {
    protected BlockingQueue in;
    protected BlockingQueue out;
    protected volatile boolean done;
    public String dir;
    public Filter(BlockingQueue in, BlockingQueue out) {
        this.in = in;
        this.out = out;
        this.done = false;
    }
    
    @SuppressWarnings("unchecked")
	public void run() {
        Object o = null;
        while(! this.done) {
            try {
				o = in.take();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    // read from input queue, may block
            o = transform(o); // allow filter to change message
            if(in.isEmpty())
				this.done = true;
            try {
				out.put(o);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}       // forward to output queue
        }
    }
    
    protected abstract Object transform(Object o);
}