puts"Task 1"
def f1(x)
  f = ((x**2)-1)*10**(-2*x)
  f.to_f
end
def f2(x)
  f = Math.exp(x) * Math.sin(x)
  f.to_f
end

def prm(a,b,n)
  h = (b-a)/n
  res=0.0
  x=a+h
  while x<=b
    res += h*f1(x)
    x+= h
  end
  return res
end
def trp(a,b,n)
  h=(b-a)/n
  if a==0
    a+=0.00000000000001
  end

  x = a + h
  res =0
  while x<=b
    res += h*(f2(a)+f2(x))/2
    x+= h
  end
  return res
end

puts"Task1.1=#{prm(0.0,0.5,100)}"
puts"Task1.2=#{trp(0.0,Math::PI/2,100)}"

puts"Task2"
def f(x,i)
  y = ((-1)**i*1) * ((Math.sin(i*x))/(i))
  return y
end
def E(x1,x2,n,e)
  step=(x2-x1)/n
  curr=f(x1,1.0)
  res=0.0
  x=x1+step
  while curr>=e && step <= n
    res+=f(x,step)
    x+=step
  end
  return res
end

puts"Task2=#{E(Math::PI/5,4*Math::PI/5,58,0.001)}"