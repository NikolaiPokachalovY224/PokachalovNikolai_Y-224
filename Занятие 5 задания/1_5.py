def delit():
    n=int(input())
    if n<2:
        print('Неверное число')
    elif n%2==0:
        print(2)
    elif n%3==0:
        print(3)
    elif n%4==0:
        print(4)
    elif n%5==0:
        print(5)
    elif n%6==0:
        print(6)
    elif n%7==0:
        print(7)
    elif n%8==0:
        print(8)
    elif n%9==0:
        print(9)
    else:
        print(n)
delit()