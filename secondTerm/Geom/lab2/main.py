import numpy as np


class RegionNode:
    def __init__(self, points):
        self.points = points
        self.left_child = None
        self.right_child = None
        self.split_dim = None
        self.split_val = None

        # Розбиття регіону на під-регіони
        if len(points) > 1:
            # Знайти розмірність з найбільшою дисперсією
            variances = np.var(points, axis=0)
            self.split_dim = np.argmax(variances)

            # Знайти значення, яке розділить під-регіони
            self.split_val = np.median(points[:, self.split_dim])

            # Розділити точки на дві під-групи
            left_points = points[points[:, self.split_dim] <= self.split_val]
            right_points = points[points[:, self.split_dim] > self.split_val]

            # Рекурсивно створити дочірні під-регіони
            if len(left_points) > 0:
                self.left_child = RegionNode(left_points)
            if len(right_points) > 0:
                self.right_child = RegionNode(right_points)

    def is_leaf(self):
        return self.left_child is None and self.right_child is None


class RegionTree:
    def __init__(self, points):
        self.root = RegionNode(points)

    def search(self, point):
        current_node = self.root
        while not current_node.is_leaf():
            if point[current_node.split_dim] <= current_node.split_val:
                current_node = current_node.left_child
            else:
                current_node = current_node.right_child
        return current_node.points


# Масив точок
X = np.array([[0, 0], [1, 1], [2, 2], [3, 3]])

# Створення дерева регіонів
tree = RegionTree(X)

# Точка, яку ми хочемо перевірити на належність регіону
y = np.array([1.5, 0.5])

# Знаходимо регіон, до якого належить точка y
region = tree.search(y)

# Виводимо регіон
print(region)

