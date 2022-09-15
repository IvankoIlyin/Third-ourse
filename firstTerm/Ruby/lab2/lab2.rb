#part 1
x = [114,147,167,224,227,373,441,456,453,453,425,382,330,290,300,238,197,151,105,104,114]
y = [146,106,84,56,47,41,45,101,147,213,245,270,273,248,199,195,212,209,190,163,146]

v=0.0

for i in 0...x.length-1
  v+=(x[i]+x[i+1])*(y[i]-y[i+1])

end
v=(v.abs)/2
puts "part 1 Answer= #{v}"


#part 2
P = 5
t = 8
r = 0
Diap = (P**r)*(1-(P**-t))
puts "part 2 Answer= #{Diap.to_f}"

#part 3
dv1 = '111100010011'
des1 = 0

for i in 0...dv1.length
  des1 += (dv1[i].to_i) * 2**(dv1.length-i-1)
end
puts "part 3 Answer= #{des1}"

#part 4
des2 = 334
dv2 = ''
while des2>0
  if des2 % 2 == 0
    dv2+='1'
    des2/=2
  else
    dv2+='0'
    des2 = des2/2 -1
  end

end
puts "part 4 Answer= #{dv2}"