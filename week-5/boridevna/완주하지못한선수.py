def solution(participant, completion):
    if len(completion) == 0:
        return participant[0]

    check_dict = dict()

    for p in participant:
        if p not in check_dict:
            check_dict[p] = 1
        else:
            check_dict[p] += 1

    for c in completion:
        if check_dict[c] > 1:
            check_dict[c] -= 1
        else:
            del check_dict[c]

    return check_dict.popitem()[0]