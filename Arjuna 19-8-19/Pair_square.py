import math
import itertools
def isPerfect(x):
	sr=math.sqrt(x)
	return ((sr-math.floor(sr))==0)
l=list(map(int,input().split()))
l1=list(itertools.permutations(l))
l1.sort()
comb=list(k for k,_ in itertools.groupby(l1))
c=0
for i in range(len(comb)):
	flag=0
	for j in range(len(comb[i])-1):
		if(not isPerfect(comb[i][j]+comb[i][j+1])):
			flag=1
			break
	if(flag==0): c+=1
print(c)