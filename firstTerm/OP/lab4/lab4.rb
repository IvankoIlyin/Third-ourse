
puts 'TASK 1'
c = [1,2,3,4,5,6,Complex(2,4),Complex(5,-12),Complex(6,87),Complex(3,3),Complex(-9,-4),Complex(1,1)]
c1=[]
for i in 0..c.length
  if i == 11
    c1[0]=c[11]
  end
  c1[i]=c[i-1]
end
puts "old arr"
for i in 0...c.length
  print " #{c[i]}  "
end
puts " \n new arr"
for i in 0...c.length
  print " #{c1[i]}  "
end

puts ''
puts 'TASK 2'

