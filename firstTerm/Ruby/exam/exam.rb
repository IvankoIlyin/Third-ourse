

class Note
  def initialize(title, tag,importan)
    @time = Time.now.utc
    @edit_time = nil
    @title = title
    @tag = tag
    @importan = importan
  end

  def time
    return @time
  end

  def title
    return @title
  end

  def tag
    return @tag
  end

  def important
    return @importan
  end

end


class Picture<Note
  def initialize(title, tag, importan)
    super
    @src
  end

  def set_src(src)
    @src=src
  end

  def edit(src)
    @src=src
    @edit_time=Time.now.utc
  end

  def print
    puts"title: #{@title}"
    puts"tag: #{@tag}"
    puts"created time: #{@time}"
    puts"src: #{@src}"
    puts"importan: #{@importan}"
    puts"edit time: #{@edit_time}"
    puts"------------------------------"
  end

end

class Text<Note
  def initialize(title, tag, importan)
    super
    @text
  end

  def set_text(text)
    @text=text
  end

  def edit(text)
    @text=text
    @edit_time=Time.now.utc
  end

  def print
    puts"title: #{@title}"
    puts"tag: #{@tag}"
    puts"created time: #{@time}"
    puts"text: #{@text}"
    puts"importan: #{@importan}"
    puts"edit time: #{@edit_time}"
    puts"------------------------------"
  end

end

class List<Note
  def initialize(title, tag, importan)
    super
    @list = Array.new
  end

  def set_list(list)
    @list=list
  end

  def edit(list)
    @list=list
    @edit_time=Time.now.utc
  end

  def print
    puts"title: #{@title}"
    puts"tag: #{@tag}"
    puts"created time: #{@time}"
    puts"list: #{@list}"
    puts"importan: #{@importan}"
    puts"edit time: #{@edit_time}"
    puts"------------------------------"
  end

end



class Content
  def initialize()
    @notes = Array.new
  end

  def add_note(note)
    @notes.push(note)
  end

  def print
    for i in 0..@notes.length
      @notes[i].print
    end
  end

  def find_by_tag(tag)
    for i in 0..@notes.length
      if @notes[i].tag==tag
        puts"Note with tag #{tag}:"
        @notes[i].print
      end
    end
  end

  def find_by_time(beg_time, end_time)
    for i in 0..@notes.length
      if @notes[i].time>=beg_time && @notes.time<=end_time
        puts"Note with time from #{beg_time} to #{end_time}:"
        @notes[i].print
      end
    end
  end

  def sort_by_title
    @notes=@notes.sort{|a,b| a.title<=>b.title}
  end

  def sort_by_important
    @notes = @notes.sort{|a,b| a.important <=> b.important}
  end

  def sort_by_edit_time
    @notes.sort_by(&:edit_time)
  end

end


content = Content.new
note =Text.new("about my suicide", "suicide",1)
note.set_text("this will happen on my ex girlfriend's birthday")
content.add_note(note)
note =Text.new("suicide note", "suicide",1)
note.set_text("burn my body and scatter the ashes under the cherry blossoms")
content.add_note(note)
note =Text.new("winter", "life",3)
note.set_text("it's a cold winter now, the frost grabbed a direwolf")
content.add_note(note)
note =Text.new("my amnesia", "life",3)
note.set_text("I don't remember names anymore")
content.add_note(note)


pic = Picture.new("my ex girlfriend's","suicide", 5 )
pic.set_src("Avrora.png")
content.add_note(pic)
pic = Picture.new("my friend ","life", 6 )
pic.set_src("Glebovski.png")
content.add_note(pic)
pic = Picture.new("building layout","affairs", 2)
pic.set_src("schema.png")
content.add_note(pic)

list = List.new("purchases","affairs",3)
list.set_list(["apple","glock","wine","cigarettes"])
content.add_note(list)
list = List.new("targets","affairs",1)
list.set_list(["enter the tower","go to the main office","send a letter to family and friends","blow up the building"])
content.add_note(list)

pic.edit("schema2.png")
note.edit("I don't remember names & nickname anymore")
list.edit(["enter the tower","go to the main office","send a letter to family and friends","blow up the building","be happy"])

#content.find_by_tag("suicide")
#content.find_by_time(Time.new(2022,12,8,13,0,0),Time.now)
#content.sort_by_title
#content.sort_by_edit_time
content.print



