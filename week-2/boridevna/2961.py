ingredients = []
ingredient_idx_set = set()
S_idx = 0
B_idx = 1
N = 0

def solve(selected_idx_set, S, B, min_candidate):
    if S - B >= 1000000000:
        return min_candidate

    new_min_candidate = min(min_candidate, abs(S - B))

    if len(selected_idx_set) == N:
        return new_min_candidate

    non_selected_idx_set = ingredient_idx_set - selected_idx_set

    return min(
        solve(
            selected_idx_set | {idx},
            S*ingredients[idx][S_idx],
            B + ingredients[idx][B_idx],
            new_min_candidate
        )
        for idx in non_selected_idx_set
    )


if __name__ == "__main__":
    N = int(input())

    for i in range(0, N):
        ingredient_idx_set.add(i)
        ingredients.append(list(map(lambda a: int(a), input().split(' '))))

    print(solve(set(), 1, 0, 1000000000))
