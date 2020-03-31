def encode(s):
    #ans stores for every substring i to j what is the encoded string
    ans=[["" for i in range(len(s))]for j in range(len(s))]
    #i,j,l denotes start,end and length of intermediate string respectively
    for l in range(0,len(s)):
        for i in range(len(s)-l):
            j=i+l
            sub=s[i:j+1]
            #if j-i < 4 then we encoding is not possible
            if(j-i<4): ans[i][j]=sub
            else:
                ans[i][j]=sub
                # this loop keeps track of all seqs which are repeating in subseq
                # from i to j, if they are formed in such a way that lenght of that
                # encoded sequence is less than ans at i,j then we replace it with the
                # encoded sequence
                for k in range(len(sub)):
                    subseq=sub[0:k+1]
                    if(len(sub)%len(subseq)==0):
                        div=len(sub)//len(subseq)
                        if(subseq*div==sub):
                            ansseq=str(div)+'['+ans[i][i+k]+']'
                            if(len(ansseq)<len(ans[i][j])):
                                ans[i][j]=ansseq

                for k in range(i,j):
                    subpart=ans[i][k]+ans[k+1][j]
                    if(len(subpart)<len(ans[i][j])):
                        ans[i][j]=subpart
    for i in ans:
        for j in i:
            print(j,end="\t")
        print()
    #return the best possible sequence which is present at ans[0][len(s)-1]
    return ans[0][len(s)-1]

s=input()
print(len(s))
print(encode(s))



