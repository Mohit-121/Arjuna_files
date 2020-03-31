def mincostPass(days,costs):
  ans=[0]*366              #ans is used to store ans
  for i in range(1,366):
    if (i not in days): ans[i] = ans[i - 1]    #Non travel day cost is same as previous day
    #On travel day it is minimum of yesterday's cost plus single-day ticket,
    # or cost for 8 days ago plus 7-day pass, or cost 31 days ago plus 30-day pass
    else:
        ans[i] = min(ans[i - 1] + costs[0], ans[max(0, i - 7)] + costs[1], ans[max(0, i - 30)] + costs[2])
  return ans[365]    #Last day of the year gives the minimum cost

days=list(map(int,input().split()))   #Takes days array
cost=list(map(int,input().split()))   #Takes cost daily,weekly and monthly
print(mincostPass(days,cost))