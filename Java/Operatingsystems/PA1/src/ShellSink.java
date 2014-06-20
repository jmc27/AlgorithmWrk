import java.util.concurrent.*;

public class ShellSink extends Filter {
    public ShellSink(BlockingQueue print) {
        super(null, print);
    }
    @SuppressWarnings("unchecked")
	public void run() {
        Object o = null;
        while(! this.done) {
            try {
				o = out.take();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            transform(o); // allow filter to change message
            if(out.isEmpty())
				this.done = true;
        }
    }
    protected Object transform(Object o) {
        // get the string message from o and print it
    	System.out.println(o);
        return o;
    }
}