def solution(clothes):
    category = {}
    
    for cloth in clothes:
        if cloth[1] not in category:
            category[cloth[1]] = 0
        category[cloth[1]] = category[cloth[1]] + 1
        
    count = 1
    for c in category.values():
        count *= c + 1
    
    return count - 1
