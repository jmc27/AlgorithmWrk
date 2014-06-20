class BracketSolver
  attr_accessor :input
  
  #input is a string of brackets
  def initialize input
	@input = input.chars
	@openbrackets = ["[", "(", "{"]
	@closebrackets = ["]", ")", "}"]
  end
  #solves a single bracket string to see if it is valid
  #returns true or false
  def solver
    queue = []
    stack = []
    while !@input.empty?
    	bracket = @input.delete_at(0)
    	if @openbrackets.include?(bracket)
    		queue << bracket
    	elsif @closebrackets.include?(bracket)
    		stack.push(bracket)
    	end
    end
    return stack_queue_solver stack, queue
  end

  #helper method to solve with stack and queue input
  def stack_queue_solver stack, queue
  	if stack.size() == queue.size()
  	  while !stack.empty?
  		close = stack.pop
  		open = queue.delete_at(0)
  		if @openbrackets[0].eql?(open) and !@closebrackets[0].eql?(close)
  			return false
  		elsif @openbrackets[1].eql?(open) and !@closebrackets[1].eql?(close)
  			return false
  		elsif @openbrackets[2].eql?(open) and !@closebrackets[2].eql?(close)
  			return false
  		end
  	  end
  	  return true
  	else
  		return false
  	end
  end
end