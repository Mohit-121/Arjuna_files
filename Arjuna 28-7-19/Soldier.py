from queue import Queue
deadlock=set(input().split())
final=input()
step=0
q=Queue()
q.put("0000")
q_size=1
while q_size:
  for i in range(q_size):
    current=q.get()

    if current in deadlock:
      continue

    if current == final:
      print(step)
      exit(0)

    deadlock.add(current)
    for j in range(4):
      forward=(int(current[j])+1)%10
      backward=(int(current[j])+9)%10
      for digit in (forward,backward):
        new_digit=''
        for k in range(4):
          if k==j:
            new_digit+=str(digit)
          else:
            new_digit+=current[k]
        q.put(new_digit)

  q_size=q.qsize()
  step+=1

print(-1)
