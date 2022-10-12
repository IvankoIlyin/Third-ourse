
class Reader
  def initialize(surname,orderDate,receivData,bookName)
    @surname=surname
    @orderDate=orderDate
    @receivData=receivData
    @bookName=bookName
  end

  def surname
    return @surname
  end

  def orderDate
    return @orderDate
  end

  def receivData
    return @receivData
  end

  def bookName
    return @bookName
  end

end

class Library

  def initialize
    @readers=Array.new
  end

  def addRaders(reader)
    @readers.push(reader)
  end

  def minTerm
    ans=0.0
    for i in 0...@readers.length-1
      if @readers[i].receivData!=0 && @readers[i+1].receivData!=0
      curr1=@readers[i].receivData-@readers[i].orderDate
      curr2=@readers[i+1].receivData-@readers[i+1].orderDate
      if curr2<curr1
        ans=curr2
      else
        ans=curr1
      end

    end
    end
    puts "minimal term= #{ans}"
  end

  def countNonReceiv
    count=0.0
    for i in 0...@readers.length
      if @readers[i].receivData==0.0
        count+=1.0
      end
    end
    puts"Count of non receiv ordere= #{count}"
  end

  def mostReader
    name=''
    count=0
    for i in 0...@readers.length
      curr=0
      for j in 0...@readers.length
        if @readers[i].surname==@readers[j].surname
          curr+=1
        end
      end
      if curr>count
        count=curr
        name=@readers[i].surname
      end
    end
    puts "The better reader: #{name}"
  end

  def popularBook
    name=''
    count=0
    for i in 0...@readers.length
      curr=0
      for j in 0...@readers.length
        if @readers[i].bookName==@readers[j].bookName
          curr+=1
        end
      end
      if curr>count
        count=curr
        name=@readers[i].bookName
      end
    end
    puts "The most popular book: #{name}"
  end



end

lib = Library.new
reader=Reader.new("Doe",2,6,"Bible")
lib.addRaders(reader)
reader=Reader.new("John",2,8,"Bible")
lib.addRaders(reader)
reader=Reader.new("Doe",2,5,"Koran")
lib.addRaders(reader)
reader=Reader.new("John",2,10,"Koran")
lib.addRaders(reader)
reader=Reader.new("nigger",2,0,"Koran")
lib.addRaders(reader)
reader=Reader.new("John",2,15,"Labuda")
lib.addRaders(reader)
reader=Reader.new("asiat",1,0,"Koran")
lib.addRaders(reader)

lib.minTerm
lib.countNonReceiv
lib.mostReader
lib.popularBook