def maxh(l,item):
    h=0
    for i in l:
        if(i[0]<item[0] and i[1]<item[1]):
            h+=1
            item=i
    return h
r=int(input())
l=[list(map(int,input().split()))for i in range(r)]
l.sort(key=lambda x: (x[0],x[1]),reverse=True)
h=0
for i in l:
    h=max(maxh(l,i),h)
print(h+1)