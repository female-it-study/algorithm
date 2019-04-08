def solution(clothes):
    clothes_dict = {}

    for (cloth, kind) in clothes:
        if kind not in clothes_dict:
            clothes_dict[kind] = [cloth]
        else:
            clothes_dict[kind].append(cloth)

    total = 1
    for (kind, items) in clothes_dict.items():
        total *= len(items) + 1
    return total - 1