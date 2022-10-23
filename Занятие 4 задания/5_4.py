def rang():
    N=int(input())
    fl=1
    for i in range (1,N):
        fl+=i*fl
    print(fl)
rang()