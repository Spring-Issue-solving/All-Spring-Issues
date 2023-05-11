# N+1

연관관계가 설정된 엔티티 조회 쿼리 하나를 실행하면 추가로 N개의 쿼리가 같이 실행됨

- - -
## PS1

### Prob 1. 이슈 발생 상황

일대다 연관관계를 가지고 있는 엔티티를 조회한다

Case 1. 연관관계의 Fetch 전략이 즉시로딩

Case 2. 연관관계의 Fetch 전략이 지연로딩


### Ans 1. 가정한 이슈발생상황에서 이슈발생여부 판단

두 Case 모두 N+1 Issue가 발생하는가?

- Query Log로 검증

<br/>

- - -
## PS2

### Prob 2. 이슈해결방법

1. Fetch Join
2. Entity Graph
3. FetchMode.SUBSELECT
4. Batch Size

### Ans 2. 이슈해결방법으로 N+1 해결 가능 여부 판단

N+1 Issue 가 해결방법으로 해결되었는가?

- TDD 방식으로 검증
