def blocks(l):
    tans=[0]*len(l)
    i=0
    for elem in l:
        left=elem[0];size=elem[1]
        right=left+size
        tans[i]+=size
        for j in range(i+1,len(l)):
            left2,size2=l[j]
            if left2<right:
                tans[j]=max(tans[j],tans[i])
        i+=1
    ans=[]
    for i in tans:
        ans.append(max(ans[-1],i)if ans else i)
    return ans

n=int(input())
l=[]
for i in range(n):
    l1=list(map(int,input().split()))
    l.append(l1)
ans=blocks(l)
print(*ans)