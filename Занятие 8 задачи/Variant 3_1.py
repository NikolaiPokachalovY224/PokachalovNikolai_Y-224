import math
def treug1(a,b):
    gipoten = (math.sqrt(a ** 2 + b ** 2))
    return(gipoten)

def treug2(a,b):
    gipoten = (math.sqrt(a ** 2 + b ** 2))
    return (gipoten)

def gipot():
    if treug1(7,3)>treug2(7,3):
        print('Гипотенуза первого треугольника больше гипотенузы второго')
    elif treug1(7,3)==treug2(7,3):
        print('Гипотенузы данных треугольников равны')
    else:
        print('Гипотенуза второго треугольника больше гипотенузы первого')
gipot()
