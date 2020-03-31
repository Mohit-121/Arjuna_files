s=input()
x=''
for i in range(len(s)-1):
    x+=s[i]
    y=int(x)
    temp=''
    while(len(temp)<len(s)):
        temp+=str(y)
        y+=1
    if(s==temp):
        print("YES", x)
        break
else:
    print("NO")
