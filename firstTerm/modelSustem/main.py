import matplotlib
import matplotlib.pyplot as plt
import numpy as np
import scipy.fft as fft
from scipy.signal import argrelextrema
import math

T = 5.0
dt = 0.01
df = 1.0 / T

file = open("f5.txt", "r")

data = [float(x) for x in file.read().split(" ")]

file.close()

xAxis = np.arange(0, T + dt, dt)

plt.plot(xAxis, data)
plt.show()

# Fourier transform

N = len(data)
frequencies = [x * df for x in range(0, (int)(N / 2))]
fourierTransform = np.zeros(N, dtype='complex_')

for i in range(0, N):
    for j in range(0, N):
        fourierTransform[i] += 1.0 / N * data[j] * (math.cos(-1 * 2 * math.pi * i * j / N) + complex(0, 1) * math.sin(-1 * 2 * math.pi * i * j / N))

fourierTransform = np.abs(fourierTransform)
plt.plot(frequencies, fourierTransform[0: int(N / 2)])
plt.show()

fourierTransformHalf = fourierTransform[0:int(N / 2) - 1]
localMaximums = np.array(argrelextrema(fourierTransformHalf, np.greater))

maxFrequencies = localMaximums / T

sinFunc = np.sin(2 * np.pi * maxFrequencies[0][0] * xAxis)
data = np.array(data)

A = np.array([
    np.array([
        np.sum(xAxis ** 6),
        np.sum(xAxis ** 5),
        np.sum(xAxis ** 4),
        np.sum(sinFunc * xAxis ** 3),
        np.sum(xAxis ** 3)]),
    np.array([
        np.sum(xAxis ** 5),
        np.sum(xAxis ** 4),
        np.sum(xAxis ** 3),
        np.sum(sinFunc * xAxis ** 2),
        np.sum(xAxis ** 2)]),
    np.array([
        np.sum(xAxis ** 4),
        np.sum(xAxis ** 3),
        np.sum(xAxis ** 2),
        np.sum(sinFunc * xAxis),
        np.sum(xAxis)]),
    np.array([
        np.sum(sinFunc * xAxis ** 3),
        np.sum(sinFunc * xAxis ** 2),
        np.sum(sinFunc * xAxis),
        np.sum(sinFunc * sinFunc),
        np.sum(N * sinFunc)]),
    np.array([
        np.sum(xAxis ** 3),
        np.sum(xAxis ** 2),
        np.sum(xAxis),
        np.sum(sinFunc * N), N]),
])

c = np.array([
    np.sum(data * xAxis ** 3),
    np.sum(data * xAxis ** 2),
    np.sum(data * xAxis),
    np.sum(data * sinFunc),
    np.sum(data)
])

res = np.matmul(np.linalg.inv(A), c)

print("coefficients:")
print(res)
