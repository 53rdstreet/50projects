import functools 

result = functools.reduce(lambda acc, item: acc + item, [1, 2, 3, 4, 5])
result1 = functools.reduce(lambda acc, item: acc * item, [1, 2, 3, 4, 5])

print(result)
print(result1)