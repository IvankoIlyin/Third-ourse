
x = [114,147,167,224,227,373,441,456,453,453,425,382,330,290,300,238,197,151,105,104,114]
y = [146,106,84,56,47,41,45,101,147,213,245,270,273,248,199,195,212,209,190,163,146]

v=0.0

for i in 0...x.length-1
  v+=(x[i]+x[i+1])*(y[i]-y[i+1])

end
v=(v.abs)/2
puts "Answer= #{v}"


