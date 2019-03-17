cache = {}


def count(w, h):
    if (w, h) in cache:
        return cache[(w, h)]
    else:
        cache[(w, h)] = 0

    if w == 0 and h == 0:
        return 1

    # pick W
    if w > 0:
        cache[(w, h)] += count(w-1, h+1)

    # pick H
    if h > 0:
        cache[(w, h)] += count(w, h-1)
    #
    # print("w:%d h:%d" % (w, h))
    return cache[(w, h)]


while True:
    N = int(input())

    if N == 0:
        break

    print(count(N-1, 1))
