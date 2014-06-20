import java.util.concurrent.BlockingQueue;


public class Exclamation extends ShellSink{

	public Exclamation(BlockingQueue in) {
		super(in);
		// TODO Auto-generated constructor stub
	}
	@SuppressWarnings("unchecked")
	public void run() {
        Object o = null;
        while(! this.done) {
            try {
				o = in.take();
				if(in.isEmpty())
					this.done = true;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    // read from input queue, may block
            o = transform(o); // allow filter to change message
            System.out.println(o);
        }
    }
	
	@Override
	protected Object transform(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

}
