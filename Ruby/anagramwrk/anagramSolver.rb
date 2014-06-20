class AnagramSolver
  attr_accessor :word1, :word2
  #initialize method for anagram solver
  def initialize word1, word2
  	@word1 = word1
  	@word2 = word2
  end

  def permute_word word
	  if word.kind_of?(Array)
	  	permutations = Hash.new
	  	word.each do |w|
	  	  permutations[w] = w.chars.to_a.permutation.to_a
	  	end
	  	return permutations
	  else
	  	permutations = word.chars.to_a.permutation.to_a
	  	return permutations
	  end
  end
  #check if word 1 and word 2 are anagrams
  def is_anagram word1, word2
  	permute = permute_word(word1)
  	permute.each do |w|
  	  puts w.join
  	  if w.join.eql?(word2)
  	  	return true
  	  end
  	end
  	return false
  end
end