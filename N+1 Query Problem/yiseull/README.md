# JPA N+1 Query Problem

> 연관 관계가 설정된 엔티티를 조회할 경우에 조회된 데이터 갯수(N)만큼 연관관계의 조회 쿼리가 추가로 발생하는 현상
한 개의 쿼리로 인해 N개의 추가적인 쿼리가 발생하는 현상

전체적인 조회 시간이 크게 증가하여 성능 문제가 생길 수 있음

## 상황 설정
- 아티스트는 여러 개의 곡을 가질 수 있음
- 곡은 1 아티스트만 가짐

## 이슈 발생 CASE

- CASE 1: Eager 로딩 - 연관된 모든 엔티티를 즉시 로딩하는 방식
- CASE 2: Lazy 로딩 - 연관된 엔티티가 필요한 시점에 로딩하는 방식

## 해결 방법

1. Fetch join - 연관된 엔티티를 하나의 쿼리로 함께 로딩하는 방식
2. EntityGraph - EntityGraph를 사용하면, 복잡한 연관 관계를 가진 엔티티를 한번에 로딩할 수 있음
3. FetchMode.SUBSELECT
4. @BatchSize

## Reference
- https://www.youtube.com/watch?v=ni92wUkAmQI
- https://incheol-jung.gitbook.io/docs/q-and-a/spring/n+1
- https://programmer93.tistory.com/83