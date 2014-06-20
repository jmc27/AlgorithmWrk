import java.util.concurrent.BlockingQueue;


public class History extends Filter{
	int n = 0;
	public History(BlockingQueue in, BlockingQueue out) {
		super(in, out);
		// TODO Auto-generated constructor stub
	}
	@SuppressWarnings("unchecked")
	public void run(){
		Object o = null;
		int size = out.size();
        while(! this.done) {
            try {
            	if(!in.isEmpty()) {
            		o = in.take();
            		size++;
            	}
            	else
            		o = out.take();
				if(in.isEmpty());
					this.done = true;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    // read from input queue, may block
            o = transform(o); // allow filter to change message
            try {
				out.put(o);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}       // forward to output queue
        }
	}
	@Override
	protected Object transform(Object o) {
		n++;	
		System.out.println(n + " " + o. toString());
		
		return null;
	}

}
