n,m=map(int,input().split())          #no of stones and no of pairs required
l=list(map(int,input().split()))       #no of stones of each type
l.sort(reverse=True)                   
ecount=0                    #Keep track of even count to adjust them later
ans=0
for i in range(n):
    if(l[i]//2>=m):                   #If we got desired pair, then ans will be adjusted as
        ans+=m*2+(n-i-1)+ecount       #value of ecount and no of stones from that element required to get desired pairs 
        m=0
        break
    else:
        ans+=l[i]                     #If not keep adding all stones and accordingly
        if(l[i]%2==0):                #adjust even count
            ecount+=1
        m-=l[i]//2
if(m!=0):                          #If no of pairs required at the end is non-zero print(-1)
    print(-1)
else:
    print(ans)                  #else print no of stones