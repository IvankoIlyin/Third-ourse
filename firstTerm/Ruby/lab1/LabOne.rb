puts "Enter x"
x = gets.chomp.to_i
puts "Enter j"
j = gets.chomp.to_i
v = Math.cos(24*(Math::PI/2)) +((Math.tan(Math.log(x**3))+4.2*(10**-2.8))/(Math.sqrt((x+Math.exp(j)).abs)))
puts "Answer = #{v}"


