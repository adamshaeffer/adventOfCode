def indOf(arr,x):
    for i in range(len(arr)):
        if arr[i] == x:
            return i
    return -1

f = open("lib/input.txt","r")
orig = []
dupe = []
for x in f:
    i = int(x)
    orig.append(i)
    dupe.append(i)
for i in orig:
    x = indOf(dupe,i)
    dupe.pop(x)
    pos = x+i
    if(pos == 0):
        dupe.append(i)
    elif(pos > len(orig)):
        pos = pos%len(orig)+1
        dupe.insert(pos,i)
    else:
        dupe.insert(pos,i)
i = 0
sum = 0
while(i < 3001):
    if(pos == len(dupe)):
        pos = pos%len(dupe)
    if(i == 1000):
        x = dupe[pos+1]
        sum += x
        print(x)
    if(i == 2000):
        x = dupe[pos+1]
        sum += x
        print(x)
    if(i == 3000):
        x = dupe[pos+1]
        sum += x
        print(x)
    i += 1
    pos += 1
print(sum)
f.close()