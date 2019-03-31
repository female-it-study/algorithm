# 여성 IT인들의 알고리즘 스터디

매주 진행되는 알고리즘 스터디의 히스토리 저장 및 코드리뷰를 위한 저장소입니다.


## Git 저장소 사용 가이드

### 1. 저장소 다운로드

`clone` 명령어를 통해 다운로드 후 해당 폴더로 들어갑니다.

```
git clone https://github.com/female-it-study/algorithm
cd algorithm
```


### 2. 브랜칭

`master > weekly > 개인브랜치`의 브랜칭 구조를 사용합니다.

- 개인 브랜치: 매주 각자 푼 문제를 업로드합니다.
- weekly: 개인 브랜치 -> weekly로 Pull Request를 통해 모든 스터디 참여자들의 풀이를 통합합니다.
- master: weekly -> master로 주 단위 스터디 코드를 merge합니다.

아래 명령어를 통해 weekly 브랜치를 base로 각자 개인 브랜치를 생성합니다.

```
git checkout weekly
git checkout -b <branch name>
```
> ex) git checkout -b newbie

브랜치명은 가급적이면 본인의 닉네임으로 생성해주세요.

**스터디 진행 중 커밋 및 푸시는 본인의 브랜치에만 해야 합니다.**
**절대 master 혹은 weekly 브랜치로 커밋/푸시하지 마세요.**


### 3. 폴더 구조

`week-(#) / <nickname> / <문제 풀이들>`의 폴더 구조를 사용합니다.  
해당 구조에 맞추어 폴더 및 파일을 생성해주세요.


### 4. 코드 업로드

본인의 브랜치로 이동합니다.
```
git checkout <branch name>
```

본인의 풀이를 커밋하기 전에 항상 weekly 브랜치의 최신 버전을 pull 받습니다.
```
git pull origin weekly
```

`status` 명령어를 통해 현재 `add` 혹은 `commit`되지 않은 파일들을 확인할 수 있습니다.
```
git status
```

`add` 명령어를 통해 업로드 할 파일들을 추가합니다.
```
git add <file1> <file2> ...
```
혹은 다음과 같이 아직 추가되지 않은 모든 파일들을 한 번에 추가할 수 있습니다.
```
git add .
```

커밋 메시지와 함께 추가된 파일들을 커밋합니다.
```
git commit -m "커밋 메시지"
```

커밋한 스터디 기록을 github 리모드 저장소에 푸시합니다.
```
git push origin <branch name>
```


### 5. PR 생성하기

Github에 접속해서 본인의 브랜치에서 weekly 브랜치로 Pull Request를 생성합니다.

본인의 브랜치에 푸시한 후 Github에 접속하면 보이는 다음 버튼을 클릭하거나,
![image](https://user-images.githubusercontent.com/22424776/55292073-3f0d4900-5421-11e9-8e20-f3c7b76fb1c3.png)

혹은 Pull Request 탭에 들어가서 `New pull request` 버튼을 클릭해서 새 PR을 생성합니다.

**이 때 반드시 base를 weekly 브랜치로 설정합니다.**
![image](https://user-images.githubusercontent.com/22424776/55292106-8e537980-5421-11e9-9f35-59cc98a355b5.png)


### 6. 코드 리뷰하기

- 매주 일요일 전까지 각자 PR를 생성해 둡니다.
- 매주 화요일 정도에 PR를 close하고 weekly 브랜치로 merge하겠습니다. 그전까지 댓글 및 리뷰 기능을 통해 자유롭게 코드 리뷰를 진행해주세요.
- PR이 열려있는 동안에는 가급적이면 그 다음주의 코드를 업로드하지 말아주세요. 즉, 가급적이면 수요일 이후로 새 풀이를 업로드 해주세요.
