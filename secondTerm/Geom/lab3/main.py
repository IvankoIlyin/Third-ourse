import heapq
import matplotlib.pyplot as plt




class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def __repr__(self):
        return f"({self.x}, {self.y})"

    def __lt__(self, other):
        return self.x < other.x or (self.x == other.x and self.y < other.y)



# Клас для відрізків
class Line:
    def __init__(self, start, end):
        self.start = start
        self.end = end

    def __repr__(self):
        return f"[{self.start}, {self.end}]"

    def is_horizontal(self):
        return self.start.y == self.end.y

    def is_above(self, point):
        return self.start.y > point.y and self.end.y > point.y

    def is_below(self, point):
        return self.start.y < point.y and self.end.y < point.y

    def intersection(self, other):
        if self.is_horizontal() or other.is_horizontal():
            return None

        x1, y1 = self.start.x, self.start.y
        x2, y2 = self.end.x, self.end.y
        x3, y3 = other.start.x, other.start.y
        x4, y4 = other.end.x, other.end.y

        x_num = (x1*y2-y1*x2)*(x3-x4)-(x1-x2)*(x3*y4-y3*x4)
        y_num = (x1*y2-y1*x2)*(y3-y4)-(y1-y2)*(x3*y4-y3*x4)
        den = (x1-x2)*(y3-y4)-(y1-y2)*(x3-x4)

        if den == 0:
            return None

        x = x_num/den
        y = y_num/den

        if (x < max(min(x1, x2), min(x3, x4))
            or x > min(max(x1, x2), max(x3, x4))
            or y < max(min(y1, y2), min(y3, y4))
            or y > min(max(y1, y2), max(y3, y4))):
            return None

        return Point(x, y)

def sort_lines(lines):
    lines_tuples = sorted(lines, key=lambda t: t[0])
    return lines_tuples



def find_intersections(lines):
        curr = []
        for line in lines:
            curr.append((line.start.x, ("left", line)))
            curr.append((line.end.x, ("right", line)))
        events=sort_lines(curr)

        active = []
        intersections = []

        for event in events:
            x, data = event
            if data[0] == "left":
                line = data[1]
                for other in active:
                    intersection = line.intersection(other)
                    if intersection is not None:
                        intersections.append(intersection)
                heapq.heappush(active, line)
            else:
                # Видалити відрізок зі списку активних відрізків та перевірити перетин між сусідніми відрізками у списку
                line = data[1]
                active.remove(line)
                for i, other in enumerate(active):
                    intersection = line.intersection(other)
                    if intersection is not None:
                        intersections.append(intersection)
                    if i == len(active) - 1:
                        break
                    # Перевірити перетин з чергуючим відрізком у списку, якщо відрізки невпорядковані за y-координатою
                    if active[i + 1].start.y < line.end.y:
                        intersection = line.intersection(active[i + 1])
                        if intersection is not None:
                            intersections.append(intersection)
                heapq.heapify(active)

            return intersections



lines = [
Line(Point(0, 0), Point(3, 3)),
Line(Point(2, 0), Point(2, 3)),
Line(Point(0, 2), Point(3, 2)),
Line(Point(0, 3), Point(3, 0)),
Line(Point(4, 4), Point(6, 6))
]

intersections = find_intersections(lines)

# Показати відрізки та їх перетини на графіку
fig, ax = plt.subplots()
for line in lines:
    ax.plot([line.start.x, line.end.x], [line.start.y, line.end.y], 'bo-')
for point in intersections:
    ax.plot(point.x, point.y, 'ro')
ax.set_xlim([-1, 7])
ax.set_ylim([-1, 7])
ax.set_aspect('equal')
plt.show()