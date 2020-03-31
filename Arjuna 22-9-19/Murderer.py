v,e=list(map(int,input().split()))
con=[[0 for i in range(v+1)]for i in range(v+1)]
for i in range(e):
    l1=list(map(int,input().split()))
    con[l1[0]][l1[1]]=1
for i in range(1,v+1):
    count=0
    for j in range(1,v+1):
        if(con[i][j]==0): count+=1
    if(count==v):
        print(i)
        exit(0)
print(-1)