import java.io.File;
import java.util.Scanner;
import java.util.concurrent.*;


//Read evaluate print loop class that reads from System.in
public class Repl {
	static Scanner repl = new Scanner(System.in);
	public static Scanner read;
	public static String dir = System.getProperty("user.dir");
	public static void main(String[] args) {
		String input = "";
	    BlockingQueue in = new LinkedBlockingQueue();
	    BlockingQueue history = new LinkedBlockingQueue();
	    BlockingQueue out = new LinkedBlockingQueue();
	    input = repl.nextLine();
	    while(!input.equalsIgnoreCase("exit")) {
	    	try {
				history.put(input);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	String[] pipes = input.split("\\|");
			in = fillqueue(pipes, in);
			
			for(int i = 0; i < pipes.length; i++){	
				if(pipes[i].contains("!")){
					read = new Scanner(pipes[i]);  
					int num = read.nextInt();
					pipes[i] = pipes[num];
					
				}
				if (pipes[i].contains("cat")) {
					Thread t = new Thread(new Cat(in, out));
					t.start();
				}
				else if(pipes[i].contains("grep")){
					Thread t = new Thread(new Grep(in, out));
					t.start();
				}
				else if(pipes[i].contains("lc")) {
					Thread t = new Thread(new LC(in, out, pipes.length - 1));
				}
				
				else if(pipes[i].contains("pwd")){
					Thread t = new Thread(new PWD(in, out));
					t.start();
					
				}
				else if(pipes[i].contains("cd")) {
					if(pipes[i].contains("..")){
						dir = dir.substring(0, dir.lastIndexOf('/'));
					}
					else {
						read = new Scanner(pipes[i]);
						String cd = read.next();
						if(cd.equalsIgnoreCase("cd") && read.hasNext())
							cd = read.next();
						dir = dir + "/" + cd;
					}
					in.remove();
				}
				else if(pipes[i].contains("ls")) {
					Thread t = new Thread(new LS(in, out));
					t.start();
					
				}
				else if(pipes[i].contains("history")){
					Thread t = new Thread(new History(history, out));
					t.start();
				}
				if(i == pipes.length - 1) {
					Thread t = new Thread(new Output(out));
					t.start();
				}
			}
	    	input = repl.nextLine();
	    }
	    
	    repl.close();            
	    
	}
	public static void cd(String directory) {
		dir = directory;
	}
	//read a single pipe and fill a blocking queue with the different commands
	public static BlockingQueue fillqueue(String[] commands, BlockingQueue in) {
		for(int i = 0; i < commands.length; i++){
			in.add(commands[i]);
		}
		return in;
	}
	
	// for some reason split is giving me hard time if I don't
	//give a limit
	public static int numpipes(String command) {
		int num = 1;
		for(int i = 0; i < command.length(); i ++) {
			if(command.charAt(i) == '|')
				num++;
		}
		return num;
	}
}
