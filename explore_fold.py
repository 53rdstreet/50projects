import functools 

def dictify_(dict):
    result = {}
    for k, v in dict:
        result.update({k: v})
    return result
dict_a = dictify_([("A", 1), ("B", 2), ("C", 3)])
print(dict_a)

def concat_(xs):
    result = ""
    for x in xs:
        result += str(x)
    return result
concat_a = concat_([("A"), ("M"), ("B"), ("O"),("O")])
print(concat_a)

result0 = functools.reduce(lambda acc, item: acc + item, [1, 2, 3, 4, 5])
result1 = functools.reduce(lambda acc, item: acc * item, [1, 2, 3, 4, 5])
result2 = functools.reduce(lambda acc, item: acc + str(item), [1, 2, 3, 4, 5], "")
result3 = functools.reduce(lambda acc, item: {**acc, item[0]: item[1]}, [("A", 1), ("B", 2), ("C", 3)], {})
result4 = functools.reduce(lambda acc, item: {**acc, item[0]: item[1]}, [("A", 1), ("B", 2), ("C", 3)], {})

print(result0)
print(result1)
print(result2)
print(result3)
print(result4)