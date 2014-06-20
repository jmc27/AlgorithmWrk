require 'minitest/autorun'
require_relative "anagramSolver"
#tests
describe "AnagramSolver" do
	before do 
		@as = AnagramSolver.new("dog", "god")
	end

	it "finds all permutations correctly" do
		@permutations = @as.permute_word(@as.word1).to_a
		size = @permutations.size()
		size.must_equal 6
	end

	it "tells if words are anagrams correctly" do
		bool = @as.is_anagram(@as.word1, @as.word2)
		puts bool
		bool.must_equal true
	end
end