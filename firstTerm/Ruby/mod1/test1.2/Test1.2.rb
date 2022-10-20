class Abiturient
  def initialize(id,name,surname,patroname,numder,grades)
    @id=id
    @name=name
    @surname=surname
    @patroname=patroname
    @numder=numder
    @grades=grades
  end

  def grades()
    return @grades
  end

  def sumOfGrades()
    sum=0
    for i in 0...@grades.length
      sum+=@grades[i]
    end
    return sum
  end

  def print()
    puts "#{@id}: #{@name} #{@surname} #{@patroname} #{@numder}"
  end


end

def poorGrades(abiturients)
  for i in 0...abiturients.length
    k=0
    for j in 0...abiturients[i].grades.length
      if abiturients[i].grades[j]<=4
        k+=1
      end
    end
    if k!=0
      abiturients[i].print
    end
  end
end

def gradesMoreThen(abiturients,x)
  for i in 0...abiturients.length
    if abiturients[i].sumOfGrades>x
      abiturients[i].print
    end
  end
end

def topN(abiturients,n)
  abiturients = abiturients.sort{|a,b| b.sumOfGrades <=> a.sumOfGrades}
  if n<abiturients.length
    for i in 0...n
      abiturients[i].print
    end
  else
    for i in 0...abiturients.length
      abiturients[i].print
    end
  end
end

def halfGood(abiturients,x)
  x=x/2
  for i in 0...abiturients.length
    if abiturients[i].sumOfGrades>=x
      abiturients[i].print
    end
  end
end

abit1=Abiturient.new(1,'Ivan','Petrov','Maksimovich','+228-1337-228',[7,7,7])
abit2=Abiturient.new(2,'Dima','Kuzenko','Genadich','+1488-1613-335',[1,10,12])
abit3=Abiturient.new(3,'Pavlo','Bere','Trohimich','+34342-452-432',[10,10,12])
abit4=Abiturient.new(4,'Marichka','Golova','Podyemovna','+666-666-666',[10,3,11])

abiturients = [abit1,abit2,abit3,abit4]
puts "Task a"
poorGrades(abiturients)
puts "Task b"
gradesMoreThen(abiturients,30)
puts "Task c 1.1"
topN(abiturients,2)
puts "Task c 1.2"
halfGood(abiturients,50)