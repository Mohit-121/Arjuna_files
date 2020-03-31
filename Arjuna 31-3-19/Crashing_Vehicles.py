import math as m
l=[int(i) for i in input().split()]
i=0;
while(i<len(l)-1):
    if(l[i]/m.fabs(l[i])==1 and l[i+1]/m.fabs(l[i+1])==-1):
        if(l[i]==m.fabs(l[i+1])):
            l.remove(l[i+1])
            l.remove(l[i])
        elif(l[i]>m.fabs(l[i+1])):
            l.remove(l[i+1])
        else:
            l.remove(l[i])
    else:
        i+=1
if(len(l)==0): print(-1)
else: print(l)