# 1
print("Курс Основы программирования начался")

#2
a=16823 * 12302
b=3092
c=a%b
print(c)

#3
name="Иван"
nameNedop="Иван"
age=17
if name == nameNedop:
    print("Недопустимое имя")
elif age<=0 or age>=75:
    print("Недопустимый возраст")
elif age>=16:
    print("Поздравляем вы поступили в ВГУИТ")
else:
    print("Сначала нужно окончить школу! Осталось учиться:",16-age,"лет")

#4
seconds=86400
print(seconds,"Секунд равно:", seconds/60, "Минут;", seconds/3600, "Часов;", seconds/86400, "Дней.")

#5
n=5
n = n + n**2 + n**3 + n**4 + n**5
print(n)

#6
x=1235
y=2
print('x =',x,'y =',y)
с=0
c=x
x=y
y=c
print('x =',x,'y =',y)

#7
number=44
if number%2 == 0:
    print('Чётное')
else:
    print('Нечётное')