def solution(genres, plays):
    count = {}
    songs = {}
    answer = []
    for i in range(len(genres)):
        if genres[i] not in count:
            count[genres[i]] = 0
            songs[genres[i]] = []
        count[genres[i]] = count[genres[i]] + plays[i]
        songs[genres[i]].append([plays[i], i])
    sortedByCategory = sorted(count.items(), key=lambda kv: kv[1], reverse=True)
    
    for category, _ in sortedByCategory:
        songsList = sorted(songs[category], key=lambda k: k[0], reverse=True)
        answer.append(songsList[0][1])
        if len(songsList) > 1:
            answer.append(songsList[1][1])
    
    return answer
