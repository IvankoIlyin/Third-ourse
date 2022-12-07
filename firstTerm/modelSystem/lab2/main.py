import numpy as np
from matplotlib import image
import matplotlib.pyplot as plt
import matplotlib
matplotlib.use('TkAgg')

input_image = np.array(image.imread('x1.bmp'))
output_image = np.array(image.imread('y5.bmp'))
EPS = 1e-10
DELTA = 1e-10


def evaluateApproximation(matrix, delta):
    e = np.identity(matrix.shape[0])
    approximation=np.dot(matrix.T,np.linalg.inv(np.dot(matrix, matrix.T) + (delta ** 2) * e))
    return approximation


def moorePenroseMethod(matrix, start_delta=DELTA, eps=EPS):
    npMatrix = np.array(matrix, float)
    result = evaluateApproximation(npMatrix, start_delta)
    current_delta = start_delta

    while True:
        current_delta /= 2
        prev_result = result
        result = evaluateApproximation(npMatrix, current_delta)

        if np.linalg.norm(result - prev_result) <= eps:
            break

    return result


def grevilleMethod(matrix):
    npMatrix = np.array(matrix, float)
    current_a = npMatrix[0:1]
    result = np.zeros_like(current_a.T)

    if np.count_nonzero(current_a[0] != 0):
        result = current_a.T / np.dot(current_a, current_a.T)

    n = npMatrix.shape[0]

    for i in range(1, n):
        current_a = matrix[i:i + 1]
        z = np.identity(result.shape[0]) - np.dot(result, npMatrix[:i])
        r = np.dot(result, result.T)
        cond_expr = np.dot(np.dot(current_a, z), current_a.T)

        if np.count_nonzero(cond_expr) == 1:
            row_to_add = np.dot(z, current_a.T) / cond_expr
        else:
            row_to_add = np.dot(r, current_a.T) / (1 + np.dot(np.dot(current_a, r), current_a.T))

        result -= np.dot(row_to_add, np.dot(current_a, result))
        result = np.concatenate((result, row_to_add), axis=1)

    return result


moore_penrose = np.dot(output_image, moorePenroseMethod(input_image, DELTA))
greville = np.dot(output_image, grevilleMethod(input_image))

plt.imshow(input_image)
plt.show()
plt.imshow(output_image)
plt.show()
plt.imshow(np.dot(moore_penrose, input_image))
plt.show()
plt.imshow(np.dot(greville, input_image))
plt.show()


