require 'minitest/autorun'
require_relative "bracketSolver"
#tests
describe "Bracket Solver" do
  before do
  	@bs = BracketSolver.new("{[{}]}")
  	@inbs = BracketSolver.new("{[(}]}")
  end
  
  it "solves correct bracket string correctly" do
  	@bs.solver.must_equal true
  end

  it "solves and identifies and incorrect bracket string correctly" do
  	@inbs.solver.must_equal false
  end
end