````mermaid
gitGraph
    commit
    commit
    branch develop
    checkout develop
    commit
    commit
    branch hegi
    checkout hegi
    commit
    commit
    checkout develop
    merge hegi
    checkout main
    merge develop
    commit
    commit
````