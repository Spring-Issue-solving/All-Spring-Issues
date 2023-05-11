# Can or Cannot Multiple-Fetch-Join

다중 Fetch-Join을 사용할 수 있는 상황과 사용할 수 없는 상황에 대해 `MultipleBagFetchException` 예외 발생 여부로 치환하여 사용가능여부를 판단한다

`MultipleBagFetchException` O → 다중 Fetch-Join을 사용불가

`MultipleBagFetchException` X → 다중 Fetch-Join을 사용가능

## PS1

### Prob 1. `MultipleBagFetchException` 이 언제 발생하는가

Case 1. XXXToOne 연관관계가 두개 있는 엔티티에서 Multiple-Fetch-Join 했을때

Case 2. XXXToOne 과 XXXToMany연관관계가 있는 엔티티에서 Multiple-Fetch-Join 했을때

Case 3. XXXToMany 연관관계가 두개 있는 엔티티에서 Multiple-Fetch-Join 했을때

### Ans 1. 가정한 이슈발생상황에서 이슈발생여부 판단

`MultipleBagFetchException` 예외발생여부 및 정상쿼리 동작여부 판단

- TDD로 검증

## PS2

### Prob 2. 이슈해결방법

1. BatchSize 설정:: hibernate.default_batch_fetch_size: 글로벌 설정 / @BatchSize디테일설정
2. 연관관계의 방향을 바꿔서 Multiple-Fetch-Join

### Ans 2. 이슈해결방법으로 JPA-DirtyChecking Performance Issue

`MultipleBagFetchException` 예외발생여부 및 정상쿼리 동작여부 판단

- TDD로 검증
