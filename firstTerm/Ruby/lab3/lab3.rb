puts " TASK 1.1:"
A=false
B=false
C=true
X=60
Y=-10
Z=4
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


puts " TASK 1.2:"
x= -0.5
y = -1
P = true
if ((y*y-x)>x*x) ||  (Math.cos(x)>0) && !P
  puts " is true"
else
  puts " is false"
end


puts " TASK 2:"
y=0
puts "enter x"
x = gets.chomp.to_f

if x > -4.0  && x<=0.0
  y = (((x-2.0).abs)/((x**2.0)*Math.cos(x)))**(1.0/7.0)
end
if x>0.0 && x<12.0
  y = 1.0 / ((Math.tan(x+(1.0/Math.exp(x))))/(Math.sin(x))**2.0)**(2.0/7.0)

end
if x<-4.0 && x>12.0
  y = 1.0 / (1.0+(x/(1.0+(x/(1.0+x)))))
end
case x
when -4.0..0.0 then
  y = (((x-2.0).abs)/((x**2.0)*Math.cos(x)))**(1.0/7.0)
when 0...12 then
  y = 1.0 / ((Math.tan(x+(1.0/Math.exp(x))))/(Math.sin(x))**2.0)**(2.0/7.0)
when x<-4 then
  y = 1.0 / (1.0+(x/(1.0+(x/(1.0+x)))))
when x>12
  y = 1.0 / (1.0+(x/(1.0+(x/(1.0+x)))))

end
puts "y= #{y}"


puts " TASK 3:"
puts "Enter n"
n = gets.chomp.to_f
s =0.0
ans=0.0
for i in 1..n
  ans+=1/(s+Math.sin(i))
end
puts "Answer= #{ans}"


puts " TASK 4:"
def factorial n
  n > 1.0 ? n * factorial(n - 1.0) : 1.0
end
e = 0.00001
ans = 0.0
n=2.0
t=0.0
while t < e
  t = ( factorial(n-1.0) / factorial(n+1.0) )**(n*(n+1.0))
  ans+= t
  n+=1.0
end
puts "Answer1= #{ans}"

e = 0.00001
ans = 0.0
n=1.0
t=0.0
while t < e
  t = ((-1)**n) * (1/n**2)
  ans+= t
  n+=1.0
end
if ans == ((Math::PI)**2)/12
  puts "Answer2= true"
else
  puts "Answer2= false"
end


e = 0.00001
ans = 0.0
n=1.0
t=0.0
while t < e
  t = ( (factorial(3*n-1)) * (factorial(3*n)) )/ ( (factorial(4*n)) * (3**(2*n)) * (factorial(2*n)) )
  ans+= t
  n+=1.0
end
puts "Answer3= #{ans}"


puts " TASK 5:"
puts "Enter N"
h=gets.chomp.to_f
puts "Enter c"
c=gets.chomp.to_f
x=1.0
stp = h/(h+c)
puts "Answer1:"
1.0.step(h, stp) do
  y = ( (2.0*x**(-1.0/3.0)) / ((x**(2.0/3.0))) - (3*x**(-1.0/3.0)) ) - ( (x**(2.0/h)) / ( (x**(5.0/3.0)) - ((x**(2.0/h)) ) ) - ( (x+1.0) / ((x**2.0) - 4.0*x +3.0) ))
  x+=stp
  puts y
end

puts "Enter N"
h=gets.chomp.to_f
puts "Enter c"
c=gets.chomp.to_f
x=(Math::PI)/h
stp = Math::PI/(3.0*(h+c)/2.0)
puts "Answer2:"
((Math::PI)/h).step(Math::PI, stp) do
  z = (Math.sin( (9.0*Math::PI/8.0) + (x/4.0) )**2.0) - (Math.sin( (7.0*Math::PI/h) + (x/(c**x)))**2.0)  + (Math.tan(2.0*x - 1)**(-1.0/x))
  x+=stp
  puts z
end

puts "Enter N"
h=gets.chomp.to_f
puts "Enter c"
c=gets.chomp.to_f
x=2.0
stp = c/(2*h)
puts "Answer3:"
2.0.step(c, stp) do
  if x>2 && x<h
    f =  ( (2.0*x**(-1.0/3.0)) / ((x**(2.0/3.0))) - (3*x**(-1.0/3.0)) ) - ( (x**(2.0/h)) / ( (x**(5.0/3.0)) - ((x**(2.0/h)) ) ) - ( (x+1.0) / ((x**2.0) - 4.0*x +3.0) ))
    puts f
  end
  if x>h && x<2*h
    f = (Math.sin( (9.0*Math::PI/8.0) + (x/4.0) )**2.0) - (Math.sin( (7.0*Math::PI/h) + (x/(c**x)))**2.0)  + (Math.tan(2.0*x - 1)**(-1.0/x))
    puts f
  end
  x+=stp

end




