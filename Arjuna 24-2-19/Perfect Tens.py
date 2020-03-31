x=int(input())
y=int(input())
k=0;lt=[]
for i in range(y):
    s=input()
    if(s=='H'*x):
        k+=1
        lt.append(k)
    else:
        k=0
        lt.append(k)
lt.sort()
print(lt[-1])
