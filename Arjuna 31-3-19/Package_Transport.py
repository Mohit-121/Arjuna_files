p=[int(i) for i in input().split()]
n=int(input())
p.sort()
i=0;j=len(p)-1
count=0
while i<=j:
    count+=1
    if(p[i]+p[j]<=n):
        i+=1
    j-=1
print(count)