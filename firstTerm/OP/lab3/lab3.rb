A=false
B=false
C=true
X=60
Y=-10
Z=4

puts " TASK 1:"
#a
if !(A || B) && (A && !B)
  puts "a) is true"
else
  puts "a) is false"
end

#b
if ((Z!=Y).object_id <= (6>=Y).object_id )&& A || B && C && (X>=1.5)
  puts "b) is true"
else
  puts "b) is false"
end


#c
if ((8-X*2)<=Z) && (X**2!=Y**2) || (Z>=15)
  puts "c) is true"
else
  puts "c) is false"
end

#d
if (X>0) && (Y<0) || (Z>=(X*Y-(-1*Y/X))+(-1*Z))
  puts "d) is true"
else
  puts "d) is false"
end

#e
if !(A && B || !(C &&(!A && B)))
  puts "e) is true"
else
  puts "e) is false"
end

#f
if (X**2 + Y**2 >= 1) && (X>=0) && (Y>=0)
  puts "f) is true"
else
  puts "f) is false"
end

#g
if (A && ((C && B).object_id != (B || A).object_id) && C) || B
  puts "g) is true"
else
  puts "g) is false"
end

puts " TASK 2:"
x= -0.5
y = -1
P = true

if ((y*y-x)>x*x) ||  (Math.cos(x)>0) && !P
  puts " is true"
else
  puts " is false"
end