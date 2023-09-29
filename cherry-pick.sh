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
