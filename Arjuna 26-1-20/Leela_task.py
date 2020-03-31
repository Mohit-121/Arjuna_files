def check(l,f):
    s=set()
    while(f!=0):
        d=f%10
        f=f//10
        if(d not in l):
            return False
        else:
            s.add(d)
    return len(s)==len(l)
n=int(input())
l=list(map(int,input().split()))
x=int(input())
mult=1
flag=0
while(True):
    f=x*mult
    if(f>999999999):
        break
    if(check(l,f)):
        print(f,mult)
        flag=1
        break
    mult+=1
if(flag==0): print(-1)