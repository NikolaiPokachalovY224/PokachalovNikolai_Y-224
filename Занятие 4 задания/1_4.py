def rang():
    A = int(input())
    B = int(input())
    if A > B:
        for i in range(A, B-1, -1):
            if i%2==1:
                print(i)
    else:
        print('Ошибка! Число А должно быть больше чем число В')
rang()