def sameDiff(l):                     #function to check if difference is same
	dif=set()
	for i in range(1,len(l)):
		dif.add(l[i]-l[i-1])
	return len(dif)==1                #If set contains only 1 diff return true              

c=0                                     #No of possible ladders
l=list(map(int,input().split()))        #lengths of ladders
for i in range(3,len(l)+1):
    for j in range(len(l)-i+1):          #Starting from length 3 to generate all possible ladders
    	if(sameDiff(l[j:j+i])):          #If difference is same increment count
    		c+=1
print(c)
