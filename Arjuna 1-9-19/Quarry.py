l=list(map(int,input().split()))
ans=0
for i in range(1,len(l)-1):
    left=max(l[0:i+1])
    right=max(l[i:len(l)])
    ans+=min(left,right)-l[i]
print(ans)