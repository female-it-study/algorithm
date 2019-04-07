def solution(genres, plays):
    genre_dict = {}
    for i in range(0, len(genres)):
        genre = genres[i]
        cnt = plays[i]
        song = Song(i, genre, cnt)
        if genre not in genre_dict:
            genre_dict[genre] = [cnt, [song]]
        else:
            genre_dict[genre][0] += cnt
            genre_dict[genre][1].append(song)

    best_album = []
    ordered_genres = sorted(genre_dict.items(), key=lambda kv: kv[1][0], reverse=True)

    for genre in ordered_genres:
        songs = genre[1][1]
        if len(songs) == 1:
            best_album.append(songs[0].idx)
        else:
            ordered_songs = sorted(songs, reverse=True)[:2]
            for song in ordered_songs:
                best_album.append(song.idx)

    return best_album


class Song():
    def __init__(self, idx, genre, cnt):
        self.idx = idx
        self.genre = genre
        self.cnt = cnt

    def __lt__(self, other):
        if self.cnt < other.cnt:
            return True
        elif self.cnt == other.cnt:
            if other.idx < self.idx:
                return True
        return False

    def __repr__(self):
        return f"idx={self.idx}, genre={self.genre}, cnt={self.cnt}"