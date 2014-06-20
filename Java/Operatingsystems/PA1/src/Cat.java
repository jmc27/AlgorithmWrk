import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;


public class Cat extends Filter{
	public Cat(BlockingQueue in, BlockingQueue out) {
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
	@SuppressWarnings({ "unchecked", "resource" })
	@Override
	protected Object transform(Object o) {
		String[] files = ((String) o).split(" ");
		printStringArray(files);
		Scanner read;
		for (int i = 0; i < files.length; i++) {
			if(!files[i].equals("cat")) {
				File curr = new File(Repl.dir + "/" + files[i].trim());
				try {
					read = new Scanner(curr);
					while(read.hasNextLine()) {
						String temp = read.nextLine();
						//System.out.println(temp);
						try {
							out.put(temp);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		return o;
	}
	public void printStringArray(String[] arr) {
		for(int i = 0; i < arr.length; i ++) {
			System.out.println(arr[i].toString());
		}
	}
}
