import math
supermod = 9699690
def monk0(items):
    newItems = []
    for v in items:
        v = v*3
        # v = math.floor(v/3)
        v = v%supermod
        newItems.append(v)
    return newItems
def monk1(items):
    newItems = []
    for v in items:
        v = v*19
        # v = math.floor(v/3)
        v = v%supermod
        newItems.append(v)
    return newItems
    return items
def monk2(items):
    newItems = []
    for v in items:
        v = v+2
        # v = math.floor(v/3)
        v = v%supermod
        newItems.append(v)
    return newItems
    return items
def monk3(items):
    newItems = []
    for v in items:
        v = v*v
        # v = math.floor(v/3)
        v = v%supermod
        newItems.append(v)
    return newItems
def monk4(items):
    newItems = []
    for v in items:
        v = v+8
        # v = math.floor(v/3)
        v = v%supermod
        newItems.append(v)
    return newItems
def monk5(items):
    newItems = []
    for v in items:
        v = v+6
        # v = math.floor(v/3)
        v = v%supermod
        newItems.append(v)
    return newItems
def monk6(items):
    newItems = []
    for v in items:
        v = v+7
        # v = math.floor(v/3)
        v = v%supermod
        newItems.append(v)
    return newItems
def monk7(items):
    newItems = []
    for v in items:
        v = v+4
        # v = math.floor(v/3)
        v = v%supermod
        newItems.append(v)
    return newItems
count0 = 0
count1 = 0
count2 = 0
count3 = 0
count4 = 0
count5 = 0
count6 = 0
count7 = 0
mon0 = [66, 59, 64, 51]
mon1 = [67, 61]
mon2 = [86, 93, 80, 70, 71, 81, 56]
mon3 = [94]
mon4 = [71, 92, 64]
mon5 = [58, 81, 92, 75, 56]
mon6 = [82, 98, 77, 94, 86, 81]
mon7 = [54, 95, 70, 93, 88, 93, 63, 50]
for i in range(10000):
    mon0 = monk0(mon0)
    for v in mon0:
        if v%2 == 0:
            mon1.append(v)
        else:
            mon4.append(v)
        count0 += 1
    mon0.clear()
    mon1 = monk1(mon1)
    for v in mon1:
        if v%7 == 0:
            mon3.append(v)
        else:
            mon5.append(v)
        count1 += 1
    mon1.clear()
    mon2 = monk2(mon2)
    for v in mon2:
        if v%11 == 0:
            mon4.append(v)
        else:
            mon0.append(v)
        count2 += 1
    mon2.clear()
    mon3 = monk3(mon3)
    for v in mon3:
        if v%19 == 0:
            mon7.append(v)
        else:
            mon6.append(v)
        count3 += 1
    mon3.clear()
    mon4 = monk4(mon4)
    for v in mon4:
        if v%3 == 0:
            mon5.append(v)
        else:
            mon1.append(v)
        count4 += 1
    mon4.clear()
    mon5 = monk5(mon5)
    for v in mon5:
        if v%5 == 0:
            mon3.append(v)
        else:
            mon6.append(v)
        count5 += 1
    mon5.clear()
    mon6 = monk6(mon6)
    for v in mon6:
        if v%17 == 0:
            mon7.append(v)
        else:
            mon2.append(v)
        count6 += 1
    mon6.clear()
    mon7 = monk7(mon7)
    for v in mon7:
        if v%13 == 0:
            mon2.append(v)
        else:
            mon0.append(v)
        count7 += 1
    mon7.clear()
counts = []
counts.append(count0)
counts.append(count1)
counts.append(count2)
counts.append(count3)
counts.append(count4)
counts.append(count5)
counts.append(count6)
counts.append(count7)
gold = 0
silv = 0
for i in counts:
    if i >= gold:
        silv = gold
        gold = i
    else:
        if i>= silv:
            silv = i
print(gold)
print(silv)
print(gold*silv)