# Report
## section 1
1. `git log --oneline README.md | wc -l`\
16

2.  `git log --pretty="%an" | sort -u`\
```
DeveloperTommy
René Just
Yuriy Brun
```
3. `git log --oneline -- README.md | grep Ant`\
c2111cc added more info about Ant
4. `git shortlog -n -s --all | grep -oE '[0-9]+' | awk '{s+=$1} END {print s}'`\
98 commits
5. `git log -1 01da475 --stat` OR  `git log -1 01da475 --pretty='' --name-only` 
```
src/Models/Model.java
src/Models/Numbers.java
src/Views/AddNumView.java
src/Views/MeanView.java
src/Views/MedianView.java
src/Views/ModeView.java
src/Views/NumbersView.java
src/Views/ResetView.java
```


6. `git log -1 HEAD` \
commit da90e878188c6de8870581bdb447299821d7e87b (HEAD -> master, origin/master, origin/HEAD)
Author: René Just <rjust@users.noreply.github.com>
Date:   Tue Oct 31 17:48:49 2017 -0400

	Updated README.md



## Section 2
The commit message after step 3: 

```
commit e43fd4e690945191967b070029d6e6c0c9cfc4f7 (HEAD -> master, origin/master, origin/HEAD)
Author: wen <xyw0025@gmail.com>
Date:   Fri Sep 29 16:58:32 2023 -0400

    Feat: requirements in section2 step 3

 src/MinMaxCalculation.java | 12 ++++++++++++
 1 file changed, 12 insertions(+)
```

## Section 3 

First, getting all commits that affect README.md on branch `master`: \
(only wanted the SHA & we want them in time ascending order) \
`git log --reverse --pretty=format:"%h" -- README.md` 

bash file: \
if the result is not equal to 0, meaning that there's a conflict (the commit might be a duplicate and existed on the feature branch), then we do cherry-pick --skip 

```
9b1bbb2
ba319db
e0ca8e1
f60980c
4fa7109
a2583e6
3e2a0a5
c2111cc
c2b3163
9712b04
ddc3fac
61ffac5
913a5d8
0f983c1
aad2f3e
da90e87
```

bash file

```

SHA=(
9b1bbb2
ba319db
e0ca8e1
f60980c
4fa7109
a2583e6
3e2a0a5
c2111cc
c2b3163
9712b04
ddc3fac
61ffac5
913a5d8
0f983c1
aad2f3e
da90e87
)


for hash in "${SHA[@]}"; do
    git cherry-pick "$hash"

    if [ $? -ne 0 ]; then
        git cherry-pick --skip
    fi
done
```

Checkout the feature branch \
`git checkout feature-branch` \
Run the bash file \
`bash cherry-pick.sh` \

Check the git commits \
`git log --oneline`

```
c427977 Updated README.md
72a8ed7 Updated the test command
b62bd52 tweaked the program features description
4f8480f cleared up running instructions
c66c88b clearing up step 5
ef241fd clearing up step 4
ccb0541 clearing up step 3
7469c76 clearing up step 2
8a23e28 added more info about Ant
fa3608b improved description
847ef4f Updated README file.
fcace12 Tweaked the README.
b2ce3f3 Updated README
d807244 Updated the README
21cf659 Merge branch 'feature-branch' of https://github.com/LASER-UMASS/basic-stats into feature-branch
39baf12 cleared up running instructions
dd5322f Updated README.md
2743356 Updated the test command
14a183a tweaked the program features description
35abb07 cleared up running instructions
c1d5f95 clearing up step 5
79fe28e clearing up step 4
a83727b clearing up step 3
b39144a clearing up step 2
d379757 added more info about Ant
a13d6cf improved description
7b43acb Updated README file.
cad9270 Tweaked the README.
e4e4cff Updated README
5b5e6b8 Updated the README
a7b1a7d (tag: v1.0.0) Added GUI functionality for mean and median
```