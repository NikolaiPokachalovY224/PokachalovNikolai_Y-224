def rang():
    N=int(input())
    if N<=9:
        for i in range (1, N+1):
            for g in range (1, i+1):
                print(g, end='')
            print()
    else:
        print('Ошибка! Число должно быть мешьше или равно 9')
rang()