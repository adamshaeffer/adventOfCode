def removeDupe(arr):
    i = 0
    while(i < len(arr)-1):
        j = i + 1
        # if(i%10000 == 0):
            # print(i)
        while(j < len(arr)):
            if(arr[i] == arr[j]):
                arr.pop(j)
                j -= 1
            j += 1
        i += 1
# inputs for the trial
# sensX = [ 2, 9,13,12,10,14, 8, 2, 0,20,17,16,14,20]
# sensY = [18,16, 2,14,20,17, 7, 0,11,14,20, 7, 3, 1]
# beacX = [-2,10,15,10,10,10, 2, 2, 2,25,21,15,15,15]
# beacY = [15,16, 3,16,16,16,10,10,10,17,22, 3, 3, 3]
# inputs for the real deal
sensX = [3729579,3662668,257356,2502777,24076,3163363,1011369,3954188,3480746,2999116,3546198,650838,3231242,1337998,1184009,212559,161020,3744187,2318112,2554810,1240184,2971747,3213584,37652,1804153]
sensY = [1453415,2749205,175834,3970934,2510696,3448163,447686,3117617,3150039,3137910,462510,1255586,3342921,31701,3259703,1737114,2251470,3722432,2254019,56579,897870,2662873,3463821,3969055,1170987]
beacX = [4078883,4078883,1207332,3102959,274522,3102959,1207332,4078883,3301559,3102959,3283798,274522,3301559,1207332,2677313,274522,274522,3301559,2677313,3283798,1207332,2677313,3102959,-615866,1207332]
beacY = [2522671,2522671,429175,3443573,2000000,3443573,429175,2522671,3383795,3443573,-405749,2000000,3383795,429175,2951659,2000000,2000000,3383795,2951659,-405749,429175,2951659,3443573,3091738,429175]
dist = []
row = []
empty = -1
# limit = 20
limit = 4000000
print(2973564+(4000000*3244277))
for k in range(3000000):
    for i in range(len(sensX)):
        dist.append(abs(sensX[i]-beacX[i]) + abs(sensY[i]-beacY[i]))
        if sensY[i] == k:
            row.append(sensX[i])
        if beacY[i] == k:
            row.append(beacX[i])
    sets = []
    removeDupe(row)
    for i in range(len(sensX)):
        if(sensY[i]+dist[i] >= k and sensY[i]-dist[i] <= k):
            rem = dist[i]-abs((sensY[i]-k))
            upp = sensX[i]+rem+1
            low = sensX[i]-rem
            changed = True
            for j in range(len(sets)):
                if j%2 == 0:
                    if upp >= sets[j] and low <= sets[j]:
                        sets[j] = low
                        changed = False
                else:
                    if upp >= sets[j] and low <= sets[j]:
                        sets[j] = upp
                        changed = False
            if changed:
                sets.append(low)
                sets.append(upp)
    i = 0
    while i<len(sets):
        j = i+2
        while j<len(sets)-1:
            if sets[j+1] >= sets[i] and sets[j] <= sets[i]:
                sets[i] = sets[j]
                sets.pop(j)
                sets.pop(j)
                j -= 2
            j += 2
        i += 2
    i = 0
    while i < len(sets):
        j = i+2
        while j<len(sets)-1:
            if sets[j+1] >= sets[i+1] and sets[j] <= sets[i+1]:
                sets[i+1] = sets[j+1]
                sets.pop(j)
                sets.pop(j)
                j -= 2
            j += 2
        i += 2
    i = 0
    while i < len(sets):
        j = i+2
        while j<len(sets)-1:
            if sets[j+1]<=sets[i+1] and sets[j]<=sets[i+1] and sets[j+1]>=sets[i] and sets[j]>=sets[i]:
                sets.pop(j)
                sets.pop(j)
                j -= 2
            j += 2
        i += 2
    sum = 0
    i = 0
    while i < len(sets)-1:
        if(sets[i] < 0):
            sets[i] = 0
        if(sets[i+1] > limit):
            sets[i+1] = limit
        sum += (sets[i+1]-sets[i])
        i += 2
    if sum < limit:
        empty = k
        print(k)
        print(sets)
print(empty)