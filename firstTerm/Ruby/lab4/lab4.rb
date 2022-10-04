
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


puts 'TASK 2'
A=Array.new(8).map!{Array.new(8)}
B=Array.new(8).map!{Array.new(8)}
S=Array.new(8).map!{Array.new(8)}
for i in 0...8
  for j in 0...8
    if i==j
      A[i][j]=1
      B[i][j]=1
    else
      A[i][j]=rand(10)
      B[i][j]=rand(10)
    end
  end
end
puts 'Matrix A'
for i in 0...8
  for j in 0...8
    print "#{A[i][j]} "
    if j==7;
      puts " "
    end
  end
end
puts 'Matrix B'
for i in 0...8
  for j in 0...8
    print "#{B[i][j]} "
    if j==7;
      puts " "
    end
  end
end
puts "A*B"
for i in 0...A.length
  for j in 0...B.length
    S[i][j]=0
    for k in 0...S.length
      S[i][j]=S[i][j] + A[i][k]*B[k][j]
    end
  end
end
for i in 0...8
  for j in 0...8
    print "#{S[i][j]} "
    if j==7;
      puts " "
    end
  end
end

puts 'TASK 3'
puts "Enter n"
n=gets.chomp.to_i
m=Array.new(n).map!{Array.new(n)}
b=Array.new(n)
for i in 0...n
  for j in 0...n
    if i==j
      m[i][j]=2

    else
      m[i][j]=6
    end
  end
end
puts 'Matrix A'
for i in 0...n
  for j in 0...n
    print "#{m[i][j]} "
    if j==n-1;
      puts " "
    end
  end
end
for i in 0...n
  b[i]=i+1
end
puts "Vecor b"
for i in 0...n
  puts b[i]
end
x=Array.new(n)

for k in 0...(n-1)
  akk=m[k][k]
  for j in k...n
    m[k][j]=m[k][j]/akk
  end
    b[k]=b[k]/akk
    g=k+1
    for i in g...n
      for j in g...n
      m[i][j] = m[i][j] - m[i][k] * m[k][j]
      end
      b[i] = b[i] - m[i][k] * b[k]
    end
  end
x[n-1]=b[n-1]/m[n-1][n-1]
k=n-2
while k<=0
  x[k]=b[k]
  m=n-2
  while m<=k
    x[k]=x[k]-m[k][m+1]*x[m+1]
    m-=1
  end
  k-=1
end

for i in 0...n
  puts "x[#{i+1}] = #{x[i]}"
end