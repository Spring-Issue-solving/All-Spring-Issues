# JPA-DirtyChecking Performance Issue

# ISSUE:: JPA-DirtyChecking Performance Issue

영속성 컨텍스트의 변경감지(Dirty-Checking)기능을 사용할때 성능 저하가 발생함

## PS1

### Prob 1. 변경감지(Dirty-Checking)가 성능저하를 일으키는가

Case 1. 트랜젝션 내에서 부하를 확인할 수 있을정도로 많은 엔티티가 영속성컨텍스트에 관리되고 있을때, 변경감지(Dirty-Checking)기능 사용

### Ans 1. 가정한 이슈발생상황에서 이슈발생여부 판단

엔티티가 증가함에 따른 처리속도 성능저하 확인

- 모니터링 툴을 통한 검증

## PS2

### Prob 2. 이슈해결방법

1. @Transactional(readOnly = true)
2. 스칼라 타입으로 조회
3. 읽기전용 쿼리힌트 사용
4. 트랜잭션 밖에서 읽기

### Ans 2. 이슈해결방법으로 JPA-DirtyChecking Performance Issue 해결 판단

같은 엔티티 수에 대한 성능차이를 통한 이슈해결판단

- 모니터링 툴을 통한 검증