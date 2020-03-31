vote=list(map(int,input().split()))
time=list(map(int,input().split()))
total_time=[-1]*max(time)
req_time=list(map(int,input().split()))
c=0;a=-1;z=0;o=0
for i in range(len(total_time)):
  if(time[c]>i):
    total_time[i]=a
  elif(time[c]==i):
    if(vote[c]==0):
      z+=1
      if(o>z): a=1
      else: a=0
    elif(vote[c]==1):
      o+=1
      if(z>o): a=0
      else: a=1
    total_time[i]=a
    c+=1

for i in req_time:
  if(i>=max(time)):
    print(total_time[-1],end=' ')
  else: print(total_time[i],end=' ')
