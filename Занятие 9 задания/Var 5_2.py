import random
def matrsort():
    N, M = 3, 3
    a = [[random.randrange(1, 10, 1) for i in range(M)] for i in range(N)]
    print(list([(1 if min(i)
                 else 0)
                if j == min(i)
                else j 
                for j in i]
               for i in a))
matrsort()