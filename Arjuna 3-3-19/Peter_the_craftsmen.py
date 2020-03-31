n,w=[int(i) for i in input().split(' ')]
wast=0;total=0;res=0;
for i in range(1,n):
    total=i;
    z=i;   #temp variable
    wast=0;
    while(z>=1):
        wast+= (z/w)-int(z/w)
        total += int(z / w)
        z=int(z/w)
    if(total+(wast)>=n):
        res=i;
        break;
print(res)