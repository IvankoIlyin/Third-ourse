# Локалізація точки на планарному розбитті методом ланцюгів

import matplotlib.pyplot as plt

def IsInPolygonChainMethod(point, polygon):
    n = len(polygon)
    cnt = 0
    p1x, p1y = polygon[0]
    for i in range(0, n+1):
        p2x, p2y = polygon[i % n]
        if point[1] > min(p1y, p2y):
            if point[1] <= max(p1y, p2y):
                if point[0] <= max(p1x, p2x):
                    if p1y != p2y:
                        xinters = (point[1]-p1y)*(p2x-p1x)/(p2y-p1y)+p1x
                    if p1x == p2x or point[0] <= xinters:
                        cnt += 1
        p1x, p1y = p2x, p2y
    return cnt%2!=0

polygon = [(0, 0), (0, 5), (5, 5), (5, 0)]

points = [(1, 1), (2, 3), (4, 4), (6, 3), (-1, 1)]

x, y = zip(*(polygon + [polygon[0]]))
plt.plot(x, y)

for point in points:
    if IsInPolygonChainMethod(point, polygon):
        plt.scatter(point[0], point[1], color='green')
    else:
        plt.scatter(point[0], point[1], color='red')

plt.show()

