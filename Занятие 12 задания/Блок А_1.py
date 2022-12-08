def a(x,n):
    def b(n):
        if n<1:
            return 1
        else:
            return n * b(n-1)
    return x**n/b(n)
print(a(7,4))