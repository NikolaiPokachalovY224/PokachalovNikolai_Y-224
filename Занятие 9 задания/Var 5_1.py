import random
def matrsort():
    N, M = 3, 3
    a = [[random.randrange(20, 30, 1) for i in range(M)] for i in range(N)]
    for i in a:
        print(*sorted(i))
matrsort()
