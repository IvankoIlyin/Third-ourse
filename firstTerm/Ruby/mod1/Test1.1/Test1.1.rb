
def function(xb,xe,dx,a,b,c)
  x=xb
  while x<=xe
    if c<0 && x!=0
      f=-1*a*x-c
    elsif c>0&&x==0
      f=(x-a)/-1*c
    else
      f = (b*x)/(c-a)
    end

    if a.to_i!=0 || b.to_i!=0 || c.to_i!=0
      puts "x_i=#{x} : F=#{f}"
    else
      puts "x_i=#{x} : F=#{f.to_i}"
    end

    x+=dx

  end

end

function(0,10,2,4,5,6)