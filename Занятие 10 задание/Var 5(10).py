import json
import random
def matrsort():
    N, M = 3, 3
    f = open('Pokachalov_Y-224_vvod.txt', encoding='utf-8')
    a1 = (int(f.readline()))
    b = (int(f.readline()))
    c = (int(f.readline()))
    f.close()
    a = [[random.randrange(a1, b, c) for i in range(M)] for i in range(N)]
    G=(list([(1 if min(i)
                 else 0)
                if j == min(i)
                else j 
                for j in i]
               for i in a))
    f1 = ''
    for i in G:
        f1 += str(i) + " "
    print(f1)
    f = open('Pokachalov_Y-224_vivod.txt', 'w')
    f.write(f1)
    f.close()
matrsort()