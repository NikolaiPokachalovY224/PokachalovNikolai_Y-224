def maxim():
    m=int(input())
    if m==0:
        return int()
    return max([m, maxim()])
print(maxim())